package com.trabajo.demo.infrastructure.error;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalErrorMadler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleEntityNotFoundException(UserNotFoundException e){
        return ResponseEntity.badRequest()
        .body(
            Map.of(
                "error",e.getMessage(),
                "statusCode",e.getStatus().value()
            )
        );
    }
    
}
