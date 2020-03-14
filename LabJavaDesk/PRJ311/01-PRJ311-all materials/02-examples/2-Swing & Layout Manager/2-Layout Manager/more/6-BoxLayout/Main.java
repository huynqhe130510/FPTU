import java.awt.*;
import javax.swing.*;
class BoxLayoutDemo
  { 
    public static void addComponentsToPane(Container thePane)
       { thePane.setLayout(new BoxLayout(thePane, BoxLayout.PAGE_AXIS));
         addAButton("mot",thePane);
         addAButton("hai",thePane);
         addAButton("ba",thePane);
         addAButton("bon bong hoa",thePane);
         addAButton("nam",thePane);
       }
    public static void addAButton(String txt, Container con)
       { JButton b = new JButton(txt);
         b.setAlignmentX(Component.CENTER_ALIGNMENT);
         con.add(b);
       }
  }
public class Main
  { public static void main(String [] a)
      { JFrame f = new JFrame("BoxLayoutDemo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BoxLayoutDemo.addComponentsToPane(f.getContentPane());
        f.pack();
        f.setVisible(true);
      }
  };
/* PAGE_AXIS stands for top to bottom arrangement and LINE_AXIS stands for left to right 
*/