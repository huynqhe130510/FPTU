import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Hobby extends JPanel implements ActionListener,ItemListener
  {

    JRadioButton rad1 = new JRadioButton("Reading",false);
    JRadioButton rad2 = new JRadioButton("Music",false);
    JRadioButton rad3 = new JRadioButton("Painting",false);

    JLabel lblHobby = new JLabel("What's your most prefer hobby?");
    JButton btnExit = new JButton("Exit");
    
    public Hobby()
      {
        setLayout(new GridLayout(5,1));

        rad1.setFont(new Font("Helvetica",Font.BOLD|Font.ITALIC,14));
        rad2.setFont(new Font("Helvetica",Font.BOLD|Font.ITALIC,14));
        rad3.setFont(new Font("Helvetica",Font.BOLD|Font.ITALIC,14));
   
        rad1.addItemListener(this);
        rad2.addItemListener(this);
        rad3.addItemListener(this);
        btnExit.addActionListener(this);
	   
        add(lblHobby);

        add(rad1);
        add(rad2);
        add(rad3);

        ButtonGroup g = new ButtonGroup();
        g.add(rad1);
        g.add(rad2);
        g.add(rad3);
        
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
         String strSelectedItem = ((JRadioButton)e.getSource()).getText();
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
       }
  }

public class Main
  {
    public static void main(String[] args)
        {
          new HobbyTest("Hobbies");
        }
  }
