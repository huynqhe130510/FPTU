package js_demo;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ConfirmDialogDemo extends JFrame{

    
    public ConfirmDialogDemo() {
        setSize(500, 200);
//      setVisible(true);
        setLocation(500, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Demo Message");
        add(label);

        JButton button = new JButton("Hit me");
        add(button, "North", 1);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//               int click = JOptionPane.showConfirmDialog(null, "Is Ducky handsome ?");
//               if(click == JOptionPane.YES_OPTION){
//                   JOptionPane.showMessageDialog(null, "Click yes");
//               }
//               if(click == JOptionPane.NO_OPTION){
//                   JOptionPane.showMessageDialog(null, "Click no");
//               }
//               if(click == JOptionPane.CANCEL_OPTION){
//                   JOptionPane.showMessageDialog(null, "Click cancel");
//               }
                JOptionPane.showConfirmDialog(null, "Is Ducky handsome", "Question", JOptionPane.YES_NO_OPTION);
            }
        });
    }

    public static void main(String[] args) {
        ConfirmDialogDemo con = new ConfirmDialogDemo();
        con.setVisible(true);
    }

}
