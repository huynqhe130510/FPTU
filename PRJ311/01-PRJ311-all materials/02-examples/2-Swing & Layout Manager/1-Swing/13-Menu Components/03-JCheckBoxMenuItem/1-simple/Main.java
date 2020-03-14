// A quick demonstration of checkbox menu items.//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
class CheckBoxMenuItemDemo extends JFrame
   { public JMenuBar bar;
     public CheckBoxMenuItemDemo()
        { bar = new JMenuBar();
          JMenu m = new JMenu("Justify");
          ActionListener h = new ActionListener()
              { public void actionPerformed(ActionEvent e)
                    { System.out.println(e.paramString());
                    }
              };
          JCheckBoxMenuItem m1 = new  JCheckBoxMenuItem("Left", new ImageIcon("Icons/left.gif"));
          m1.setHorizontalTextPosition(JMenuItem.RIGHT);
          m1.addActionListener(h);
          JCheckBoxMenuItem rm2 = new  JCheckBoxMenuItem("Right", new ImageIcon("Icons/right.gif"));
          rm2.setHorizontalTextPosition(JMenuItem.RIGHT);
          rm2.addActionListener(h);
          JCheckBoxMenuItem m3 = new  JCheckBoxMenuItem("Center", new ImageIcon("Icons/center.gif"));
          m3.setHorizontalTextPosition(JMenuItem.RIGHT);
          m3.addActionListener(h);
          JCheckBoxMenuItem m4 = new JCheckBoxMenuItem("Full", new ImageIcon("Icons/full.gif"));
          m4.setHorizontalTextPosition(JMenuItem.RIGHT);
          m4.addActionListener(h);
          m.add(m1);
          m.add(rm2);
          m.add(m3);
          m.add(m4);
          bar.add(m);
        }
   }
public class Main
   {
     public static void main(String s[])
        { CheckBoxMenuItemDemo f = new CheckBoxMenuItemDemo();
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          f.setJMenuBar(f.bar);
          f.pack();
          f.setSize(200,300);
          f.setVisible(true);
        }
  }