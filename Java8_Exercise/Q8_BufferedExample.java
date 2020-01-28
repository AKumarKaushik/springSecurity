/*Q (8) Read and Write data using buffered input and ouput stream.*/
package java5_Assgnmnt;

import java.io.*;

public class Q8_BufferedExample {
    public static void main(String[] args) {
        String path = "/home/akash/desktop/bufferedtest.txt";
        try{
            FileOutputStream fout = new FileOutputStream(path);
            BufferedOutputStream bout = new BufferedOutputStream(fout);
            String s = "Testing Buffered Stream";
            byte b[] = s.getBytes();
            bout.write(b);
            bout.flush();
            bout.close();
            fout.close();
            System.out.println(" Success ");
        }catch(IOException e){
            System.out.println(e);
        }
        try{
            FileInputStream fin = new FileInputStream(path);
            BufferedInputStream bin = new BufferedInputStream(fin);
            int i;
            while((i=bin.read())!=-1){
                System.out.println((char)i);
            }
            fin.close();
            bin.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
