import javax.swing.JOptionPane;
public class Main
 {public static void main(String [] args)
   {JOptionPane t = new JOptionPane();
    int k; float x; double y;
    String s;
    s = t.showInputDialog(null,"Enter an integer: ");
    k = Integer.parseInt(s);
    s = t.showInputDialog(null,"Enter a float: ");
    x = Float.parseFloat(s);
    s = t.showInputDialog(null,"Enter a double: ");
    y = Double.parseDouble(s);

    t.showMessageDialog(null,"k, x, y =  " + k + ", " + x + ", " + y);
    System.out.println();  

   }
 }
