package com.example.programmerfoxclubfinal.Repository;
import com.example.programmerfoxclubfinal.Pokemon;
import com.example.programmerfoxclubfinal.Pokemon;
import com.example.programmerfoxclubfinal.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
    //    Modifying
//    @Transactional
//    @Query("UPDATE f JOIN u SET f.name WHERE f.user_id = u.id")
    //Fox setName(String name, Long userId);
    Pokemon findFirstByUser(User user);
    List<Pokemon> findAllByUser(User user);
}