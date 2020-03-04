package com.rabobank.chris.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<RestError> handleEntityNotFound(
            EntityNotFoundException ex) {
        RestError restError = new RestError(NOT_FOUND, String.format("Entity %s with id %s does not exist", ex.getCls().getCanonicalName(), ex.getId()), ex);
        return buildResponseEntity(restError, NOT_FOUND);
    }

    private ResponseEntity<RestError> buildResponseEntity(RestError restError, HttpStatus status) {
        return new ResponseEntity<>(restError, status);
    }
}
