package com.example.thereddit.Controllers;
import com.example.thereddit.Model.Post;
import com.example.thereddit.Model.User;
import com.example.thereddit.Repository.PostRepository;
import com.example.thereddit.Repository.UsersRepository;
import com.example.thereddit.Repository.VotesRepository;
import com.example.thereddit.Service.RedditService;
import jdk.jfr.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Scanner;

@Controller
public class RedditController {
    @Autowired
    private RedditService redditService;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    VotesRepository votesRepository;
    @Autowired
    UsersRepository usersRepository;


    @GetMapping("/register")
    public String registerPage() {
        return "Register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
        try {
            User user = redditService.register(username, password);
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
    public String loginUser(@RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes) {
        try {
            if (redditService.isUser(username, password)) {
                return "redirect:/index?username=" + username;
            }
        } catch (IllegalArgumentException e) {
            redirectAttributes.addAttribute("error", e.getMessage());
            redirectAttributes.addAttribute("Username", username);
            return "redirect:/login";
        }
        return null;
    }

    @GetMapping("/index")
    public String indexPage(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("posts", redditService.findAllPostAndAssignNumberOfLikes());
        User users = usersRepository.findByUsername(username);
        model.addAttribute("users", users);
        return "Index";
    }

    @GetMapping("/submit")
    public String submitPage(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        return "SubmitPost";
    }

    @PostMapping("/submit")
    public String submit(@RequestParam String username, @RequestParam String title, @RequestParam String url) {
        redditService.addNewPost(username, title, url);
        return "redirect:/index?username=" + username;
    }

    @PostMapping("/voteUp")
    public String voteUp(@RequestParam String username, @RequestParam long id) {
        if (!redditService.isPresent(username, id)) {
            redditService.createVote(true, id, username);
            return "redirect:/index?username=" + username;
        }
        return "redirect:/index?username=" + username;
    }

    @PostMapping("/voteDown")
    public String voteDown(@RequestParam String username, @RequestParam long id) {
        if (redditService.isPresent(username, id)) {
            redditService.remove(username, id);
            return "redirect:/index?username=" + username;
        }
        return "redirect:/index?username=" + username;
    }

    @GetMapping("topTen")
    public String getTopTen(@RequestParam String username, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("posts", redditService.mostLiked());
        return "index";

    }
    @GetMapping("/renatReddit")
    public String indexPage() {
        return "Welcome";
    }

}


