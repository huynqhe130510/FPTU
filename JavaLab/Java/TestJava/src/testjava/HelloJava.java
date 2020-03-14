/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testjava;

import java.awt.Color;
import javafx.scene.text.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author NQH
 */
public class HelloJava extends JFrame {

    public HelloJava() {
        JLabel label = new JLabel("Hello Java", SwingConstants.CENTER);
        label.setForeground(Color.black);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(label);
    }

    public static void main(String[] args) {
        new HelloJava().setVisible(true);
    }

}
