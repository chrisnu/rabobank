package com.rabobank.chris.model.entities;

import lombok.Getter;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Entity(name = "Account")
@Table(name = "account")
public class Account {

    protected Account() {
    }

    public Account(Integer id, String owner, float balance, Calendar created, Calendar ended) {
        Assert.hasLength(owner, "Account name should not be empty");
        Assert.isTrue(id > 0, "ID should be greater than 0");
        Assert.notNull(created, "Created should not be null");
        if (ended != null) {
            Assert.isTrue(ended.after(created), "Ended should be after created date");
        }

        this.id = id;
        this.owner = owner;
        this.balance = balance;
        this.created = created;
        this.ended = ended;
    }

    /**
     * In order to use database auto incremental flag, we set the generation type to IDENTITY
     */
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Column(nullable = false)
    @NotNull
    private String owner;

    @Getter
    @Column(length = 13, precision = 3, nullable = false)
    @NotNull
    private Float balance;

    @Getter
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    private Calendar created;

    @Getter
    @Temporal(TemporalType.DATE)
    private Calendar ended;
}
