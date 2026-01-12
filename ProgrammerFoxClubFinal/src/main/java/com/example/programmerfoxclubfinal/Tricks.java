package com.example.programmerfoxclubfinal;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Optional;
import java.util.Set;
@Getter
@Entity
public class Tricks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOfTrick;

    @ManyToMany
    // @JoinColumn(name = "fox_id")
    private Set<Pokemon> pokemon;

    public String getNameOfTrick() {
        return nameOfTrick;
    }

    public void setPokemon(Optional<Pokemon> pokemon) {
    }

    @Override
    public String toString() {
        return nameOfTrick;
    }
}