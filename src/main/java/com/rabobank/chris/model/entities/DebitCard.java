package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.enums.CardStatus;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "DebittCard")
@DiscriminatorValue("DEBIT_CARD")
public class DebitCard extends Card {

    protected DebitCard() {
    }

    public DebitCard(Integer id, CardStatus status, Integer cardNumber, Integer sequenceNumber, String cardHolder, Boolean contactless, CardLimit atmLimit, CardLimit posLimit) {
        this.id = id;
        this.status = status;
        this.cardNumber = cardNumber;
        this.sequenceNumber = sequenceNumber;
        this.cardHolder = cardHolder;
        this.contactless = contactless;
        this.atmLimit = atmLimit;
        this.posLimit = posLimit;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    private CardLimit atmLimit;

    @OneToOne(cascade = CascadeType.ALL)
    @Getter
    private CardLimit posLimit;

}
