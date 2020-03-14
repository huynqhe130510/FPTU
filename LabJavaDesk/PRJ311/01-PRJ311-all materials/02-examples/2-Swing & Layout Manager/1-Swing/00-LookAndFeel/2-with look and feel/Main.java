import javax.swing.*;
public class Main
 {public static void main(String [] args)
   {
    try {

      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

     } catch(Exception e) {

      e.printStackTrace();
     }


    JFrame win = new JFrame("Test Look and Feel");
    win.setVisible(true);
    win.setSize(500,400);
    win.setResizable(false);
    win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel pan = new JPanel();
    win.add(pan);

    JButton btn = new JButton("Look and Feel");
    pan.add(btn);

    JProgressBar pb = new JProgressBar();
    pb.setValue(75);
    pan.add(pb);     
      
    System.out.println();  
   }
 }
