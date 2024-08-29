package com.example.thereddit.Model;

import com.example.thereddit.Repository.PostRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String url;
    @Transient
    private long likes;
    private LocalDate localDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "post")
    private Set<Vote> vote;

    public Post(String title, String url) {
        this.title = title;
        this.url = url;
        this.localDate = LocalDate.now();
    }

    public Post() {

    }

    @Override
    public String toString() {
        return title;

    }
}
