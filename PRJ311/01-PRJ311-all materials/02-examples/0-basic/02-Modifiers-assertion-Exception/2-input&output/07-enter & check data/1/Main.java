import javax.swing.JOptionPane;

class Main 
 {public static void main(String [] args) throws Exception
   {JOptionPane t = new JOptionPane();
    String s;int k;
    while(true)
     {s = t.showInputDialog(null,"Enter number: ");
      try {k = Integer.parseInt(s);} catch(Exception e) 
       {System.out.println(" Not a valid number, please reenter!");continue;}
      break;
     }

    t.showMessageDialog(null," k = " + k);

    System.out.println();
   }
 }
