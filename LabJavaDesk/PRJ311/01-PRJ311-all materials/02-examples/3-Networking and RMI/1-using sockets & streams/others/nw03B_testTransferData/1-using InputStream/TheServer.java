import java.awt.*;
import java.net.*;
import java.io.*;

class TheServer
 {ServerSocket xServer;Socket xSocket; int xPort;
  OutputStream xOut; InputStream xIn;

  TheServer() {xServer=null;xSocket=null;xPort=4321;}

  public void finalize() throws Exception // It seems that this method does not run auomatically
   {xServer.close(); xSocket.close();
   }
    
  void makeConnection()
   {// Setup our server on socket xPort; //xPort = 4321 
    try {xServer = new ServerSocket(xPort);}catch(IOException e) {System.exit(1); }
    System.out.println("Server already setup and waiting for client connection ...");


    // Wait and listen for a connection
    try {xSocket=xServer.accept();}catch (IOException e) {System.exit(1);}
    System.out.println("Connection to the client is accepted");
   }

  void createDataObject() throws Exception
   {try {
    xOut = xSocket.getOutputStream();
    xIn = xSocket.getInputStream();
    } catch(Exception e) {System.exit(1);}
   }

  public void testDataTransfer()
   {String serverMess = "Hello client.\r\nHow are you?";
    int n,i,c, k; n = serverMess.length();
     System.out.println("Sending message to the client...");

     try {Thread.sleep(1000);
      for(i=0;i<n;i++) xOut.write((int) serverMess.charAt(i));
      }
       catch(Exception e) {System.exit(1);}
    
   }

  void test()
   {try {
     makeConnection();
     createDataObject();
     testDataTransfer();
      } catch(Exception e) {System.exit(1);}
 }   
  public static void main(String args[]) throws Exception
   {TheServer g = new TheServer();
    g.test();
   }

 }
