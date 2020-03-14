import javax.swing.JOptionPane;
public class Main
 {public static void main(String [] args)
   {JOptionPane t = new JOptionPane();
    int k; float x; double y;
    String s;
    while(true)
     {try {
        s = t.showInputDialog(null,"Enter an integer: ");
        k = Integer.parseInt(s);
       } catch(NumberFormatException e)
          {System.out.println("Data format is invalid, please reenter!");continue;}
      break;
     }
    t.showMessageDialog(null,"An integer entered is " + k);
    System.out.println();  

   }
 }
