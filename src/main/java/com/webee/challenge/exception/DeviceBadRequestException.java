package com.webee.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DeviceBadRequestException extends RuntimeException {

    public DeviceBadRequestException(String message) {
        super(message);
    }
}
