package com.rabobank.chris.api.exception;

import com.rabobank.chris.model.entities.CreditCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

class RestErrorTest {

    private static final String EXPECTED_ERROR_MESSAGE = "Sample error message";
    private static final HttpStatus EXPECTED_HTTP_STATUS = HttpStatus.BAD_REQUEST;

    private RestError restError;

    @BeforeEach
    void setup() {
        restError = new RestError(HttpStatus.BAD_REQUEST, EXPECTED_ERROR_MESSAGE, new EntityNotFoundException(1, CreditCard.class));
    }

    @Test
    public void testRestError() {
        Assertions.assertEquals(EXPECTED_ERROR_MESSAGE, restError.getMessage());
        Assertions.assertEquals(EXPECTED_HTTP_STATUS.value(), restError.getStatus());
    }

}
