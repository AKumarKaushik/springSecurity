package java4_Assgnmnt;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Q8_DateFormat {

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        String dateToStr = simpleDateFormat.format(date);
        System.out.println(dateToStr);


    }
}