import java.awt.*;
import javax.swing.*;
public class Main
  {
    public static void main(String[] args)
        {
          JFrame f = new JFrame("GridLayout demo");
          Container con = f.getContentPane();
          con.setLayout(new GridLayout(0,2));
          JButton b1,b2,b3,b4,b5,b6,b7;
          b1 = new JButton("1");
          b2 = new JButton("2");
          b3 = new JButton("3");
          b4 = new JButton("4");
          b5 = new JButton("5");
          b6 = new JButton("6");
          b7 = new JButton("7");
          con.add(b1);
          con.add(b2);
          con.add(b3);
          con.add(b4);
          con.add(b5);
          con.add(b6);
          con.add(b7);
          f.pack();
          f.setVisible(true);
          //f.setSize(300,100);
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
  }

