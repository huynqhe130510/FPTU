import java.awt.*; 

import java.awt.event.*; 
public class Main
   { public static void main(String[] args)
       { 
         final Frame tcl = new Frame(); 
         tcl.setSize(100,100); 
         final CardLayout cardLayout = new CardLayout(10,10); 
         tcl.setLayout(cardLayout); 
         for(int i=1; i<=9; i++)
           { 
             Button b = new Button("Button Nr." + i); 
             ActionListener listener = new ActionListener() 
                { public void actionPerformed(ActionEvent e)
                   { 
                     cardLayout.next(tcl);
                   }
               }; 
            b.addActionListener(listener); 
            tcl.add("Button Nr." + i, b); 
          }
        tcl.show(); 
     }
 }



