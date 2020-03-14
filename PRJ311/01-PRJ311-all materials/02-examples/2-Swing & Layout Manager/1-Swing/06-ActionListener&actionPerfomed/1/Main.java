import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
class TestListener extends JFrame implements ActionListener
 {private JButton helloBtn, goodbyeBtn;
  TestListener(String sTitle)
   {super(sTitle);
    setSize(250, 150);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    helloBtn = new JButton("Hello");
    goodbyeBtn = new JButton("Goodbye");

    Container cont = getContentPane();
    cont.setLayout(new FlowLayout());
    helloBtn.addActionListener(this);
    goodbyeBtn.addActionListener(this);
    cont.add(helloBtn);
    cont.add(goodbyeBtn);
   }
  public void actionPerformed(ActionEvent e)
   {if(e.getSource() == helloBtn)
      System.out.println(" Hello ");
       else
        System.out.println(" Good bye ");
   }
 }
public class Main
 {public static void main(String[] args)
   {(new TestListener("Test button and action listener")).setVisible(true);

   }
 }

/*
<button>.addActionListener(this);
<pane>.add(<button>);
public void actionPerform(ActionEven e) {} 
*/
