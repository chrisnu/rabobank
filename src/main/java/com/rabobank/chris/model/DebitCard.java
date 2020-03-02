package com.rabobank.chris.model;

import lombok.Data;

@Data
public class DebitCard extends Card {
    boolean contactless;
    Limit atmLimit;
    Limit posLimit;
}
