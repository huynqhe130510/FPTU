import java.awt.*;
import javax.swing.*;
class TextAreaDemo extends JFrame
  { public TextAreaDemo()
        { super("Sample JTextArea");
          Container con1 = getContentPane();
          con1.setLayout(new FlowLayout());
          JLabel lbl1=new JLabel("Ly lich: ");
          JTextArea txtA1=new JTextArea(5,15);
          txtA1.setFont(new Font("Times New Roman", Font.ITALIC, 16));
          txtA1.setLineWrap(true);
          JScrollPane p = new JScrollPane(txtA1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
          con1.add(lbl1);
          //con1.add(txtA1); Lenh nay khong can nua vi txtA1 da gan voi p
          con1.add(p);
          pack();
          setVisible(true);
          //setSize(400,400);
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

