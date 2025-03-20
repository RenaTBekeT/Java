package movies.com.example.movies.models;

import movies.com.example.movies.models.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Boolean direction;
    @ManyToOne()
    private User user;

    @ManyToOne()
    private Movie movie;


    public Vote(boolean direction) {
        this.direction = direction;

    }

    public Vote() {

    }
}
