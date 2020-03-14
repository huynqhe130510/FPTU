import javax.swing.JOptionPane;
public class Main
 {public static void main(String [] args)
   {JOptionPane t = new JOptionPane();
    String s;
    s = t.showInputDialog(null,"Enter a string: ");
    t.showMessageDialog(null,"The string entered is: " + s);
    System.out.println();  

   }
 }
