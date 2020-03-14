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

          DefaultMutableTreeNode node11 = new DefaultMutableTreeNode("Trau");
          node1.add(node11);
          DefaultMutableTreeNode node12 = new DefaultMutableTreeNode("Bo");
          node1.add(node12);
          DefaultMutableTreeNode node13 = new DefaultMutableTreeNode("Ngua");
          node1.add(node13);
          DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("An thit");

          root1.add(node2);
          DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("Gam nham");

          root1.add(node3);
          JTree  t = new JTree(root1);
          Container ct = getContentPane();
          ct.add(new JScrollPane(t));
        }
   }
public class Main
  {
    public static void main(String[] args)
        {
          TreeDemo t = new TreeDemo("Tree demo");
          t.setSize(400,300);
          t.setVisible(true);
          t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
  }

