package com.example.samplespringapp.controller;

import com.example.samplespringapp.exception.CustomException;
import com.example.samplespringapp.exception.ValidationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public String handleConflict(EntityNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public List<String> handleConflict(ValidationException e) {
        return e.getExceptionList();
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(CustomException.class)
    public String handleConflict(CustomException e) {
        return e.getMessage();
    }
}
