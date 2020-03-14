import java.awt.*;
import javax.swing.*;
public class Main
  {
    public static void main(String[] args)
        {
          JFrame f = new JFrame("JScrollPane demo");
          Container con1 = f.getContentPane();
          con1.setLayout(new FlowLayout());
          JTextArea text1 = new JTextArea("Hay nhap nhieu hon 5 dong",5,15);
          JScrollPane p = new JScrollPane(text1);
          con1.add(p);
          f.pack();
          f.setVisible(true);
          f.setSize(200,200);
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
  }
/*
the pack() method causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
*/
