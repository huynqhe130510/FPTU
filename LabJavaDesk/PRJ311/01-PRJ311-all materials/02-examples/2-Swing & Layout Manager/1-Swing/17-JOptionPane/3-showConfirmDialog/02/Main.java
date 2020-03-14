import javax.swing.*;
public class Main
   { public static void main(String[] args)
        {
           JFrame f = new JFrame("This frame contains a dialog box");
           f.setVisible(true);
           f.setSize(400,400);
           f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JOptionPane.showConfirmDialog(f.getContentPane(), 
"choose one", "choose one", JOptionPane.YES_NO_OPTION);

       }
  }