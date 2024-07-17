package com.cinelist.ms.catalog.dtos.handler;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomErrorResponse {
    private int status;
    private String error;
    private String code;

    public CustomErrorResponse() {
    }

    public CustomErrorResponse(int status, String error, String code) {
        this.status = status;
        this.error = error;
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String message) {
        this.error = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}