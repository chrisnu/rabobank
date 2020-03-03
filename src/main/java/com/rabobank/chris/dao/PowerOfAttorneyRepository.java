package com.rabobank.chris.dao;

import com.rabobank.chris.model.entities.PowerOfAttorney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerOfAttorneyRepository extends JpaRepository<PowerOfAttorney, String> {
}
