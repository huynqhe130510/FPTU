import java.io.*;
import java.util.*;
import java.net.*;

public class TheServer { 
 public static void main(String[] args) throws Exception {
   ServerSocket server1;Socket service1;
   ObjectOutputStream ou;
   Scanner t = new Scanner(System.in);
   server1 = new ServerSocket(4321);
   service1 = server1.accept();
   ou = new ObjectOutputStream(new DataOutputStream(service1.getOutputStream()));
   String sTo;
   System.out.print("\n Enter a string to be sent to the client s = ");
   sTo = t.nextLine();
   ou.writeObject(sTo);
   ou.close(); service1.close(); server1.close();
  }
 }

