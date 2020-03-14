// Use an inner-class as the event-handler
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ButtonDemo extends JPanel
  { JButton btn1, btn2;
    String message="";

    class MyActionListener implements ActionListener
         {
             public void actionPerformed(ActionEvent e)
                  { if (e.getSource()==btn1)
                       message="You like flower";
                       else  if (e.getSource()==btn2)
                        message="You like coffee";
                     repaint(); 
                  }
         }
    MyActionListener t = new MyActionListener(); 

    public ButtonDemo()
        { btn1 = new JButton("Flower");
          btn2 = new JButton("Coffee");
          //Register the buttons with the ActionListener interface
          btn1.addActionListener(t);
          btn2.addActionListener(t);
          //add the two buttons to panel
          add(btn1);
          add(btn2);
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
