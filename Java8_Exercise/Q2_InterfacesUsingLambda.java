/*Q(2) Implement following functional interfaces from java.util.functionusing lambdas:

    Consumer

    Supplier

     Predicate

     Function
*/
package java5_Assgnmnt;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Q2_InterfacesUsingLambda {
    public static void main(String[] args) {
        Consumer<Integer> consumer = i -> System.out.println(i);
        List<Integer> integerList = Arrays.asList(1,5,2,8,6);
        printConsumer(integerList,consumer);
        Supplier<String> StrSupplier = () -> new String("Testing Supplier");
        String str = StrSupplier.get();
        printSupplier(str);
        Predicate<String> predicateString = s -> {return s.equals("Hello");};
        pintPredicate(predicateString);
        calc((a) -> "Result: " + (a * 2), 10);
    }

    public static void printConsumer(List<Integer> integerList, Consumer<Integer> consumer ){
        System.out.println("===> Consumer Interface Test");
        for(Integer integer:integerList){
            consumer.accept(integer);
        }
        System.out.println(" #### Consumer Interface Ends ");
        System.out.println("-----------------------------------------------");

    }

    public static void printSupplier(String str){
        System.out.println("==> Supplier Interface Test");
        System.out.println(str);
        System.out.println("####Supplier Interface Ends");
        System.out.println("-----------------------------------------------");

    }

    public static void pintPredicate(Predicate<String> predicateString){
        System.out.println("===> Predicate Interface Test");
        System.out.println(predicateString.test("Hello"));
        System.out.println(predicateString.test("Hello World"));
        System.out.println("===> Predicate Interface Ends");
        System.out.println("-----------------------------------------------");
    }

    public static void calc(Function<Integer, String> bi, Integer i) {
        System.out.println("===> Function Interface Test");
        System.out.println(bi.apply(i));
        System.out.println("===> Function Interface Ends");
        System.out.println("-----------------------------------------------");
    }

}
