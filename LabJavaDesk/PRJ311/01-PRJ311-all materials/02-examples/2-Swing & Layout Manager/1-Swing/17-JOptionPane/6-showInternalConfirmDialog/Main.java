import javax.swing.*;
public class Main
   { public static void main(String[] args)
        {
           JFrame f = new JFrame("This frame contains a dialog box");
           f.setVisible(false);
           f.setSize(400,400);
           f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          JOptionPane.showInternalConfirmDialog(f.getContentPane(), "please choose one", "information", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
       }
  }