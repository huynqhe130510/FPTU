import java.awt.*;
import javax.swing.*;
class MenuDemo extends JFrame
 {public MenuDemo()
   {super("Menu Demo");
    JMenuBar menBar;
    JMenu men1, men2, menSub;
    JMenuItem menItemExit;
    JMenuItem menItem1, menItem2;
    JMenuItem menItemSub1,menItemSub2;

    menBar = new JMenuBar();
    men1 = new JMenu("File");
    men2 = new JMenu("New");
    menItemExit = new JMenu("Exit");

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

