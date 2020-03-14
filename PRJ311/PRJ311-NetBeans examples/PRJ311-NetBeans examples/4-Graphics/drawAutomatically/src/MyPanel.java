import javax.swing.*;
import java.awt.*;
public class MyPanel extends JPanel {
   public void paint(Graphics g) {
     super.paint(g);
     this.setBackground(Color.yellow);
     g.setColor(Color.RED);
     g.drawLine(20, 30, 100,150);
     int x,y,width,height;
     x = 150; y = 200;
     width = 200; height = 150;
     g.drawOval(x, y, width, height);
     g.setColor(Color.GREEN);
     g.fillOval(x, y, width, height);
     
   } 
}
