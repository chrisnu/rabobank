package com.rabobank.chris.model.entities;

import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "DebittCard")
@DiscriminatorValue("DEBIT_CARD")
public class DebitCard extends Card {

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    private CardLimit atmLimit;

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    private CardLimit posLimit;

}
