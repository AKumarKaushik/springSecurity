/*Q3_CountCharacter. Write a program to find the number of occurrences of a character in a string without using loop?*/
package java1_Assgnmnt;

import java.util.Scanner;

public class Q3_CountCharacter {
    public static void main(String[] args){
        String str = null;
        char ch;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter String ");
        str = scan.nextLine();
        System.out.println("Enter Character to be Searched");
        ch = scan.next().charAt(0);
        int len = str.length();
        System.out.println("String length with "+ch+" : "+len);
        int len_without_char = str.replace(""+ch,"").length();
        System.out.println("String length without "+ch+" : "+len_without_char);
        int count = len-len_without_char;
        System.out.println("Occurence of "+ch+" : "+count);
    }
}
