package com.hackaton.wayhome.controllers;

import com.hackaton.wayhome.exceptions.BadRequestException;
import com.hackaton.wayhome.exceptions.NotFoundException;
import com.hackaton.wayhome.dtos.error.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorDto> notFoundExHandler(NotFoundException exception){
        var error = ErrorDto.builder()
                .code(exception.getCode())
                .message(exception.getMessage())
                .build();
        return  new ResponseEntity<>(error, exception.getHttpStatus());
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ErrorDto> badRequestHandler(BadRequestException ex){
        var error = ErrorDto.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }
}
