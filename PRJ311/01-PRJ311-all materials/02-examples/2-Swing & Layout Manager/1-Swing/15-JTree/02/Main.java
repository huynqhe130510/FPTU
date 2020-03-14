import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*; 
class TreeDemo extends JFrame
   { public TreeDemo(String xTitle)
        { setTitle(xTitle);
          DefaultMutableTreeNode root1 = new DefaultMutableTreeNode("Dong vat");
          //Create child node

          DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("An co");
          root1.add(node1);
          DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("An thit");
          root1.add(node2);
          JTree  t = new JTree(root1);
          Container con = getContentPane();
          con.add(t);
        }
   }
public class Main
  {
    public static void main(String[] args)
        {
          TreeDemo t = new TreeDemo("Tree demo");
          t.setSize(200,150);
          t.setVisible(true);
          t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
  }

