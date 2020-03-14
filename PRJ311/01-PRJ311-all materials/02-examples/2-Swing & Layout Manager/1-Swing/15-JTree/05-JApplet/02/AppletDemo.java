import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class AppletDemo extends JApplet implements CellEditorListener
{
	public void init() 
  {
   	JTree tree = new JTree();
		getContentPane().add(tree);
		tree.setEditable(true);
		tree.getCellEditor().addCellEditorListener(this);
  }

  public void editingCanceled(ChangeEvent e) 
  {
  		CellEditor editor = (CellEditor)e.getSource();
     showStatus("Change not made");
	}

   public void editingStopped(ChangeEvent e) 
   {
   	CellEditor editor = (CellEditor)e.getSource();
		showStatus("New text: " + (String)editor.getCellEditorValue());
 	}
}
