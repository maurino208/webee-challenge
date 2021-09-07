package com.webee.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DeviceConstraintViolationException extends RuntimeException {

    public DeviceConstraintViolationException(String message) {
        super(message);
    }
}
