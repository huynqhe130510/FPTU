import java.awt.*;
import javax.swing.*;
class SpringLayoutDemo
  { 
    public void show()
       { JFrame f = new JFrame("SpringLayout demo");
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         Container c = f.getContentPane();
         SpringLayout s = new SpringLayout();
          c.setLayout(s);
         JLabel lbl1 = new JLabel("Label: ");
         JTextField txt1 = new JTextField("Text field",10);
         c.add(lbl1);
         c.add(txt1);

         // lbl1's west (left) edge is 5 pixels from c container's left (west) edge.
         s.putConstraint(SpringLayout.WEST, lbl1, 5, SpringLayout.WEST, c);

         // lbl1's top (north) edge is 5 pixels from c container's top edge.
         s.putConstraint(SpringLayout.NORTH, lbl1, 5, SpringLayout.NORTH, c);

         // txt1's left edge is 4  pixels away from lbl1's right (east) edge.
         s.putConstraint(SpringLayout.WEST, txt1, 4, SpringLayout.EAST, lbl1);

         // txt1's top (north) edge is 5 pixels from c container's top edge.
         s.putConstraint(SpringLayout.NORTH, txt1, 5, SpringLayout.NORTH, c);

         // c's east (right) edge is 5 pixels from c txt1's right (east) edge.
         s.putConstraint(SpringLayout.EAST, c, 5, SpringLayout.EAST, txt1);

         // c's bottom (south) edge is 5 pixels from txt1's bottom edge.
         s.putConstraint(SpringLayout.SOUTH, c, 5, SpringLayout.SOUTH, txt1);

         f.pack();
         f.setVisible(true);
       }
  }
public class Main
  { public static void main(String [] a)
      { SpringLayoutDemo t = new SpringLayoutDemo();
        t.show(); 
      }
  };
