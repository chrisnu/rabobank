package com.rabobank.chris.api.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class RestError {


    private final HttpStatus httpStatus;

    @Getter
    private int status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp = LocalDateTime.now();

    @Getter
    private String message;

    @Getter
    private String debugMessage;

    public RestError(HttpStatus httpStatus, Throwable ex) {
        this(httpStatus, "Unexpeceted error", ex);
    }

    RestError(HttpStatus httpStatus, String message, Throwable ex) {
        this.httpStatus = httpStatus;
        this.status = httpStatus.value();
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

}
