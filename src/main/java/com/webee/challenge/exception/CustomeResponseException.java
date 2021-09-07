package com.webee.challenge.exception;



import com.webee.challenge.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
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
        ApiError apiError = new ApiError("Not Found", ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleDeviceConstraintViolationException(DeviceConstraintViolationException ex, WebRequest request) {
        ApiError apiError = new ApiError("Bad Request", ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }
}
