package com.example.programmerfoxclubfinal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String food;
    private String drink;
    @Column(name = "image_path")
    private String imagePath;


    @ManyToMany(mappedBy = "pokemon", fetch = FetchType.LAZY)
    private Set<Tricks> tricks;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Pokemon(String name) {
        this.name = name;
    }

    public Pokemon() {
    }

    public String getElements(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            return list.get(i);
        }
        return null;
    }

    @Override
    public String toString() {
        return "This is pokemon with: " +
                "id: " + id +
                ", his name is " + name +
                ", he eats " + food +
                " and he drinks " + drink +
                " he can do " + tricks +
                " and name of his user is " + user.getUsername();
    }
}
