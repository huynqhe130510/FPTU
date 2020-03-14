import java.awt.*;
import javax.swing.*;
class FlowLayoutDemo extends JFrame
  { JLabel lbl1 = new JLabel("Name:");
    JTextField txt1 = new JTextField(10);
    JButton btn1, btn2, btn3;
    FlowLayoutDemo(String ptitle) 
      { super(ptitle);

        btn1 = new JButton("mot");
        btn2 = new JButton("hai");
        btn3 = new JButton("ba");
        setLayout(new FlowLayout());
        add(lbl1);
        add(txt1);
        add(btn1);
        add(btn2);
        add(btn3);
      }
  }
public class Main
  { public static void main(String [] a)
      { FlowLayoutDemo f = new FlowLayoutDemo("FlowLayout demo");
        f.setSize(400,100);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
  };
