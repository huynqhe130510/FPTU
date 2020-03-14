import java.io.File;
public class Main
    {
       public static void main(String args[])
           { File f = new File("thu.txt");  
             if(f.exists())
               System.out.println("The file "+ f.getName() + " already exists.");
               else
               System.out.println("The file "+ f.getName() + " does not exist.");
           } 
    }
