import javax.swing.JOptionPane;

class Main 
 {public static void main(String [] args) throws Exception
   {JOptionPane h = new JOptionPane();
    String s,mess;int k;
    mess="";
    while(true)
     {s = h.showInputDialog(null,"Enter number: ",mess,JOptionPane.QUESTION_MESSAGE);
      try {k = Integer.parseInt(s);} catch(Throwable t) 
       {mess = "Not a valid number, please reenter!";continue;}
      break;
     }

    h.showMessageDialog(null," k = " + k);

    System.out.println();
   }
 }
