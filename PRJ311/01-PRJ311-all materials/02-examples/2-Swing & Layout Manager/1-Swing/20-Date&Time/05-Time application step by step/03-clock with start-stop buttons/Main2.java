import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
class TimeDemo extends JFrame
 {Timer t1, t2;JLabel lbl1,lbl2; JButton btn1,btn2;
  TimeDemo()
   {initComponents();
    t1 = new Timer(1000,
     new ActionListener()
      {public void actionPerformed(ActionEvent e)
         {t1ActionPerformed(e);
         }
      }
     );
     
   }
  void initComponents()
   {Container con = getContentPane();
    con.setLayout(new FlowLayout());
    lbl1 = new JLabel("ABC1");
    lbl2 = new JLabel("ABC2");
    btn1 = new JButton("ABC1");
    btn2 = new JButton("ABC2");
    btn1.addActionListener(new ActionListener() 
      {public void actionPerformed(ActionEvent e)
        {btn1ActionPerformed(e);
        }
      }
     );
    btn2.addActionListener(new ActionListener() 
      {public void actionPerformed(ActionEvent e)
        {btn2ActionPerformed(e);
        }
      }
     );
    con.add(lbl1);
    con.add(lbl2);
    con.add(btn1);
    con.add(btn2);
    setSize(500, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
  public void btn1ActionPerformed(ActionEvent e)
   {
   }
  public void btn2ActionPerformed(ActionEvent e)
   {
   }
  public void t1ActionPerformed(ActionEvent e)
   {Calendar g = Calendar.getInstance();
    String s = "" + g.getTimeInMillis();
    System.out.println(s);
    lbl1.setText(s);
   }
  public void t2ActionPerformed(ActionEvent e)
   {
   }
 
 }
public class Main
 {public static void main(String[] args)
   {TimeDemo f = new TimeDemo();
    f.setVisible(true);
   }
 }


