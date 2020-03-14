import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.*;
public class Main
 {public static void main(String[] args)
   {JFrame f = new JFrame("Frame - Content Pane Demo");
    f.setSize(350, 250);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container cont = f.getContentPane();
    JPanel pan;
    int i, j;

    cont.setLayout(new GridLayout(2,1));
    for(i=0; i<2; i++)
     {pan = new JPanel();
      pan.setBackground(i==0 ? Color.lightGray : Color.blue);
      for(j=0; j<3; j++) pan.add(new JButton("Button # " + i + " " + j));
      cont.add(pan);
     }

    f.setVisible(true);

   }
 }


