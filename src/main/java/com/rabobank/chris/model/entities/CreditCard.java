package com.rabobank.chris.model.entities;

import lombok.Data;

@Data
public class CreditCard  extends Card {
    Integer monthlyLimit;
}
