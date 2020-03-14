import javax.swing.*;
public class Main
   { public static void main(String[] args)
        { String s = (String) JOptionPane.showInputDialog(null, "Please choose a prefer fruit", "JOptionPane demo", JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Dao", "Man", "Tao", "Le", "Chom chom"},"Man");
          JOptionPane.showMessageDialog(null,"you selected " + s);
        }
  }