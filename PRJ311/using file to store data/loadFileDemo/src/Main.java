
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String fname = "emp.txt";
        MyList u = new MyList();
        u.loadFile(fname);
        u.traverse();
        System.out.println();
    }

}
