package com.example.greenfoxclassapp.Controllers;

import com.example.greenfoxclassapp.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gfa")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public String mainpage(Model model) {
        String numOfStudents = studentService.countStudents();
        model.addAttribute("count", numOfStudents);
        return "MainPage";
    }
    @GetMapping("/list")
    public String listOfStudents(Model model) {
        String numOfStudents = studentService.countStudents();
        model.addAttribute("count", numOfStudents);
        List<String>students = studentService.findAll();
        model.addAttribute("students", students);
        return "MainPage";
    }
    @PostMapping("/add")
    public String addstudent(@RequestParam String name, Model model) {
        String numOfStudents = studentService.countStudents();
        model.addAttribute("count", numOfStudents);
        studentService.save(name);
        return "MainPage";
    }
    @GetMapping("/checkName")
    public String registredName(Model model) {
        return "CheckPage";
    }
    @PostMapping("/checkName")
    public String registredName1(@RequestParam String name, Model model) {
        boolean exist = studentService.isRegistred(name);
        if (exist) {
            model.addAttribute("message", name + " is already in database");
        } else {
            model.addAttribute("message", name + " is not here");
        }
        return "CheckPage";
    }
}
