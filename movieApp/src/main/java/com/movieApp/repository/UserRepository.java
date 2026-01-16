package com.movieApp.repository;

import com.movieApp.model.Movie;
import com.movieApp.model.User;
import com.movieApp.model.UserMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    long countByUsername(String username);
    Boolean existsByUsername(String username);
}