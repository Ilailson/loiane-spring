package com.ilailson.crud_spring.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ilailson.crud_spring.exception.RecordNotFoundException;

@RestControllerAdvice // + dizer para os controllers rest o que fazer com as exceções
@ResponseStatus(HttpStatus.NOT_FOUND) // + retornar status com 404
public class ApplicationControllerAdivice {

    @ExceptionHandler(RecordNotFoundException.class)
    public String handleNotFoundException(RecordNotFoundException ex) {
        return ex.getMessage();
    }
}
