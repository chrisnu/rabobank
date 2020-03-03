package com.rabobank.chris.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "CreditCard")
@DiscriminatorValue("CREDIT_CARD")
public class CreditCard  extends Card {

    @OneToOne(cascade = CascadeType.ALL)
    CardLimit creditLimit;

    @Column(nullable = false)
    @NotNull
    boolean contactless = false;
}
