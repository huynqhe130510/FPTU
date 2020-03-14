import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JOptionPaneTest extends JPanel {
    JInternalFrame internalFrame = new JInternalFrame("Internal Frame test");
         static JFrame f = new JFrame();
  
static JPanel p2;

  public JOptionPaneTest() {
        setLayout(new FlowLayout());
          p2 = new JPanel();
      JLabel label = new JLabel("Click to get Dialog...");
        label.setOpaque(false);
        add(label);
        JButton button1 = new JButton("InternalMessageDialog");
        JButton button2 = new JButton("MessageDialog");
      p2.add(button1);
      p2.add(button2);
      this.add(p2);
    final JFrame theFrame = new JFrame("test");

    button1.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
         JOptionPane.showInternalMessageDialog(f.getContentPane(), "InternalMessageDialog", "InternalMessageDialog", JOptionPane.ERROR_MESSAGE);
        System.out.println("showed1");
      }
    });

     button2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "MessageDialog", "MessageDialog", JOptionPane.ERROR_MESSAGE);
        System.out.println("showed2");
      }
    });

   }
   void test() {
       JPanel p = new JOptionPaneTest();
         f.getContentPane().add(p);
         f.pack();
         f.setBounds(100,100, 200, 300);
         f.show();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
    
}

public class Main
{   public static void main (String [] args) {
     (new JOptionPaneTest()).test();
        System.out.println ("yo");
        } 

 }