import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class FrameDemo extends JFrame
  {public FrameDemo()
     {int nRow, nCol; nRow=5; nCol=3;
      Object [][] a = new Object[nRow][nCol];
      String [] h = {"Mot","Hai","Ba"};
      JTable t = new JTable(a,h);
      Container con = getContentPane();
      con.add(new JScrollPane(t), "Center");
     }
  } 
public class Main
  {
   public static void main(String[] args)
     {
      FrameDemo f = new FrameDemo();
      f.setSize(200,200);
      f.setVisible(true);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
  }
