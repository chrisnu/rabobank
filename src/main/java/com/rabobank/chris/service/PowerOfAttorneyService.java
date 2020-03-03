package com.rabobank.chris.service;

import com.rabobank.chris.dao.PowerOfAttorneyRepository;
import com.rabobank.chris.model.entities.PowerOfAttorney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PowerOfAttorneyService extends EntityService<PowerOfAttorney, String> {

    @Autowired
    public PowerOfAttorneyService(PowerOfAttorneyRepository repository) {
        this.repository = repository;
    }
}
