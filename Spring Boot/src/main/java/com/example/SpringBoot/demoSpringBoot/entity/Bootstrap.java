package com.example.SpringBoot.demoSpringBoot.entity;

import com.example.SpringBoot.demoSpringBoot.Repository.StudentRepository;
import com.example.SpringBoot.demoSpringBoot.entity.StudentBootstrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.event.ApplicationStartedEvent;

import java.util.Iterator;

@Component
public class Bootstrap {
    @Autowired
    StudentRepository studentRepository;

    @EventListener(ApplicationStartedEvent.class)
    public void init(){
        Iterator<StudentBootstrap> studentBootstrapIterator = studentRepository.findAll().iterator();
        if(!studentBootstrapIterator.hasNext()){
            for(int i=1;i<=10;i++){
                StudentBootstrap studentBootstrap = new StudentBootstrap(i,"Student"+i);
                studentRepository.save(studentBootstrap);
                System.out.println("Student "+i+" Added");
            }
        }
        System.out.println("Your Application Is Up And Runing");

    }
}
