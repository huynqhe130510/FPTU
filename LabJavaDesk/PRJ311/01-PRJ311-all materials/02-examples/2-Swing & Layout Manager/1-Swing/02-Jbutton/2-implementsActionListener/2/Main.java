// Handle events by implementing the actionPerformed() method of the ActionListener  interface
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ButtonDemo extends JPanel implements ActionListener
  { JButton btn1, btn2;
    String message="";
    public ButtonDemo()
        { btn1 = new JButton("Flower");
          btn2 = new JButton("Coffee");
          //Register the buttons with the ActionListener interface
          btn1.addActionListener(this);
          btn2.addActionListener(this);
          //add the two buttons to panel
          add(btn1);
          add(btn2);
        }
    public void actionPerformed(ActionEvent e)
        { if (e.getSource()==btn1)
             message="You like flower";
             else  if (e.getSource()==btn2)
             message="You like coffee";
          repaint(); 
        }
    public void paintComponent(Graphics g)
        { super.paintComponent(g);
           g.drawString(message,50,70);
        } 
  } 
public class Main
  {
    public static void main(String[] args)
        {
          JFrame f = new JFrame("Button test!");
          f.getContentPane().add(new ButtonDemo());
          f.setSize(200,150);
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          f.setVisible(true);
        }
  }
