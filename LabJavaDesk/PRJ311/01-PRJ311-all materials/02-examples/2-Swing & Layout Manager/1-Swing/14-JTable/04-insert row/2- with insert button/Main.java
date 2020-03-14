import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
class FrameDemo extends JFrame
  {DefaultTableModel g; JTable t;
   public FrameDemo()
     {int nRow, nCol, i,j; nRow=5; nCol=3;
      Object [][] a = new Object[nRow][nCol];
      String [] h = {"Mot","Hai","Ba"};
      g = new DefaultTableModel(a,h);
      t = new JTable(g);
      for(i=0;i<nRow;i++)
        for(j=0;j<nCol;j++)
          t.setValueAt(new String("A" + i+j), i, j);

      Container con = getContentPane();
      con.setLayout(new FlowLayout());
      con.add(new JScrollPane(t));
      JButton btn1 = new JButton("Insert row");
      btn1.addActionListener(
       new ActionListener()
         {public void actionPerformed(ActionEvent e)
           {btn1ActionPerformed(e);
           }
         }
       );
      con.add(btn1);
     }
   public void btn1ActionPerformed(ActionEvent e)
     {g.insertRow(t.getRowCount(),new Object[]{null,null,null});
     }
  } 
public class Main
  {
   public static void main(String[] args)
     {
      FrameDemo f = new FrameDemo();
      f.setSize(500,600);
      f.setVisible(true);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
  }

