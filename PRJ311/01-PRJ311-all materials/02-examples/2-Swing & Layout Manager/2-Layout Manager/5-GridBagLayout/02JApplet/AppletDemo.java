import java.awt.*;
import java.awt.font.*;
import java.util.*;
import javax.swing.*;

 public class AppletDemo extends JApplet
    {
      protected void makebutton(String name,GridBagLayout gridbag,GridBagConstraints c)
          {
            JButton button = new JButton(name);
            gridbag.setConstraints(button, c);
            add(button);
         }

     public void init()
         {
           GridBagLayout gridbag = new GridBagLayout();
           GridBagConstraints c = new GridBagConstraints();

           setFont(new Font("Helvetica", Font.PLAIN, 14));
           setLayout(gridbag);

           c.fill = GridBagConstraints.BOTH;
           c.weightx = 1.0;
           makebutton("JButton A1", gridbag, c);
           makebutton("JButton A2", gridbag, c);
           makebutton("JButton A3", gridbag, c);

           c.gridwidth = GridBagConstraints.REMAINDER; //end row
           makebutton("JButton A4", gridbag, c);

           c.weightx = 0.0;		   //reset to the default
           makebutton("JButton B", gridbag, c); //another row

           c.gridwidth = GridBagConstraints.RELATIVE; //next-to-last in row
           makebutton("JButton C1", gridbag, c);

           c.gridwidth = GridBagConstraints.REMAINDER; //end row
           makebutton("JButton C2", gridbag, c);

           c.gridwidth = 1;	   	   //reset to the default
           c.gridheight = 2;
           c.weighty = 1.0;
           makebutton("JButton D1", gridbag, c);

           c.weighty = 0.0;		   //reset to the default
           c.gridwidth = GridBagConstraints.REMAINDER; //end row
           c.gridheight = 1;		   //reset to the default
           makebutton("JButton D11", gridbag, c);
           makebutton("JButton D12", gridbag, c);

           setSize(300, 100);
        }

     public static void main(String args[])
        {
          JFrame f = new JFrame("GridBag Layout Example");
          AppletDemo ex1 = new AppletDemo();

          ex1.init();

          f.add("Center", ex1);
          f.pack();
          f.setSize(f.getPreferredSize());
          f.setVisible(true);
       }
  }
