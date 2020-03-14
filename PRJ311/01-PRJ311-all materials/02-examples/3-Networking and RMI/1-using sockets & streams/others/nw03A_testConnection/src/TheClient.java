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
   }
  
 }

