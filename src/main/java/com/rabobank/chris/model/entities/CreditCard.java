package com.rabobank.chris.model.entities;

import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "CreditCard")
@DiscriminatorValue("CREDIT_CARD")
public class CreditCard  extends Card {

    @Getter
    @OneToOne(cascade = CascadeType.ALL)
    private CardLimit creditLimit;

}
