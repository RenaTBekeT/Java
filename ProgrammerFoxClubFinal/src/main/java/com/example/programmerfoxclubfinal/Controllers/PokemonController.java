package com.example.programmerfoxclubfinal.Controllers;

import com.example.programmerfoxclubfinal.Pokemon;
import com.example.programmerfoxclubfinal.Repository.PokemonRepository;
import com.example.programmerfoxclubfinal.Repository.TrickRepository;
import com.example.programmerfoxclubfinal.Repository.UsersRepository;
import com.example.programmerfoxclubfinal.Services.PokemonService;
import com.example.programmerfoxclubfinal.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class PokemonController {

    private final PokemonService pokemonService;
    private final PokemonRepository pokemonRepository;
    private final UsersRepository usersRepository;
    private final TrickRepository trickRepository;

    public PokemonController(PokemonService pokemonService,
                             PokemonRepository pokemonRepository,
                             UsersRepository usersRepository,
                             TrickRepository trickRepository) {
        this.pokemonService = pokemonService;
        this.pokemonRepository = pokemonRepository;
        this.usersRepository = usersRepository;
        this.trickRepository = trickRepository;
    }

    // -------------------- WELCOME --------------------

    @GetMapping("/pokemonclub")
    public String welcomePage() {
        return "WelcomePage";
    }

    // -------------------- REGISTER --------------------

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String name,
                           @RequestParam String password,
                           Model model) {

        User created = pokemonService.register(name, password);

        if (created == null) {
            model.addAttribute("error", "Name already exist");
            return "register";
        }

        return "redirect:/chooseProfilePicture?name=" + name;
    }


    // -------------------- LOGIN --------------------

    @GetMapping("/loginUser")
    public String loginUserPage() {
        return "LoginUser";
    }

    @PostMapping("/loginUser")
    public String loginUser(@RequestParam String name,
                            @RequestParam String password,
                            Model model) {
        if (pokemonService.isUser(name, password)) {
            return "redirect:/index?name=" + name;
        }
        model.addAttribute("error", "Invalid username or password");
        return "LoginUser";
    }

    // -------------------- DASHBOARD --------------------

    @GetMapping("/index")
    public String indexPage(@RequestParam("name") String name, Model model) {
        User users = usersRepository.findByUsername(name);
        if (users == null) {
            return "redirect:/loginUser";
        }

        var pokemons = pokemonRepository.findAllByUser(users);

        model.addAttribute("name", name);
        model.addAttribute("users", users);
        model.addAttribute("pokemons", pokemons);
        model.addAttribute("pokemon", firstPokemonOrNull(pokemons));

        return "index";
    }


    // -------------------- NUTRITION --------------------

    @GetMapping("/nutritionStore")
    public String nutritionPage(@RequestParam String name, Model model) {
        User users = usersRepository.findByUsername(name);
        if (users == null) {
            return "redirect:/loginUser";
        }

        model.addAttribute("name", name);
        model.addAttribute("users", users);
        model.addAttribute("pokemons", users.getPokemons());
        model.addAttribute("pokemon", firstPokemonOrNull(users.getPokemons()));

        return "nutritionStore";
    }

    @PostMapping("/nutritionStore")
    public String setPokemonDrinkAndFood(@RequestParam String name,
                                         @RequestParam String food,
                                         @RequestParam String drink) {
        if (usersRepository.findByUsername(name) == null) {
            return "redirect:/loginUser";
        }

        pokemonService.updatePokemonFoodAndDrink(food, drink, name);
        return "redirect:/index?name=" + name;
    }

    // -------------------- SET POKEMON NAME --------------------

    @GetMapping("/setName")
    public String setNamePage(@RequestParam String name, Model model) {
        User users = usersRepository.findByUsername(name);
        if (users == null) {
            return "redirect:/loginUser";
        }

        model.addAttribute("name", name);
        model.addAttribute("users", users);
        model.addAttribute("pokemons", users.getPokemons());
        model.addAttribute("pokemon", firstPokemonOrNull(users.getPokemons()));

        return "SetNamePage";
    }

    @PostMapping("/setName")
    public String setPokemonName(@RequestParam String name, @RequestParam String setName) {
        if (usersRepository.findByUsername(name) == null) {
            return "redirect:/loginUser";
        }

        pokemonService.updatePokemonName(setName, name);
        return "redirect:/index?name=" + name;
    }

    // -------------------- TRICKS --------------------

    @GetMapping("/setTricks")
    public String setTricksPage(@RequestParam String name, Model model) {
        User users = usersRepository.findByUsername(name);
        if (users == null) {
            return "redirect:/loginUser";
        }

        model.addAttribute("name", name);
        model.addAttribute("users", users);
        model.addAttribute("pokemons", users.getPokemons());
        model.addAttribute("pokemon", firstPokemonOrNull(users.getPokemons()));
        model.addAttribute("tricks", trickRepository.findAll());

        return "TrickCenter";
    }

    @PostMapping("/setTricks")
    public String setTricks(@RequestParam String name, @RequestParam String trick) {
        if (usersRepository.findByUsername(name) == null) {
            return "redirect:/loginUser";
        }

        pokemonService.updateTricks(trick, name);
        return "redirect:/index?name=" + name;
    }

    // -------------------- POKEMON MANAGEMENT --------------------
    // NEW: POST add from select (instead of GET random/empty)

    @PostMapping("/addAnotherPokemon")
    public String addAnotherPokemon(@RequestParam String name,
                                    @RequestParam String pokemonName) {
        if (usersRepository.findByUsername(name) == null) {
            return "redirect:/loginUser";
        }

        pokemonService.addAnotherPokemon(name, pokemonName);
        return "redirect:/index?name=" + name;
    }

    // -------------------- HELPERS --------------------

    private Pokemon firstPokemonOrNull(Collection<Pokemon> pokemons) {
        if (pokemons == null || pokemons.isEmpty()) {
            return null;
        }
        return new ArrayList<>(pokemons).get(0);
    }

    @GetMapping("/chooseProfilePicture")
    public String chooseProfilePicture(@RequestParam String name, Model model) {
        if (usersRepository.findByUsername(name) == null) return "redirect:/loginUser";
        model.addAttribute("name", name);
        return "ChooseProfilePicture";
    }

    @GetMapping("/setProfilePicture")
    public String setProfilePicture(@RequestParam String name, @RequestParam String avatar) {
        User user = usersRepository.findByUsername(name);
        if (user == null) return "redirect:/loginUser";

        user.setProfileImagePath("/" + avatar); // uložíš cestu pro <img src="...">
        usersRepository.save(user);

        return "redirect:/index?name=" + name;
    }

}
