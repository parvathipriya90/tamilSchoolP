package com.sikar.tamilSchoolP.controller;

import com.sikar.tamilSchoolP.exceptions.EmployeeNotFoundException;
import com.sikar.tamilSchoolP.exceptions.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler
    public ResponseEntity<String> handleException(RuntimeException exception){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
    @ExceptionHandler
    public ResponseEntity<Error> handleException(EmployeeNotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new Error(exception.getMessage(),HttpStatus.NOT_FOUND.value()));
    }



}
