import java.awt.*;
import javax.swing.*;
class MyPanel extends JPanel
 {
  public void paintComponent(Graphics g)
    {g.drawLine(0,350,900,350); // x-axis
      g.drawLine(450,0,450,900); // y-axis
      g.setColor(Color.red);
      double x, y; int X, Y;
      for(x=-450;x<=450;x=x+0.5)
        {y = 50 * Math.sin(x*(3.1415926/180));
          X = (int) x;
          Y = (int) y;
          g.drawLine(450+X,350-Y,450+X,350-Y);
        }
    }
 }
public class Main
 {public static void main(String [] args)
   {JFrame t = new JFrame();
    MyPanel pan = new MyPanel();
    t.setTitle("Test grapchics");
    t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    t.add(pan);
    t.setSize(900,700);
    t.setVisible(true);

    System.out.println();  
   }
 }
