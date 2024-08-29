package com.example.thereddit.Controllers;

import com.example.thereddit.Model.Message;
import com.example.thereddit.Model.Post;
import com.example.thereddit.Model.PostUpdatedTitle;
import com.example.thereddit.Model.Vote;
import com.example.thereddit.Repository.PostRepository;
import com.example.thereddit.Repository.UsersRepository;
import com.example.thereddit.Repository.VotesRepository;
import com.example.thereddit.Service.RedditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class DataController {
    @Autowired
    RedditService redditService;
    @Autowired
    PostRepository postRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    VotesRepository votesRepository;

    @PutMapping("/update/{id}")
    public ResponseEntity updatePost(@RequestBody PostUpdatedTitle postUpdatedtitle, @PathVariable("id") long id) {
        if (postUpdatedtitle.getTitle() == null) {
            return ResponseEntity.status(400).body(new Message("Missing name"));
        }
        Post post = postRepository.findById(id);
        if (post == null) {
            return ResponseEntity.status(400).body(new Message("Id not found"));
        }
        post.setTitle(postUpdatedtitle.getTitle());
        postRepository.save(post);
        return ResponseEntity.ok(new Message("Post updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePost(@PathVariable("id") long id) {
        if (postRepository.findById(id) == null) {
            ResponseEntity.status(300).body(new Message("Id not found"));
        }
        for (Vote vote : votesRepository.findAll()) {
                if (vote.getPost().getId() == id) {
                    votesRepository.delete(vote);
                }
            }
        Post post = postRepository.findById(id);
        postRepository.delete(post);
        return ResponseEntity.ok(new Message("post deleted"));

        }
    }
