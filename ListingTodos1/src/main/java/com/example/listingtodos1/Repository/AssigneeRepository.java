package com.example.listingtodos1.Repository;

import com.example.listingtodos1.Model.Assignee;
import com.example.listingtodos1.Model.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssigneeRepository extends CrudRepository<Assignee, Long> {
    List<Assignee> findByAssigneeContaining(String assignee);
    Assignee findByAssignee(String assignee);
}
