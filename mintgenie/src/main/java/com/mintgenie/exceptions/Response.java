package com.mintgenie.exceptions;

public class Response {


    String message;
    boolean status;


    public Response(String message, boolean status) {
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
    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

}
