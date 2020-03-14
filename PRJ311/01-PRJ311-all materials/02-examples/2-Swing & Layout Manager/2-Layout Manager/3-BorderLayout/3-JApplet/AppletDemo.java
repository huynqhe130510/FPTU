import java.awt.*;
import javax.swing.*;
public class AppletDemo extends JApplet
  { 
    public void init() 
      { setBackground(Color.cyan);
        setForeground(Color.blue);
        JButton btnDong, btnTay, btnNam, btnBac, btnTam;
        btnDong = new JButton("DONG");
        btnTay = new JButton("TAY");
        btnNam = new JButton("NAM");
        btnBac = new JButton("BAC");
        btnTam = new JButton("TrungTam");
        add(btnDong, BorderLayout.LINE_END);
        add(btnTay, BorderLayout.LINE_START);
        add(btnNam, BorderLayout.PAGE_END);
        add(btnBac, BorderLayout.PAGE_START);
        add(btnTam, BorderLayout.CENTER);
      }
  }
