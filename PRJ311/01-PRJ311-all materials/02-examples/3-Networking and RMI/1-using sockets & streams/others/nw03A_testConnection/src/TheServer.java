import java.net.*;
import java.io.*;

public class TheServer
 {public static void main(String[] args)
   {ServerSocket xServer; Socket xSocket; int xPort;
    xServer = null; xSocket = null;
    xPort = 4321;
    try {
      xServer = new ServerSocket(xPort);
     }
      catch(IOException e) {System.exit(1);}
      System.out.println("The server is waiting for a client at port " + xPort);
     try {
      xSocket = xServer.accept();
     }
      catch(IOException e) {System.exit(1);}
    System.out.println("The client has accepted...");
       

   }
  
 }

