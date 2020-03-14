import java.net.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
     Socket socket1;String host1 = "localhost";
     ObjectInputStream in;
     socket1=null;in=null;
      try {
        socket1 = new Socket(host1,4321);  
      }
      catch(IOException e) {
      }
      try {
        in = new ObjectInputStream(new DataInputStream(socket1.getInputStream()));
      }
      catch(IOException e) {
      }
      String s=null;
      if(in!=null)
       while(true) {   
         try {
           s = (String) in.readObject();
           System.out.println("The message received from the server: " + s);
         }
        catch(Exception e) {
       }
       if(s!=null) break;  
      }   
    }
    
}
