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
          btnOk.setActionCommand("isOk");
          btnOk.addActionListener(this);
          btnCancel.setActionCommand("isCancel");
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
        { String s = e.getActionCommand();
          if(s.equals("isOk"))
             { char a[] = txt1.getPassword();
               String txt2 = new String(a);
               if(txt2.trim().equals("123"))
                  { JOptionPane.showMessageDialog(this,"Entered password is correct");
                  }
                  else
                  { JOptionPane.showMessageDialog(this,"Incorrect password has been entered", "Thong bao loi!", JOptionPane.ERROR_MESSAGE);
                  }
             }
          if(s.equals("isCancel"))
             { System.exit(0);
             }

        }

  } 
public class Main
  {
    public static void main(String[] args)
        {
          new PasswordFieldDemo();
        }
  }

