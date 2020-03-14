import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class CardLayoutManager extends JFrame 
                               implements ItemListener {

    // Object fields
    private      JPanel cardsPanel;
    final static String BUTTONPANEL = "JPanel with JButtons";
    final static String TEXTPANEL   = "JPanel with JTextField";

    public CardLayoutManager() {

        // ----------------------------
        // Call super class constructor
        // ----------------------------
        super("CardLayout Manager Example");

        // ----------------------------------------------------------------
        // Get the frame's content pane. It is not neccessary to set the 
        // layout manager to BorderLayout (as I did below) since BorderLayout
        // is the default for the frame's content pane.
        // ----------------------------------------------------------------
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // --------------------------------------
        // Put the JComboBox in a seperate JPanel
        // --------------------------------------
        JPanel    comboBoxPanel = new JPanel();
        String    comboBoxItems[] = {BUTTONPANEL, TEXTPANEL};
        JComboBox comboBox = new JComboBox(comboBoxItems);
        comboBox.setEditable(false);
        comboBox.addItemListener(this);
        comboBoxPanel.add(comboBox);

        // ---------------------------------------------------
        // Add the JComboBox Panel to the frame's content pane
        // ---------------------------------------------------
        contentPane.add(comboBoxPanel, BorderLayout.NORTH);

        // -----------------------------------------------------------------
        // Make a JPanel for the cards. This panel will be visiable to other 
        // methods.
        // -----------------------------------------------------------------
        cardsPanel = new JPanel();
        cardsPanel.setLayout(new CardLayout());

        JPanel p1 = new JPanel();
        p1.add(new JButton("Button 1"));
        p1.add(new JButton("Button 2"));
        p1.add(new JButton("Button 3"));

        JPanel p2 = new JPanel();
        p2.add(new JTextField("TextField", 20));

        // --------------------------------------------------------------------
        // Add all of the JPanel components you want to the stack. In our case,
        // we created 2 JPanel components that will be added.
        // --------------------------------------------------------------------
        cardsPanel.add(p1, BUTTONPANEL);
        cardsPanel.add(p2, TEXTPANEL);

        // -----------------------------------------------
        // Add the Cards Panel to the frame's content pane
        // -----------------------------------------------
        contentPane.add(cardsPanel, BorderLayout.CENTER);

        // ------------------------------------------------------------
        // Window listener to close application when Window gets closed
        // ------------------------------------------------------------
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cardsPanel.getLayout());
        cl.show(cardsPanel, (String)evt.getItem());
    }

}
public class Main
{   public static void main(String[] args) {
        CardLayoutManager mainFrame = new CardLayoutManager();
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
}
