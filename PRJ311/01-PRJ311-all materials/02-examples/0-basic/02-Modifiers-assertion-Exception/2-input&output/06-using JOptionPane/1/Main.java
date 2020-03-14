import javax.swing.JOptionPane;

class Main 
 {public static void main(String [] args) throws Exception
   {JOptionPane t = new JOptionPane();
    String s;
    s = t.showInputDialog(null,"Enter a string: ");
    t.showMessageDialog(null," You entered:\n " + s);

    System.out.println();
   }
 }
