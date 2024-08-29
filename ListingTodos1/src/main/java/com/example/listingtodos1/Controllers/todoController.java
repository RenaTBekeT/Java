package com.example.listingtodos1.Controllers;

import com.example.listingtodos1.Model.Assignee;
import com.example.listingtodos1.Model.Todo;
import com.example.listingtodos1.Repository.AssigneeRepository;
import com.example.listingtodos1.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/todo")
public class todoController {
    @Autowired
    TodoRepository todoRepository;
    @Autowired
    AssigneeRepository assigneeRepository;

    @GetMapping(path = {"/list", "/"})
    public String list(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        model.addAttribute("assignees", assigneeRepository.findAll());
        return "todoList";
    }

    @GetMapping("/add")
    public String addtodoPage() {
        return "AddNewTodo";
    }

    @PostMapping("/add")
    public String addNew(@RequestParam String name) {
        Todo todo = new Todo(name);
        todoRepository.save(todo);
        return "redirect:/todo/list";
    }

    @PostMapping("/{id}/delete")
    public String deletetodo(@PathVariable("id") long id) {
        todoRepository.deleteById(id);
        return "redirect:/todo/list";
    }

    @GetMapping("/{id}/edit")
    public String editTodoPage(@PathVariable("id") long id, Model model) {
        todoRepository.findById(id);
        model.addAttribute("assignees", assigneeRepository.findAll());

        var todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            model.addAttribute("todo", todoOptional.get());
            return "EditTodo";
        } else {
            return "redirect:/todo/list";
        }
    }

    @PostMapping("/{id}/edit")
    public String saveEdit(@PathVariable("id") long id, @RequestParam String title, @RequestParam(required = false) boolean urgent, @RequestParam(required = false) boolean done, @RequestParam(required = false) String assignee) {
        Todo editedTodo = new Todo(id, title, urgent, done);
        editedTodo.setAssignee(assigneeRepository.findByAssignee(assignee));
        todoRepository.save(editedTodo);
        return "redirect:/todo/list";

    }

    @PostMapping("/find")
    public String findTodo(@RequestParam String title, Model model) {
        List<Todo> actualList = todoRepository.findByTitleContaining(title);
        model.addAttribute("todos", actualList);
        return "todoList";
    }
    @PostMapping("/newAssignee")
    public String registerAssignee(@RequestParam String assignee, @RequestParam String email) {
        Assignee newAssignee = new Assignee(assignee, email);
        assigneeRepository.save(newAssignee);
        return "redirect:/todo/list";
    }
    @PostMapping("/{id}/deleteAssignee")
    public String deleteAssignee(@PathVariable("id") long id) {
        assigneeRepository.deleteById(id);
        return "redirect:/todo/list";
    }
    @GetMapping("/{id}/editAssignee")
    public String editAssignee(@PathVariable("id") long id, Model model) {
        assigneeRepository.findById(id);
        var assigneeOptional = assigneeRepository.findById(id);
        if (assigneeOptional.isPresent()) {
            model.addAttribute("assignee", assigneeOptional.get());
            return "EditAssignee";
        } else {
            return "redirect:/todo/list";
        }
    }

    @PostMapping("/{id}/editAssignee")
    public String saveEditAssignee(@PathVariable("id") long id, @RequestParam String assignee, @RequestParam String email) {
        Assignee editedAssignee = new Assignee(id, assignee, email);
        assigneeRepository.save(editedAssignee);
        return "redirect:/todo/list";
    }
    @PostMapping("/findAssignee")
    public String findAssignee(@RequestParam String assignee, Model model) {
        List<Assignee> actualList = assigneeRepository.findByAssigneeContaining(assignee);
        model.addAttribute("assignees", actualList);
        return "todoList";
    }
}
