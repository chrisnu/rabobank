package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.enums.Direction;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "PowerOfAttorney")
@Table(name = "power_of_attorney")
public class PowerOfAttorney {

    /**
     * We are creating custom id generator where it generates numerical increment with 4 zeroes fill value
     */
    @Id
    @Column(length = 4)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "poa_seq")
    @GenericGenerator(
            name = "poa_seq",
            strategy = "com.rabobank.chris.model.generator.POASequenceGenerator"
    )
    String id;

    @ManyToOne
    @NotNull
    Account grantor;

    @ManyToOne
    @NotNull
    Account grantee;

    @Column(nullable = false)
    @NotNull
    String account;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    Direction direction;

    @ManyToMany
    List<Authorization> authorizations;

    @OneToMany
    List<Card> cards;
}
