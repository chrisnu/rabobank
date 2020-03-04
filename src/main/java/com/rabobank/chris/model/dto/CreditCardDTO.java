package com.rabobank.chris.model.dto;

import com.rabobank.chris.model.enums.CardStatus;
import lombok.Data;

@Data
public class CreditCardDTO {
    private Integer id;
    private CardStatus Status;
    private Integer cardNumber;
    private Integer sequenceNumber;
    private String cardHolder;
    private Float monthlyLimit;
}
