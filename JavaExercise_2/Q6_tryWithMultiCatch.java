package java2_Assgnmnt;

public class Q6_tryWithMultiCatch {
    public static void main(String[] args) {

        try{

            int num1 = 0;
            int num2 = 1/num1;
            System.out.println("## "+num2);
            System.out.println("Try Block Ends");

        }catch(ArithmeticException exception){

            System.out.println("Never Divide A Number By Zero");
            System.out.println("####  First Catch Ends  ####");

        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            System.out.println("Finally Block Executed ");
        }

    }
}
