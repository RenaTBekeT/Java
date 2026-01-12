package com.example.programmerfoxclubfinal.Repository;

import com.example.programmerfoxclubfinal.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u where u.username = ?1 ")
    User findByName(String name);
    long countByUsername(String username);


    User findByUsername(String username);
   // boolean existsByName(String name);
}


