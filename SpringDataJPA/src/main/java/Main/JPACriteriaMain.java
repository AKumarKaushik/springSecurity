package Main;

import config.PersistenceContext;
import entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.domain.Specification;
import repository.PersonJPARepository;

import javax.persistence.criteria.*;

public class JPACriteriaMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistenceContext.class);
        PersonJPARepository personJPARepository = applicationContext.getBean(PersonJPARepository.class);


        Specification<Person> personSpecification = new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path path = root.get("id");
                Predicate predicate = criteriaBuilder.gt(path,5);
                return predicate;
            }
        };

        System.out.println(personJPARepository.findAll(personSpecification));

        System.out.println("----------------------------------------------------------------------");

        Specification<Person> personSpecification1 = new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path path = root.get("id");
                Path path1= root.get("fname");

                Predicate predicate = criteriaBuilder.and(criteriaBuilder.equal(path1,"Peter"),criteriaBuilder.lt(path,13));
                return  predicate;
            }
        };

        System.out.println(personJPARepository.findAll(personSpecification1));

        System.out.println("----------------------------------------------------------------------");

         Specification<Person> personSpecification2 = new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Path path = root.get("id");
                Path path1= root.get("fname");

                Predicate predicate = criteriaBuilder.or(criteriaBuilder.equal(path1,"Peter"),criteriaBuilder.lt(path,2));
                return  predicate;
            }
        };

        System.out.println(personJPARepository.findAll(personSpecification2));

        System.out.println("----------------------------------------------------------------------");

        Specification<Person> personSpecification3 = new Specification<Person>() {
            @Override
            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path path = root.get("id");
                Path path1= root.get("fname");

                Predicate predicate = cb.between(path,1,5);
                return  predicate;
            }
        };

        System.out.println(personJPARepository.findAll(personSpecification3));

    }
}
