import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Main
 { public static void main(String[] args)
     { JFileChooser fc= new JFileChooser();
        // "user.dir" means that the currently working directory is shown at openning
       fc.setCurrentDirectory(new File(System.getProperty("user.dir")));

       try {
            int result= fc.showOpenDialog(null);
            if (result==JFileChooser.APPROVE_OPTION)
              { File f= fc.getSelectedFile();
                System.out.println("The selected filer is  " + f.getName());
              }
         } catch(Exception e) {}
     }
 }
