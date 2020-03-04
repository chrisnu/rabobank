package com.rabobank.chris.model.dto;

import com.rabobank.chris.model.enums.PeriodUnit;
import lombok.Data;

@Data
public class CardLimitDTO {
    Float limit;
    PeriodUnit periodUnit;
}
