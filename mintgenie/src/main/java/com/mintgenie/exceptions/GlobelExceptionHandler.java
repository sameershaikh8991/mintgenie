package com.mintgenie.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobelExceptionHandler {

    @ExceptionHandler(NotfoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response> FlightNotFoundHandler(NotfoundException ex){

        String message=ex.getMessage();

        Response response = new Response(message,false);

        return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);

    }


}
