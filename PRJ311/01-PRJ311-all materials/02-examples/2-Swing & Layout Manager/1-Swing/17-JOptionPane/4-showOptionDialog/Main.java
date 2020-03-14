import javax.swing.*;
public class Main
   { public static void main(String[] args)
        {
          Object[] options = { "OK",  "RETRY", "CANCEL" };
          JOptionPane.showOptionDialog(null, "Click OK to continue", "Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
       }
  }