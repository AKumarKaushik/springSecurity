package java2_Assgnmnt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Q7_SecondsConversion {
    int hour,min,sec,day;
    DateFormat df = new SimpleDateFormat("dd hh:mm:ss");

    public void convert(int seconds)
    {
        day=seconds/86400;

        seconds= seconds % (24 * 3600);
        int hour = seconds/ 3600;

        seconds %= 3600;
        int min = seconds / 60 ;

        seconds %= 60;
        int sec = seconds;
        System.out.println(" Day "+day);
        System.out.println("Hour "+hour);
        System.out.println("Minute "+min);
        System.out.println("Sec "+sec);

//System.out.println(df.format(day +hour +min +sec));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value for seconds");
        int seconds=sc.nextInt();
        Q7_SecondsConversion sec_con=new Q7_SecondsConversion();
        sec_con.convert(seconds);

    }
}
