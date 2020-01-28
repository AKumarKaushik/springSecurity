/*Q7_UsageOfStatic. Write a program to print your Firstname,LastName & age using static block,static method & static variable respectively*/

package java1_Assgnmnt;
public class Q7_UsageOfStatic {

    static String firstname = "Akash";
    static String lastName = "Kumar";
    static String age = "24";

    static{
        lastName = "Kaushik";
        System.out.println("Static Block called");
    }

    public  static void printList(){
        System.out.println("First Name = "+firstname);
        System.out.println("Last Name = "+lastName);
        System.out.println("Age = "+age);
    }

    public static void main(String[] args) {
        printList();
    }


}
