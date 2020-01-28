/*Q(9) Write data using print stream.*/
package java5_Assgnmnt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Q9_UseOfPrintStream {
    public static void main(String[] args) {
        try{
            String path = "/home/akash/desktop/printstream.txt";
            FileOutputStream fout = new FileOutputStream(path);
            PrintStream ps = new PrintStream(fout);
            ps.println(3027);
            ps.println("Akash");
            ps.println("Kaushik");
            fout.close();
            ps.close();
            System.out.println("Success ");
        }catch(IOException exception){
            System.out.println(exception);
        }
    }
}
