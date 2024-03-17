package com.example.testapi.repository;

import com.example.testapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRep extends JpaRepository<com.example.testapi.model.Book,Long> {

    Optional<Book> findByname(String name);
}
