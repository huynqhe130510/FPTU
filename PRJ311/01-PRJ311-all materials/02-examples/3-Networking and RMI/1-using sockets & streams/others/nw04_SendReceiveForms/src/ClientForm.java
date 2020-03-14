import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ClientForm extends JFrame
 {String host;Socket client;DataOutputStream ou;
  JTextArea txtArea1;
  ClientForm()
   {makeConnectToServer();
    initComponents();
   }
  void initComponents()
   {Container con = getContentPane();
    con.setLayout(new FlowLayout());
    txtArea1 = new JTextArea(5,10);
    con.add(new JScrollPane(txtArea1));
    JButton btn1 = new JButton("Send");
      btn1.addActionListener(
       new ActionListener()
         {public void actionPerformed(ActionEvent ev)
           {btn1ActionPerformed(ev);
           }
         }
       );
    con.add(btn1);
    setSize(180,200);
    setTitle("The client");
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
  public void btn1ActionPerformed(ActionEvent ev)
   {try 
     {String s = txtArea1.getText().trim();
      ou.writeBytes(s + "\n");
      txtArea1.setText("");
     } 
     catch (IOException e) 
       {System.err.println("I/O error with " + host);
       }
   }
  void makeConnectToServer()
   {host = "localhost";
    try 
      {client = new Socket(host, 4321);
       ou = new DataOutputStream(client.getOutputStream());
      } 
      catch(UnknownHostException e) 
       {System.err.println(host + ": unknown host.");
       } 
      catch (IOException e) 
       {System.err.println("I/O error with " + host);
       }
    }
  public void finalize()
    {try
       {ou.close(); client.close();
       }
       catch (IOException e) 
        {System.err.println("I/O error with " + host);
        }
    }
 }
