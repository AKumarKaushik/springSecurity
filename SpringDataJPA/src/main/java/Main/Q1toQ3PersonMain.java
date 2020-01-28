package Main;
import config.PersistenceContext;
import entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.PersonRepository;

import java.util.Optional;

public class Q1toQ3PersonMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceContext.class);
        PersonRepository personRepository = applicationContext.getBean(PersonRepository.class);

        // create
        /*for(int i=0;i<=10;i++){
            Person person = new Person("Akash"+i,"Kaushik"+i,25000,23);
            personRepository.save(person);
            System.out.println(person);
        }*/

        // Read
        /*Optional<Person> person = personRepository.findById(1);
        System.out.println(person);*/


        //Update
       /* Person person = personRepository.findById(3).get();
        person.setFname("Third Name");
        personRepository.save(person);*/

        //Delete
       /* personRepository.deleteById(2);*/


    }
}

