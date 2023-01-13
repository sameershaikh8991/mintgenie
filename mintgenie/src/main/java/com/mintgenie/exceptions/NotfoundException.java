package com.mintgenie.exceptions;

public class NotfoundException extends RuntimeException {
    private int id;

    public NotfoundException() {
        super();
    }

    public int getId() {
        return id;
    }

    public NotfoundException(int id) {
        super(String.format("WatchList not found with this id: %s", id));
        this.id = id;
    }

}
