package com.example.SpringBoot.demoSpringBoot.Controller;

import com.example.SpringBoot.demoSpringBoot.Service.StudentService;
import com.example.SpringBoot.demoSpringBoot.entity.Database;
import com.example.SpringBoot.demoSpringBoot.entity.Student;
import com.example.SpringBoot.demoSpringBoot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/student")
    public List<Student> getStudent(){
        return  studentService.getStudent();
    }

    @Value("${database.port}")
    int port;
    @Value("${database.name}")
    String name;

    @GetMapping("/portValue")
    public int getPort(){
        return port;
    }

    @GetMapping("/databaseName")
    public String getName(){
        return name;
    }
}

