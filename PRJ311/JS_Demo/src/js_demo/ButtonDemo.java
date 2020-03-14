package js_demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ButtonDemo extends JFrame implements ActionListener {

    private JLabel label;
    private JButton button1;

    public ButtonDemo() {
        setSize(500, 200);
//      setVisible(true);
        setLocation(500, 300);//đặt vị trí của frame
        setResizable(false);//kéo khung
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//dừng chương trình khi đóng frame
        label = new JLabel("Study and Share");
        add(label);

        JButton button = new JButton("Hit me");//tạo button
        add(button, "North", 1);//đặt vị trí cho button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button");//khi nhấn button sẽ hiện ra "Button"

            }
        });

        button1 = new JButton("Hit me1");
        add(button1, "South", 1);
        button1.addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b == button1) {
            label.setText("Study and Share");
        }
    }

    public static void main(String[] args) {
        ButtonDemo button = new ButtonDemo();
        button.setVisible(true);
    }

}
