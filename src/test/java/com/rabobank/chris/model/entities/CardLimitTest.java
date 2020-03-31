package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.enums.LimitType;
import com.rabobank.chris.model.enums.PeriodUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardLimitTest {

    private static final Integer EXPECTED_ID = 10;
    private static final float EXPECTED_VALUE = 99;
    private static final PeriodUnit EXPECTED_PERIOD_UNIT = PeriodUnit.PER_WEEK;
    private static final LimitType EXPECTED_TYPE = LimitType.POS;

    private CardLimit cardLimit;

    @BeforeEach
    public void setUp() {
        cardLimit = new CardLimit(10, 99, PeriodUnit.PER_WEEK, LimitType.POS);
    }

    @Test
    public void testAuthorization() {
        Assertions.assertEquals(EXPECTED_ID, cardLimit.getId());
        Assertions.assertEquals(EXPECTED_VALUE, cardLimit.getValue());
        Assertions.assertEquals(EXPECTED_PERIOD_UNIT, cardLimit.getPeriodUnit());
        Assertions.assertEquals(EXPECTED_TYPE, cardLimit.getType());
    }

}
