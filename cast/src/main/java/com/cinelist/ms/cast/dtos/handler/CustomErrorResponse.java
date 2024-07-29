package com.cinelist.ms.cast.dtos.handler;

public class CustomErrorResponse {
    private String error;
    private int status;
    private String code;

    public CustomErrorResponse() {
    }

    public CustomErrorResponse(String error, int status, String code) {
        this.error = error;
        this.status = status;
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}