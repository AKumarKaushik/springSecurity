package java2_Assgnmnt;
import java.io.*;
public class Q5_ObjectCloning implements Cloneable {

    int id;
    String name;

    Q5_ObjectCloning(int i, String s)
    {
        this.id=i;
        this.name=s;
    }
    Q5_ObjectCloning(Q5_ObjectCloning cc)
    {
        id=cc.id;
        name=cc.name;
    }

    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }

    public static void main(String args[])
    {
        try {

            Q5_ObjectCloning obj1 = new Q5_ObjectCloning(3027, "Akash");
            Q5_ObjectCloning obj2 = (Q5_ObjectCloning) obj1.clone();
            System.out.println("Id is: "+obj1.id +" Name is: "+obj1.name);
            System.out.println("Id is: "+obj2.id +" Name is: "+obj2.name+" for cloned object ");

            Q5_ObjectCloning obj3=new Q5_ObjectCloning(obj1);
            System.out.println("Id is: "+obj3.id +" Name is: "+obj3.name+" for copy constructor ");


        }
        catch (CloneNotSupportedException ex)
        {
            System.out.println("Exception arises");
        }
    }





}