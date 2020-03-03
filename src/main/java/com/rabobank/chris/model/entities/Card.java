package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.enums.CardStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "Card")
@Table(name = "card")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.STRING,
        name = "card_type",
        columnDefinition = "ENUM('DEBIT_CARD', 'CREDIT_CARD')"
)
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    CardStatus status;

    @Column(nullable = false)
    @NotNull
    Integer cardNumber;

    @Column(nullable = false)
    @NotNull
    Integer sequenceNumber;

    @Column(nullable = false)
    @NotNull
    String cardHolder;

    @OneToOne(cascade = CascadeType.ALL)
    CardLimit atmLimit;

    @OneToOne(cascade = CascadeType.ALL)
    CardLimit posLimit;

    @OneToOne(cascade = CascadeType.ALL)
    CardLimit creditLimit;

    @Column(nullable = false)
    @NotNull
    boolean contactless;
}
