package courier;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: courier.proto")
public final class CourierServiceGrpc {

  private CourierServiceGrpc() {}

  public static final String SERVICE_NAME = "courier.CourierService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<courier.Courier.StartingCity,
      courier.Courier.Path> getFindPathMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindPath",
      requestType = courier.Courier.StartingCity.class,
      responseType = courier.Courier.Path.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<courier.Courier.StartingCity,
      courier.Courier.Path> getFindPathMethod() {
    io.grpc.MethodDescriptor<courier.Courier.StartingCity, courier.Courier.Path> getFindPathMethod;
    if ((getFindPathMethod = CourierServiceGrpc.getFindPathMethod) == null) {
      synchronized (CourierServiceGrpc.class) {
        if ((getFindPathMethod = CourierServiceGrpc.getFindPathMethod) == null) {
          CourierServiceGrpc.getFindPathMethod = getFindPathMethod = 
              io.grpc.MethodDescriptor.<courier.Courier.StartingCity, courier.Courier.Path>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "courier.CourierService", "FindPath"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  courier.Courier.StartingCity.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  courier.Courier.Path.getDefaultInstance()))
                  .setSchemaDescriptor(new CourierServiceMethodDescriptorSupplier("FindPath"))
                  .build();
          }
        }
     }
     return getFindPathMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CourierServiceStub newStub(io.grpc.Channel channel) {
    return new CourierServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CourierServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CourierServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CourierServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CourierServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CourierServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void findPath(courier.Courier.StartingCity request,
        io.grpc.stub.StreamObserver<courier.Courier.Path> responseObserver) {
      asyncUnimplementedUnaryCall(getFindPathMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFindPathMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                courier.Courier.StartingCity,
                courier.Courier.Path>(
                  this, METHODID_FIND_PATH)))
          .build();
    }
  }

  /**
   */
  public static final class CourierServiceStub extends io.grpc.stub.AbstractStub<CourierServiceStub> {
    private CourierServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CourierServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourierServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CourierServiceStub(channel, callOptions);
    }

    /**
     */
    public void findPath(courier.Courier.StartingCity request,
        io.grpc.stub.StreamObserver<courier.Courier.Path> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFindPathMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CourierServiceBlockingStub extends io.grpc.stub.AbstractStub<CourierServiceBlockingStub> {
    private CourierServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CourierServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourierServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CourierServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public courier.Courier.Path findPath(courier.Courier.StartingCity request) {
      return blockingUnaryCall(
          getChannel(), getFindPathMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CourierServiceFutureStub extends io.grpc.stub.AbstractStub<CourierServiceFutureStub> {
    private CourierServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CourierServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CourierServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CourierServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<courier.Courier.Path> findPath(
        courier.Courier.StartingCity request) {
      return futureUnaryCall(
          getChannel().newCall(getFindPathMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FIND_PATH = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CourierServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CourierServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FIND_PATH:
          serviceImpl.findPath((courier.Courier.StartingCity) request,
              (io.grpc.stub.StreamObserver<courier.Courier.Path>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CourierServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CourierServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return courier.Courier.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CourierService");
    }
  }

  private static final class CourierServiceFileDescriptorSupplier
      extends CourierServiceBaseDescriptorSupplier {
    CourierServiceFileDescriptorSupplier() {}
  }

  private static final class CourierServiceMethodDescriptorSupplier
      extends CourierServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CourierServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CourierServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CourierServiceFileDescriptorSupplier())
              .addMethod(getFindPathMethod())
              .build();
        }
      }
    }
    return result;
  }
}
