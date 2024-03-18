package com.example.testapi.repository;

import com.example.testapi.model.Factor;
import com.example.testapi.model.Payed;
import com.example.testapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FactorRep extends JpaRepository<com.example.testapi.model.Factor,Long> {
    Optional<Factor> findByUserAndPayed(User user, Payed payed);
}
