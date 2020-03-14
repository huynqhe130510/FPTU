import java.io.*;
import java.net.*;

class ChatClient
 {String host;Socket client;
   ObjectInputStream in;
   ObjectOutputStream ou;
   ChatClient()
     {makeConnectToServer();
     }
  void makeConnectToServer()
   {host = "localhost";
    try 
      {client = new Socket(host, 4321);
       ou = new ObjectOutputStream(new DataOutputStream(client.getOutputStream()));
       in = new ObjectInputStream(new DataInputStream(client.getInputStream()));
      } 
      catch(UnknownHostException e) 
       {System.err.println(host + ": unknown host.");
       } 
      catch (IOException e) 
       {System.err.println("I/O error with " + host);
       }
    }


  void sendToServer(Object ob)
   {
      try 
      { ou.writeObject(ob);
      } 
     catch (Exception e) 
       {e.printStackTrace();
       }
   }

  Object receiveFromServer()
   {Object ob = null;
     try
      {ob = in.readObject();
      }
      catch(Exception e)
       {e.printStackTrace(); }
     return(ob);
    }
  void sendReceiveWithServer()  throws Exception
   {Emp obTo, obFro;
    obTo = new Emp("Client",500,100);
    System.out.println("\nData to be sent to the server: " + obTo);
    sendToServer(obTo);
    obFro = (Emp) receiveFromServer();
    System.out.println("Data received from the server: " + obFro);
   
   }

  public void finalize()
    {try
       {ou.close(); in.close(); client.close();
       }
      catch(IOException e)
       {System.out.println("IO Error in streams " + e);
       }
    }
 }

public class TheClient 
 {public static void main(String[] args) throws Exception
   {ChatClient t = new ChatClient();
     try {t.sendReceiveWithServer(); } catch(Exception e) {}
    System.out.println();

   }
 }

