package com.example.testapi.repository;

import com.example.testapi.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Repository
public interface UserRep extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
