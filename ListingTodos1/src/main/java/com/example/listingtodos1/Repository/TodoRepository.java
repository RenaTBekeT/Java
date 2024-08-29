package com.example.listingtodos1.Repository;

import com.example.listingtodos1.Model.Assignee;
import com.example.listingtodos1.Model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findAllByDone(boolean done);
    List<Todo> findAllByUrgent(boolean urgent);

    public void deleteById (long id);
    // public Todo findById (long id);
    List<Todo>findByTitleContaining(String title);


}
