package com.mintgenie.exceptions;

public class Response {


    String message;
    String status;


    public Response(String message, String status) {
        super();
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String isStatus() {
        return status;
    }

    public String setStatus(String status) {
        this.status = status;
        return status;
    }


}
