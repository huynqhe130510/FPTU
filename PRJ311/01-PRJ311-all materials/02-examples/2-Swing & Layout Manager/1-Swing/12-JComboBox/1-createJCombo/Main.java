import java.awt.*;
import javax.swing.*;
class ComboBoxDemo extends JFrame
  { public ComboBoxDemo()
        { super("Sample JComboBox");
          setSize(350, 250);
          Container cont = getContentPane();
          cont.setLayout(new FlowLayout());

          String[] initialVals = {"Dragon", "Ghost", "Unicorn"};
          JComboBox combo = new JComboBox(initialVals);
          combo.setEditable(true);
          cont.add(combo);

          setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
  } 
public class Main
  {
    public static void main(String[] args)
        {
          new ComboBoxDemo();
        }
  }

