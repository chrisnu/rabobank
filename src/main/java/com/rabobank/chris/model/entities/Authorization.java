package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.enums.AuthorizationValue;

import javax.persistence.*;

@Entity(name = "Authorization")
@Table(name = "authorization")
public class Authorization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, unique = true, length = 20)
    @Enumerated(EnumType.STRING)
    AuthorizationValue value;
}
