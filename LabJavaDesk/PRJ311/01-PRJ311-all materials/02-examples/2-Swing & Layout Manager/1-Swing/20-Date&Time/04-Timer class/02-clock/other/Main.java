import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Calendar;
class MyFrame extends JFrame
 {JLabel lblClock;
  MyFrame() {initComponents();}
  void initComponents()
   {Container c = getContentPane();
    lblClock = new JLabel();
    lblClock.setFont(new Font("Tahoma",Font.BOLD, 30));
    c.add(lblClock);
    c.setLayout(new FlowLayout());
    javax.swing.Timer t = new javax.swing.Timer(1000,
      new ActionListener()
            {public void actionPerformed(ActionEvent e)
               {String s = getCurrTime();
                lblClock.setText(s);
               }
              });
    t.start();  // Start the timer
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
  String getCurrTime()
   {Calendar now = Calendar.getInstance();
    int h = now.get(Calendar.HOUR_OF_DAY);
    int m = now.get(Calendar.MINUTE);
    int s = now.get(Calendar.SECOND);
    return("" + h + ":" + m + ":" + s);
   }

 }
class Main 
 {public static void main(String [] args) throws Exception
   {MyFrame f = new MyFrame(); 
    f.setSize(300,100);
    f.setVisible(true);

    System.out.println();
   }
  }