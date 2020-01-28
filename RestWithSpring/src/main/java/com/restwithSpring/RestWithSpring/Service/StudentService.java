package com.restwithSpring.RestWithSpring.Service;

import com.restwithSpring.RestWithSpring.Entity.Student;
import com.restwithSpring.RestWithSpring.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    List<Student> studentList = new ArrayList<>();

    public List<Student> getAllStudent(){
        return (List<Student>) studentRepository.findAll();
    }

    public List<Student> createStudent(){
        for(int i=0;i<10;i++){
            Student student = new Student("Akash"+i,23,"India");
            studentList.add(student);
            studentRepository.saveAll(studentList);
        }
        return studentList;
    }

    public List<Student> createStudent2(){
            Student student = new Student("New Student",21,"New Jersey");
            studentList.add(student);
            studentRepository.saveAll(studentList);
            return studentList;
    }


    public Student getStudentById(int id){
        Optional<Student> optional=studentRepository.findById(id);
        return optional.isPresent() ? optional.get(): null;
    }

    public void save(Student student){
        studentRepository.save(student);
    }

    public void saveUser2(Student student){
        studentRepository.save(student);
    }


}
