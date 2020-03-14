package js_demo;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JS_Demo extends JFrame {

    public JS_Demo() {
        setSize(500, 200);
//      setVisible(true);
        setLocation(500, 300);//đặt vị trí của frame
        setResizable(false);//kéo khung
        JLabel label = new JLabel("Hello World");
        add(label);
    }

    public static void main(String[] args) {
        JS_Demo hello = new JS_Demo();
        hello.setVisible(true);
    }

}
