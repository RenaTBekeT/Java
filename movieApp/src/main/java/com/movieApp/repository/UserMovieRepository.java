package com.movieApp.repository;

import com.movieApp.model.User;
import com.movieApp.model.UserMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserMovieRepository extends JpaRepository<UserMovie, Long> {

    List<UserMovie> findAllByUser(User user);

    long countByUserAndMovie(User user, com.movieApp.model.Movie movie);

    UserMovie findByUserAndMovie(User user, com.movieApp.model.Movie movie);

    @Query("select um.movie.imdbId from UserMovie um where um.user = :user")
    List<String> findAllImdbIdsByUser(@Param("user") User user);
    UserMovie findByUserAndMovie_ImdbId(User user, String imdbId);
    long countByUserAndMovie_ImdbId(User user, String imdbId);

}