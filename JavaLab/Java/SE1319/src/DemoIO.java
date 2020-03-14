
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DemoIO {

    public static void main(String[] args) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream("DemoFileOutPutStream.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            for (int i = 0; i < 10; i++) {
                bos.write(i+48);
            }
            bos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File khong tim thay");
        }
        catch (IOException ex){
            System.out.println("IO co van de");
        }
        
    }
}
