import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.*;
public class Main
 {public static void main(String[] args)
   {JFrame f = new JFrame("Frame - Content Pane Demo");
    f.setSize(350, 250);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container cont = f.getContentPane();
    cont.setLayout(new FlowLayout());
    for (int i=1; i<=3; i++)
    cont.add(new JButton("Button #" + i));

    f.setVisible(true);

   }
 }


