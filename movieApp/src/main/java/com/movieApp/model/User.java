package com.movieApp.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<UserMovie> userMovie;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }
}