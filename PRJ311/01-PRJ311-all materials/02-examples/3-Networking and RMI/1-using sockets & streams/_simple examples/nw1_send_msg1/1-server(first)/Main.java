import java.net.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
     ServerSocket server1; Socket service1;
     ObjectOutputStream ou;
     server1=null; service1=null; ou=null;
      try {
        server1 = new ServerSocket(4321);  
      }
      catch(IOException e) {
      }
      try {
        service1 = server1.accept();
      }
      catch(IOException e) {
      }
      try {
        ou = new ObjectOutputStream(new DataOutputStream(service1.getOutputStream()));
      }
      catch(IOException e) {
      }
      try {
       Thread.sleep(1000);
      }
      catch(Exception e) {
       }
      if(ou!=null)
        try {
          ou.writeObject("Hello Client");
        }
      catch(IOException e) {
      }
    }
    
}
