package com.rabobank.chris.api.exception;

import com.rabobank.chris.model.entities.CreditCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class EntityNotFoundExceptionTest {

    @Test
    public void testEntityNotFoundException() {
        Assertions.assertThrows(EntityNotFoundException.class, () -> {
           throw new EntityNotFoundException(1, CreditCard.class);
        });
    }
}
