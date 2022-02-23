package com.reqres.api.test.context;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScenarioContext {

    private static final String REQUEST_KEY = "REQUEST";
    private static final String RESPONSE_KEY = "RESPONSE";

    private Map<String, Object> data = new HashMap<>();

    public void setRequest(RequestSpecification request) {
        data.put(REQUEST_KEY, request);
    }

    public RequestSpecification getRequest() {
        return (RequestSpecification) data.get(REQUEST_KEY);
    }

    public void setResponse(Response response) {
        data.put(RESPONSE_KEY, response);
    }

    public JsonPath getResponse(String response) {
        return (JsonPath) data.get(response);
    }

    public void set(String key, Object object) {
        data.put(key, object);
    }

    public Object get(String key) {
        return data.get(key);
    }

    public String getString(String key) {
        return (String) data.get(key);
    }

    public Integer getInteger(String key) {
        return (Integer) data.get(key);
    }

    public void clearContext() {
        data.clear();
    }

    public void setResponse(String response, JsonPath jsonPath) {
        data.put(response, jsonPath);
    }
}