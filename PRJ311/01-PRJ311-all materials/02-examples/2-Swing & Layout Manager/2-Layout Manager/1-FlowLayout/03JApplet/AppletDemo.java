import java.awt.*;
import javax.swing.*;
public class AppletDemo extends JApplet
  { Label lblName = new Label("Name:");
    TextField txtName = new TextField(10);
    Button btnOk = new Button("Ok");
    public void init() 
      { setBackground(Color.cyan);
        setForeground(Color.blue);
        //setLayout(new FlowLayout());Khong can viet lenh nay vi FlowLayout la Layout ngam dinh cua Applet
        setLayout(new BorderLayout());
        add(lblName);
        add(txtName);
        add(btnOk);
      }
  }
