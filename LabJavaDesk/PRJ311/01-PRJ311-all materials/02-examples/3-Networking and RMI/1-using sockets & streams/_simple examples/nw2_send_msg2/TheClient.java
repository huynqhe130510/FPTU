import java.io.*;
import java.net.*;

public class TheClient { 
 public static void main(String[] args) throws Exception {
   Socket client1;
   ObjectInputStream in;
   String host1 = "localhost";
   client1 = new Socket(host1,4321);
   in = new ObjectInputStream(new DataInputStream(client1.getInputStream()));
   String sFro;
   sFro = (String) in.readObject();
   System.out.println("A string received from the server: " + sFro);
   in.close();client1.close();
  }
 }

