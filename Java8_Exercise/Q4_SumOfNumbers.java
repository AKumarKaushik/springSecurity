/*Q(4) Sum all the numbers greater than 5 in the integer list.*/
package java5_Assgnmnt;

import java.util.Arrays;
import java.util.List;

public class Q4_SumOfNumbers {
    public static int sum(List<Integer> list){
        return list.stream().filter(num -> num > 5).mapToInt(num -> num).sum();
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,7,10,11,9);
        System.out.println(sum(list));
    }
}
