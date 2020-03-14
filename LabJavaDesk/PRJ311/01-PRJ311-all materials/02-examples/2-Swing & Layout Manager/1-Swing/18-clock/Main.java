import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Calendar;      // only need this one class



class TextClock extends JFrame
 {
  private JTextField txtTime;  // set by timer listener

  public TextClock()
   {// Build the GUI - only one panel
    txtTime = new JTextField(6);
    txtTime.setFont(new Font("sansserif", Font.PLAIN, 48));
    txtTime.setEditable(false);
    Container content = this.getContentPane();
    content.setLayout(new FlowLayout());
    content.add(txtTime); 
        
    this.setTitle("Text Clock");
    this.pack();

    // Create a 1-second timer and action listener for it.
    // Specify package because there are two Timer classes
    javax.swing.Timer t = new javax.swing.Timer(1000,
      new ActionListener()
            {public void actionPerformed(ActionEvent e)
               {Calendar now = Calendar.getInstance();
                int h = now.get(Calendar.HOUR_OF_DAY);
                int m = now.get(Calendar.MINUTE);
                int s = now.get(Calendar.SECOND);
                txtTime.setText("" + h + ":" + m + ":" + s);
               }
              });
    t.start();  // Start the timer
   }//end constructor
 }//endclass TextClock


public class Main
 {public static void main(String[] args)
   {JFrame clock = new TextClock();
    clock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    clock.setVisible(true);
   }
 }


