import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class MenuDemo extends JPanel
   { JLabel label1;
     JPopupMenu pMenu1;
     public MenuDemo()
        { label1 = new JLabel("Click the right mouse button");
          pMenu1 = new JPopupMenu();
          JMenuItem item1, item2, item3;
          item1 = new JMenuItem("Orange"); 
          item2 = new JMenuItem("Pineapple"); 
          item3 = new JMenuItem("Mango");
          item1.addActionListener(new ActionListener()
            { public void actionPerformed(ActionEvent e)
                 { label1.setText("Orange");
                 }

            }
            ); 
          item2.addActionListener(new ActionListener()
            { public void actionPerformed(ActionEvent e)
                 { label1.setText("Pineapple");
                 }

            }
            ); 
         item3.addActionListener(new ActionListener()
            { public void actionPerformed(ActionEvent e)
                 { label1.setText("Mango");
                 }

            }
            ); 

         pMenu1.add(item1);
         pMenu1.add(item2);
         pMenu1.add(item3);
         addMouseListener(new MouseAdapter()
            { public void mouseReleased(MouseEvent e)
                 {  if (e.isPopupTrigger())
                       pMenu1.show(e.getComponent(), e.getX(), e.getY());

                 }
            }
            );
          add(label1);
     }
  }
public class Main
  {
    public static void main(String[] args)
        {
          JFrame f = new JFrame("Menu test!");
          MenuDemo m = new MenuDemo();
          f.getContentPane().add("Center",m);
          f.getContentPane().setBackground(Color.gray);
          f.setSize(400,300);
          f.addWindowListener(new WindowAdapter()
	   { public void windowClosing(WindowEvent e)
	       {System.exit(0);
	       }
	   }
	);
          f.setVisible(true);
        }
  }

