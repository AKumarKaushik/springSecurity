/*2. Write a program to find the number of occurrences of the duplicate words in a string and print them ?*/

package java1_Assgnmnt;

import java.util.Scanner;

public class Q2_CountDuplicateWords {
    public static void main(String[] args){
        String str = null;
        int count=0,len=0;
        System.out.println("Enter String ");
        Scanner scan = new Scanner(System.in);
        str = scan.nextLine();
        if(!str.equals("null")){
            System.out.println("Entered String : "+str);
            String[] words = str.split(" ");
            int wc = 1;
            for(int i=0;i<words.length;i++)
            {
                for(int j=i+1;j<words.length;j++)
                {
                    if(words[i].equals(words[j]))
                    {
                        wc = wc+1;
                        words[j]="0";
                    }
                }
                if(words[i]!="0")
                    System.out.println(words[i]+"--->"+wc);
                    wc = 1;
            }
        }
    }
}
