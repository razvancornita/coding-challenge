package com.challenge.controller;

import com.challenge.exception.ErrorDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    ObjectMapper mapper = new ObjectMapper();

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) throws JsonProcessingException {
        log.error("illegal argument", e);
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST.toString(), e.getMessage(), "Illegal argument");
        String body = mapper.writeValueAsString(errorDetails);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        log.error("invalid arguments", e);
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.BAD_REQUEST.toString(), e.getMessage(), "Invalid request body");
        return handleExceptionInternal(e, errorDetails, headers, HttpStatus.BAD_REQUEST, request);
    }
}