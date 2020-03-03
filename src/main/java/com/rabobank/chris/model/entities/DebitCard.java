package com.rabobank.chris.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "DebittCard")
@DiscriminatorValue("DEBIT_CARD")
public class DebitCard extends Card {

    @OneToOne(cascade = CascadeType.ALL)
    CardLimit atmLimit;

    @OneToOne(cascade = CascadeType.ALL)
    CardLimit posLimit;

    @Column(nullable = false)
    @NotNull
    boolean contactless = true;
}
