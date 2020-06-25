package com.example.springboot;


import com.google.gson.Gson;
import net.minidev.json.JSONObject;
import org.apache.tomcat.util.http.parser.Authorization;
import org.apache.tomcat.util.json.JSONParser;
import org.ietf.jgss.GSSCredential;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;

import java.io.StringReader;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java11HttpClientExample {

    // one instance, reuse
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    /*
    val request = HttpRequest(
      method = HttpMethods.GET,
      uri = "https://darglobal.okta.com/api/v1/users"
    ).addHeader(Authorization(GenericHttpCredentials("SSWS", "00qWe7FbyWL2CnbqaqqleKdZegEOWYcdltY4lC6Cix")))
    for {
      response <- Http().singleRequest(request)
      entity <- response.entity.toStrict(10 seconds)
    } yield {
      parse(entity.getData().utf8String)
        .flatMap(_.as[List[OktaUser]])
        .map(_.map(_.simplify))
    }
     */
    public static void main(String[] args) throws Exception {

        Java11HttpClientExample obj = new Java11HttpClientExample();

        System.out.println("Testing 1 - Send Http GET request");
        obj.sendGet();


    }

    private void sendGet() throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://darglobal.okta.com/api/v1/users"))
                .setHeader("Authorization", "SSWS 00qWe7FbyWL2CnbqaqqleKdZegEOWYcdltY4lC6Cix")
                .build();

        HttpResponse<String > response = httpClient. send(request, HttpResponse.BodyHandlers.ofString());

        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());

    }


}