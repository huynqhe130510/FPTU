import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;
class Form1 extends JFrame
 {Timer t;JTextField txtClock; Calendar ca;
  Form1()
   {Container con = getContentPane();
    con.setLayout(new FlowLayout());
    ca = Calendar.getInstance();
    String s = myGetCurrTime();
    txtClock = new JTextField(20);
    txtClock.setText(s);

    txtClock.setFont(new Font("Arial",Font.BOLD,24));
    txtClock.setEditable(false);
    t = new Timer(100,new ActionListener()
      {public void actionPerformed(ActionEvent e)
        {String s = myGetCurrTime();
         txtClock.setText(s);
        }
      }
    );
    t.start();
    con.add(txtClock);

    setVisible(true);
    setSize(500,100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   } 
  String myGetCurrTime()
   {ca = Calendar.getInstance();
    String s = "" + ca.getTime();
    return(s);
   } 
 }
public class Main
 {public static void main(String args[])
   {Form1 f = new Form1();
    System.out.println();
   }
 }
