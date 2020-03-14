import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException  {
     String fname = "emp.txt";
     String fname1 = "emp1.txt";
     MyList t = new MyList();
     t.loadFile(fname);
     t.display();
     System.out.println();
     t.input();
     t.saveFile(fname1);
     t.loadFile(fname1);
     t.display();
     System.out.println();
     
     System.out.println();
    }
    
}
