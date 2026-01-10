package com.example.programmerfoxclubfinal.Services;

import com.example.programmerfoxclubfinal.Fox;
import com.example.programmerfoxclubfinal.Reository.FoxRepository;
import com.example.programmerfoxclubfinal.Reository.TrickRepository;
import com.example.programmerfoxclubfinal.Reository.UsersRepository;
import com.example.programmerfoxclubfinal.Tricks;
import com.example.programmerfoxclubfinal.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class FoxService {

    private final UsersRepository usersRepository;
    private final FoxRepository foxRepository;
    private final TrickRepository trickRepository;

    public FoxService(UsersRepository usersRepository,
                      FoxRepository foxRepository,
                      TrickRepository trickRepository) {
        this.usersRepository = usersRepository;
        this.foxRepository = foxRepository;
        this.trickRepository = trickRepository;
    }

    public User createUser(User user) {
        return usersRepository.save(user);
    }

    public Fox createFox(Fox fox) {
        return foxRepository.save(fox);
    }

    public User register(String name, String password) {
        User user = new User(name, password);
        usersRepository.save(user);

        // vytvoříme default lišku, aby appka hned fungovala
        Fox newFox = new Fox();
        newFox.setUser(user);
        foxRepository.save(newFox);

        // pokud má User kolekci foxů a mapping je bidirectional,
        // je dobré ji udržovat i na této straně (neškodí to)
        try {
            if (user.getFox() != null) {
                user.getFox().add(newFox);
                usersRepository.save(user);
            }
        } catch (Exception ignored) {
            // když mapping/collection není takto nastavená, nebudeme to tady lámat
        }

        return user;
    }

    public boolean isUser(String name, String password) {
        User user = usersRepository.findByUsername(name);
        if (user == null) return false;
        return user.getPassword() != null && user.getPassword().equals(password);
    }

    public void updateFoxName(String setName, String username) {
        User user = usersRepository.findByUsername(username);
        if (user == null) return;

        Fox fox = getOrCreatePrimaryFox(user);
        fox.setName(setName);
        foxRepository.save(fox);
    }

    public void updateFoxFoodAndDrink(String food, String drink, String username) {
        User user = usersRepository.findByUsername(username);
        if (user == null) return;

        Fox fox = getOrCreatePrimaryFox(user);
        fox.setFood(food);
        fox.setDrink(drink);
        foxRepository.save(fox);
    }

    public void updateTricks(String trickName, String username) {
        User user = usersRepository.findByUsername(username);
        if (user == null) return;

        Fox fox = getOrCreatePrimaryFox(user);

        Tricks trick = trickRepository.findByNameOfTrick(trickName);
        if (trick == null) return;

        // zabráníme duplicitám a zbytečným save
        if (fox.getTricks() != null && fox.getTricks().contains(trick)) {
            return;
        }

        fox.getTricks().add(trick);

        // obousměrný vztah jen pokud existuje kolekce i na tricku
        try {
            if (trick.getFox() != null && !trick.getFox().contains(fox)) {
                trick.getFox().add(fox);
            }
        } catch (Exception ignored) {
        }

        foxRepository.save(fox);
        trickRepository.save(trick);
    }

    public void addAnotherFox(String username) {
        User user = usersRepository.findByUsername(username);
        if (user == null) return;

        Fox newFox = new Fox();
        newFox.setUser(user);
        foxRepository.save(newFox);

        // udržet kolekci na userovi (pokud existuje a je mutable)
        try {
            if (user.getFox() != null) {
                user.getFox().add(newFox);
                usersRepository.save(user);
            }
        } catch (Exception ignored) {
        }
    }

    /**
     * Vezme “primární” lišku uživatele (první z kolekce).
     * Když žádná není, vytvoří ji, uloží a vrátí.
     */
    private Fox getOrCreatePrimaryFox(User user) {
        Collection<Fox> foxes = user.getFox();
        if (foxes != null && !foxes.isEmpty()) {
            // bezpečný převod (bez toArray()[0] bordelu)
            return new ArrayList<>(foxes).get(0);
        }

        Fox fox = new Fox();
        fox.setUser(user);
        foxRepository.save(fox);

        try {
            if (user.getFox() != null) {
                user.getFox().add(fox);
                usersRepository.save(user);
            }
        } catch (Exception ignored) {
        }

        return fox;
    }
}
