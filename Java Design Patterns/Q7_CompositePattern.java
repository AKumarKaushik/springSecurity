/*Q7) Implement Composite Design Pattern to maintaing the directories of employees on the basis of departments.*/
package java6_Assgnmnt;

import java.util.ArrayList;
import java.util.List;

//Component
interface Employee {
    void showEmployeeDetails();
}
//Leaf
class Developer implements Employee {
    private String name;
    private String favoriteLanguage;

    public Developer(String name, String favoriteLanguage) {
        this.name = name;
        this.favoriteLanguage = favoriteLanguage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println("Developer { " +
                "name = '" + name + '\'' +
                ", favoriteLanguage = '" + favoriteLanguage + '\'' +
                '}');
    }

    @Override
    public String toString() {
        return "Developer { " +
                "name = '" + name + '\'' +
                ", favoriteLanguage = '" + favoriteLanguage + '\'' +
                '}';
    }
}

//leaf
class Manager implements Employee{

    private String name;
    private String type;

    public Manager(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void showEmployeeDetails() {
        System.out.println("Manager { " +
                "name = '" + name + '\'' +
                ", type = '" + type + '\'' +
                '}');
    }

    @Override
    public String toString() {
        return "Manager { " +
                "name = '" + name + '\'' +
                ", type = '" + type + '\'' +
                '}';
    }
}

//Composite
class DeveloperEmployee implements Employee{

    List<Employee> developerEmployee = new ArrayList<Employee>();

    @Override
    public void showEmployeeDetails() {
        System.out.println("Developer Directory");
        developerEmployee.forEach(e->e.showEmployeeDetails());
    }
}

//Composite
class ManagerEmployee implements Employee{

    List<Employee> managerEmployee = new ArrayList<Employee>();

    @Override
    public void showEmployeeDetails() {
        System.out.println("Manager Directory");
        managerEmployee.forEach(e->e.showEmployeeDetails());
    }
}

//Composite

class CompanyEmployee implements Employee{

    List<Employee> companyEmployee = new ArrayList<>();

    @Override
    public void showEmployeeDetails() {
        companyEmployee.forEach(e->e.showEmployeeDetails());
    }
}
//Client
public class Q7_CompositePattern {

    public static void main(String[] args) {

        Developer developer1 = new Developer("Akash","Java");
        Developer developer2 = new Developer("Anurag","C#");

        Manager manager1 = new Manager("Raj","Executive");
        Manager manager2 = new Manager("Prashant","Senior");

        DeveloperEmployee developerEmployee= new DeveloperEmployee();
        developerEmployee.developerEmployee.add(developer1);
        developerEmployee.developerEmployee.add(developer2);

        ManagerEmployee managerEmployee = new ManagerEmployee();
        managerEmployee.managerEmployee.add(manager1);
        managerEmployee.managerEmployee.add(manager2);

        CompanyEmployee companyEmployee= new CompanyEmployee();
        companyEmployee.companyEmployee.add(developerEmployee);
        companyEmployee.companyEmployee.add(managerEmployee);

        companyEmployee.showEmployeeDetails();
    }
}

