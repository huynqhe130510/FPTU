import java.awt.*;
import javax.swing.*;
class TextAreaDemo extends JFrame
  { public TextAreaDemo()
        { super("Sample JTextArea");
          Container con1 = getContentPane();
          con1.setLayout(new FlowLayout());
          JLabel lbl1=new JLabel("Ly lich: ");
          con1.add(lbl1);
          JTextArea txtA1=new JTextArea(5,15);
          txtA1.setFont(new Font("Times New Roman", Font.ITALIC, 16));
          con1.add(txtA1);
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
          new TextAreaDemo();
        }
  }

