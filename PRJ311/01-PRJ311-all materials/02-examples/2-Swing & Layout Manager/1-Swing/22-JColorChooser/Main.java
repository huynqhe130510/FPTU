import javax.swing.*;
import java.awt.*;

public class Main
 { public static void main(String[] args)
     { JColorChooser cc= new JColorChooser();
        Color c= cc.showDialog(null, "Select a color", Color.WHITE);

       System.out.println("The selected color is  " + c);
     }
 }
