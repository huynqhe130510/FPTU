import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
class FrameDemo extends JFrame
  {public FrameDemo()
     {int nRow, nCol, i,j; nRow=5; nCol=3;
      Object [][] a = new Object[nRow][nCol];
      String [] h = {"Mot","Hai","Ba"};
      DefaultTableModel g = new DefaultTableModel(a,h);
      JTable t = new JTable(g);
      for(i=0;i<nRow;i++)
        for(j=0;j<nCol;j++)
          t.setValueAt(new String("A" + i+j), i, j);

      Container con = getContentPane();
      //con.add(new JScrollPane(t), "Center");
      con.add(new JScrollPane(t));
      //Insert first position
      g.insertRow(0,new Object[]{"B","2","3"});
      //Insert 4 position
      g.insertRow(3,new Object[]{"C","2","3"});
      //Insert last position
      g.insertRow(t.getRowCount(),new Object[]{"D","2","3"});
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

