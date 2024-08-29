package com.example.programmerfoxclubfinal;
//import jakarta.persistence.Column;

import jakarta.persistence.*;
//import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Fox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String food;
    private String drink;

    @ManyToMany(mappedBy = "fox", fetch = FetchType.LAZY)
    private Set<Tricks> tricks;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    public Fox(String name) {
        this.name = name;
       // this.tricks = tricks;
        this.food = food;
        this.drink = drink;
    }

    public Fox() {
    }

    public String getElements(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            return list.get(i);
        }
        return null;
    }

    @Override
    public String toString() {
        return "This is fox with: " +
                "id: " + id +
                ", his name is " + name + ", he eats " + food + " and he drinks " + drink + " he can do " + tricks +
                " and name of his user is " + user.getUsername();
    }
}

