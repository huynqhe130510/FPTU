import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ButtonDemo extends JFrame
 {private JButton helloBtn, goodbyeBtn;
  ButtonDemo()
   {super("Button Demo");
    setSize(250, 150);
    Container cont = getContentPane();
    cont.setLayout(new FlowLayout());
    helloBtn = new JButton("Hello");
    goodbyeBtn = new JButton("Goodbye");
    cont.add(helloBtn);
    cont.add(goodbyeBtn);
    ButtonListener listener = new ButtonListener();
    helloBtn.addActionListener(listener);
    goodbyeBtn.addActionListener(listener);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
  class ButtonListener implements ActionListener
   {public void actionPerformed(ActionEvent e)
     {if(e.getSource() == helloBtn) // Which
        System.out.println("Hello"); // button
         else // was
          System.out.println("Goodbye"); // pushed?
     }
   }
 }

public class Main
 {public static void main(String[] args)
   {(new ButtonDemo()).setVisible(true);
   }
 }
