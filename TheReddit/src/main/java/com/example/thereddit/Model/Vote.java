package com.example.thereddit.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.aot.generate.GeneratedTypeReference;

import java.util.Set;

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
    private Post post;


    public Vote(boolean direction) {
        this.direction = direction;

    }

    public Vote() {

    }
}
