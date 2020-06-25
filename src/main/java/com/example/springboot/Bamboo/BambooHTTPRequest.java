package com.example.springboot.Bamboo;
import java.util.HashMap;

public class BambooHTTPRequest {
    public String method="GET";
    public HashMap<String,String> headers;
    public String url="";
    public String content="";

    public BambooHTTPRequest() {
        headers=new HashMap<String,String>();
    }
}