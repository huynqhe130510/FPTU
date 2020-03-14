package js_demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TextFieldDemo extends JFrame implements ActionListener {

    private JTextField tfName;
    private JButton bHit;

    public TextFieldDemo() {
        setSize(500, 200);
//      setVisible(true);
        setLocation(500, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tfName = new JTextField();
        add(tfName, "North", 0);

        bHit = new JButton("Hit me");
        add(bHit, "South", 0);
        bHit.addActionListener(this);
    }

    public static void main(String[] args) {
        TextFieldDemo text = new TextFieldDemo();
        text.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((JButton) e.getSource() == bHit) {
//            JOptionPane.showMessageDialog(null, tfName.getText());
            tfName.setText("Hello");
        }
    }

}
