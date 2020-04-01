package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.enums.CardStatus;
import com.rabobank.chris.model.enums.LimitType;
import com.rabobank.chris.model.enums.PeriodUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DebitCardTest {
    private static final Integer EXPECTED_ID = 10;
    private static final CardStatus EXPECTED_STATUS = CardStatus.ACTIVE;
    private static final Integer EXPECTED_NUMBER = 51;
    private static final Integer EXPECTED_SEQUENCE_NUMBER = 23;
    private static final String EXPECTED_CARD_HOLDER = "Doctor";

    private static final float EXPECTED_ATM_LIMIT_VALUE = 1000;
    private static final PeriodUnit EXPECTED_ATM_LIMIT_PERIOD_UNIT = PeriodUnit.PER_DAY;
    private static final LimitType EXPECTED_ATM_LIMIT_TYPE = LimitType.ATM;

    private static final float EXPECTED_POS_LIMIT_VALUE = 100;
    private static final PeriodUnit EXPECTED_POS_LIMIT_PERIOD_UNIT = PeriodUnit.PER_MONTH;
    private static final LimitType EXPECTED_POS_LIMIT_TYPE = LimitType.POS;

    private DebitCard debitCard;

    @BeforeEach
    public void setUp() {
        var atmLimit = new CardLimit(5, 1000, PeriodUnit.PER_DAY, LimitType.ATM);
        var posLimit = new CardLimit(6, 100, PeriodUnit.PER_MONTH, LimitType.POS);
        debitCard = new DebitCard(10, CardStatus.ACTIVE, 51, 23, "Doctor", true, atmLimit, posLimit);
    }

    @Test
    public void testDebitCard() {
        Assertions.assertEquals(EXPECTED_ID, debitCard.getId());
        Assertions.assertEquals(EXPECTED_STATUS, debitCard.getStatus());
        Assertions.assertEquals(EXPECTED_NUMBER, debitCard.getCardNumber());
        Assertions.assertEquals(EXPECTED_SEQUENCE_NUMBER, debitCard.getSequenceNumber());
        Assertions.assertEquals(EXPECTED_CARD_HOLDER, debitCard.getCardHolder());
        Assertions.assertTrue(debitCard.getContactless());

        Assertions.assertEquals(EXPECTED_ATM_LIMIT_VALUE, debitCard.getAtmLimit().getValue());
        Assertions.assertEquals(EXPECTED_ATM_LIMIT_PERIOD_UNIT, debitCard.getAtmLimit().getPeriodUnit());
        Assertions.assertEquals(EXPECTED_ATM_LIMIT_TYPE, debitCard.getAtmLimit().getType());

        Assertions.assertEquals(EXPECTED_POS_LIMIT_VALUE, debitCard.getPosLimit().getValue());
        Assertions.assertEquals(EXPECTED_POS_LIMIT_PERIOD_UNIT, debitCard.getPosLimit().getPeriodUnit());
        Assertions.assertEquals(EXPECTED_POS_LIMIT_TYPE, debitCard.getPosLimit().getType());
    }
}
