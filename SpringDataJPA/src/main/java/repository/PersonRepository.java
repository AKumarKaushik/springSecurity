package repository;

import entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.Embeddable;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person,Integer> {

    List<Person> findByFname(String fname);

    List<Person> findByLname(String lname);

    Person findById(int id);

    @Query("select fname from Person where age = :age")
    List<String> findByAge(@Param("age") int age);

    @Query("select fname,lname from Person where age = :age")
    List<Person[]> findByFnameAndLname(@Param("age") int age);

    @Query("select p from Person p where age = :age")
    List<Person> findAllByAge(@Param("age") int age);

    @Query("SELECT Count(*) from Person where fname=:name")
    Integer countByName(@Param("name") String name);

    Integer countBySalary(int salary);

    List<String> findDistinctByFname(String fname);

    List<String> findByFnameOrAge(String name, Integer age);

    List<String> findByFnameAndAge(String name, Integer age);

    List<String> findByAgeBetween(int min,int max);

    List<String> findByAgeLessThan(int age);

    List<String> findByAgeGreaterThan(int age);

    List<String> findByFnameLike(String name);

    List<String> findByFnameNot(String name);

    List<String> findByAgeIn(List<Integer> ageList);

    List<String> findByFnameIgnoreCase(String name);


    List<Person> findByAgeOrderByIdDesc(int  age);

    List<Person> findAll(Sort sort);

    Page<Person> findAll(Pageable pageable);

}