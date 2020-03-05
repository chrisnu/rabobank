package com.rabobank.chris.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CreditCardDTO extends CardDTO {
    private Float monthlyLimit;
}
