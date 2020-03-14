import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.tree.*;


public class AppletDemo extends JApplet 
{
	public void init()
   {
   	JTree tree = new JTree();
		getContentPane().add(new JScrollPane(tree));

     tree.addMouseListener(new MouseAdapter()
 		{
     		public void mousePressed(MouseEvent e) 
        {
        		String outString = null;
           JTree jtree = (JTree)e.getSource();

           int clickedrow = jtree.getRowForLocation(e.getX(), e.getY());

 			if(clickedrow != -1)
			{
        		TreePath treepath = jtree.getPathForRow(clickedrow);
           TreeNode treenode = (TreeNode) treepath.getLastPathComponent(); 

   			outString = "Node " + treenode.toString();

           if(e.getClickCount() == 1)
           {
           	outString += " was single clicked.";
           }
				else
				{
           	outString += " was double clicked.";
          	}

           showStatus(outString);
        }
    }
  });
  }
}
