package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.enums.AuthorizationValue;
import lombok.Getter;

import javax.persistence.*;

@Entity(name = "Authorization")
@Table(name = "authorization")
public class Authorization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 20)
    @Enumerated(EnumType.STRING)
    @Getter
    private AuthorizationValue value;
}
