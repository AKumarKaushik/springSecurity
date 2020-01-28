package com.example.SpringBoot.demoSpringBoot;

import com.example.SpringBoot.demoSpringBoot.entity.Database;
import com.example.SpringBoot.demoSpringBoot.entity.Student;
import com.example.SpringBoot.demoSpringBoot.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;


@SpringBootApplication
public class DemoSpringBootApplication {

	@Bean
    public User getUser(){
		User user = new User();
		user.getPassword();
		user.getUsername();
		return user;
	}

//	private static final Logger logger = LoggerFactory.getLogger(SpringBootApplication.class);


	public static void main(String[] args) {
		/*logger.info("this is a info message");
		logger.warn("this is a warn message");
		logger.error("this is a error message");*/
		SpringApplication.run(DemoSpringBootApplication.class, args);
	}
}
