package com.mintgenie.exceptions;

public class CommonException extends RuntimeException {

    public CommonException() {
        super();
    }


    public CommonException(String message) {
        super(String.format("%s",message));

    }
}
