package com.example.programmerfoxclubfinal.Services;

import com.example.programmerfoxclubfinal.Fox;
import com.example.programmerfoxclubfinal.Reository.FoxRepository;
import com.example.programmerfoxclubfinal.Reository.TrickRepository;
import com.example.programmerfoxclubfinal.Reository.UsersRepository;
import com.example.programmerfoxclubfinal.Tricks;
import com.example.programmerfoxclubfinal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@Service
public class FoxService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private FoxRepository foxRepository;
    @Autowired
    private TrickRepository trickRepository;

    //  private List<Fox> foxes;
    //   public List<String> currentTricks;
    public User createUser(User user) {
        return usersRepository.save(user);
    }

    public Fox createFox(Fox fox) {
        return foxRepository.save(fox);
    }
//    public boolean isNameExists(String name) {
//        return usersRepository.existsByName(name);
//    }

    public User register(String name, String password) {
        // if (!isNameExists(name)) {
        User user = new User(name, password);
        Fox newfox = new Fox();
        usersRepository.save(user);
        newfox.setUser(user);
        foxRepository.save(newfox);
        return user;
        //} else return null;
    }


    public Boolean isUser(String name, String password) {
        User user = usersRepository.findByName(name);
        if (user == null) {
            return false;
        }
        if (!user.getPassword().equals(password)) {
            return false;
        }
        return true;
    }

    public void add(String name) {
        Fox newFox = new Fox(name);
        foxRepository.save(newFox);
    }

    public void updateFoxName(String setName, String name) {
        User user = usersRepository.findByName(name);
        Fox fox = (Fox) user.getFox().toArray()[0];
        //  Fox fox = foxRepository.findFirstByUser(user);
        fox.setName(setName);
        foxRepository.save(fox);
        // foxRepository.setName(setName, user.getId().longValue());
    }

    public void updateFoxFoodAndDrink(String food, String drink, String name) {
        User user = usersRepository.findByName(name);
        Fox fox = (Fox) user.getFox().toArray()[0];
        //  Fox fox = foxRepository.findFirstByUser(user);
        fox.setFood(food);
        fox.setDrink(drink);
        foxRepository.save(fox);
        // foxRepository.setName(setName, user.getId().longValue());
    }

    public void updateTricks(String trickName, String name) {
        User user = usersRepository.findByName(name);
        Fox fox = (Fox) user.getFox().toArray()[0];
        Tricks trick = trickRepository.findByNameOfTrick(trickName);
        fox.getTricks().add(trick);
        trick.getFox().add(fox);
        foxRepository.save(fox);
        trickRepository.save(trick);
    }

    public void addAnotherFox(String name) {
        User user = usersRepository.findByName(name);
        Fox newfox = new Fox();
        newfox.setUser(user);
        foxRepository.save(newfox);
        //} else return null;
    }
}
