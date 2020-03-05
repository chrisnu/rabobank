package com.rabobank.chris.model.dto;

import lombok.Data;

@Data
public class DebitCardDTO extends CardDTO {
    private CardLimitDTO atmLimit;
    private CardLimitDTO posLimit;
    private Boolean contactless;
}
