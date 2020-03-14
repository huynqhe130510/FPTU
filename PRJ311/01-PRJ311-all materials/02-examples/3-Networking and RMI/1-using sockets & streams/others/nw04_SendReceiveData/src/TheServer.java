import java.net.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class TheServer
 {public static void main(String[] args)
   {ServerSocket xServer; Socket xSocket; int xPort;
    xServer = null; xSocket = null;
    xPort = 4321;
    try {
      xServer = new ServerSocket(xPort);
     }
      catch(IOException e) {System.exit(1);}
      System.out.println("The server is waiting for a client at the port " + xPort);
     try {
      xSocket = xServer.accept();
     }
      catch(IOException e) {System.exit(1);}
    System.out.println("The client has accepted...");

    //======= Making a message to be sent to the client===== 
     String xMess = "Hello client.\n";

     SimpleDateFormat  df = new SimpleDateFormat("dd-MM-yyyy");
     String xDate = df.format(new Date());

     xMess += "The date at the server now is ";
     xMess += xDate + "\n";


//try {Thread.sleep(1000); } catch(InterruptedException e) {}
    //======================================================

     System.out.println("Sending message to the client...");
     try {
       OutputStream o = xSocket.getOutputStream();
       DataOutputStream ou = new DataOutputStream(o);
       ObjectOutputStream out = new ObjectOutputStream(ou);
       out.writeObject(xMess);
       out.close();
       xSocket.close();
       xServer.close();
     }
     catch(IOException e) {System.exit(0);}
    
     System.out.println("Sending finished...");
     

   }
  
 }

