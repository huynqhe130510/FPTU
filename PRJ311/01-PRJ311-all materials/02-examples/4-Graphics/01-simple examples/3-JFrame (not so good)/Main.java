import java.awt.*;
import javax.swing.*;
class MyCanvas extends JFrame {
    MyCanvas() {
      super("JFrame Example");
    }
    public void paint(Graphics g) {
      super.paint(g);
      setBackground(Color.YELLOW); // no effect
      //g.drawOval(int x, int y, int width, int height)
      g.setColor(Color.RED);
      g.drawOval(50, 50, 30, 60);
      //g.setColor(Color.BLUE);
      //g.fillOval(50, 50, 30, 60);
   }
}
public class Main {
 public static void main(String [] args) {
   MyCanvas t = new MyCanvas();

   t.setSize(300,250);
   t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
   t.setVisible(true);

   System.out.println();  
  }
}
