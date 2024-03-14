package com.example.testapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRep extends JpaRepository<com.example.testapi.model.Book,Long> {
}
