/*Q8_RemoveCharUsingIndex. Write a program to reverse a string and remove character from index 4 to index 9 from the reversed string using String Buffer*/

package java1_Assgnmnt;
import java.util.Scanner;

public class Q8_RemoveCharUsingIndex {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter String ");
        String str = scan.nextLine();
        if(!str.equals("null")){
            if(str.length()>4){
                System.out.println("Original String = "+str);
                StringBuffer newstr = new StringBuffer();
                newstr.append(str);
                StringBuffer revString = newstr.reverse();
                System.out.println("Reverse String = "+revString);
                revString.delete(4, 9);
                System.out.println("String After Removing Character "+revString);
            }else{
                System.out.println("Plz Enter String of length greater than 4");
            }
        }
    }
}
