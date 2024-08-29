package com.example.listingtodos1;

import com.example.listingtodos1.Model.Todo;
import com.example.listingtodos1.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ListingTodos1Application implements CommandLineRunner {
    @Autowired
    TodoRepository todoRepository;
    public static void main(String[] args) {
        SpringApplication.run(ListingTodos1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
  //      todoRepository.save(new Todo("I have to learn Object Relational Mapping"));
    }
}
