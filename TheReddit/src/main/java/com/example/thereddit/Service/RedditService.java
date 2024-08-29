package com.example.thereddit.Service;

import com.example.thereddit.Model.Post;
import com.example.thereddit.Model.Vote;
import com.example.thereddit.Repository.PostRepository;
import com.example.thereddit.Model.User;
import com.example.thereddit.Repository.UsersRepository;
import com.example.thereddit.Repository.VotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RedditService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    VotesRepository votesRepository;

    public User register(String username, String password) {
        User user = new User(username, password);
        if (usersRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already in used");
        } else {
            return usersRepository.save(user);
        }
    }

    public Boolean isUser(String username, String password) {
        User user = usersRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("No username found");
        }
        if (usersRepository.existsByUsername(username) & !user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Password not match");
        }
        if (!usersRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username not found ");
        } else {
            return true;
        }
    }

    public Post addNewPost(String username, String title, String url) {
        Post post = new Post(title, url);
        User user = usersRepository.findByUsername(username);
        post.setUser(user);
        return postRepository.save(post);
    }

    public Vote createVote(boolean direction, long id, String username) {
        User user = usersRepository.findByUsername(username);
        Post post = postRepository.findById(id);
        Vote newVote = new Vote(direction);
        newVote.setUser(user);
        newVote.setPost(post);
        votesRepository.save(newVote);
        return newVote;
    }

    public boolean isPresent(String username, Long PostId) {
        User user = usersRepository.findByUsername(username);
        Long Userid = user.getId();
        return votesRepository.findByUserIdAndPostId(Userid, PostId).isPresent();
    }

    public void remove(String username, Long postId) {
        Long voteId = getVoteId(username, postId);
        if (voteId == 0) {
            return;
        }
        votesRepository.deleteById(voteId);
    }

    public long getVoteId(String username, Long PostId) {
        User user = usersRepository.findByUsername(username);
        Long Userid = user.getId();
        Optional<Vote> optionalVote = votesRepository.findByUserIdAndPostId(Userid, PostId);
        if (optionalVote.isPresent()) {
            return optionalVote.get().getId();
        }
        return 0;
    }

    public long getVoteCountByPostId(long postId) {
        return votesRepository.countVotesByPostId(postId);
    }

    public Iterable<Post> findAllPostAndAssignNumberOfLikes() {
        Iterable<Post> allPosts = postRepository.findAll();
        List<Long[]> likes = votesRepository.getPostVoteCounts();
        for (Post post : allPosts) {
            long postId = post.getId();
            for (Long[] like : likes) {
                if (like[0] == postId) {
                    post.setLikes(like[1]);
                    break;
                }
            }
        }

        return allPosts;
    }

    public Iterable<Post> mostLiked() {
        Iterable<Post> likes = findAllPostAndAssignNumberOfLikes();
        return StreamSupport.stream(likes.spliterator(), false)
                .sorted(Comparator.comparingLong(Post::getLikes).reversed())
                .limit(10)
                .collect(
                        Collectors.toList());
    }
}



