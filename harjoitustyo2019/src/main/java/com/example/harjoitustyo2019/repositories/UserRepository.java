package com.example.harjoitustyo2019.repositories;

import com.example.harjoitustyo2019.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}