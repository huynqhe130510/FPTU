import javax.swing.*;
public class Main {

    public static void main(String[] args) {
     MyPanel t = new MyPanel();
     JFrame f = new JFrame();
     f.setSize(600,500);
     f.add(t);
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     f.setVisible(true);
    }
    
}
