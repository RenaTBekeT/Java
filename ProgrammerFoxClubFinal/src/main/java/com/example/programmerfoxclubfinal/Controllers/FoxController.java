package com.example.programmerfoxclubfinal.Controllers;

import com.example.programmerfoxclubfinal.Fox;
import com.example.programmerfoxclubfinal.Reository.FoxRepository;
import com.example.programmerfoxclubfinal.Reository.TrickRepository;
import com.example.programmerfoxclubfinal.Reository.UsersRepository;
import com.example.programmerfoxclubfinal.Services.FoxService;
import com.example.programmerfoxclubfinal.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class FoxController {
    private final FoxService foxService;
    private final FoxRepository foxRepository;      // nechávám, i když teď není použité
    private final UsersRepository usersRepository;
    private final TrickRepository trickRepository;

    public FoxController(FoxService foxService,
                         FoxRepository foxRepository,
                         UsersRepository usersRepository,
                         TrickRepository trickRepository) {
        this.foxService = foxService;
        this.foxRepository = foxRepository;
        this.usersRepository = usersRepository;
        this.trickRepository = trickRepository;
    }

    // -------------------- WELCOME --------------------

    @GetMapping("/foxclub")
    public String welcomePage() {
        return "WelcomePage";
    }

    // -------------------- REGISTER --------------------

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String name, @RequestParam String password) {
        foxService.register(name, password);
        return "redirect:/loginUser";
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
        if (foxService.isUser(name, password)) {
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

        model.addAttribute("name", name);
        model.addAttribute("users", users);
        model.addAttribute("foxes", users.getFox());
        model.addAttribute("fox", firstFoxOrNull(users.getFox()));

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
        model.addAttribute("foxes", users.getFox());
        model.addAttribute("fox", firstFoxOrNull(users.getFox()));

        return "nutritionStore";
    }

    @PostMapping("/nutritionStore")
    public String setFoxDrinkAndFood(@RequestParam String name,
                                     @RequestParam String food,
                                     @RequestParam String drink) {
        // když user neexistuje, radši zpět na login
        if (usersRepository.findByUsername(name) == null) {
            return "redirect:/loginUser";
        }

        foxService.updateFoxFoodAndDrink(food, drink, name);
        return "redirect:/index?name=" + name;
    }

    // -------------------- SET FOX NAME --------------------

    @GetMapping("/setName")
    public String setNamePage(@RequestParam String name, Model model) {
        User users = usersRepository.findByUsername(name);
        if (users == null) {
            return "redirect:/loginUser";
        }

        model.addAttribute("name", name);
        model.addAttribute("users", users);
        model.addAttribute("foxes", users.getFox());
        model.addAttribute("fox", firstFoxOrNull(users.getFox()));

        return "SetNamePage";
    }

    @PostMapping("/setName")
    public String setFoxName(@RequestParam String name, @RequestParam String setName) {
        if (usersRepository.findByUsername(name) == null) {
            return "redirect:/loginUser";
        }

        foxService.updateFoxName(setName, name);
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
        model.addAttribute("foxes", users.getFox());
        model.addAttribute("fox", firstFoxOrNull(users.getFox()));
        model.addAttribute("tricks", trickRepository.findAll());

        return "TrickCenter";
    }

    @PostMapping("/setTricks")
    public String setTricks(@RequestParam String name, @RequestParam String trick) {
        if (usersRepository.findByUsername(name) == null) {
            return "redirect:/loginUser";
        }

        foxService.updateTricks(trick, name);
        return "redirect:/index?name=" + name;
    }

    // -------------------- FOX MANAGEMENT --------------------

    @GetMapping("/addAnotherFox")
    public String addAnotherFox(@RequestParam String name) {
        if (usersRepository.findByUsername(name) == null) {
            return "redirect:/loginUser";
        }

        foxService.addAnotherFox(name);
        return "redirect:/index?name=" + name;
    }

    // -------------------- HELPERS --------------------

    private Fox firstFoxOrNull(Collection<Fox> foxes) {
        if (foxes == null || foxes.isEmpty()) {
            return null;
        }
        return new ArrayList<>(foxes).get(0);
    }
}



