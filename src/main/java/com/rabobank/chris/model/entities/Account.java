package com.rabobank.chris.model.entities;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Entity(name = "Account")
@Table(name = "account")
public class Account {

    /**
     * In order to use database auto incremental flag, we set the generation type to IDENTITY
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Column(nullable = false)
    @NotNull
    private String owner;

    @Column(length = 13, precision = 3, nullable = false)
    @NotNull
    private Float balance;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    private Calendar created;

    @Temporal(TemporalType.DATE)
    private Calendar ended;
}
