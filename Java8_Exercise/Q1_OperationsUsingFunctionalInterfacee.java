/*Q1) Write the following a functional interface and implement it using lambda:

     First number is greater than second number or not

            Parameter (int ,int ) Return boolean

     Increment the number by 1 and return incremented value

            Parameter (int) Return int

     Concatination of 2 string

          Parameter (String , String ) Return (String)

     Convert a string to uppercase and return

        Parameter (String) Return (String)*/

package java5_Assgnmnt;
@FunctionalInterface
interface  Increment{
    int operation(int a);
}

@FunctionalInterface
interface Concat<T,R>{
    T operation(T a , T b);
}

@FunctionalInterface
interface ToUpperCase<T>{
    T operation(T a);
}

interface Compare{
    int operation(int a, int b);
}
public class Q1_OperationsUsingFunctionalInterfacee {
    public static void main(String[] args) {
        Increment Inc = a -> a+1;
        System.out.println(Inc.operation(7));
        Concat<String,String> concat = (a , b) -> a+b;
        System.out.println(concat.operation("Hello ","World"));
        ToUpperCase<String> upperObj = a -> a.toUpperCase();
        System.out.println(upperObj.operation("hello"));
        Compare object = (a,b) -> a > b ? a : b;
        System.out.println(object.operation(9,6));
    }
}
