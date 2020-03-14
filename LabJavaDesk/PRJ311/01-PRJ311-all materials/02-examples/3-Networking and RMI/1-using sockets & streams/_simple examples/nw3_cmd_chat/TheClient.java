import java.io.*;
import java.util.*;
import java.net.*;

public class TheClient { 
 public static void main(String[] args) throws Exception {
   Socket client1;
   ObjectInputStream in;
   ObjectOutputStream ou;
   String host1 = "localhost";
   Scanner t = new Scanner(System.in);
   client1 = new Socket(host1,4321);
   ou = new ObjectOutputStream(new DataOutputStream(client1.getOutputStream()));
   in = new ObjectInputStream(new DataInputStream(client1.getInputStream()));
   String sTo, sFro;
   while(true) {
     System.out.print("\n Enter a string to be sent to the server s = ");
     sTo = t.nextLine();
     ou.writeObject(sTo);
     if(sTo.equalsIgnoreCase(".bye")) break;

     sFro = (String) in.readObject();
     if(sFro.equalsIgnoreCase(".bye")) break;
     System.out.println("A string received from the server: " + sFro);

    }
   in.close(); ou.close(); client1.close();
  }
 }

