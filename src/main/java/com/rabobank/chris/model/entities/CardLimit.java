package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.enums.LimitType;
import com.rabobank.chris.model.enums.PeriodUnit;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "CardLimit")
@Table(name = "card_limit")
public class CardLimit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 13, precision = 3, nullable = false)
    @NotNull
    @Getter
    private Float value;

    @Column(nullable = false)
    @NotNull
    @Enumerated(EnumType.STRING)
    @Getter
    private PeriodUnit periodUnit;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LimitType type;
}
