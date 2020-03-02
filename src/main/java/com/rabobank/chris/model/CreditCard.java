package com.rabobank.chris.model;

import lombok.Data;

@Data
public class CreditCard  extends Card {
    Integer monthlyLimit;
}
