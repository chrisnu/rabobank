package com.rabobank.chris.service;

import com.rabobank.chris.dao.DebitCardRepository;
import com.rabobank.chris.model.entities.DebitCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DebitCardService extends EntityService<DebitCard, Integer> {

    @Autowired
    public DebitCardService(DebitCardRepository repository) {
        this.repository = repository;
    }
}
