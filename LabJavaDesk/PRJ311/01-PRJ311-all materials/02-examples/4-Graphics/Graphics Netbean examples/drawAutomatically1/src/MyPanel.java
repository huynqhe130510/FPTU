import javax.swing.*;
import java.awt.*;
public class MyPanel extends JPanel {
   public void paint(Graphics g) {
     super.paint(g);
     this.setBackground(Color.WHITE);
     g.setColor(Color.BLACK);
     g.drawPolygon(xPoints, yPoints, WIDTH);
     
   } 
}
