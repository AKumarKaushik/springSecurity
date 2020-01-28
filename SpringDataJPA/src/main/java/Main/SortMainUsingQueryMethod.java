package Main;

import config.PersistenceContext;
import entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.PersonJPARepository;
import repository.PersonRepository;

import java.time.Period;
import java.util.List;

public class SortMainUsingQueryMethod {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceContext.class);
        PersonRepository personRepository = applicationContext.getBean(PersonRepository.class);

        List<Person> list = personRepository.findByAgeOrderByIdDesc(25);
        System.out.println(list);
    }
}
