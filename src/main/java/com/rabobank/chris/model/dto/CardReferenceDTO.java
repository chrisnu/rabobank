package com.rabobank.chris.model.dto;

import com.rabobank.chris.model.enums.CardType;
import lombok.Data;

@Data
public class CardReferenceDTO {
    Integer id;
    CardType type;
}
