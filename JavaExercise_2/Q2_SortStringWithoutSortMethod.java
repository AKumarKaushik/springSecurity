package java2_Assgnmnt;

import java.util.Scanner;

public class Q2_SortStringWithoutSortMethod {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = null;
        System.out.println("Enter String ");
        str = scan.nextLine().trim();
        if(!str.equals("null")){
            sort(str);
        }
    }

    public static void sort(String str){
        char ch[] = str.toCharArray();
        System.out.println("Length : "+ch.length);
        char temp = 0;
        for(int k = 0; k < ch.length-1; k++){
            for(int j = 0; j < ch.length-1; j++){
                if(ch[j] > ch[j+1]){
                    temp = ch[j];
                    ch[j] = ch[j+1];
                    ch[j+1] = temp;
                }
            }
        }
        String name = "";
        for(int a = 0; a < ch.length; a++){
            name += ch[a];
        }
        name = name.replaceFirst(" ","");
        System.out.println("Sorted String ="+name);
    }
}
