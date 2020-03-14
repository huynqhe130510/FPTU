import java.io.*;
import java.util.*;
import java.net.*;

public class TheServer { 
 public static void main(String[] args) throws Exception {
   ServerSocket server1;Socket service1;
   ObjectInputStream in;
   ObjectOutputStream ou;
   Scanner t = new Scanner(System.in);
   server1 = new ServerSocket(4321);
   service1 = server1.accept();
   ou = new ObjectOutputStream(new DataOutputStream(service1.getOutputStream()));
   in = new ObjectInputStream(new DataInputStream(service1.getInputStream()));
   String sTo, sFro;
   while(true) {
     sFro = (String) in.readObject();
     if(sFro.equalsIgnoreCase(".bye")) break;
     System.out.println("A string received from the client: " + sFro);

     System.out.print("\n Enter a string to be sent to the client s = ");
     sTo = t.nextLine();
     ou.writeObject(sTo);
     if(sTo.equalsIgnoreCase(".bye")) break;
    }
   in.close(); ou.close(); service1.close(); server1.close();
  }
 }

