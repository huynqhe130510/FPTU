import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;
class Form1 extends JFrame
 {Timer t;JTextField txtClock1,txtClock2; Calendar now;
  Form1()
   {Container con = getContentPane();
    con.setLayout(new FlowLayout());
    now = Calendar.getInstance();
    String s;
    s = myGetCurrTime();
    txtClock1 = new JTextField(20);
    txtClock1.setText(s);

    txtClock1.setFont(new Font("Arial",Font.BOLD,24));
    txtClock1.setEditable(false);

    s = myGetCurrTimeHMS();
    txtClock2 = new JTextField(10);
    txtClock2.setText(s);

    txtClock2.setFont(new Font("Arial",Font.BOLD,24));
    txtClock2.setEditable(false);

    t = new Timer(100,new ActionListener()
      {public void actionPerformed(ActionEvent e)
        {String s1 = myGetCurrTime();
         String s2 = myGetCurrTimeHMS();
         txtClock1.setText(s1);
         txtClock2.setText(s2);
        }
      }
    );
    t.start();


    con.add(txtClock1);
    con.add(txtClock2);

    setVisible(true);
    setSize(500,400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   } 
  String myGetCurrTime()
   {now = Calendar.getInstance();
    String s = "" + now.getTime();
    return(s);
   } 
  String myGetCurrTimeHMS()
   {now = Calendar.getInstance();
    int ho = now.get(Calendar.HOUR_OF_DAY);
    int mi = now.get(Calendar.MINUTE);
    int se = now.get(Calendar.SECOND);
    String s = "" + ho +" : " + mi + " : " + se;
    return(s);
   } 
 }
public class Main
 {public static void main(String args[])
   {Form1 f = new Form1();
    System.out.println();
   }
 }
