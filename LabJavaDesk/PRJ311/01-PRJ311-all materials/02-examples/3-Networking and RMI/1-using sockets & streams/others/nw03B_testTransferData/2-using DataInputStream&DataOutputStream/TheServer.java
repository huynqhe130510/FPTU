import java.io.*;
import java.net.*;

class ChatServer
 {ServerSocket server;Socket client;
   DataInputStream in;
   DataOutputStream ou;
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
       ou = new DataOutputStream(client.getOutputStream());
       in = new DataInputStream(client.getInputStream());
      } 
      catch (IOException e) 
       {System.out.println("Did not accept connection: " + e);
        System.exit(1);
       }
   }

  void sendToClient(String s)
   {
      try 
      { ou.writeBytes(s + "\n");
      } 
     catch (IOException e) 
       {System.err.println("I/O error with client");
       }
   }
  String receiveFromClient()
   {String s = null;
     try
      {s = in.readLine();
      }
      catch(IOException e)
       {System.out.println("IO Error in streams " + e); }
     return(s);
    }

  void sendReceiveWithClient() throws Exception
   {String sTo, sFro;
     while(true)
      {sFro = receiveFromClient();
        if (sFro.equalsIgnoreCase(".bye")) break;
        System.out.println("A string received from the client: " + sFro);

        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\n Enter a string to be sent to the client s = ");
        sTo = bu.readLine();
        sendToClient(sTo);
      }
     
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
   }
 }

