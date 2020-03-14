import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
class PanelDemo extends JPanel
  { 
    public void paintComponent(Graphics g)
      { 
          g.drawString("Good morning",10,20);
      }
  }
public class Main
  {
    public static void main(String[] args)
        {PanelDemo p = new PanelDemo();
         JFrame f = new JFrame("JPanel demo");
         f.getContentPane().add(p);
         f.setSize(300,100);
         f.setLocation(50,10);
         f.setVisible(true);
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
  }

/*
Neu thay lenh
g.drawString("Good morning",10,20);
bang lenh
g.drawString("Good morning",10,0);
thi khong nhin thay chu, vi chu sat mep cua panel nen bi phan dau cua
panel che khuat.
*/