import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
public class Main
   { public static void main(String[] args)
       { 
         final Frame f = new Frame(); 
         f.setSize(100,100); 
         final CardLayout c = new CardLayout(10,10); 
         f.setLayout(c); 
         Button b1, b2, b3;
         b1 = new Button("1");
         b2 = new Button("2");
         b3 = new Button("3");
         ActionListener h = new ActionListener() 
               { public void actionPerformed(ActionEvent e)
                   { 
                     c.next(f);
                   }
               }; 
          b1.addActionListener(h); 
          b2.addActionListener(h); 
          b3.addActionListener(h); 
          f.add("mot",b1);            
          f.add("hai",b2);            
          f.add("ba",b3);            
          f.setSize(100,100); 
          f.show();
          f.pack();
          try {Thread.sleep(5000);} catch(Exception e) {}
          System.exit(0);
     }
 }
