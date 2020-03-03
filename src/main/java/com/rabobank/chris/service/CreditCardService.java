package com.rabobank.chris.service;

import com.rabobank.chris.dao.CreditCardRepository;
import com.rabobank.chris.model.entities.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService extends EntityService<CreditCard, Integer> {

    @Autowired
    public CreditCardService(CreditCardRepository repository) {
        this.repository = repository;
    }
}
