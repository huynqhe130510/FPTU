import java.net.*;
import java.io.*;
import java.util.Calendar;

public class MyServer {
    public static void main(String[] args) {
ObjectOutputStream ou;
ObjectInputStream in;
ou = null;
in = null;

    ServerSocket xServer; Socket xSocket; int xPort;
    xServer = null; xSocket = null;
    xPort = 4321;
    try {
      xServer = new ServerSocket(xPort);
     }
      catch(IOException e) {System.exit(1);}
      //System.out.println("The server is waiting for a client at the port " + xPort);
     try {
      xSocket = xServer.accept();
     }
      catch(IOException e) {System.exit(1);}
      //System.out.println("The client has accepted...");

     try {
       DataOutputStream x = new DataOutputStream(xSocket.getOutputStream());
       DataInputStream y = new DataInputStream(xSocket.getInputStream());
       ou = new ObjectOutputStream(x);
       in = new ObjectInputStream(y);
   
     }
     catch(Exception e) {System.exit(0);}
     String xInString, xOutString;

       try
        {
          while(true)
           {xInString = (String) in.readObject();
            xInString = xInString.trim();
            if(xInString.indexOf("time")==-1 && xInString.indexOf("date")==-1)
              {xOutString = "I do not understand your question";
               ou.writeObject(xOutString);
               continue;   
              }   
            if(xInString.contains("time"))
              {Calendar t = Calendar.getInstance();
               xOutString = "The time at server is " + t.getTime();
               ou.writeObject(xOutString);
               continue;   
              }   
           }

        }catch(Exception e) {}
        
        
        
        // TODO code application logic here
    }
    
}
