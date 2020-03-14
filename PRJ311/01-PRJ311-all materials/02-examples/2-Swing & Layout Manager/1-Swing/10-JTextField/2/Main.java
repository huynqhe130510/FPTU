import java.awt.*;
import javax.swing.*;
class TextFieldDemo extends JFrame
  { public TextFieldDemo()
        { super("Sample JTextField");
          Container con1 = getContentPane();
          con1.setLayout(new FlowLayout());
          JLabel lbl1=new JLabel("Nhap ho ten:");
          con1.add(lbl1);
          JTextField txt1=new JTextField(20);
          txt1.setFont(new Font("Times New Roman", Font.ITALIC, 16));
          con1.add(txt1);
          pack();
          setVisible(true);
          //setSize(400,200);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
  } 
public class Main
  {
    public static void main(String[] args)
        {
          new TextFieldDemo();
        }
  }

