import javax.swing.JOptionPane;

class Main 
 {public static void main(String [] args) throws Exception
   {JOptionPane t = new JOptionPane();
    String s,mess;int k;
    mess="";
    while(true)
     {s = t.showInputDialog(null,"Enter number: ",mess,JOptionPane.QUESTION_MESSAGE);
      try {k = Integer.parseInt(s);} catch(Exception e) 
       {mess = "Not a valid number, please reenter!";continue;}
      break;
     }

    t.showMessageDialog(null," k = " + k);

    System.out.println();
   }
 }
