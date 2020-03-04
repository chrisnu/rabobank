package com.rabobank.chris.model.dto;

import com.rabobank.chris.model.enums.CardStatus;
import lombok.Data;

@Data
public class DebitCardDTO {

    private Integer id;
    private CardStatus Status;
    private Integer cardNumber;
    private Integer sequenceNumber;
    private String cardHolder;
    private CardLimitDTO atmLimit;
    private CardLimitDTO posLimit;
    private Boolean contactless;
}
