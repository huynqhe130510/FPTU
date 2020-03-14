package js_demo;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageDemo extends JFrame {

    public ImageDemo() {
        setSize(400, 250);
//      setVisible(true);
        setLocation(500, 300);//đặt vị trí của frame
        setResizable(true);//kéo khung
        JLabel label = new JLabel();
        add(label);
        label.setSize(350, 250);
        System.out.println("x: " + label.getSize().width + " y: " + label.getSize().height);

        try {
            BufferedImage image = ImageIO.read(new File("tt.jpg"));
            int x = label.getSize().width;
            int y = label.getSize().height;
            int ix = label.getSize().width;
            int iy = label.getSize().height;

            int dx = 0;
            int dy = 0;
            if (x / y > ix / iy) {
                dy = y;
                dx = dy * ix / iy;
            } else {
                dx = x;
                dy = dx * iy / ix;
            }

            ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, Image.SCALE_SMOOTH));//tạo ảnh
            label.setIcon(icon);//tạo ảnh
        } catch (IOException ex) {
            Logger.getLogger(ImageDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        ImageDemo imagedemo = new ImageDemo();
        imagedemo.setVisible(true);
    }

}
