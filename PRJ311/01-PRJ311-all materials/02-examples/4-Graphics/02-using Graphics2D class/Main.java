import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
class MyCanvas extends JPanel {
  public void paint(Graphics g) {
    super.paint(g); // (1)
    setBackground(Color.YELLOW); // without (1) no effect
    Graphics2D g2 = (Graphics2D) g;
    Shape shape = new Ellipse2D.Double(10, 10, 20, 50);
    g2.setColor(Color.BLUE);
    g2.fill(shape);
  }
}
public class Main {
 public static void main(String [] args) {
   MyCanvas t = new MyCanvas();

   // create a basic JFrame
   JFrame u = new JFrame("JPanel Example");
   u.setSize(300,250);
   u.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
   // add the JPanel to main frame
   u.add(t); /* The same as the statement below */
   //u.setContentPane(t);
   u.setVisible(true);

   System.out.println();  
  }
}
