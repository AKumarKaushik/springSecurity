/*Q4_findPercentage. Calculate the number & Percentage Of Lowercase Letters,Uppercase Letters, Digits And Other Special Characters In A String*/

package java1_Assgnmnt;
import java.util.Scanner;

public class Q4_findPercentage {
    public static void main(String[] args) {
        String str = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter String ");
        str = scan.nextLine();
        if(!str.equals("null")){
            findCount(str);
        }
    }

    public static void findCount(String str){
        int len = str.length();
        int upperCaseLetters = 0;
        int lowerCaseLetters = 0;
        int digit = 0;
        int other = 0;
        for(int i = 0; i < len; i++){
            char ch = str.charAt(i);
            if(Character.isUpperCase(ch)){
                upperCaseLetters++;
            }else if(Character.isLowerCase(ch)){
                lowerCaseLetters++;
            }else if(Character.isDigit(ch)){
                digit++;
            }else{
                other++;
            }
        }
        findPercentage(upperCaseLetters,lowerCaseLetters,digit,other,len);
    }

    public static void findPercentage(int upperCaseLetters,int lowerCaseLetters,int digit,int other,int len){
        double upperCaseLetterPercentage = ( upperCaseLetters * 100.00 ) / len;
        double lowerCaseLetterPercentage = ( lowerCaseLetters * 100.00 ) / len;
        double digitPercentage = ( digit * 100.00 ) / len;
        double otherPercentage = ( other * 100.00 ) / len;

        printPercentage(upperCaseLetterPercentage,lowerCaseLetterPercentage,digitPercentage,otherPercentage);
    }

    public static void printPercentage(double upperCaseLetterPercentage,double lowerCaseLetterPercentage,double digitPercentage,double otherPercentage){
        System.out.println(" UpperCase Letter Percentage : "+upperCaseLetterPercentage);
        System.out.println(" LowerCase Letter Percentage : "+lowerCaseLetterPercentage);
        System.out.println(" Digit Percentage : "+digitPercentage);
        System.out.println(" Other Percentage : "+otherPercentage);
    }
}
