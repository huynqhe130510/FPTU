import java.net.*;
import java.io.*;

public class TestInetAddress {
   public static void main(String [] args) {
    try{  
      InetAddress ip=InetAddress.getByName("www.fpt.vn");   
  
      System.out.println("\nHost Name: "+ip.getHostName());  
      System.out.println("IP Address: "+ip.getHostAddress());  
      }
      catch(UnknownHostException e) {
        e.printStackTrace();
      }  
    System.out.println();
   }
}

