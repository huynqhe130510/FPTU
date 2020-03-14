import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ServerForm extends JFrame
 {ServerSocket server;Socket client;DataInputStream in;
  String s = "";
  JTextArea txtArea1;
  ServerForm()
   {initComponents();
    makeConnectToClient();
    Thread u = new Thread()
     {public void run()
       {receiveDataFromClient();
       } 
     };
    u.start();
   }
  void initComponents()
   {Container con = getContentPane();
    con.setLayout(new FlowLayout());
    txtArea1 = new JTextArea(5,10);
    txtArea1.setEditable(false);
    con.add(new JScrollPane(txtArea1));
    JButton btn1 = new JButton("Refresh");
      btn1.addActionListener(
       new ActionListener()
         {public void actionPerformed(ActionEvent ev)
           {s="";
            txtArea1.setText(s);
           }
         }
       );
    con.add(btn1);
    setSize(200,200);
    setTitle("The Server");
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
       in = new DataInputStream(new BufferedInputStream(client.getInputStream()));
      } 
      catch (IOException e) 
       {System.out.println("Did not accept connection: " + e);
        System.exit(1);
       }
   }
  void receiveDataFromClient()
   {try
      {boolean done = false;
       String s1;
       while (!done)
         {s1 = in.readLine();
          if (s1.equalsIgnoreCase(".bye"))
           done = true;
            else
             {s += s1 + "\n";
              txtArea1.setText(s);
             }
         }

      }
      catch(IOException e)
       {System.out.println("IO Error in streams " + e); }
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
