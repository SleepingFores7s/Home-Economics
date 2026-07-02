package com.example.homeeconomics.core.exception.exceptionhandler;

import com.example.homeeconomics.core.exception.customexceptions.ObjectAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectAlreadyExistsException.class)
    public ResponseEntity<String> handleObjectAlreadyExistsException(ObjectAlreadyExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }

}
