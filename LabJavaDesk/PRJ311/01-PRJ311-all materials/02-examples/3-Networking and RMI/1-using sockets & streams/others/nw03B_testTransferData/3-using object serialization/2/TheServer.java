import java.io.*;
import java.net.*;

class ChatServer
 {ServerSocket server;Socket client;
   ObjectInputStream in;
   ObjectOutputStream ou;
   ChatServer()
     {makeConnectToClient();
     }
  void makeConnectToClient()
    {server = null;
      try 
        {server = new ServerSocket(4321);
        } 
        catch(IOException e) 
          {System.out.println("Error on port: 4321 " + ", " + e);
            System.exit(1);
          }
      System.out.println("Server already setup and waiting for client connection ...");

      client = null;
      try 
      {client = server.accept();
       ou = new ObjectOutputStream(new DataOutputStream(client.getOutputStream()));
       in = new ObjectInputStream(new DataInputStream(client.getInputStream()));
      } 
      catch (IOException e) 
       {System.out.println("Did not accept connection: " + e);
        System.exit(1);
       }
   }

  void sendToClient(Object ob)
   {
      try 
      { ou.writeObject(ob);
      } 
     catch (IOException e) 
       {System.err.println("I/O error with client");
       }
   }
  Object receiveFromClient()
   {Object ob = null;
     try
      {ob = in.readObject();
      }
      catch(Exception e)
       {e.printStackTrace();}
     return(ob);
    }

  void sendReceiveWithClient() throws Exception
   {Emp obTo, obFro;
    obFro = (Emp) receiveFromClient();
    System.out.println("Data received from the client: " + obFro);

    obTo = new Emp("Server", 800, 100);
    System.out.print("\nData to be sent to the client: " + obTo);
    sendToClient(obTo);
     
   }
  public void finalize()
    {try
       {in.close(); client.close(); server.close();
       }
      catch(IOException e)
       {System.out.println("IO Error in streams " + e);
       }
    }

 }

public class TheServer 
 {public static void main(String[] args) throws Exception
   {ChatServer t = new ChatServer();
     try {t.sendReceiveWithClient(); } catch(Exception e) {}
    System.out.println();
   }
 }

