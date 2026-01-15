package com.movieApp.repository;

import com.movieApp.model.User;
import com.movieApp.model.Movie;
import com.movieApp.model.UserMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserMovieRepository extends JpaRepository<UserMovie, Long> {

    List<UserMovie> findAllByUser(User user);

    // aby sis zabránil duplicitám: stejný user + stejný movie
    long countByUserAndMovie(User user, Movie movie);

    UserMovie findByUserAndMovie(User user, Movie movie);
}