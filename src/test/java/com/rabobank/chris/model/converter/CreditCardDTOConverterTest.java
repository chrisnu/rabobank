package com.rabobank.chris.model.converter;

import com.rabobank.chris.model.dto.CreditCardDTO;
import com.rabobank.chris.model.entities.CreditCard;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

class CreditCardDTOConverterTest {

    private CreditCard creditCard;
    private CreditCardDTO dto;

    @BeforeEach
    void setup() {
        var creditCardDTOConverter = new CreditCardDTOConverter();
        var modelMapper = new ModelMapper();
        modelMapper.addConverter(creditCardDTOConverter);

        creditCard = new EasyRandom().nextObject(CreditCard.class);
        dto = modelMapper.map(creditCard, CreditCardDTO.class);
    }

    @Test
    void testConvert() {
        Assertions.assertEquals(dto.getId(), creditCard.getId());
        Assertions.assertEquals(dto.getCardHolder(), creditCard.getCardHolder());
        Assertions.assertEquals(dto.getCardNumber(), creditCard.getCardNumber());
        Assertions.assertEquals(dto.getMonthlyLimit(), creditCard.getCreditLimit().getValue());
    }
}
