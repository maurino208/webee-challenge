package com.webee.challenge.device.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomeResponseException extends ResponseEntityExceptionHandler {

    /**
     * Handle user not found exception response entity.
     *
     * @param ex      from DeviceNotFoundException
     * @param request from WebRequest
     * @return the response entity
     */
    @ExceptionHandler(DeviceNotFoundException.class)
    public final ResponseEntity<Object> handleDeviceNotFoundException(DeviceNotFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DeviceBadRequestException.class)
    public final ResponseEntity<Object> handleDeviceBadRequestException(DeviceNotFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
