package movies.com.example.movies.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String genre;
    private int year;
    private String title;
    private int duration;
    private double ranking;
    private String url;
    @Transient
    private long likes;
    private LocalDate localDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

//    @OneToMany(mappedBy = "movie")
//    private Set<Vote> vote;

    public Movie(Integer year, String genre, String title, Integer duration, Double ranking, String url) {
        this.year = year;
        this.genre = genre;
        this.title = title;
        this.duration = duration;
        this.ranking = ranking;
        this.url = url;
        this.localDate = LocalDate.now();
    }

    public Movie() {

    }

    @Override
    public String toString() {
        return title;

    }
}
