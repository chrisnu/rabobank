package com.rabobank.chris.service;

import com.rabobank.chris.dao.AuthorizationRepository;
import com.rabobank.chris.model.entities.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService extends EntityService<Authorization, Integer> {

    @Autowired
    public AuthorizationService(AuthorizationRepository repository) {
        this.repository = repository;
    }
}
