package com.example.programmerfoxclubfinal.Services;

import com.example.programmerfoxclubfinal.Pokemon;
import com.example.programmerfoxclubfinal.Repository.PokemonRepository;
import com.example.programmerfoxclubfinal.Repository.TrickRepository;
import com.example.programmerfoxclubfinal.Repository.UsersRepository;
import com.example.programmerfoxclubfinal.Tricks;
import com.example.programmerfoxclubfinal.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class PokemonService {

    private final UsersRepository usersRepository;
    private final PokemonRepository pokemonRepository;
    private final TrickRepository trickRepository;

    public PokemonService(UsersRepository usersRepository,
                          PokemonRepository pokemonRepository,
                          TrickRepository trickRepository) {
        this.usersRepository = usersRepository;
        this.pokemonRepository = pokemonRepository;
        this.trickRepository = trickRepository;
    }

    public User createUser(User user) {
        return usersRepository.save(user);
    }

    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public User register(String name, String password) {
        if (usersRepository.countByUsername(name) > 0) {
            return null;
        }

        User user = new User(name, password);
        usersRepository.save(user);

        try {
            if (user.getPokemon() != null) {
                usersRepository.save(user);
            }
        } catch (Exception ignored) { }

        return user;
    }

    public boolean isUser(String name, String password) {
        User user = usersRepository.findByUsername(name);
        if (user == null) return false;
        return user.getPassword() != null && user.getPassword().equals(password);
    }

    public void updatePokemonName(String setName, String username) {
        User user = usersRepository.findByUsername(username);
        if (user == null) return;

        Pokemon pokemon = getOrCreatePrimaryPokemon(user);
        pokemon.setName(setName);
        pokemonRepository.save(pokemon);
    }

    public void updatePokemonFoodAndDrink(String food, String drink, String username) {
        User user = usersRepository.findByUsername(username);
        if (user == null) return;

        Pokemon pokemon = getOrCreatePrimaryPokemon(user);
        pokemon.setFood(food);
        pokemon.setDrink(drink);
        pokemonRepository.save(pokemon);
    }

    public void updateTricks(String trickName, String username) {
        User user = usersRepository.findByUsername(username);
        if (user == null) return;

        Pokemon pokemon = getOrCreatePrimaryPokemon(user);

        Tricks trick = trickRepository.findByNameOfTrick(trickName);
        if (trick == null) return;

        if (pokemon.getTricks() != null && pokemon.getTricks().contains(trick)) {
            return;
        }

        pokemon.getTricks().add(trick);

        try {
            if (trick.getPokemon() != null && !trick.getPokemon().contains(pokemon)) {
                trick.getPokemon().add(pokemon);
            }
        } catch (Exception ignored) { }

        pokemonRepository.save(pokemon);
        trickRepository.save(trick);
    }

    // NEW METHOD: add selected name
    public void addAnotherPokemon(String username, String pokemonName) {
        User user = usersRepository.findByUsername(username);
        if (user == null) return;

        Pokemon newPokemon = new Pokemon();
        newPokemon.setUser(user);
        newPokemon.setName(pokemonName);

        if (pokemonName != null) {
            switch (pokemonName.trim().toLowerCase()) {
                case "pikachu":
                    newPokemon.setImagePath("/PikachuCard.png");
                    break;
                case "bulbasaur":
                    newPokemon.setImagePath("/BulbasaurCard.png");
                    break;
                case "charmander":
                    newPokemon.setImagePath("/CharmanderCard.png");
                    break;
                case "squirtle":
                    newPokemon.setImagePath("/SquirtleCard.png");
                    break;
                case "eevee":
                    newPokemon.setImagePath("/EeveeCard.png");
                    break;
                default:
                    newPokemon.setImagePath("/default.png");
            }
        }

        pokemonRepository.save(newPokemon);

        try {
            if (user.getPokemons() != null) {         // pokud máš getPokemons()
                user.getPokemons().add(newPokemon);
                usersRepository.save(user);
            }
        } catch (Exception ignored) { }
    }

    // ✅ DELETE (jen pro daného usera)
    @Transactional
    public void deletePokemonForUser(String username, Long pokemonId) {
        User user = usersRepository.findByUsername(username);
        if (user == null) return;

        Pokemon pokemon = pokemonRepository.findByIdAndUser(pokemonId, user).orElse(null);
        if (pokemon == null) return; // nepatří userovi / neexistuje

        // pro jistotu odpoj z kolekce usera (když ji máš)
        try {
            if (user.getPokemons() != null) {
                user.getPokemons().removeIf(p -> p.getId() != null && p.getId().equals(pokemonId));
            }
        } catch (Exception ignored) { }

        pokemonRepository.delete(pokemon);
    }

    private Pokemon getOrCreatePrimaryPokemon(User user) {
        Collection<Pokemon> pokemons = user.getPokemon(); // nechávám jak máš
        if (pokemons != null && !pokemons.isEmpty()) {
            return new ArrayList<>(pokemons).get(0);
        }

        Pokemon pokemon = new Pokemon();
        pokemon.setUser(user);
        pokemonRepository.save(pokemon);

        try {
            if (user.getPokemon() != null) {
                user.getPokemon().add(pokemon);
                usersRepository.save(user);
            }
        } catch (Exception ignored) { }

        return pokemon;
    }
}