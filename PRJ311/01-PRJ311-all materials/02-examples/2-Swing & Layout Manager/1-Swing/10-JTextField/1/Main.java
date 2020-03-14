import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TextDemo extends JFrame implements ActionListener, KeyListener
 {private JTextField field;
  private JTextArea area;
  TextDemo()
   {super("TextDemo");
    setSize(350, 250);
    Container cont = getContentPane();
    field = new JTextField("Type here");
    field.addKeyListener(this);
    field.addActionListener(this);
    cont.add(field, BorderLayout.NORTH);
    area = new JTextArea();
    cont.add(area, BorderLayout.CENTER);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
   }
  public void keyPressed(KeyEvent e) { }
  public void keyReleased(KeyEvent e) { }
  public void keyTyped(KeyEvent e)
   {area.append("KEY: " + e.getKeyChar() + "\n");
   }
  public void actionPerformed(ActionEvent e)
   {
    area.append("ACTION: " + field.getText() + "\n");
   }
 }

public class Main
 { public static void main(String[] args)
     { 
       new TextDemo();
     }
 }
