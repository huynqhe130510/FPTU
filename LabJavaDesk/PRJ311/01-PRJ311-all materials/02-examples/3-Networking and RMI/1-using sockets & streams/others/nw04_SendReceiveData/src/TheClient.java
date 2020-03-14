import java.net.*;
import java.io.*;

public class TheClient
 {public static void main(String[] args)
   {Socket xClient; String xHost; int xPort;
    xClient = null;
    xHost = "localhost";
    xPort = 4321;
    try {
      xClient = new Socket(xHost,xPort);
     }
      catch(IOException e) {System.exit(1);}
    System.out.println("The connection to server is accepted.");
    System.out.println("Receiving message from the server...");

    try {
     InputStream is = xClient.getInputStream();
     DataInputStream din = new DataInputStream(is);
     ObjectInputStream in = new ObjectInputStream(din);
     String xMess = (String) in.readObject();
     System.out.println(xMess);
     in.close();
     xClient.close();
     }
     catch(Exception e) {System.exit(0);}

    System.out.println("Receiving finished...");

   }
  
 }

