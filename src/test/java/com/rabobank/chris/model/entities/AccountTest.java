package com.rabobank.chris.model.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

class AccountTest {

    private static final Integer EXPECTED_ACCOUNT_ID = 1;
    private static final String EXPECTED_OWNER = "Owner";
    private static final float EXPECTED_BALANCE = 50;
    private static final float EXPECTED_CREATED_YEAR = 2020;
    private static final float EXPECTED_CREATED_MONTH = 0;
    private static final float EXPECTED_CREATED_DAY = 1;

    private Account account;

    @BeforeEach
    public void setUp() {
        Calendar created = Calendar.getInstance();
        created.set(2020, Calendar.JANUARY , 1);
        account = new Account(1, "Owner", 50, created, null);
    }

    @Test
    public void testAccount() {
        Assertions.assertEquals(EXPECTED_ACCOUNT_ID, account.getId());
        Assertions.assertEquals(EXPECTED_OWNER, account.getOwner());
        Assertions.assertEquals(EXPECTED_BALANCE, account.getBalance());
        Assertions.assertEquals(EXPECTED_CREATED_YEAR, account.getCreated().get(Calendar.YEAR));
        Assertions.assertEquals(EXPECTED_CREATED_MONTH, account.getCreated().get(Calendar.MONTH));
        Assertions.assertEquals(EXPECTED_CREATED_DAY, account.getCreated().get(Calendar.DAY_OF_MONTH));
    }
}
