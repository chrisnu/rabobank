package com.rabobank.chris.model.converter;

import com.rabobank.chris.model.dto.DebitCardDTO;
import com.rabobank.chris.model.entities.DebitCard;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

class DebitCardDTOConverterTest {

    private DebitCard debitCard;
    private DebitCardDTO dto;

    @BeforeEach
    void setup() {
        var debitCardDTOConverter = new DebitCardDTOConverter();
        var modelMapper = new ModelMapper();
        modelMapper.addConverter(debitCardDTOConverter);

        debitCard = new EasyRandom().nextObject(DebitCard.class);
        dto = modelMapper.map(debitCard, DebitCardDTO.class);
    }

    @Test
    void testConvert() {
        Assertions.assertEquals(dto.getId(), debitCard.getId());
        Assertions.assertEquals(dto.getCardHolder(), debitCard.getCardHolder());
        Assertions.assertEquals(dto.getCardNumber(), debitCard.getCardNumber());
        Assertions.assertEquals(dto.getAtmLimit().getLimit(), debitCard.getAtmLimit().getValue());
        Assertions.assertEquals(dto.getPosLimit().getLimit(), debitCard.getPosLimit().getValue());
    }
}
