package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.enums.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Collections;

class PowerOfAttorneyTest {

    private static final String EXPECTED_ID = "0001";
    private static final String EXPECTED_GRANTOR_OWNER = "Grantor";
    private static final float EXPECTED_GRANTOR_BALANCE = 500;
    private static final String EXPECTED_GRANTEE_OWNER = "Grantee";
    private static final float EXPECTED_GRANTEE_BALANCE = 1000;

    private PowerOfAttorney powerOfAttorney;

    @BeforeEach
    public void setUp() {
        var cardLimit = new CardLimit(5, 1000, PeriodUnit.PER_DAY, LimitType.CREDIT);

        Calendar created = Calendar.getInstance();
        created.set(2020, Calendar.JANUARY , 1);
        var grantor = new Account(5, "Grantor", 500, created, null);
        var grantee = new Account(5, "Grantee", 1000, created, null);
        var authorization = new Authorization(10, AuthorizationValue.CREDIT_CARD);
        var creditCard = new CreditCard(10, CardStatus.ACTIVE, 51, 23, "Doctor", true, cardLimit);

        powerOfAttorney = new PowerOfAttorney("0001", grantor, grantee, Direction.GIVEN, Collections.singletonList(authorization), Collections.singletonList(creditCard));
    }

    @Test
    public void testPowerOfAttorney() {
        Assertions.assertEquals(EXPECTED_ID, powerOfAttorney.getId());
        Assertions.assertEquals(EXPECTED_GRANTOR_OWNER, powerOfAttorney.getGrantor().getOwner());
        Assertions.assertEquals(EXPECTED_GRANTOR_BALANCE, powerOfAttorney.getGrantor().getBalance());
        Assertions.assertEquals(EXPECTED_GRANTEE_OWNER, powerOfAttorney.getGrantee().getOwner());
        Assertions.assertEquals(EXPECTED_GRANTEE_BALANCE, powerOfAttorney.getGrantee().getBalance());
        Assertions.assertTrue(powerOfAttorney.getAuthorizations().stream().findFirst().isPresent());
        Assertions.assertTrue(powerOfAttorney.getCards().stream().findFirst().isPresent());
    }

}
