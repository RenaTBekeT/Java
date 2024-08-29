package com.example.programmerfoxclubfinal.Reository;
import com.example.programmerfoxclubfinal.Fox;
import com.example.programmerfoxclubfinal.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoxRepository extends CrudRepository<Fox, Long> {
    //    Modifying
//    @Transactional
//    @Query("UPDATE f JOIN u SET f.name WHERE f.user_id = u.id")
    //Fox setName(String name, Long userId);
    Fox findFirstByUser(User user);
}