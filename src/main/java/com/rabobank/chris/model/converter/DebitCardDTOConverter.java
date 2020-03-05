package com.rabobank.chris.model.converter;

import com.rabobank.chris.model.dto.CardLimitDTO;
import com.rabobank.chris.model.dto.DebitCardDTO;
import com.rabobank.chris.model.entities.CardLimit;
import com.rabobank.chris.model.entities.DebitCard;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class DebitCardDTOConverter implements Converter<DebitCard, DebitCardDTO> {

    @Override
    public DebitCardDTO convert(MappingContext<DebitCard, DebitCardDTO> context) {
        final var source = context.getSource();
        final var destination = new DebitCardDTO();

        destination.setId(source.getId());
        destination.setStatus(source.getStatus());
        destination.setCardNumber(source.getCardNumber());
        destination.setSequenceNumber(source.getSequenceNumber());
        destination.setContactless(source.getContactless());
        destination.setCardHolder(source.getCardHolder());

        CardLimit atmLimit = source.getAtmLimit();
        if (atmLimit != null) {
            var cardLimitDTO = new CardLimitDTO();
            cardLimitDTO.setLimit(atmLimit.getValue());
            cardLimitDTO.setPeriodUnit(atmLimit.getPeriodUnit());
            destination.setAtmLimit(cardLimitDTO);
        }

        CardLimit posLimit = source.getPosLimit();
        if (posLimit != null) {
            var cardLimitDTO = new CardLimitDTO();
            cardLimitDTO.setLimit(posLimit.getValue());
            cardLimitDTO.setPeriodUnit(posLimit.getPeriodUnit());
            destination.setPosLimit(cardLimitDTO);
        }

        return destination;
    }
}
