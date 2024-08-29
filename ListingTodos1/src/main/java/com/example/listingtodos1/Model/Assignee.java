package com.example.listingtodos1.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Assignee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String assignee;
    @Column
    private String email;

    @OneToMany(mappedBy = "assignee", fetch = FetchType.LAZY)
    private Set<Todo> todos;


    public Assignee(long id, String assignee, String email) {
        this.assignee = assignee;
        this.email = email;
        this.id = id;
    }
    public Assignee(String assignee, String email) {
        this.assignee = assignee;
        this.email = email;
    }

    @Override
    public String toString() {
        return  assignee;
    }
}
