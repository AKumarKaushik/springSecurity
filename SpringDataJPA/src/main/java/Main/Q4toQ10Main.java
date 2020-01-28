package Main;

import config.PersistenceContext;
import entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.PersonRepository;

import java.util.Arrays;
import java.util.List;

public class Q4toQ10Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceContext.class);
        PersonRepository personRepository = applicationContext.getBean(PersonRepository.class);

        List<Person> personList = personRepository.findByFname("Akash0");
        System.out.println("## Person List Size for First Name ======== "+personList.size());
        System.out.println(personList);

        System.out.println("----------------------------------------------------------------------");

        List<Person> personList1 = personRepository.findByLname("Kaushik0");
        System.out.println("## Person List Size for Last Name ======== "+personList1.size());
        System.out.println(personList1);

        System.out.println("----------------------------------------------------------------------");

        Person person = personRepository.findById(3);
        System.out.println("## Person Find By Id "+person);

        System.out.println("----------------------------------------------------------------------");

        List<String> personList2 = personRepository.findByAge(25);
        System.out.println("## Person List Size for Find FName With Given Age ==== "+personList2.size());
        System.out.println(personList2);

        System.out.println("----------------------------------------------------------------------");

        List<Person[]> list  = personRepository.findByFnameAndLname(25);
        System.out.println("## Person List Size for Find FNameANDLName With Given Age ==== "+personList2.size());
        System.out.println(list);

        System.out.println("----------------------------------------------------------------------");

        List<Person> pAllByAge = personRepository.findAllByAge(25);
        System.out.println("## Fina All By Age"+pAllByAge);

        System.out.println("----------------------------------------------------------------------");

        int count = personRepository.countByName("Peter");
        System.out.println("## Count By Name "+count);

        System.out.println("----------------------------------------------------------------------");

        int countSalaryResult = personRepository.countBySalary(25000);
        System.out.println(" ## Salary Count "+countSalaryResult);

        System.out.println("----------------------------------------------------------------------");

        List<String> pDistinct = personRepository.findDistinctByFname("Akash0");
        System.out.println("## Find By Distinct Name "+pDistinct);

        System.out.println("----------------------------------------------------------------------");

        List<String> pNameorAge = personRepository.findByFnameOrAge("Akash0",25);
        System.out.println("## Person With Name Or Age "+pNameorAge);

        System.out.println("----------------------------------------------------------------------");

        List<String> pNameAndAge = personRepository.findByFnameAndAge("Akash0",25);
        System.out.println("## Person With Name AND Age "+pNameAndAge);

        System.out.println("----------------------------------------------------------------------");

        List<String> pAgeBetween = personRepository.findByAgeBetween(24,25);
        System.out.println("## Age Between "+pAgeBetween);

        System.out.println("----------------------------------------------------------------------");

        List<String> pAgeLessThan = personRepository.findByAgeLessThan(24);
        System.out.println("## Age Less Than "+pAgeLessThan);

        System.out.println("----------------------------------------------------------------------");

        List<String> pAgeGreateThan = personRepository.findByAgeGreaterThan(23);
        System.out.println("## Age Greater Than "+pAgeGreateThan);

        System.out.println("----------------------------------------------------------------------");

        List<String> pFnameLike = personRepository.findByFnameLike("%Akash%");
        System.out.println("## Name Like "+pFnameLike);

        System.out.println("----------------------------------------------------------------------");

        List<String> pNameNot = personRepository.findByFnameNot("Akash0");
        System.out.println("## Name Not "+pNameNot);

        System.out.println("----------------------------------------------------------------------");

        List<Integer> ageList = Arrays.asList(24,25);
        List<String> pAgeIn = personRepository.findByAgeIn(ageList);
        System.out.println("## Age In "+pAgeIn);

        System.out.println("----------------------------------------------------------------------");

        List<String> pNameIgnore = personRepository.findByFnameIgnoreCase("akash0");
        System.out.println("## Name with Ignore Case "+pNameIgnore);

        System.out.println("----------------------------------------------------------------------");


    }
}
