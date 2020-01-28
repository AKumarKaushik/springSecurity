package com.example.SpringBoot.demoSpringBoot.Service;

import com.example.SpringBoot.demoSpringBoot.Repository.StudentRepository;
import com.example.SpringBoot.demoSpringBoot.entity.StudentBootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentServiceBootstrap {

    @Autowired
    StudentRepository studentRepository;

    public List<StudentBootstrap> getStudents(){
        List<StudentBootstrap> list = new ArrayList<>();
        Iterator<StudentBootstrap> studentBootstrapIterator = studentRepository.findAll().iterator();
        studentBootstrapIterator.forEachRemaining(list::add);
        return list;
    }
}
