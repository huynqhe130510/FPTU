import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
class TimeDemo extends JFrame
 {javax.swing.Timer t1;JLabel lbl1;
  TimeDemo()
    {initComponents();
     t1 = new javax.swing.Timer(1000,
      new ActionListener()
       {public void actionPerformed(ActionEvent e)
          {t1ActionPerformed(e);
          }
       }
      );
     t1.start();
     
    }
  void initComponents()
    {Container con = getContentPane();
     con.setLayout(new FlowLayout());
     lbl1 = new JLabel();
     lbl1.setFont(new Font("Tahoma",Font.BOLD,30));
     con.add(lbl1);
     setSize(200, 100);
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
 
 }
public class Main
 {public static void main(String[] args)
   {TimeDemo f = new TimeDemo();
    f.setVisible(true);
   }
 }


