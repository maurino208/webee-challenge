package com.webee.challenge.exception;



import com.webee.challenge.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomeResponseException extends ResponseEntityExceptionHandler {

    /**
     * Handle user not found exception response entity.
     *
     * @param ex      from DeviceNotFoundException
     * @return the response entity
     */
    @ExceptionHandler(DeviceNotFoundException.class)
    public final ResponseEntity<Object> handleDeviceNotFoundException(DeviceNotFoundException ex) {
        ApiError apiError = new ApiError("Not Found", ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    /**
     * Handle device constraint violation exception response entity.
     *
     * @param ex      from DeviceConstrainViolationException
     * @return the response entity
     */
    @ExceptionHandler(DeviceBadRequestException.class)
    public final ResponseEntity<Object> handleDeviceConstraintViolationException(DeviceBadRequestException ex) {
        ApiError apiError = new ApiError("Bad Request", ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleException(Exception ex) {
        ApiError apiError = new ApiError("Internal Server Error", ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(apiError.getStatus()).body(apiError);
    }
}
