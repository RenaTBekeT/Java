package com.example.thereddit.Model;

import com.example.thereddit.Model.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;


    @OneToMany(mappedBy = "user")
    private Set<Vote> vote;

    @OneToMany(mappedBy = "user")
    private Set<Post> post;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {

    }
}
