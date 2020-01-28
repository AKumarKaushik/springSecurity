package java2_Assgnmnt;

public class Q3_ProduceException {
    public static void main() {
        try{
            Class.forName("Resolve");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}


