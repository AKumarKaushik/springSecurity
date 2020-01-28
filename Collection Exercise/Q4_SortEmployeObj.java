package java4_Assgnmnt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparator<Employee> {


    private double age;
    private double salary;
    private String name;

    Employee(double age, double salary, String name) {
        this.age = age;
        this.salary = salary;
        this.name = name;
    }
    Employee() {
    }
    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                '}';
    }
    @Override
    public int compare(Employee o1, Employee o2) {

        if (o1.salary < o2.salary) {
            return -1;
        }
        if (o1.salary > o2.salary) {
            return 1;
        } else return 0;
    }
}


public class Q4_SortEmployeObj {


    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(24.00, 50000, "Kaushik"));
        employeeList.add(new Employee(20.00, 40000, "TTN"));
        employeeList.add(new Employee(21.00, 4555, "Hello"));
        employeeList.add(new Employee(22.00, 6544300, "Welcome"));
        Employee employee = new Employee();
        Collections.sort(employeeList, employee);

        for (Employee e : employeeList) {

            System.out.println(e.toString());
        }

    }
}