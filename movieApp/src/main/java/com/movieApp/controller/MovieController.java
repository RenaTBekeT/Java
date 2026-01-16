package com.movieApp.controller;

import com.movieApp.model.User;
import com.movieApp.model.UserMovie;
import com.movieApp.repository.UserRepository;
import com.movieApp.service.MovieService;
import com.movieApp.service.dto.OmdbSearchItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Set;

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
        model.addAttribute("favouriteIds", movieService.getFavouriteImdbIds(username));

        // ✅ VŽDY poslat, aby nikdy nebyl null
        model.addAttribute("favouriteIds", movieService.getFavouriteImdbIds(username));

        if (q != null && !q.trim().isBlank()) {
            List<OmdbSearchItem> results = movieService.searchOmdb(q);
            model.addAttribute("results", results);
        }

        return "Index";
    }
    @GetMapping("/movie")
    public String movieDetail(@RequestParam("username") String username,
                              @RequestParam("imdbId") String imdbId,
                              Model model) {

        User user = userRepository.findByUsername(username);
        if (user == null) return "redirect:/login?error=Please%20login";

        var detail = movieService.getOmdbDetail(imdbId);

        model.addAttribute("username", username);
        model.addAttribute("users", user);
        model.addAttribute("m", detail);

        return "MovieDetail";
    }

    @GetMapping("/favourites")
    public String favourites(@RequestParam("username") String username, Model model) {

        User users = userRepository.findByUsername(username);
        if (users == null) return "redirect:/login?error=Please%20login";

        List<UserMovie> myMovies = movieService.getMyMovies(username);
        Set<String> favouriteIds = movieService.getFavouriteImdbIds(username);
        model.addAttribute("favouriteIds", favouriteIds);

        model.addAttribute("username", username);
        model.addAttribute("users", users);
        model.addAttribute("myMovies", myMovies);

        return "MyMovies";
    }

    @PostMapping("/favourites/add")
    @ResponseBody
    public ResponseEntity<?> addToFavourites(@RequestParam("username") String username,
                                             @RequestParam("imdbId") String imdbId) {
        movieService.addToMyMovies(username, imdbId);
        return ResponseEntity.ok().build();
    }
    // ✅ DELETE z favourites (pro fetch, bez redirectu)
    @PostMapping("/favourites/delete")
    @ResponseBody
    public ResponseEntity<?> deleteFromFavourites(@RequestParam("username") String username,
                                                  @RequestParam("userMovieId") long userMovieId) {
        movieService.deleteFromFavourites(username, userMovieId);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/favourites/toggle")
    @ResponseBody
    public ResponseEntity<?> toggleFavourite(@RequestParam("username") String username,
                                             @RequestParam("imdbId") String imdbId) {
        boolean nowSaved = movieService.toggleFavourite(username, imdbId);
        return ResponseEntity.ok(nowSaved ? "saved" : "removed");
    }
}