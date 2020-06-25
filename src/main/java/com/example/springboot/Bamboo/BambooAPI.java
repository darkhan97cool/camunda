package com.example.springboot.Bamboo;


import java.io.*;
import java.net.URLEncoder;
import java.util.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
//import sun.misc.BASE64Encoder;

public class BambooAPI {

    protected BambooHTTPClient httpHandler;
    protected String baseUrl="https://api.bamboohr.com/api/gateway.php/";

    private RestTemplate restTemplate = new RestTemplate();



    HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
            String authHeader = "Basic " +  encodedAuth;
            set( "Authorization", authHeader );
        }};
    }

    BambooAPI(String companyDomain) {
        httpHandler=new BambooHTTPClient();
        baseUrl+=companyDomain;
    }

    BambooAPI(String companyDomain, BambooHTTPClient http) {
        httpHandler=http;
        baseUrl+=companyDomain;
    }

    void setSecretKey(String key){
        httpHandler.setBasicAuth(key, "x");
    }

    private static String implode(String glue, String[] arr) {
        StringBuilder sb = new StringBuilder();
        if (arr.length > 0) {
            sb.append(arr[0]);
            for (int i=1; i<arr.length; i++) {
                sb.append(glue);
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    private static String prepareKeyValues(HashMap<String,String> values) {
        StringBuilder xml=new StringBuilder();
        Set<String> keys=values.keySet();
        for(String str : keys) {
            xml.append("<field id=\"").append(str).append("\">").append(values.get(str)).append("</field>");
        }
        return xml.toString();
    }

    private static String encodeHTML(String s) {
        StringBuffer out = new StringBuffer();
        for(int i=0; i<s.length(); i++) {
            char c=s.charAt(i);
            switch(c) {
                case '"': out.append("&quot;"); break;
                case '<': out.append("&lt;");break;
                case '>': out.append("&gt;");break;
                default: out.append(c); break;
            }
        }
        return out.toString();
    }

    BambooHTTPResponse getEmployee(int employeeId, String[] fields) throws ClassNotFoundException {
        BambooHTTPRequest request=new BambooHTTPRequest();
        request.method="GET";
        request.url=baseUrl + "/v1/employees/" + employeeId + "/?fields=" + implode(",",fields);
        return httpHandler.sendRequest( request );
    }

    public BambooHTTPResponse getDirectoryOfEmployees() throws ClassNotFoundException {
        System.out.println("BaseURL + " + baseUrl);
        BambooHTTPRequest request=new BambooHTTPRequest();
/*
        HttpHeaders header = new HttpHeaders();
        String auth = "099b339d74d09194945812ed59aa1bf21a7cf042" + ":" + "x";
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes());
        String authHeader = "Basic " +  encodedAuth;
        String authorizationHeader = "Basic " + encodedAuth;
        header.add("Authorization",authorizationHeader);
//        header.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        header.setContentType(MediaType.APPLICATION_JSON);

        List<HttpMessageConverter<BambooHrEmployeeRes>> messageConverters = new ArrayList<HttpMessageConverter<BambooHrEmployeeRes>>();

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);*/
/*
        String url = UriComponentsBuilder
                .fromUriString(baseUrl + "/v1/employees/directory")
                .queryParams(tempParams)
                .toUriString();*/
        //restTemplate.getForEntity(url, BambooHrEmployeeRes.class);
/*        HttpEntity requestEntity = new HttpEntity(header);

        restTemplate.exchange(
                baseUrl + "/v1/employees/directory",
                HttpMethod.GET,
                requestEntity,
                BambooHrEmployeeRes.class);
        BambooHrEmployeeRes employeeRes = restTemplate.getForObject(baseUrl, BambooHrEmployeeRes.class);*/

        request.method="GET";
        request.url=baseUrl + "/v1/employees/directory";
//        System.out.println(employeeRes);
        return httpHandler.sendRequest( request );
    }



    public BambooHTTPResponse getDirectoryOfDepartments() throws ClassNotFoundException {
        System.out.println("BaseURL + " + baseUrl);
        BambooHTTPRequest request=new BambooHTTPRequest();

        request.method="GET";
        request.url=baseUrl + "/v1/department/directory";
//        System.out.println(employeeRes);
        return httpHandler.sendRequest( request );
    }



    BambooHTTPResponse getReport(int reportId, String format) throws ClassNotFoundException {
        BambooHTTPRequest request=new BambooHTTPRequest();
        request.method="GET";
        request.url=baseUrl+"/v1/reports/"+reportId+"/?format="+format;
        return httpHandler.sendRequest( request );
    }

    BambooHTTPResponse updateEmployee(int employeeId, HashMap<String,String> fieldValues) throws ClassNotFoundException {
        BambooHTTPRequest request=new BambooHTTPRequest();
        request.method="POST";
        request.url=baseUrl+"/v1/employees/"+employeeId;
        request.headers.put("Content-type","text/xml");

        String xml=String.format("<employee id=\"%d\">", employeeId);
        xml+=prepareKeyValues(fieldValues);
        xml+="</employee>";
        request.content=xml;
        return httpHandler.sendRequest( request );
    }

    BambooHTTPResponse addEmployee(HashMap<String,String> initialFieldValues) throws ClassNotFoundException {
        BambooHTTPRequest request=new BambooHTTPRequest();
        request.method="POST";
        request.url=baseUrl+"/v1/employees/";
        request.headers.put("Content-type","text/xml");

        request.content="<employee>"+prepareKeyValues(initialFieldValues)+"</employee>";
        return httpHandler.sendRequest( request );
    }

    BambooHTTPResponse getCustomReport(String format, String[] fields) throws ClassNotFoundException {
        BambooHTTPRequest request=new BambooHTTPRequest();
        request.method="POST";
        request.url=baseUrl+"/v1/reports/custom/?format="+format;
        request.headers.put("Content-type", "text/xml");

        StringBuilder sb=new StringBuilder();
        sb.append("<report><fields>");
        for(String field : fields) {
            sb.append( String.format("<field id=\"%s\" />", field ) );
        }
        sb.append("</fields></report>");
        request.content=sb.toString();
        return httpHandler.sendRequest( request );
    }

    BambooHTTPResponse getTable(int employeeId, String tableName) throws ClassNotFoundException {
        BambooHTTPRequest request=new BambooHTTPRequest();
        request.method="GET";
        try {
            request.url=baseUrl+"/v1/employees/"+employeeId+"/tables/"+URLEncoder.encode(tableName,"utf-8")+"/";
        }
        catch(UnsupportedEncodingException e) {
        }
        return httpHandler.sendRequest( request );
    }



//76 Darkhan's ID
    public static void main(String arguments[]) throws ClassNotFoundException {



        BambooAPI client=new BambooAPI("darglobal" /* Your company subdomain here */);
        // Ask Nurbek before deploy
        client.setSecretKey("099b339d74d09194945812ed59aa1bf21a7cf042" /* Your key here */ );
        BambooHTTPResponse resp=client.getEmployee(76, new String[] {"lastName","workPhone"} );
//        System.out.println( resp.statusCode );
//        System.out.println( resp.content );

        System.out.println(" I am getting directory of Employees" );
        resp=client.getDirectoryOfEmployees();
        System.out.println( resp.statusCode );
        System.out.println( resp.content );


        resp = client.getTable(76, "employmentStatus" );
        System.out.println(" I am getting employmentStatus table of Employees by ID 76" );
        System.out.println( resp.statusCode );
        System.out.println( resp.content );


        resp = client.getDirectoryOfDepartments();
        System.out.println(" I am getting departments table of Employees by ID 76" );
        System.out.println( resp.statusCode );
        System.out.println( resp.content );


        resp = client.getTable(76, "jobInfo" );
        System.out.println(" I am getting jobInfo table of Employees by ID 76" );
        System.out.println( resp.statusCode );
        System.out.println( resp.content );

        resp = client.getTable(87, "jobInfo" );
        System.out.println(" I am getting jobInfo table of Employees by ID 76" );
        System.out.println( resp.statusCode );
        System.out.println( resp.content );
/*
        System.out.println(" I am getting Darkhan,Yersultan" );
        resp=client.getCustomReport("xml", new String[] { "Darkhan","Yersultan" } );
        System.out.println( resp.statusCode );
        System.out.println( resp.content );


        resp = client.getTable(76, "emergencyContacts" );
        System.out.println(" I am getting emergencyContacts table of Employees by ID 76" );
        System.out.println( resp.statusCode );
        System.out.println( resp.content );


        resp = client.getTable(76, "jobInfo" );
        System.out.println(" I am getting jobInfo table of Employees by ID 76" );
        System.out.println( resp.statusCode );
        System.out.println( resp.content );



        resp = client.getTable(76, "compensation" );
        System.out.println(" I am getting compensation table of Employees by ID 76" );
        System.out.println( resp.statusCode );
        System.out.println( resp.content );


        resp = client.getTable(76, "dependents" );
        System.out.println(" I am getting dependents table of Employees by ID 76" );
        System.out.println( resp.statusCode );
        System.out.println( resp.content );*/

//        HashMap<String,String> map=new HashMap<String,String>();
//        map.put("firstName","API");
//        map.put("lastName","Employee");
//        resp=client.addEmployee( map );
//        System.out.println( resp.statusCode );
//        System.out.println( resp.content );
    }

}
