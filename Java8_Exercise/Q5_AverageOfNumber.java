/*Q(5) Find average of the number inside integer list after doubling it.*/
package java5_Assgnmnt;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Q5_AverageOfNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        OptionalDouble avg = list.stream().mapToInt(num -> num * 2).average();
        System.out.println(avg.getAsDouble());
    }
}
