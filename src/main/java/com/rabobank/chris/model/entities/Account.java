package com.rabobank.chris.model.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Entity(name = "Account")
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(nullable = false)
    @NotNull
    String owner;

    @Column(length = 13, precision = 4, nullable = false)
    @NotNull
    Double balance;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    Calendar created;

    @Temporal(TemporalType.DATE)
    Calendar ended;
}
