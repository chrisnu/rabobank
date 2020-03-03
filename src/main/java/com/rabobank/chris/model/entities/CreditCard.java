package com.rabobank.chris.model.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity(name = "CreditCard")
@DiscriminatorValue("CREDIT_CARD")
public class CreditCard  extends Card {

    @Column(nullable = false, columnDefinition = "0")
    @NotNull
    boolean contactless = false;
}
