package com.sanbro.Authentication.DTO;

public class APIResponseDTO {
    private int statusCode;
    private String message;

    public APIResponseDTO(String message,int statusCode) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
