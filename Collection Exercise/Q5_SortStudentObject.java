package java4_Assgnmnt;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparator<Student> {


    private String name;
    private Double score;
    private Double age;

    public Student() {
    }


    public Student(String name, Double score, Double age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }


    @Override
    public int compare(Student o1, Student o2) {

        if (o1.getScore().equals(o2.getScore())) {
            return o1.getName().compareTo(o2.getName());
        }
        if (o1.getScore() < o2.getScore()) {
            return -1;
        } else return 1;
    }
}

public class Q5_SortStudentObject {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Ramesh", 455.00, 20.00));
        studentList.add(new Student("Thina", 45.00, 32.00));
        studentList.add(new Student("Dyna", 455.00, 73.00));
        studentList.add(new Student("Hyena", 55.00, 23.00));
        studentList.add(new Student("Poh", 35.00, 93.00));
        studentList.add(new Student("Roh", 75.00, 53.00));
        studentList.add(new Student("Rsh", 855.00, 13.00));
        studentList.add(new Student("Ram", 455.00, 83.00));
        studentList.add(new Student("Ram", 123.00, 55.00));

        Student student = new Student();

        //studentList.sort(student);
        Collections.sort(studentList, student);

        for (Student s : studentList) {
            System.out.println(s.toString());
        }

    }

}