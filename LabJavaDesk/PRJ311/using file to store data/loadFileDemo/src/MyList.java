
import java.util.*;
import java.io.*;

public class MyList {

    ArrayList<Employee> t;

    MyList() {
        t = new ArrayList<Employee>();
    }

    void clear() {
        t.clear();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void traverse() {
        for (int i = 0; i < t.size(); i++) {
            System.out.print(t.get(i));
        }
        System.err.println();
    }

    void loadFile(String fname) throws IOException {
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        String s;
        String[] a;
        String xName;
        int xAge;
        double xIncome;
        while (true) {
            s = f.readLine();
            if (s == null || s.trim().length() < 3) {
                break;
            }
            a = s.split("[|]");
            xName = a[0].trim();
            xAge = Integer.parseInt(a[1].trim());
            xIncome = Double.parseDouble(a[2].trim());
            t.add(new Employee(xName, xAge, xIncome));
        }
        f.close();
    }
}
