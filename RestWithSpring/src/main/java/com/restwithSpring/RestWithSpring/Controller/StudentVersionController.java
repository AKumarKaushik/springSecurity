package com.restwithSpring.RestWithSpring.Controller;

import com.restwithSpring.RestWithSpring.Entity.StudentName;
import com.restwithSpring.RestWithSpring.Entity.StudentV1;
import com.restwithSpring.RestWithSpring.Entity.StudentV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentVersionController {

    // URI Versioning

    @GetMapping("/studentV1")
    StudentV1 getStudent(){
        return new StudentV1("Peter");
    }


    @GetMapping("/studentV2")
    StudentV2 getStudent2(){
        return new StudentV2(new StudentName("Peter","Parker"));
    }


    @GetMapping(value = "/student/param",params = "version=1")
    StudentV1 getStudentParam1() {
        return new StudentV1("Peter");
    }

    @GetMapping(value = "/student/param",params = "version=2")
    StudentV2 getPersonParam2() {
        return new StudentV2(new StudentName("Peter","Parker"));
    }

    @GetMapping(value = "/student/header",headers = "API-VERSION=1")
    StudentV1 getStudentHeader1() {
        return new StudentV1("Peter Parker");
    }

    @GetMapping(value = "/student/header",headers = "API-VERSION=2")
    StudentV2 getStudentHeader2() {
        return new StudentV2(new StudentName("Peter","Parker"));
    }
}
