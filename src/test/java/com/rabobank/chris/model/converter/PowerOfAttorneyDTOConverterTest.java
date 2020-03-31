package com.rabobank.chris.model.converter;

import com.rabobank.chris.model.dto.CardReferenceDTO;
import com.rabobank.chris.model.dto.PowerOfAttorneyDTO;
import com.rabobank.chris.model.entities.Authorization;
import com.rabobank.chris.model.entities.Card;
import com.rabobank.chris.model.entities.PowerOfAttorney;
import com.rabobank.chris.model.enums.AuthorizationValue;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.Optional;

class PowerOfAttorneyDTOConverterTest {

    PowerOfAttorney poa;
    PowerOfAttorneyDTO dto;

    @BeforeEach
    void setup() {
        var powerOfAttorneyDTOConverter = new PowerOfAttorneyDTOConverter();
        var modelMapper = new ModelMapper();
        modelMapper.addConverter(powerOfAttorneyDTOConverter);

        poa = new EasyRandom().nextObject(PowerOfAttorney.class);
        dto = modelMapper.map(poa, PowerOfAttorneyDTO.class);
    }

    @Test
    void testConvert() {
        Assertions.assertEquals(dto.getId(), poa.getId());
        Assertions.assertEquals(dto.getAccount(), poa.getAccount());
        Assertions.assertEquals(dto.getDirection(), poa.getDirection());
        Assertions.assertEquals(dto.getGrantee(), poa.getGrantee().getOwner());
        Assertions.assertEquals(dto.getGrantor(), poa.getGrantor().getOwner());

        AuthorizationValue existingAuth = dto.getAuthorizations().get(0);
        Optional<Authorization> firstAuth = poa.getAuthorizations().stream()
                .filter(p -> p.getValue().equals(existingAuth))
                .findFirst();
        Assertions.assertTrue(firstAuth.isPresent());

        CardReferenceDTO cardReferenceDTO = dto.getCards().get(0);
        Optional<Card> firstCard = poa.getCards().stream()
                .filter(c -> c.getId().equals(cardReferenceDTO.getId()))
                .findFirst();
        Assertions.assertTrue(firstCard.isPresent());
    }
}
