package java2_Assgnmnt;

import java.util.Scanner;

public class Q8_CheckCharactersOfWord {

    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = sc.next();
        //with while loop
        while (!word.equals("done")) {
            if (word.charAt(0) == word.charAt(word.length() - 1)) {
                System.out.println("First and last character are equals for the word:" + word);
            }
            else{
                System.out.println("First and last character are NOT equals for the word:" + word);
            }
            word = sc.next();
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a word");
        String word = sc.next();
        do {
            if (word.charAt(0) == word.charAt(word.length() - 1)) {
                System.out.println("First and last character are equals for the word:" + word);
            } else {
                System.out.println("Fisrt and last character are NOT equals for the word:" + word);
            }
            word = sc.next();
        }while (!word.equals("done"));

    }


}

