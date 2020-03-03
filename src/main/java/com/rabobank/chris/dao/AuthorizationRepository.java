package com.rabobank.chris.dao;

import com.rabobank.chris.model.entities.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorizationRepository extends JpaRepository<Authorization, Integer> {
}
