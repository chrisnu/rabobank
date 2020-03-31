package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.enums.AuthorizationValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthorizationTest {

    private static final Integer EXPECTED_ID = 10;
    private static final AuthorizationValue EXPECTED_VALUE = AuthorizationValue.CREDIT_CARD;

    private Authorization authorization;

    @BeforeEach
    public void setUp() {
        authorization = new Authorization(10, AuthorizationValue.CREDIT_CARD);
    }

    @Test
    public void testAuthrization() {
        Assertions.assertEquals(EXPECTED_ID, authorization.getId());
        Assertions.assertEquals(EXPECTED_VALUE, authorization.getValue());
    }
}
