import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;
public class Main
 {public static void main(String[] args)
   {JFrame f = new JFrame("Frame - Content Pane Demo");
    f.setSize(350, 250);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container cont = f.getContentPane();
    cont.setLayout(new FlowLayout());
    JLabel lbl1 = new JLabel("Hello");
    lbl1.setFont(new Font("Tahoma",Font.BOLD, 20));
    cont.add(lbl1);

    f.setVisible(true);

   }
 }


