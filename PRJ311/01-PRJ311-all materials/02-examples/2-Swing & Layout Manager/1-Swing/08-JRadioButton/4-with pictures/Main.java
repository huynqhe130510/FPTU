import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RadioButtonDemo extends JPanel
 {
    static JFrame frame;

    static String strFlower = "flower";
    static String strCoffee = "coffee";
    static String strCogai = "cogaiVN";

    JLabel picture;

    public RadioButtonDemo()
	 {
        // Create the radio buttons.
        JRadioButton flowerButton = new JRadioButton(strFlower);
        flowerButton.setMnemonic('b');
        flowerButton.setActionCommand(strFlower);
        flowerButton.setSelected(true);

        JRadioButton coffeeButton = new JRadioButton(strCoffee);
        coffeeButton.setMnemonic('c');
        coffeeButton.setActionCommand(strCoffee);

        JRadioButton cogaiButton = new JRadioButton(strCogai);
        cogaiButton.setMnemonic('d');
        cogaiButton.setActionCommand(strCogai);


        // Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(flowerButton);
        group.add(coffeeButton);
        group.add(cogaiButton);

        // Register a listener for the radio buttons.
        RadioListener myListener = new RadioListener();
        flowerButton.addActionListener(myListener);
        coffeeButton.addActionListener(myListener);
        cogaiButton.addActionListener(myListener);

        // Set up the picture label
        picture = new JLabel(new ImageIcon("images/flower.gif"));

        // The preferred size is hard-coded to be the width of the
        // widest image and the height of the tallest image.
        // A real program would compute this.
        picture.setPreferredSize(new Dimension(177, 122));


        // Put the radio buttons in a column in a panel
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(0, 1));
        radioPanel.add(flowerButton);
        radioPanel.add(coffeeButton);
        radioPanel.add(cogaiButton);

        setLayout(new BorderLayout());
        add(radioPanel, BorderLayout.WEST);
        add(picture, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

    }


    /** Listens to the radio buttons. */
    class RadioListener implements ActionListener
	 { 
    	public void actionPerformed(ActionEvent e)
	 	{
   		picture.setIcon(new ImageIcon("images/" 
                                          + e.getActionCommand() 
                                          + ".gif"));
      }
    }

    public void test()
	 {frame = new JFrame("RadioButtonDemo");
        frame.addWindowListener(new WindowAdapter()
			 {
             public void windowClosing(WindowEvent e) 
					{
						System.exit(0);
					}
         });
 
        frame.getContentPane().add(new RadioButtonDemo(), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
	   }	

}
public class Main
 {  public static void main(String s[])
	 {
        (new RadioButtonDemo()).test();

     }
 }
