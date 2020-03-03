package com.rabobank.chris.model.entities;

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
    Integer id;

    @Column(nullable = false)
    @NotNull
    String owner;

    @Column(length = 13, precision = 3, nullable = false)
    @NotNull
    Float balance;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    Calendar created;

    @Temporal(TemporalType.DATE)
    Calendar ended;
}
