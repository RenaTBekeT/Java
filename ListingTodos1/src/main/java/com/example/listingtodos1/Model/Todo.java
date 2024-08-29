package com.example.listingtodos1.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column
    String title;
    @Column
    boolean urgent = false;
    @Column
    boolean done = false;

    @ManyToOne
    private Assignee assignee;

    public Todo(long id, String title, boolean urgent, boolean done) {
        this.id = id;
        this.title = title;
        this.urgent = urgent;
        this.done = done;
    }

    public Todo(String title) {
        this.title = title;
    }

    public Todo() {
    }
    public Todo(long id, String title, boolean urgent, boolean done, Assignee assignee) {
        this.id = id;
        this.title = title;
        this.urgent = urgent;
        this.done = done;
        this.assignee = assignee;
    }
}
