import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

/**
 * JTree basic tutorial and example
 * @author wwww.codejava.net
 */

class TreeExample extends JFrame
{
    private JTree tree;
    private JLabel selectedLabel;
    
    public TreeExample()
    {
        //create the root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        //create the child nodes
        DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode("Vegetables");
        vegetableNode.add(new DefaultMutableTreeNode("Capsicum"));
        vegetableNode.add(new DefaultMutableTreeNode("Carrot"));
        vegetableNode.add(new DefaultMutableTreeNode("Tomato"));
        vegetableNode.add(new DefaultMutableTreeNode("Potato"));
        
        DefaultMutableTreeNode fruitNode = new DefaultMutableTreeNode("Fruits");
        fruitNode.add(new DefaultMutableTreeNode("Banana"));
        fruitNode.add(new DefaultMutableTreeNode("Mango"));
        fruitNode.add(new DefaultMutableTreeNode("Apple"));
        fruitNode.add(new DefaultMutableTreeNode("Grapes"));
        fruitNode.add(new DefaultMutableTreeNode("Orange"));

        //add the child nodes to the root node
        root.add(vegetableNode);
        root.add(fruitNode);
        
        //create the tree by passing in the root node
        tree = new JTree(root);

        ImageIcon imageIcon = new ImageIcon(TreeExample.class.getResource("leaf.jpg"));
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();        
        renderer.setLeafIcon(imageIcon);
        
        tree.setCellRenderer(renderer);
        tree.setShowsRootHandles(true);
        tree.setRootVisible(false);
        add(new JScrollPane(tree));
        
        selectedLabel = new JLabel();
        add(selectedLabel, BorderLayout.SOUTH);

        tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                System.out.println(e.getPath().toString());
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                selectedLabel.setText(selectedNode.getUserObject().toString());
            }
        });
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("JTree Example");        
        this.setSize(200, 200);
        this.setVisible(true);
    }
    
}




public class Main
  {
    public static void main(String[] args)
       {
          TreeExample t = new TreeExample();
           t.setVisible(true);
       }
  }

