import javax.swing.JOptionPane;

class Main 
 {public static void main(String [] args) throws Exception
   {JOptionPane t = new JOptionPane();
    String s;
    s = t.showInputDialog(null,"Enter a string: ","ABC",JOptionPane.QUESTION_MESSAGE);
    t.showMessageDialog(null," You entered:\n " + s,"XYZ",JOptionPane.INFORMATION_MESSAGE);

    System.out.println();
   }
 }
