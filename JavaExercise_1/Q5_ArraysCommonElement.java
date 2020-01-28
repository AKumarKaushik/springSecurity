/*Q5_ArraysCommonElement. Find common elements between two arrays.*/

package java1_Assgnmnt;
import java.util.Scanner;

public class Q5_ArraysCommonElement {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       System.out.println("Enter size of 1st array ");
       int n = scan.nextInt();
       int arr1[] = new int[n];
       System.out.println("Enter size of 2nd array ");
       int m = scan.nextInt();
       int arr2[] = new int[m];

       System.out.println("Enter Elements for array 1 ");
        for(int i = 0; i < arr1.length; i++){
            arr1[i] = scan.nextInt();
        }

        System.out.println("Enter Elements for array 2");
         for(int k = 0 ; k < arr2.length; k++){
             arr2[k] = scan.nextInt();
         }
        findCommonElements(arr1,arr2);
    }

    public static void findCommonElements(int arr1[], int arr2[]) {
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2.length; j++){
                if(arr1[i]==arr2[j]){
                    System.out.println("Common Elements : "+arr1[i]);
                }
            }
        }
    }
}
