package com.restwithSpring.RestWithSpring.Controller;

import com.restwithSpring.RestWithSpring.Entity.CustomException;
import com.restwithSpring.RestWithSpring.Entity.Post;
import com.restwithSpring.RestWithSpring.Entity.Student;
import com.restwithSpring.RestWithSpring.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class StudentController {

    @Autowired
    MessageSource messageSource;

    @Autowired
    StudentService studentService;

    @GetMapping("/studentList")
    public List<Student> getStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/create")
    public List<Student> createStudent() {
        return studentService.createStudent();
    }

    @GetMapping("/users/{id}")
    public Student getUserById(@PathVariable int id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            throw new CustomException("User not found!!");
        }
        return studentService.getStudentById(id);
    }

    @PostMapping("/students")
    Student student(@RequestBody Student student){
        studentService.save(student);
        return student;
    }


    @PostMapping("/studentsException")
    public ResponseEntity<Student> saveUser(@Valid @RequestBody Student student) {
        studentService.save(student);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}").buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @GetMapping("/")
    String helloWorld(@RequestHeader(name = "Accept-Language",required = false) Locale locale){
        System.out.println("hello world");
        System.out.println(locale.getLanguage());
        return messageSource.getMessage("good.morning.message",null,locale);
    }

    @GetMapping("/createNew")
    public List<Student> createStudent2() {
        return studentService.createStudent2();
    }


    @PostMapping("/usersNewCreate")
    Student saveUser2( @RequestBody Student student){
        studentService.saveUser2(student);
        return student;
    }

    @GetMapping("/postList")
    public List<Post> getPostList(){
        RestTemplate restTemplate = new RestTemplate();
        String url="https://jsonplaceholder.typicode.com/posts";
        ResponseEntity<List<Post>> response = restTemplate
                .exchange(url, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Post>>(){});
        return response.getBody();
    }

    @PostMapping("/createPost")
    public ResponseEntity<Post> createPost(){
        String url="https://jsonplaceholder.typicode.com/posts";
        RestTemplate restTemplate= new RestTemplate();
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("Content-type","application/json; charset=UTF-8");
        HttpEntity<Post> request=new HttpEntity<>(new Post(10000L,10000L,"title1","description1"),httpHeaders);
        Post post=restTemplate.postForObject(url,request,Post.class);
        System.out.println(post);
        return new ResponseEntity<Post>(post, HttpStatus.CREATED);
    }

    @PutMapping("/updatePost")
    public ResponseEntity<Post> updatePost(){
        String url="https://jsonplaceholder.typicode.com/posts/1";
        RestTemplate restTemplate= new RestTemplate();
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("Content-type","application/json; charset=UTF-8");
        HttpEntity<Post> request=new HttpEntity<>(new Post(101L,100L,"title1","description1"),httpHeaders);
        return restTemplate.exchange(url,HttpMethod.PUT,request,Post.class);
    }

    @DeleteMapping("/deletePost")
    public void deletePost(){
        String url="https://jsonplaceholder.typicode.com/posts/1";
        RestTemplate restTemplate= new RestTemplate();
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("Content-type","application/json; charset=UTF-8");
        HttpEntity<Post> request=new HttpEntity<>(httpHeaders);
        restTemplate.exchange(url,HttpMethod.DELETE,request,Post.class);
    }
}
