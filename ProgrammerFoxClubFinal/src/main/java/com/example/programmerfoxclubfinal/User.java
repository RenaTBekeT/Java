package com.example.programmerfoxclubfinal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@Entity
public class User {

    private String username;
    private String password;
    @Column(name = "profile_image_path")
    private String profileImagePath;


    @OneToMany(mappedBy = "user")
    private Set<Pokemon> pokemon;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Collection<Pokemon> getPokemons() {
        return java.util.List.of();
    }
}
