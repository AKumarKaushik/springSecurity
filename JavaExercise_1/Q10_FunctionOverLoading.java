/*Q10_FunctionOverLoading.Write a single program for following operation using overloading
  A) Adding 2 integer number
  B) Adding 2 double
  C) multiplying 2 float
  D) multiplying 2 int
  E) concate 2 string
  F) Concate 3 String*/

package java1_Assgnmnt;

public class Q10_FunctionOverLoading {

    public int sum(int a, int b){

        return (a+b);
    }

    public double sum(double a , double b){

        return (a+b);
    }

    public float multiply(float a, float b){

        return (a*b);
    }

    public int multiply(int a, int b){

        return (a*b);
    }

    public String concat(String str1, String str2){

        return (str1+str2);
    }

    public String concat(String str1, String str2, String str3){

        return (str1+str2+str3);
    }

    public static void main(String[] args) {
        Q10_FunctionOverLoading obj = new Q10_FunctionOverLoading();
        System.out.println("Integer Sum : "+obj.sum(5,9));
        System.out.println("Double Sum : "+obj.sum(5.2,9.4));
        System.out.println("Float Multiply : "+obj.multiply(1.4f,3.3f));
        System.out.println("Integer Multiply : "+obj.multiply(2,5));
        System.out.println("Two String Concatenation : "+obj.concat("Hello","_World"));
        System.out.println("Three String Concatenation : "+obj.concat("Hello","_World","_Welcome"));
    }
}
