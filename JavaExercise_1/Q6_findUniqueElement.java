/*Q6_findUniqueElement. There is an array with every element repeated twice except one. Find that element*/

package java1_Assgnmnt;
import java.util.Scanner;

public class Q6_findUniqueElement {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of an array");
        int n = scan.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the array elements");
        for(int i = 0; i < n; i++)
        {
            arr[i]=scan.nextInt();
        }
        int res=arr[0];
        for (int i = 1; i < arr.length; i++){
            res = res ^ arr[i];
        }
        System.out.println("\n Element : "+res);
    }
}
