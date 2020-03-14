import java.awt.*;
import javax.swing.*;
public class Main
 {public static void main(String[] args)
   {JFrame f = new JFrame("Frame - Content Pane Demo");
    f.setSize(500, 500);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container cont = f.getContentPane();
    cont.setLayout(new FlowLayout());
    JLabel lbl1 = new JLabel("Hello");
    lbl1.setFont(new Font("Tahoma",Font.BOLD, 20));
    lbl1.setBackground(Color.YELLOW);

    JLabel red = new JLabel("RED");
    red.setForeground(Color.RED);
    JLabel blue = new JLabel("BLUE");
    blue.setForeground(Color.BLUE);
    JLabel pink = new JLabel("PINK");
    pink.setForeground(Color.PINK);
    JLabel magenta = new JLabel("MAGENTA");
    magenta.setForeground(Color.MAGENTA);

    cont.add(lbl1);
    cont.add(red);
    cont.add(blue);
    cont.add(pink);
    cont.add(magenta);

    f.setVisible(true);

   }
 }


