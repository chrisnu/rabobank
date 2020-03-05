package com.rabobank.chris.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class DebitCardDTO extends CardDTO {
    private CardLimitDTO atmLimit;
    private CardLimitDTO posLimit;
    private Boolean contactless;
}
