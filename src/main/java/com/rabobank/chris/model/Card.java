package com.rabobank.chris.model;

import lombok.Data;

@Data
public abstract class Card {
    String id;
    Integer cardNumber;
    Integer squenceNumber;
    String cardHolder;
}
