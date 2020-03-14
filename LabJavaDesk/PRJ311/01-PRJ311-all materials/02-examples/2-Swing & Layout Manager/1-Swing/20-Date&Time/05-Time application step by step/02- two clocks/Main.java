import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
class TimeDemo extends JFrame
 {Timer t1,t2;JLabel lbl1,lbl2;
  TimeDemo()
    {initComponents();
     t1 = new Timer(1000,
      new ActionListener()
       {public void actionPerformed(ActionEvent e)
          {t1ActionPerformed(e);
          }
       }
      );
     t1.start();
     t2 = new Timer(1000,
      new ActionListener()
       {public void actionPerformed(ActionEvent e)
          {t2ActionPerformed(e);
          }
       }
      );
     t2.start();
     
    }
  void initComponents()
    {Container con = getContentPane();
     con.setLayout(new FlowLayout());
     lbl1 = new JLabel();
     lbl1.setFont(new Font("Tahoma",Font.BOLD,30));
     lbl2 = new JLabel();
     lbl2.setFont(new Font("Tahoma",Font.BOLD,20));
     con.add(lbl1);
     con.add(lbl2);
     setSize(200, 150);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
  String getCurrTime()
    {Calendar now = Calendar.getInstance();
     int h = now.get(Calendar.HOUR_OF_DAY);
     int m = now.get(Calendar.MINUTE);
     int s = now.get(Calendar.SECOND);
     return("" + h + ":" + m + ":" + s);
    }
  public void t1ActionPerformed(ActionEvent e)
    {String s = getCurrTime();
     lbl1.setText(s);
    }
  public void t2ActionPerformed(ActionEvent e)
    {String s = getCurrTime();
     lbl2.setText(s);
    }

 
 }
public class Main
 {public static void main(String[] args)
   {TimeDemo f = new TimeDemo();
    f.setVisible(true);
   }
 }


