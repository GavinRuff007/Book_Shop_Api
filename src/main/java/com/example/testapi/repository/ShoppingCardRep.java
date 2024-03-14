package com.example.testapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCardRep extends JpaRepository<com.example.testapi.model.ShoppingCard,Long> {
}
