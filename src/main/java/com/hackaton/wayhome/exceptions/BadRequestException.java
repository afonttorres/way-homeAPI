package com.hackaton.wayhome.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class BadRequestException extends RuntimeException{
    String code;
    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    public BadRequestException(String message, String code){
        super(message);
        this.code = code;
    }
}
