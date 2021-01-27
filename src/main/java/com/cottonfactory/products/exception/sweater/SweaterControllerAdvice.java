package com.cottonfactory.products.exception.sweater;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SweaterControllerAdvice {
    @ExceptionHandler(InvalidSweaterException.class)
    public ResponseEntity handleInvalidSweaterException(Exception ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }
}
