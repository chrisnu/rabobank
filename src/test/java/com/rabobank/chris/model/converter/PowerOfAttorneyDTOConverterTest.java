package com.rabobank.chris.model.converter;

import com.rabobank.chris.model.dto.CardReferenceDTO;
import com.rabobank.chris.model.dto.PowerOfAttorneyDTO;
import com.rabobank.chris.model.entities.Authorization;
import com.rabobank.chris.model.entities.Card;
import com.rabobank.chris.model.entities.PowerOfAttorney;
import com.rabobank.chris.model.enums.AuthorizationValue;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.Optional;

class PowerOfAttorneyDTOConverterTest {

    private ModelMapper modelMapper;

    @BeforeEach
    void setup() {
        var powerOfAttorneyDTOConverter = new PowerOfAttorneyDTOConverter();
        modelMapper = new ModelMapper();
        modelMapper.addConverter(powerOfAttorneyDTOConverter);
    }

    @Test
    void convert() {
        var poa = new EasyRandom().nextObject(PowerOfAttorney.class);
        var map = modelMapper.map(poa, PowerOfAttorneyDTO.class);

        assert map.getId().equals(poa.getId());
        assert map.getAccount().equals(poa.getAccount());
        assert map.getDirection().equals(poa.getDirection());
        assert map.getGrantee().equals(poa.getGrantee().getOwner());
        assert map.getGrantor().equals(poa.getGrantor().getOwner());

        AuthorizationValue existingAuth = map.getAuthorizations().get(0);
        Optional<Authorization> firstAuth = poa.getAuthorizations().stream()
                .filter(p -> p.getValue().equals(existingAuth))
                .findFirst();
        assert firstAuth.isPresent();

        CardReferenceDTO cardReferenceDTO = map.getCards().get(0);
        Optional<Card> firstCard = poa.getCards().stream()
                .filter(c -> c.getId().equals(cardReferenceDTO.getId()))
                .findFirst();
        assert firstCard.isPresent();
    }
}
