package com.example.programmerfoxclubfinal.Reository;

import com.example.programmerfoxclubfinal.Tricks;
import com.example.programmerfoxclubfinal.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u where u.username = ?1 ")
    User findByName(String name);

    User findByUsername(String username);
   // boolean existsByName(String name);
}


