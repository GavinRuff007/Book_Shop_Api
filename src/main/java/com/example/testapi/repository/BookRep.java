package com.example.testapi.repository;

import com.example.testapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRep extends JpaRepository<com.example.testapi.model.Book,Long> {

    Optional<Book> findByname(String name);
    @Query("select b from Book b where b.name like :name ")
    List<Book> findBookByName(String name);
}
