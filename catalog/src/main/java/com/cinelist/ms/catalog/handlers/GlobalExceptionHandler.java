package com.cinelist.ms.catalog.handlers;

import com.cinelist.ms.catalog.dtos.handler.CustomErrorResponse;
import com.cinelist.ms.catalog.handlers.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest request) {
        CustomErrorResponse error = new CustomErrorResponse();
        error.setError(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setCode("404");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
        List<String> errorList = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String errorMessage = error.getDefaultMessage();
            errorList.add(errorMessage);
        });

        log.error("List of errors: {}", errorList);

        CustomErrorResponse error = new CustomErrorResponse();
        error.setError(errorList.get(0));
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setCode("400");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}