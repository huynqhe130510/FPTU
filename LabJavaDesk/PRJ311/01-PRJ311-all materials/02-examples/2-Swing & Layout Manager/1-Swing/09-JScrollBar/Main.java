import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ScrollBarDemo extends JFrame
  {ScrollBarDemo()
    {super("Scroll Bar Demo");
     setSize(350, 250);
     Container cont = getContentPane();
     JScrollBar sbar = new JScrollBar(JScrollBar.HORIZONTAL);
     cont.add(sbar, BorderLayout.NORTH);
     BarListener listener = new BarListener();
     sbar.addAdjustmentListener(listener);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setVisible(true);
    }
   class BarListener implements AdjustmentListener
    {public void adjustmentValueChanged(AdjustmentEvent e)
      {System.out.println("Val = " + e.getValue());
      }
    }
  }
public class Main
 { public static void main(String[] args)
     { new ScrollBarDemo();
     }
 }
