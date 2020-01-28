package java2_Assgnmnt;

public class Q4_SingletonClass {
    private static Q4_SingletonClass myObj;

    static{
        myObj = new Q4_SingletonClass();
    }

    private Q4_SingletonClass(){

    }

    public static Q4_SingletonClass getInstance(){
        return myObj;
    }

    public void testMe(){
        System.out.println("Hey.... it is working!!!");
    }

    public static void main(String a[]){
        Q4_SingletonClass ms = getInstance();
        ms.testMe();
    }
}
