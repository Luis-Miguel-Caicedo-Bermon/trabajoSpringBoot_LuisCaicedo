package com.trabajo.demo.infrastructure.error;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    private String message;
    private HttpStatus status;


    public UserNotFoundException(String message, HttpStatus statuscode) {
        super(message);
        this.message = message;
        this.status = statuscode;
    }

    
}
