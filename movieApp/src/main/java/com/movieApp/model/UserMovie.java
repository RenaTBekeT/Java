package com.movieApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="user_movie",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id","movie_id"}))
public class UserMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer rating; // 1-10 nebo 1-100 podle tebe

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    public UserMovie() {}

    public UserMovie(User user, Movie movie) {
        this.user = user;
        this.movie = movie;
    }
}