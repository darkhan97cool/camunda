package com.example.springboot.Bamboo;

import java.util.HashMap;
import java.util.List;

public class BambooHTTPResponse {
    public int statusCode=0;
    public HashMap<String,String> headers;
    public BambooHrEmployeeRes content;

    public BambooHTTPResponse() {
        headers=new HashMap<String,String>();
    }
}