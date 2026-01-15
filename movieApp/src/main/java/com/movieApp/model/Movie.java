package com.movieApp.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private Integer year;
    private String genre;

    @Column(length = 1000)
    private String description;
    private String posterUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Movie(String title) {
        this.title = title;
    }

    public Movie() {

    }
    @Override
    public String toString() {
        return title;

    }
}

