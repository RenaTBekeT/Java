package com.movieApp.controller;

import com.movieApp.model.User;
import com.movieApp.repository.UserRepository;
import com.movieApp.service.MovieService;
import com.movieApp.service.dto.OmdbSearchItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String registerPage() {
        return "Register";
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           RedirectAttributes redirectAttributes) {
        try {
            User user = movieService.register(username, password);
            redirectAttributes.addAttribute("Username", user.getUsername());
            return "redirect:/index?username=" + username;
        } catch (IllegalArgumentException e) {
            redirectAttributes.addAttribute("error", e.getMessage());
            redirectAttributes.addAttribute("Username", username);
            return "redirect:/register";
        }
    }

    @GetMapping("/login")
    public String loginUserPage() {
        return "Login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            RedirectAttributes redirectAttributes) {
        try {
            if (movieService.isUser(username, password)) {
                return "redirect:/index?username=" + username;
            }
        } catch (IllegalArgumentException e) {
            redirectAttributes.addAttribute("error", e.getMessage());
            redirectAttributes.addAttribute("Username", username);
            return "redirect:/login";
        }
        return "redirect:/login?error=Unknown%20error";
    }

    @GetMapping("/index")
    public String indexPage(@RequestParam("username") String username,
                            @RequestParam(value = "q", required = false) String q,
                            Model model) {

        User users = userRepository.findByUsername(username);
        if (users == null) {
            return "redirect:/login?error=Please%20login";
        }

        model.addAttribute("username", username);
        model.addAttribute("users", users);
        model.addAttribute("q", q);

        if (q != null && !q.trim().isBlank()) {
            List<OmdbSearchItem> results = movieService.searchOmdb(q);
            model.addAttribute("results", results);
        }

        return "Index";
    }
}