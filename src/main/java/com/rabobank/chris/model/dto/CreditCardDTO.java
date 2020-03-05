package com.rabobank.chris.model.dto;

import lombok.Data;

@Data
public class CreditCardDTO extends CardDTO {
    private Float monthlyLimit;
}
