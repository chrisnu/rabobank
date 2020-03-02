package com.rabobank.chris.model;

import com.rabobank.chris.model.enums.Authorization;
import com.rabobank.chris.model.enums.Direction;

public class PowerOfAttorney {
    String id;
    String grantor;
    String grantee;
    String account;
    Direction direction;
    Authorization authorizations;
    CardReference cards;
}
