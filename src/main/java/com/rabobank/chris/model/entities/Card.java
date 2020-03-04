package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.enums.CardStatus;
import lombok.Data;

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
@Data
public class Card {

    /**
     * In order to use database auto incremental flag, we set the generation type to IDENTITY
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    protected CardStatus status;

    @Column(nullable = false)
    @NotNull
    protected Integer cardNumber;

    @Column(nullable = false)
    @NotNull
    protected Integer sequenceNumber;

    @Column(nullable = false)
    @NotNull
    protected String cardHolder;

    @Column(nullable = false)
    @NotNull
    protected Boolean contactless;
}
