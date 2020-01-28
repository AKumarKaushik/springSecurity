package Main;

import config.PersistenceContext;
import entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Sort;
import repository.PersonRepository;

import java.util.List;

public class SortPersonUsingSortClass {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceContext.class);
        PersonRepository personRepository=applicationContext.getBean(PersonRepository.class);

        List<Person> personList = personRepository.findAll(new Sort(Sort.Direction.DESC,"age").and(new Sort(Sort.Direction.ASC,"fname")));
        System.out.println(personList);
    }
}
