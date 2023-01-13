package com.mintgenie.exceptions;

public class UserNotfoundException extends RuntimeException {


    private int id;

    public UserNotfoundException() {
        super();
    }

    public int getId() {
        return id;
    }

    public UserNotfoundException(int id) {
        super(String.format("user not found with this id: %s", id));
        this.id = id;
    }
}
