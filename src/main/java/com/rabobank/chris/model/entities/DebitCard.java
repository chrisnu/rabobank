package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.Limit;
import lombok.Data;

@Data
public class DebitCard extends Card {
    boolean contactless;
    Limit atmLimit;
    Limit posLimit;
}
