package com.rabobank.chris.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class EntityService<T, ID> {

    protected JpaRepository<T, ID> repository;

    public List<T> findAll() {
        return this.repository.findAll();
    }

    public Optional<T> findById(ID id) {
        return this.repository.findById(id);
    }
}
