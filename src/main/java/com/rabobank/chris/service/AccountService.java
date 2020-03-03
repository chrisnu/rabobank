package com.rabobank.chris.service;

import com.rabobank.chris.dao.AccountRepository;
import com.rabobank.chris.model.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends EntityService<Account, Integer> {

    @Autowired
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }
}
