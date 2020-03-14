/*
 Write a program, HobbyTest. There should be another class called Hobby, which will implement the controls and the listener interfaces.
 The labels of the check boxes should be displayed in a Helvetica font with style as bold and italic.
  When the user clicks on the Exit button, the application should close. Also, display the label of selected checkbox in command prompt.
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Hobby extends JPanel implements ActionListener,ItemListener
  {

    JCheckBox chkReading = new JCheckBox("Reading",false);
    JCheckBox chkMusic = new JCheckBox("Music",false);
    JCheckBox chkPainting = new JCheckBox("Painting",false);
    JCheckBox chkMovies = new JCheckBox("Movies",false);
    JCheckBox chkDancing = new JCheckBox("Dancing",false);

    JLabel lblHobby = new JLabel("What's your hobby?");
    JButton btnExit = new JButton("Exit");
    
    public Hobby()
      {
        setLayout(new GridLayout(7,1));

        chkReading.setFont(new Font("Helvetica",Font.BOLD|Font.ITALIC,14));
        chkMusic.setFont(new Font("Helvetica",Font.BOLD|Font.ITALIC,14));
        chkPainting.setFont(new Font("Helvetica",Font.BOLD|Font.ITALIC,14));
        chkMovies.setFont(new Font("Helvetica",Font.BOLD|Font.ITALIC,14));
        chkDancing.setFont(new Font("Helvetica",Font.BOLD|Font.ITALIC,14));
	   
        chkReading.addItemListener(this);
        chkMusic.addItemListener(this);
        chkPainting.addItemListener(this);
        chkMovies.addItemListener(this);
        chkDancing.addItemListener(this);
	   
        add(lblHobby);

        add(chkReading);
        add(chkMusic);
        add(chkPainting);
        add(chkMovies);
        add(chkDancing);
        add(btnExit);
	   	
        btnExit.addActionListener(this);
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
       }
  }

public class Main
  {
    public static void main(String[] args)
        {
          new HobbyTest("Hobbies");
        }
  }
