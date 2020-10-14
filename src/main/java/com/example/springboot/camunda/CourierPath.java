package com.example.springboot.camunda;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;
import java.awt.Desktop;
import java.net.URI;


import courier.Courier;
import courier.CourierServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.client.ExternalTaskClient;

// To start the application you have to run Camunda on your localhost so ExternalTaskClient could connect.
// cd camunda path -> ./start-camunda.sh
// And to Camunda the bpmn diagram must be apploaded through rest api or Camunda Modeler deploy.
@Slf4j
public class CourierPath {
    private final static Logger LOGGER = Logger.getLogger(CourierPath.class.getName());

    public static void main(String[] args) throws InterruptedException {
        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000) // long polling timeout
                .build();

        ManagedChannel channel = ManagedChannelBuilder.forAddress("127.0.0.1",8082).usePlaintext().build();
        CourierServiceGrpc.CourierServiceBlockingStub courierStub = CourierServiceGrpc.newBlockingStub(channel);



        client.subscribe("courier-path")
                .lockDuration(1000)
                .handler((externalTask, externalTaskService) -> {


                    // Get a process variable
                    String city1 = (String) externalTask.getVariable("city1");
                    String city2 = (String) externalTask.getVariable("city2");


                    LOGGER.info("WOW.WOW.WOW!!! Now I will send you paths! ");
                    LOGGER.info("WOW.WOW.WOW!!! CITY: " + city1);


                    Courier.StartingCity startingCity = Courier.StartingCity.newBuilder().
                            setCity1(city1).setCity2(city2).build();

                    Courier.Path path;

                    try {
                        path = courierStub.findPath(startingCity);
                    } catch (StatusRuntimeException e) {
                        log.warn( "RPC failed: " + e.getStatus());
                        return;
                    }


                    System.out.println("WOW RESULT => "  + path);




                    Map<String, Object> processVariables = new HashMap<>();
                    //putting process vars
                    processVariables.put("Path",path.getPath());
                    processVariables.put("Distance",path.getValue());
                    // Complete the task
                    System.out.println("WOW PASSING VARS => "  + path.getPath());
                    externalTaskService.complete(externalTask,processVariables);
                })
                .open();
                channel.shutdown();
    }



}
