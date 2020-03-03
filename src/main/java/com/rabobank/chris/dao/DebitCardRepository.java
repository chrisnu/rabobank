package com.rabobank.chris.dao;

import com.rabobank.chris.model.entities.DebitCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebitCardRepository extends JpaRepository<DebitCard, Integer> {
}
