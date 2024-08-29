package com.example.programmerfoxclubfinal.Reository;

import com.example.programmerfoxclubfinal.Tricks;
import com.example.programmerfoxclubfinal.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrickRepository extends CrudRepository<Tricks, Long> {
    @Query("SELECT u FROM User u where u.username = ?1 ")
    User setName(String name);

     Tricks findByNameOfTrick(String trickname);
}
