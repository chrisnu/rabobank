package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.enums.CardStatus;
import com.rabobank.chris.model.enums.LimitType;
import com.rabobank.chris.model.enums.PeriodUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreditCardTest {
    private static final Integer EXPECTED_ID = 10;
    private static final CardStatus EXPECTED_STATUS = CardStatus.ACTIVE;
    private static final Integer EXPECTED_NUMBER = 51;
    private static final Integer EXPECTED_SEQUENCE_NUMBER = 23;
    private static final String EXPECTED_CARD_HOLDER = "Doctor";

    private static final float EXPECTED_LIMIT_VALUE = 1000;
    private static final PeriodUnit EXPECTED_LIMIT_PERIOD_UNIT = PeriodUnit.PER_DAY;
    private static final LimitType EXPECTED_LIMIT_TYPE = LimitType.CREDIT;

    private CreditCard creditCard;

    @BeforeEach
    public void setUp() {
        var cardLimit = new CardLimit(5, 1000, PeriodUnit.PER_DAY, LimitType.CREDIT);
        creditCard = new CreditCard(10, CardStatus.ACTIVE, 51, 23, "Doctor", true, cardLimit);
    }

    @Test
    public void testCreditCard() {
        Assertions.assertEquals(EXPECTED_ID, creditCard.getId());
        Assertions.assertEquals(EXPECTED_STATUS, creditCard.getStatus());
        Assertions.assertEquals(EXPECTED_NUMBER, creditCard.getCardNumber());
        Assertions.assertEquals(EXPECTED_SEQUENCE_NUMBER, creditCard.getSequenceNumber());
        Assertions.assertEquals(EXPECTED_CARD_HOLDER, creditCard.getCardHolder());
        Assertions.assertTrue(creditCard.getContactless());
        Assertions.assertEquals(EXPECTED_LIMIT_VALUE, creditCard.getCreditLimit().getValue());
        Assertions.assertEquals(EXPECTED_LIMIT_PERIOD_UNIT, creditCard.getCreditLimit().getPeriodUnit());
        Assertions.assertEquals(EXPECTED_LIMIT_TYPE, creditCard.getCreditLimit().getType());
    }
}
