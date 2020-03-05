package com.rabobank.chris.model.dto;

import com.rabobank.chris.model.enums.AuthorizationValue;
import com.rabobank.chris.model.enums.Direction;
import lombok.Data;

import java.util.List;

@Data
public class AggregateDTO {
    private String id;
    private String grantor;
    private String grantee;
    private String account;
    private Direction direction;
    private List<AuthorizationValue> authorizations;
    private List<? extends CardDTO> cards;
}
