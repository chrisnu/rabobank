package com.rabobank.chris.model.converter;

import com.rabobank.chris.model.dto.CreditCardDTO;
import com.rabobank.chris.model.entities.CreditCard;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class CreditCardDTOConverterTest {

    private ModelMapper modelMapper;

    @BeforeEach
    void setup() {
        var creditCardDTOConverter = new CreditCardDTOConverter();
        modelMapper = new ModelMapper();
        modelMapper.addConverter(creditCardDTOConverter);
    }

    @Test
    void convert() {
        var creditCard = new EasyRandom().nextObject(CreditCard.class);
        var map = modelMapper.map(creditCard, CreditCardDTO.class);

        assert map.getId().equals(creditCard.getId());
        assert map.getCardHolder().equals(creditCard.getCardHolder());
        assert map.getCardNumber().equals(creditCard.getCardNumber());
        assert map.getMonthlyLimit().equals(creditCard.getCreditLimit().getValue());
    }
}
