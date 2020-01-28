package java4_Assgnmnt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q1_SumOfFloatingNumbers {
    public static void main(String[] args) {
            float sum = 0.0f;
            List<Float> numberList = new ArrayList<>();
            numberList.add(6.1f);
            numberList.add(3.3f);
            numberList.add(7.4f);
            numberList.add(9.1f);
            numberList.add(0.5f);
            numberList.add(1.1f);
            Iterator<Float> iterator = numberList.iterator();
            while (iterator.hasNext()) {
                float n = iterator.next();
                sum += n;
            }
            System.out.println("Sum of Numbers :" + sum);

        }
}
