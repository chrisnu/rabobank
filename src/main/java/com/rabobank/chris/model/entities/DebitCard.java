package com.rabobank.chris.model.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity(name = "DebittCard")
@DiscriminatorValue("DEBIT_CARD")
public class DebitCard extends Card {

    @Column(nullable = false, columnDefinition = "1")
    @NotNull
    boolean contactless = true;
}
