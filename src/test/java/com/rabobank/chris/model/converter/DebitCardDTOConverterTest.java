package com.rabobank.chris.model.converter;

import com.rabobank.chris.model.dto.DebitCardDTO;
import com.rabobank.chris.model.entities.DebitCard;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
class DebitCardDTOConverterTest {

    private ModelMapper modelMapper;

    @BeforeEach
    void setup() {
        var debitCardDTOConverter = new DebitCardDTOConverter();
        modelMapper = new ModelMapper();
        modelMapper.addConverter(debitCardDTOConverter);
    }

    @Test
    void convert() {
        var debitCard = new EasyRandom().nextObject(DebitCard.class);
        var map = modelMapper.map(debitCard, DebitCardDTO.class);

        assert map.getId().equals(debitCard.getId());
        assert map.getCardHolder().equals(debitCard.getCardHolder());
        assert map.getCardNumber().equals(debitCard.getCardNumber());
        assert map.getAtmLimit().getLimit().equals(debitCard.getAtmLimit().getValue());
        assert map.getPosLimit().getLimit().equals(debitCard.getPosLimit().getValue());
    }
}
