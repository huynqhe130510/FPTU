/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package js_demo;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JFrame;

/**
 *
 * @author NQH
 */
public class LabelDemo extends JFrame{

    public LabelDemo() {
        setSize(500, 200);
//      setVisible(true);
        setLocation(500, 300);//đặt vị trí của frame
        setResizable(false);//kéo khung
        JLabel label = new JLabel("Study and Share");
        add(label);
        
        label.setText("Viet Nam");//đặt label mới
        label.setToolTipText("A beautiful");//chú thích của label
        label.setForeground(Color.blue);
    }

    public static void main(String[] args) {
        LabelDemo LabelDemo = new LabelDemo();
        LabelDemo.setVisible(true);
    }
}
