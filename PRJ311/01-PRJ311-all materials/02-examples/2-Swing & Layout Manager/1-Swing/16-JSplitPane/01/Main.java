import javax.swing.*;

public class Main
 {  public static void main(String[] args)
      {
        JFrame fr=new JFrame("JSplitPane Demo");
        fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
        fr.setSize(500,100);
    
        JSplitPane content=new JSplitPane();    
        content.add(new JButton("Button "),JSplitPane.LEFT);
        content.add(new JButton("Button2"),JSplitPane.RIGHT);
    
        //alternatively, use this syntax:
        //content.setLeftComponent(new JButton("Button"));
        //content.setRightComponent(new JButton("Button2"));
        
        fr.getContentPane().add(content);
    
        fr.show();
     }
 }