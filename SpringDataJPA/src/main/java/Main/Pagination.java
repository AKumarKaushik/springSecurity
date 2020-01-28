package Main;

import config.PersistenceContext;
import entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import repository.PersonRepository;


import java.util.List;

public class Pagination {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceContext.class);
        PersonRepository personRepository = applicationContext.getBean(PersonRepository.class);

        Page<Person> personPage = personRepository.findAll(new PageRequest(0,2,new Sort(Sort.Direction.ASC,"id")));

        List<Person> personList = personPage.getContent();
        System.out.println(personList);
    }
}
