import java.awt.*;
import java.net.*;
import java.io.*;

class TheClient
 {Socket xClient; String xHost; int xPort;
  OutputStream xOut; InputStream xIn;

  TheClient() {xClient=null;xHost="localhost";xPort=4321;}
  public void finalize() throws Exception
   {xClient.close();
   }
    
  void makeConnection()
   {try {xClient = new Socket(xHost,xPort);} catch(IOException e) {System.exit(1);}
    System.out.println("Connection to the server is accepted");
   }

  void createDataObject()
   {try {
    xOut = xClient.getOutputStream();
    xIn = xClient.getInputStream();
    } catch(Exception e) {System.exit(1);}
   }

  public void testDataTransfer()
   {int i,n,k,c;
    System.out.println("Receiving message from the server...");
    try {
    while ((c = xIn.read()) != -1)
     {System.out.print((char)c);
     }
    }
    catch(IOException e) {System.exit(0);}

   }

  void test()
   {try {
    makeConnection();
    createDataObject();
    testDataTransfer();
    } catch(Exception e) {System.exit(1);}
   }   
  public static void main(String args[]) throws Exception
   {TheClient g = new TheClient();
    g.test();
   }

 }
