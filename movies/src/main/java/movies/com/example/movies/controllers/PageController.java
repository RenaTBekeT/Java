package movies.com.example.movies.controllers;

import movies.com.example.movies.Services.MovieService;
import movies.com.example.movies.models.Movie;
import movies.com.example.movies.models.MovieSubmissionException;
import movies.com.example.movies.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/login")
    public String loginUserPage() {
        return "Login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam(required = false) String username, Model model) {
        if (username == null || !movieService.isUser(username)) {
            model.addAttribute("error", "Uživatelské jméno je neplatné!");
            return "login";
        }
        return "redirect:/mainPage?username" + username;
    }

    @GetMapping("/mainPage")
    public String mainPage(Model model) {
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "Main";
    }


    @PostMapping("/submit")
    public String submit(@RequestParam(required = false) Integer year, @RequestParam(required = false) String genre,
                         @RequestParam(required = false) String title, @RequestParam(required = false) Integer duration,
                         @RequestParam(required = false) Double ranking, @RequestParam(required = false) String url,
                         RedirectAttributes redirectAttributes) {
        if(year == null || genre == null || title == null || duration == null || ranking == null || url == null
                || genre.isEmpty() || title.isEmpty() || url.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "All fields must be filled!");
            return "redirect:/mainPage";
        }
        try {
            // Add your validation checks here
            movieService.addNewMovie(year, genre, title, duration, ranking, url);
            redirectAttributes.addFlashAttribute("message", "Successfully saved!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "An error occurred while adding the movie.");
        }
        return "redirect:/mainPage";  // should be same as GetMapping in mainPage() method
    }

    @PostMapping("/voteUp")
    public String voteUp(@RequestParam String username, @RequestParam long id) {
        if (!movieService.isPresent(username, id)) {
            movieService.createVote(true, id, username);
            return "redirect:/mainPage?username=" + username;
        }
        return "redirect:/mainPage?username=" + username;
    }

    @PostMapping("/voteDown")
    public String voteDown(@RequestParam String username, @RequestParam long id) {
        if (movieService.isPresent(username, id)) {
            movieService.remove(username, id);
            return "redirect:/mainPage?username=" + username;
        }
        return "redirect:/mainPage?username=" + username;
    }
}

