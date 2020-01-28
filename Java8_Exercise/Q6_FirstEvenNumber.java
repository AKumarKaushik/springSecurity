/*Q(6) Find the first even number in the integer list which is greater than 3.*/
package java5_Assgnmnt;

import java.util.Arrays;
import java.util.List;

public class Q6_FirstEvenNumber {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,6,2,7,1,10,8);
        System.out.println(integerList.stream().filter(num -> num > 3).filter(num -> num%2 == 0).min(Integer::compare).get());
    }
}
