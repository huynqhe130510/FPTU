import java.awt.*;
import javax.swing.*;
public class Main
 { public static void main(String[] args)
     {
      JFrame f = new JFrame("CheckBox Demo");
      f.setSize(350, 250);
      Container cont = f.getContentPane();
      cont.setLayout(new FlowLayout());

      ButtonGroup btnGroup = new ButtonGroup();
      JRadioButton rbtn = new JRadioButton("Rare", true);
      btnGroup.add(rbtn);
      cont.add(rbtn);
      rbtn = new JRadioButton("Medium");
      btnGroup.add(rbtn);
      cont.add(rbtn);
      rbtn = new JRadioButton("Well Done");
      btnGroup.add(rbtn);
      cont.add(rbtn);

      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
     }
 }
