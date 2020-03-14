package js_demo;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MessageDialogDemo extends JFrame{

    
    public MessageDialogDemo() {
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
                String name = "Ducky";
                JOptionPane.showMessageDialog(null,"Name: " + name, "Hey", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Name: " + name);
            }
        });
    }

    public static void main(String[] args) {
        MessageDialogDemo mess = new MessageDialogDemo();
        mess.setVisible(true);
    }

}
