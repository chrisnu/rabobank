package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.enums.CardStatus;
import lombok.Data;

@Data
public abstract class Card {
    String id;
    CardStatus cardStatus;
    Integer cardNumber;
    Integer sequenceNumber;
    String cardHolder;
}
