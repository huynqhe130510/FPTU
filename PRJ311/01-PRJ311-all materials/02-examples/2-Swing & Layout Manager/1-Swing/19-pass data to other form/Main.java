import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Form1 extends JFrame
 {JLabel lbl1; JButton btn1;
  Form1()
   {initComponents();
   }
  void initComponents()
   {Container c = getContentPane();
    c.setLayout(new FlowLayout());
    lbl1 = new JLabel("ABC1");
    btn1 = new JButton("activate form2");
    btn1.addActionListener(
    new ActionListener()
      {public void actionPerformed(ActionEvent e)
        {btn1ActionPerformed(e);
        }
      }
     );
    add(lbl1);
    add(btn1);
    setSize(500,300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
  void btn1ActionPerformed(ActionEvent e)
   { new Form2(this).setVisible(true);
   }
 }

class Form2 extends JFrame
 {Form1 f1; JButton btn2;
  Form2(Form1 f1)
   {this.f1 = f1;
    initComponents();
   }
  void initComponents()
   {Container c = getContentPane();
    c.setLayout(new FlowLayout());
    btn2 = new JButton("set label in form1");
    btn2.addActionListener(
    new ActionListener()
      {public void actionPerformed(ActionEvent e)
        {btn2ActionPerformed(e);
        }
      }
     );
    add(btn2);
    setSize(300,200);
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
   }
  void btn2ActionPerformed(ActionEvent e)
   { f1.lbl1.setText("XYZ");
   }
 }

public class Main
 {public static void main(String[] args)
   {Form1 f = new Form1();
    f.setVisible(true);
   }
}