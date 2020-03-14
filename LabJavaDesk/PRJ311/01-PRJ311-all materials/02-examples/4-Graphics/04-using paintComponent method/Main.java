import java.awt.*;
import javax.swing.*;
class MyPanel extends JPanel
 {
  public void paintComponent(Graphics g)
   {int x, y, width, height, inc, inc2;
    x = y =50;
    width = 120;
    height = 100;
    inc = 2;inc2 = 2*inc;
    super.paintComponent(g); //(1)
    //super.paint(g); //(2) has the same effect as (1)
    this.setBackground(Color.YELLOW); // without (1) this statement has no effect
    g.setColor(Color.RED);
    g.drawLine(0,0,250,400);
//    g.drawLine(40,40,250,400);
    g.drawRect(x,y,width,height);
    g.setColor(Color.BLUE);
    g.fillRect(x+inc,y+inc,width-inc2,height-inc2);
    int fontSize = 20;
    g.setFont(new Font("Times New Roman", Font.PLAIN, fontSize));
    g.setColor(Color.red);    
    g.drawString("This is a rectangle",x,y+height+20);
   }
 }
public class Main
 {public static void main(String [] args)
   {JFrame t = new JFrame();
    MyPanel h = new MyPanel();
    t.setTitle("Test grapchics");
    t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    t.add(h);
    t.setSize(600,500);
    t.setVisible(true);

    System.out.println();  
   }
 }
