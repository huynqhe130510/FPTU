import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
class FrameDemo extends JFrame
  {DefaultTableModel g; JTable t;
   JTextField txtMot,txtHai,txtBa;
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
      JButton btn1 = new JButton("Insert row");
      btn1.addActionListener(
       new ActionListener()
         {public void actionPerformed(ActionEvent e)
           {btn1ActionPerformed(e);
           }
         }
       );
      con.add(new JLabel("Table demo"));
      con.add(new JScrollPane(t));
      con.add(new JLabel("Mot:"));
      txtMot = new JTextField("A",10);
      con.add(txtMot);
      con.add(new JLabel("Hai:"));
      txtHai = new JTextField("B",10);
      con.add(txtHai);
      con.add(new JLabel("Ba:"));
      txtBa = new JTextField("C",10);
      con.add(txtBa);
      con.add(btn1);

     }
   public void btn1ActionPerformed(ActionEvent e)
     {g.insertRow(t.getRowCount(),
       new Object[]{txtMot.getText(),txtHai.getText(),txtBa.getText()}
       );
     }
  } 
public class Main
  {
   public static void main(String[] args)
     {
      FrameDemo f = new FrameDemo();
      f.setSize(460,600);
      f.setVisible(true);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
  }

