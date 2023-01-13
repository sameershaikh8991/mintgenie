package com.mintgenie.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobelExceptionHandler {

    @ExceptionHandler(NotfoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response> NotFoundHandler(NotfoundException ex){

        String message=ex.getMessage();

        String status = String.valueOf(HttpStatus.NOT_FOUND);

        Response response = new Response(message,status);

        return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(UserNotfoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Response> UserNotFoundHandler(UserNotfoundException ex){

        String message=ex.getMessage();

        String status = String.valueOf(HttpStatus.NOT_FOUND);

        Response response = new Response(message,status);
        System.out.println(status);

        return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);

    }




}
