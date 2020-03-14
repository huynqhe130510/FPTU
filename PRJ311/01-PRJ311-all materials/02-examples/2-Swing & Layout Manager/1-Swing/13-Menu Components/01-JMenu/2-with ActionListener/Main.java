import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class MenuDemo extends JFrame
 {public MenuDemo()
   {super("Menu Demo");
    JMenuBar menBar;
    JMenu men1, men2, menSub;
    JMenuItem menItemExit;
    JMenuItem menItem1, menItem2;
    JMenuItem menItemSub1,menItemSub2;

    ActionListener t = new ActionListener()
     {public void actionPerformed(ActionEvent e)
       {System.exit(0);
       }
     };
         
    ActionListener h = new ActionListener()
     {public void actionPerformed(ActionEvent e)
       {System.out.println("MS Access");
       }
     };

    menBar = new JMenuBar();
    men1 = new JMenu("File");
    men2 = new JMenu("New");
    menItemExit = new JMenuItem("Exit");
    menItemExit.addActionListener(t);

    menBar.add(men1);
    menBar.add(men2);
    menBar.add(menItemExit);//The menu bar can add an item

    menItem1 = new JMenuItem("Word");
    menItem2 = new JMenuItem("Excel");
    menSub = new JMenu("Other...");
    men1.add(menItem1);
    men1.add(menItem2);
    men1.add(menSub);//The menu can add the other menu

    menItemSub1 = new JMenuItem("Access");
    menItemSub2 = new JMenuItem("PowerPoint");
    menItemSub1.addActionListener(h);
    menSub.add(menItemSub1);
    menSub.add(menItemSub2);


    setJMenuBar(menBar);
   } 
 }
public class Main
 {public static void main(String [] args)
   {
    MenuDemo f = new MenuDemo();
    f.setSize(600,500);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
   }
 }

