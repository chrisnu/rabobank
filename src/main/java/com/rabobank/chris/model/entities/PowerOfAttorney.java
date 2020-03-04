package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.enums.Direction;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "PowerOfAttorney")
@Table(name = "power_of_attorney")
@Data
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
    private String id;

    @ManyToOne
    @NotNull
    private Account grantor;

    @ManyToOne
    @NotNull
    private Account grantee;

    @Column(nullable = false)
    @NotNull
    private String account;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Direction direction;

    @ManyToMany
    private List<Authorization> authorizations;

    @OneToMany
    private List<Card> cards;
}
