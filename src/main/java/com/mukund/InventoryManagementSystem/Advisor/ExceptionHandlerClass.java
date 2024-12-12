package com.mohitsabhadiya123.InventoryManagementSystem.Advisor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ExceptionHandlerClass {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> airthmeticException() {
        return new ResponseEntity<>("Exception Occurred", HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ClassCastException.class)
    public ResponseEntity<?> classCastException() {
        return new ResponseEntity<>("Class Cast Exception Occurred", HttpStatus.BAD_REQUEST);
    }
}
