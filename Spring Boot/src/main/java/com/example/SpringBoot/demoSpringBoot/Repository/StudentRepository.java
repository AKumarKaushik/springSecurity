package com.example.SpringBoot.demoSpringBoot.Repository;

import com.example.SpringBoot.demoSpringBoot.entity.StudentBootstrap;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentBootstrap,Integer> {

}
