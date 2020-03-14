import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class PasswordFieldDemo extends JFrame implements ActionListener
  { JPasswordField txt1;
    public PasswordFieldDemo()
        { super("Sample JPasswordField");
          Container con = getContentPane();
          txt1 = new JPasswordField(12);
          txt1.setEchoChar('*');

          // Set the command string that will be used for handling events on the password field
          txt1.setActionCommand("Password");
          txt1.addActionListener(this);

          JLabel lbl1=new JLabel("Nhap mat khau: ");
          lbl1.setLabelFor(txt1);

          JPanel p1 = new JPanel(new FlowLayout(FlowLayout.TRAILING));

          // Add the label and textbox to the panel p1
          p1.add(lbl1);
          p1.add(txt1);

          JPanel p2 = new JPanel(new GridLayout(0,1));
          JButton btnOk = new JButton("Ok");
          JButton btnCancel = new JButton("Cancel");

          // Set the command string that will be used for handling events on the Ok and Cancel button
          btnOk.setActionCommand("Ok");
          btnOk.addActionListener(this);
          btnCancel.setActionCommand("Cancel");
          btnCancel.addActionListener(this);

          // Add the label and textbox to the panel p1
          p2.add(btnOk);
          p2.add(btnCancel);


          con.add(p1, BorderLayout.WEST);
          con.add(p2, BorderLayout.CENTER);
          pack();
          setVisible(true);
          //setSize(400,200);
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

