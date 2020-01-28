
/*Q1. Write a program to replace a substring inside a string with other string ?*/

package java1_Assgnmnt;

import java.util.Scanner;

public class Q1_ReplaceSubString {
    public static void main(String[] args)
    {
        String str = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter String ");
        str = scan.nextLine().toLowerCase();
        if(!str.equals("null")){
            System.out.println("Entered String : "+str);
            String subString = null;
            System.out.println("Enter Sub String ");
            subString = scan.nextLine().toLowerCase();
            if(!subString.equals("null")){
                System.out.println("Entered Sub_String : "+subString);
                boolean flag = findSubString(subString,str);
                if(flag == true){
                    System.out.println("Sub String Exists");
                    replaceString(subString,str);
                }else{
                    System.out.println("Sub String Not Found");
                }
            }else{
                System.out.println("Plz Enter a valid SubString ");
            }

        }else{
            System.out.println("plzz enter a valid string");
        }

    }


     public static boolean findSubString(String subString, String str){
        boolean flag = str.contains(subString);
        return flag;
     }

     public static void replaceString(String subString, String str){
        String str_to_replace = null;
        System.out.println("Enter String to Replace");
        Scanner scan = new Scanner(System.in);
        str_to_replace = scan.nextLine().toLowerCase();
        if(!str_to_replace.equals("null")){
            str = str.replace(subString,str_to_replace);
            System.out.println("String After Replaced :: "+str);
        }else{
            System.out.println("plz Enter a valid String to replace ");

        }
     }
}