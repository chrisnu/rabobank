package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.enums.LimitType;
import com.rabobank.chris.model.enums.PeriodUnit;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "CardLimit")
@Table(name = "card_limit")
public class CardLimit {

    @Id
    @GeneratedValue
    Integer id;

    @Column(length = 13, precision = 3, nullable = false)
    @NotNull
    Float value;

    @Column(nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    PeriodUnit periodUnit;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    LimitType type;
}
