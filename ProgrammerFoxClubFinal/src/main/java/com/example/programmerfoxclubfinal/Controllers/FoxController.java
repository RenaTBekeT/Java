package com.example.programmerfoxclubfinal.Controllers;

import com.example.programmerfoxclubfinal.Fox;
import com.example.programmerfoxclubfinal.Reository.FoxRepository;
import com.example.programmerfoxclubfinal.Reository.TrickRepository;
import com.example.programmerfoxclubfinal.Reository.UsersRepository;
import com.example.programmerfoxclubfinal.Services.FoxService;
import com.example.programmerfoxclubfinal.Tricks;
import com.example.programmerfoxclubfinal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/gfa")
public class FoxController {

    @Autowired
    private FoxService foxService;
    @Autowired
    private FoxRepository foxRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private TrickRepository trickRepository;
 /*
    @GetMapping("/")
    public String mainPage(@RequestParam(required = false) String name, Model model) {
        if (name != null) {
            model.addAttribute("fox", foxService.getFox(name));
        } else {
            return "login";
        }
        int numberOfTricks = foxService.numOfTricks();
        model.addAttribute("number", numberOfTricks);
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String loginPageName(@RequestParam String name, Model model) {
        foxService.clearTricks();
        return "redirect:/?name=" + name;
    }

    @GetMapping("/nutritionStore")
    public String nutritionPage(@RequestParam(required = false) String name, Model model) {
        if (name != null) {
            model.addAttribute("name", name);
            return "nutritionStore";
        } else {
            return "login";
        }
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam String name, @RequestParam String food, @RequestParam String drink, Model model) {
        Fox currentFox = foxService.getFox(name);
        currentFox.setFood(food);
        currentFox.setDrink(drink);
        return "redirect:/?name=" + name;
    }

    @GetMapping("/trickcenter")
    public String trickCenterPage(@RequestParam(required = false) String name, Model model) {
        Fox currentFox = foxService.getFox(name);
        model.addAttribute("name", currentFox);
        if (name != null) {
            model.addAttribute("name", name);
            return "TrickCenter";
        } else {
            return "login";
        }
    }

    @PostMapping("/submitTrick")
    public String submitTrickForm(@RequestParam String name, @RequestParam String trick, Model model) {
        Fox currentFox = foxService.getFox(name);
        List<String> currenttricks = foxService.addTrick(trick);
      //  currentFox.setTricks(currenttricks);
        return "redirect:/?name=" + name;
        */

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String name, @RequestParam String password) {
        foxService.register(name, password);
        return "redirect:/loginUser";
    }

    @PostMapping("/loginUser")
    public String loginUser(@RequestParam String name, @RequestParam String password) {
        if (foxService.isUser(name, password)) {
            return "redirect:/index?name=" + name;
        }
        return "LoginUser";
    }

    @GetMapping("/loginUser")
    public String loginUserPage() {
        return "LoginUser";
    }

    @GetMapping("/index")
    public String indexPage(@RequestParam(name = "name") String name, Model model) {
        User users = usersRepository.findByUsername(name);
        model.addAttribute("foxes", users.getFox());
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/nutritionStore")
    public String nutritionPage(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        User users = usersRepository.findByUsername(name);
        model.addAttribute("foxes", new ArrayList<>(users.getFox()).get(0));
        model.addAttribute("users", users);
        return "nutritionStore";
    }

    @GetMapping("/setName")
    public String setNamePage(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        User users = usersRepository.findByUsername(name);
        model.addAttribute("foxes", new ArrayList<>(users.getFox()).get(0));
        model.addAttribute("users", users);
        return "SetNamePage";
    }

    @PostMapping("/setName")
    public String SetFoxName(@RequestParam String name, @RequestParam String setName) {
        foxService.updateFoxName(setName, name);
        return "redirect:/index?name=" + name;
    }

    @PostMapping("/nutritionStore")
    public String SetFoxDrinkandFood(@RequestParam String name, @RequestParam String food, @RequestParam String drink) {
        foxService.updateFoxFoodAndDrink(food, drink, name);
        return "redirect:/index?name=" + name;
    }

    @GetMapping("/setTricks")
    public String setTricksPage(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        User users = usersRepository.findByUsername(name);
        model.addAttribute("foxes", new ArrayList<>(users.getFox()).get(0));
        model.addAttribute("users", users);
        model.addAttribute("tricks", trickRepository.findAll());
        return "TrickCenter";
    }

    @PostMapping("/setTricks")
    public String SetTricks(@RequestParam String name, @RequestParam String trick) {
        foxService.updateTricks(trick, name);
        return "redirect:/index?name=" + name;
    }

    @GetMapping("/foxclub")
    public String welcomePage() {
        return "WelcomePage";
    }
    @GetMapping("/addAnotherFox")
    public String addAnotherFox (@RequestParam String name) {
        foxService.addAnotherFox(name);
        return "redirect:/index?name=" + name;
    }
}





