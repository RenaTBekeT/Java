package com.example.programmerfoxclubfinal.Repository;

import com.example.programmerfoxclubfinal.Pokemon;
import com.example.programmerfoxclubfinal.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    List<Pokemon> findAllByUser(User user);

    Optional<Pokemon> findByIdAndUser(Long id, User user);

    void deleteByIdAndUser(Long id, User user);
}