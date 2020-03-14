/*
 * Swing version.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FlowWindow extends JFrame {
    boolean inAnApplet = true;
     
    public FlowWindow() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
   
        contentPane.add(new JButton("Button 1"));
        contentPane.add(new JButton("2"));
        contentPane.add(new JButton("Button 3"));
        contentPane.add(new JButton("Long-Named Button 4"));
        contentPane.add(new JButton("Button 5"));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (inAnApplet) {
                    dispose();
                } else {
                    System.exit(0);
                }
            }
        });
    }

}
public class Main
    { public static void main(String args[]) {
        FlowWindow window = new FlowWindow();
        window.inAnApplet = false;

        window.setTitle("FlowLayout");
        window.pack();
        // window.setSize(500,200); /*do not need*/
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

