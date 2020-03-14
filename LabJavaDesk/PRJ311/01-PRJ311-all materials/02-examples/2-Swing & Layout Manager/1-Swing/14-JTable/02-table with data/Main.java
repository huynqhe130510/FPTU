import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class FrameDemo extends JFrame
  { public FrameDemo()
        { Object a [][] =
            { {"Nam", 20, 500},
              {"Hung", 25, 1000},
              {"Tuyet", 22, 700},
            };
          String c [] = {"Ten", "Tuoi", "Luong"};
          JTable t = new JTable(a,c);
          Container con = getContentPane();
          con.add(new JScrollPane(t), "Center");
        }
  } 
public class Main
  {
    public static void main(String[] args)
        {
          FrameDemo f = new FrameDemo();
          f.setSize(200,100);
          f.setVisible(true);
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
  }

