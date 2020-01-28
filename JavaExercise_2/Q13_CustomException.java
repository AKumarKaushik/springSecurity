package java2_Assgnmnt;
import java.lang.*;

 class MyCustomException extends Exception{
    private String str = null;
    public MyCustomException(){
        super();
    }

    public MyCustomException(String message){
        super(message);
    }
}

public class Q13_CustomException {
    public static void main(String[] args) {
        try{
            validate(null);
        }catch(MyCustomException e){
            System.out.println("Custom Exception Occured :"+e.getMessage());
        }
    }

    public static void validate(String str) throws MyCustomException{
        if(str==null){
            throw  new MyCustomException("String is Null");
        }
    }
}
