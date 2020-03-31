package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.enums.AuthorizationValue;
import lombok.Getter;

import javax.persistence.*;

@Entity(name = "Authorization")
@Table(name = "authorization")
public class Authorization {

    protected Authorization() {
    }

    public Authorization(Integer id, AuthorizationValue value) {
        this.id = id;
        this.value = value;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @Column(nullable = false, unique = true, length = 20)
    @Enumerated(EnumType.STRING)
    @Getter
    private AuthorizationValue value;
}
