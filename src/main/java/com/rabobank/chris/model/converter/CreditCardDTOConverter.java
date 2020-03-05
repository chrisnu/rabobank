package com.rabobank.chris.model.converter;

import com.rabobank.chris.model.dto.CreditCardDTO;
import com.rabobank.chris.model.entities.CreditCard;
import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

public class CreditCardDTOConverter implements Converter<CreditCard, CreditCardDTO> {

    @Override
    public CreditCardDTO convert(MappingContext<CreditCard, CreditCardDTO> context) {
        final var source = context.getSource();
        final var destination = new CreditCardDTO();

        destination.setId(source.getId());
        destination.setStatus(source.getStatus());
        destination.setCardNumber(source.getCardNumber());
        destination.setSequenceNumber(source.getSequenceNumber());
        destination.setCardHolder(source.getCardHolder());
        final var creditLimit = source.getCreditLimit();
        if (creditLimit != null) {
            destination.setMonthlyLimit(creditLimit.getValue());
        }

        return destination;
    }
}
