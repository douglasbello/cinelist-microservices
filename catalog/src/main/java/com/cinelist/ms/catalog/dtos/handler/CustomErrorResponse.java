package com.cinelist.ms.catalog.dtos.handler;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomErrorResponse {
    private String error;
    private String status;
    private int code;

    public CustomErrorResponse() {
    }

    public CustomErrorResponse(String status, String error, int code) {
        this.status = status;
        this.error = error;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String message) {
        this.error = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}