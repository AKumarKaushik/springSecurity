package com.example.SpringBoot.demoSpringBoot.Service;

import com.example.SpringBoot.demoSpringBoot.entity.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    public List<Student> getStudent(){
        return Arrays.asList(new Student(1,"Akash"),
                new Student(2,"Divanshu"));
    }
}
