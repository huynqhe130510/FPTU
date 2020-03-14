import javax.swing.*;
public class Main
   { public static void main(String[] args)
        {
           JFrame f = new JFrame("This frame contains a dialog box");
           f.setVisible(false);
           f.setSize(400,400);
           f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           JOptionPane.showInternalMessageDialog(f.getContentPane(), "information", "Information dialog", JOptionPane.INFORMATION_MESSAGE);
       }
  }