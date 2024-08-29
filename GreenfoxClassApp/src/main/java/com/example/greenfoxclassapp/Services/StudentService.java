package com.example.greenfoxclassapp.Services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<String> names;

    public StudentService() {
        names = new ArrayList<>();
        names.add("Sanyi");
        names.add("Lilla");
        names.add("John");
    }

    public List<String> findAll() {
        return names;
    }

    public void save(String student) {
        names.add(student);
    }

    public String countStudents() {
        int count = 0;
        for (int i = 0; i < names.size(); i++) {
            count++;
        }
        return "There is " + count + " students";
    }

    public boolean isRegistred(String name) {
        if (names.contains(name)) {
            return true;
        } else {
            return false;
        }
    }
}