package movies.com.example.movies.models;

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


    @OneToMany(mappedBy = "user")
    private Set<Vote> vote;

    @OneToMany(mappedBy = "user")
    private Set<Movie> movie;

    public User(String username) {
        this.username = username;
    }

    public User() {

    }
}
