import javax.swing.*;
public class Main
   { public static void main(String[] args)
        {
           JFrame f = new JFrame("Test Dialog box");
           f.setVisible(true);
           f.setSize(400,400);
           f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          JOptionPane.showMessageDialog(f, "alert", "alert dialog", JOptionPane.ERROR_MESSAGE); 
        }
  }