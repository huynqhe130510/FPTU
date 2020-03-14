import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Person
 {String name; int age;
  Person(String name1, int age1) {name=name1;age=age1;}
  public String toString() {return(name + "  " + age);}
 }
class FrameDemo extends JFrame
  {public FrameDemo()
     {int nRow, nCol, i, j; nRow=5; nCol=3;
      Object [][] a = new Object[nRow][nCol];
      String [] h = {"Mot","Hai","Ba"};
      JTable t = new JTable(a,h);
      for(i=0;i<nRow;i++)
        for(j=0;j<nCol;j++)
          t.setValueAt(new Person("A" + i + j, i+j), i, j);
      Container con = getContentPane();
      con.add(new JScrollPane(t), "Center");
      Person x=null;
      for(i=0;i<nRow;i++)
        {System.out.println();
         for(j=0;j<nCol;j++)
           {x = (Person) t.getValueAt(i, j);
            System.out.print(x + "|");
           }
        }
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

