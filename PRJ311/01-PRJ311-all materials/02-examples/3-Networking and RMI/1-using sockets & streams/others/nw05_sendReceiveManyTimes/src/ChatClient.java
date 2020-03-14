import java.io.*;
import java.net.*;

public class ChatClient
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


  void sendToServer(String s)
   {
      try 
      { ou.writeObject(s);
      } 
     catch (Exception e) 
       {e.printStackTrace();
       }
   }

  String receiveFromServer()
   {String s = null;
     try
      {s = (String) in.readObject();
      }
      catch(Exception e)
       {e.printStackTrace(); }
     return(s);
    }
  void sendReceiveWithServer()  throws Exception
   {String sTo, sFro;
     while(true)
      {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\n Enter a string to be sent to the server (type .bye to finish):  ");
        sTo = bu.readLine();
        sendToServer(sTo);

        if (sTo.equalsIgnoreCase(".bye")) break;

        sFro = receiveFromServer();
        System.out.println("A string received from the server: " + sFro);

        if(sFro.equalsIgnoreCase(".bye")) break;

       }
     
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
