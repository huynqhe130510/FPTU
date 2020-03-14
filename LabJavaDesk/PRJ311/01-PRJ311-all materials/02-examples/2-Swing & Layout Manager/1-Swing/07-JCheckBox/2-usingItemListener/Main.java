import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Hobby extends JPanel implements ActionListener,ItemListener
  {

    JCheckBox chk1 = new JCheckBox("Reading",false);
    JCheckBox chk2 = new JCheckBox("Music",false);
    JCheckBox chk3 = new JCheckBox("Painting",false);

    JLabel lblHobby = new JLabel("What's your hobby?");
    JButton btnExit = new JButton("Exit");
    
    public Hobby()
      {
        setLayout(new GridLayout(5,1));

        chk1.setFont(new Font("Helvetica",Font.BOLD|Font.ITALIC,14));
        chk2.setFont(new Font("Helvetica",Font.BOLD|Font.ITALIC,14));
        chk3.setFont(new Font("Helvetica",Font.BOLD|Font.ITALIC,14));
   
        chk1.addItemListener(this);
        chk2.addItemListener(this);
        chk3.addItemListener(this);
        btnExit.addActionListener(this);
	   
        add(lblHobby);

        add(chk1);
        add(chk2);
        add(chk3);
        add(btnExit);
	   	
      }
	
    public void actionPerformed(ActionEvent e)
      {
        if(e.getSource().equals(btnExit))
           {
	System.exit(0);
           }
      }
	
    public void itemStateChanged(ItemEvent e)
       {
         String strSelectedItem = ((JCheckBox)e.getSource()).getText();
         System.out.println(strSelectedItem);
       }
  }


class HobbyTest extends JFrame
  {
    HobbyTest(String s)
       {
         super(s);
         getContentPane().add(new Hobby());
         pack();
         setVisible(true);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       }
  }

public class Main
  {
    public static void main(String[] args)
        {
          new HobbyTest("Hobbies");
        }
  }
