package com.rabobank.chris.model.entities;

import com.rabobank.chris.model.CardReference;
import com.rabobank.chris.model.enums.Authorization;
import com.rabobank.chris.model.enums.Direction;
import lombok.Data;

@Data
public class PowerOfAttorney {
    String id;
    String grantor;
    String grantee;
    String account;
    Direction direction;
    Authorization authorizations;
    CardReference cards;
}
