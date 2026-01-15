package com.movieApp.repository;

import com.movieApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    long countByUsername(String username);
    Boolean existsByUsername(String username);
}