package com.rabobank.chris.model.converter;

import com.rabobank.chris.model.dto.CardReferenceDTO;
import com.rabobank.chris.model.dto.PowerOfAttorneyDTO;
import com.rabobank.chris.model.entities.CreditCard;
import com.rabobank.chris.model.entities.PowerOfAttorney;
import com.rabobank.chris.model.enums.AuthorizationValue;
import com.rabobank.chris.model.enums.CardType;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PowerOfAttorneyDTOConverter implements Converter<PowerOfAttorney, PowerOfAttorneyDTO> {

    @Override
    public PowerOfAttorneyDTO convert(MappingContext<PowerOfAttorney, PowerOfAttorneyDTO> context) {
        PowerOfAttorney source = context.getSource();
        var destination = new PowerOfAttorneyDTO();

        destination.setId(source.getId());
        destination.setGrantor(source.getGrantor().getOwner());
        destination.setGrantee(source.getGrantee().getOwner());
        destination.setAccount(source.getAccount());
        destination.setDirection(source.getDirection());

        var autorizations = new ArrayList<AuthorizationValue>();
        source.getAuthorizations().stream()
                .forEach(auth -> autorizations.add(auth.getValue()));
        destination.setAuthorizations(autorizations);

        destination.setCards(source.getCards()
            .stream()
            .map(card -> {
                CardReferenceDTO cardReferenceDTO = new CardReferenceDTO();
                cardReferenceDTO.setId(card.getId());
                if (card instanceof CreditCard) {
                    cardReferenceDTO.setType(CardType.CREDIT_CARD);
                } else {
                    cardReferenceDTO.setType(CardType.DEBIT_CARD);
                }

                return cardReferenceDTO;
            })
            .collect(Collectors.toList())
        );

        return destination;
    }
}
