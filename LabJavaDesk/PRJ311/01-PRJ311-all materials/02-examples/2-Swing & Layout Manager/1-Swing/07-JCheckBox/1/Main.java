import java.awt.*;
import javax.swing.*;
public class Main
 { public static void main(String[] args)
     {
      JFrame f = new JFrame("CheckBox Demo");
      f.setSize(350, 250);
      Container cont = f.getContentPane();
      cont.setLayout(new FlowLayout());
      cont.add(new JCheckBox("Charge my acct"));
      cont.add(new JCheckBox("Gift wrap"));
      cont.add(new JButton("Submit"));
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
 }
