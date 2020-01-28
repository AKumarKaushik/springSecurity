/*Q(3) Collect all the even numbers from an integer list.*/
package java5_Assgnmnt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q3_EvenNoCalculation {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,3,6,7,9,2,10,4,8,5);
        integerList.stream().filter(num -> num%2 == 0).forEach(System.out::println);
    }
}
