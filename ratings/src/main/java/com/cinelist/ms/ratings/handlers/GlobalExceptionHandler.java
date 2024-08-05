package com.cinelist.ms.ratings.handlers;

import com.cinelist.ms.ratings.dtos.handler.CustomErrorResponse;
import com.cinelist.ms.ratings.handlers.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
        CustomErrorResponse error = new CustomErrorResponse();
        error.setError(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.getReasonPhrase());
        error.setCode(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}