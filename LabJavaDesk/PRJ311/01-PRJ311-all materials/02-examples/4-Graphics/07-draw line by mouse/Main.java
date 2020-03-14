// Import the basic necessary classes.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MousePanel extends JPanel implements MouseListener{

    public MousePanel(){
        super();
        pointX=20;
        pointY=20;
        oldX=0;
        oldY=0;
        addMouseListener(this);   
    }

    int pointX, pointY, oldX, oldY;

    public void paintComponent(Graphics g){
    // Draw a line from the prior mouse click to new one.
        g.drawLine(oldX,oldY,pointX,pointY);
    }

    public void mouseClicked(MouseEvent mouse){
    // Copy the last clicked location into the 'old' variables.
        oldX=pointX;
        oldY=pointY;
    // Get the location of the current mouse click.
        pointX = mouse.getX();
        pointY = mouse.getY();
    // Tell the panel that we need to redraw things.
        repaint();
    }

/* The following methods have to be here to comply
   with the MouseListener interface, but we don't
   use them, so their code blocks are empty. */

    public void mouseEntered(MouseEvent mouse){ }   
    public void mouseExited(MouseEvent mouse){ }
    public void mousePressed(MouseEvent mouse){ }
    public void mouseReleased(MouseEvent mouse){ }
}

public class Main {

    public static void main(String arg[]){
        JFrame frame = new JFrame("MousePanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250,250);

        MousePanel panel = new MousePanel();
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}

/*
public class Main
 {public static void main(String [] args)
   {JFrame t = new JFrame();
    MyPanel h = new MyPanel();
    t.setTitle("Test grapchics");
    t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    t.add(h);
    t.setSize(600,500);
    t.setVisible(true);

    System.out.println();  
   }

 }
*/
 