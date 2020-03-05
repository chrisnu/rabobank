package com.rabobank.chris.api.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
@Log4j2
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<RestError> handleEntityNotFound(
            EntityNotFoundException ex) {
        RestError restError = new RestError(NOT_FOUND, String.format("Entity %s with id %s does not exist", ex.getCls().getCanonicalName(), ex.getId()), ex);
        return (ResponseEntity<RestError>) buildResponseEntity(restError, NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(
            TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        RestError restError = new RestError(BAD_REQUEST, "Invalid parameter", ex);
        return (ResponseEntity<Object>) buildResponseEntity(restError, NOT_FOUND);
    }

    private ResponseEntity<?> buildResponseEntity(RestError restError, HttpStatus status) {
        return new ResponseEntity<>(restError, status);
    }
}
