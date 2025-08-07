package com.examhub.examhub.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ResponseTO {
    private int status;
    private String code;
    private String message;
    private String path;
    private Map<String, Object> data = new HashMap<>();
    private Map<String, String> errorList;
    public static ResponseTO responseBuilder(int status, String code, String message, String path, String key, Object data) {
        ResponseTO response = new ResponseTO();
        response.setStatus(status);
        response.setPath(path);
        response.setMessage(message);
        response.setCode(code);
        response.putData(key, data);
        return response;
    }


    public void putData(String key, Object Value) {
        data.put(key, Value);
    }
}
