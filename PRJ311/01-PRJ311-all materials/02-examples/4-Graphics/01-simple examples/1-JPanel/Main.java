import java.awt.*;
import javax.swing.*;
class MyCanvas extends JPanel {

    public void paint(Graphics g) {
        super.paint(g); // (1)
        setBackground(Color.YELLOW); // without (1) no effect
        //g.drawOval(int x, int y, int width, int height)
        g.setColor(Color.RED);
        g.drawOval(20, 20, 25, 50);
        g.setColor(Color.BLUE);
        g.fillOval(20, 20, 25, 50);
   }
}
public class Main {
 public static void main(String [] args) {
   MyCanvas t = new MyCanvas();

   // create a basic JFrame
   JFrame frame = new JFrame("JPanel Example");
   frame.setSize(300,250);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
   // add the JComponent to main frame
   frame.add(t);
 
   frame.setVisible(true);

   System.out.println();  
  }
}
