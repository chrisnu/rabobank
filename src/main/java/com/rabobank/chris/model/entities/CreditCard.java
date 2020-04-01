package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.enums.CardStatus;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "CreditCard")
@DiscriminatorValue("CREDIT_CARD")
public class CreditCard  extends Card {

    protected CreditCard() {
        super();
    }

    public CreditCard(Integer id, CardStatus status, Integer cardNumber, Integer sequenceNumber, String cardHolder, Boolean contactless, CardLimit creditLimit) {
        this.id = id;
        this.status = status;
        this.cardNumber = cardNumber;
        this.sequenceNumber = sequenceNumber;
        this.cardHolder = cardHolder;
        this.contactless = contactless;
        this.creditLimit = creditLimit;
    }

    @Getter
    @OneToOne(cascade = CascadeType.ALL)
    private CardLimit creditLimit;

}
