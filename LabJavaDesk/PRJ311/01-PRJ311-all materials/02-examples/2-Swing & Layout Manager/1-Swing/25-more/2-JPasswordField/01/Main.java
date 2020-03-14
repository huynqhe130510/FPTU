import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class PasswordFieldDemo extends JFrame implements ActionListener
  { JPasswordField txt1;
    public PasswordFieldDemo()
        { super("Sample JPasswordField");
          Container con1 = getContentPane();
          txt1 = new JPasswordField(12);
          txt1.setEchoChar('*');

          JLabel lbl1=new JLabel("Nhap mat khau: ");
          lbl1.setLabelFor(txt1);

          JPanel p = new JPanel(new FlowLayout(FlowLayout.TRAILING));

          // Add the label and textbox to the panel
          p.add(lbl1);
          p.add(txt1);

          con1.add(p);
          pack();
          setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    public void actionPerformed(ActionEvent e)
        { 
        }

  } 
public class Main
  {
    public static void main(String[] args)
        {
          new PasswordFieldDemo();
        }
  }

