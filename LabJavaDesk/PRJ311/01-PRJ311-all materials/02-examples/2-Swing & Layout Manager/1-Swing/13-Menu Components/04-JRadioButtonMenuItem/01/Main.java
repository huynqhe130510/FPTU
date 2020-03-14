// A quick demonstration of RadioButton menu items.//
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
class RadioButtonMenuItemDemo extends JFrame
   { public JMenuBar bar;
     public RadioButtonMenuItemDemo()
        { bar = new JMenuBar();
          JMenu m = new JMenu("Justify");
          ActionListener h = new ActionListener()
              { public void actionPerformed(ActionEvent e)
                    { System.out.println(e.paramString());
                    }
              };
          JRadioButtonMenuItem m1 = new  JRadioButtonMenuItem("Left", new ImageIcon("Icons/left.gif"));
          m1.setHorizontalTextPosition(JMenuItem.RIGHT);
          m1.addActionListener(h);
          JRadioButtonMenuItem rm2 = new  JRadioButtonMenuItem("Right", new ImageIcon("Icons/right.gif"));
          rm2.setHorizontalTextPosition(JMenuItem.RIGHT);
          rm2.addActionListener(h);
          JRadioButtonMenuItem m3 = new  JRadioButtonMenuItem("Center", new ImageIcon("Icons/center.gif"));
          m3.setHorizontalTextPosition(JMenuItem.RIGHT);
          m3.addActionListener(h);
          JRadioButtonMenuItem m4 = new JRadioButtonMenuItem("Full", new ImageIcon("Icons/full.gif"));
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
        { RadioButtonMenuItemDemo f = new RadioButtonMenuItemDemo();
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          f.setJMenuBar(f.bar);
          f.pack();
          f.setSize(200,300);
          f.setVisible(true);
        }
  }