import javax.swing.JOptionPane;

class Main 
 {public static void main(String [] args) throws Exception
   {JOptionPane t = new JOptionPane();
    String s;
    s = t.showInputDialog(null,"Enter number: ");
    int k = Integer.parseInt(s);
    t.showMessageDialog(null," k = " + k);

    System.out.println();
   }
 }
