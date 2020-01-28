package com.restwithSpring.RestWithSpring.Repository;

import com.restwithSpring.RestWithSpring.Entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Integer> {

}
