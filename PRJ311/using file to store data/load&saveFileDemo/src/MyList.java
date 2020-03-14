
import java.util.*;
import java.io.*;

public class MyList {

    ArrayList<Emp> t;

    MyList() {
        t = new ArrayList<Emp>();
    }

    void clear() {
        t.clear();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void add(Emp x) {
        t.add(x);
    }

    void display() {
        for (int i = 0; i < t.size(); i++) {
            System.out.print(t.get(i));
        }
        System.out.println();
    }

    void loadFile(String fname) throws IOException {
        RandomAccessFile f = new RandomAccessFile(fname, "r");
        String s;
        String[] a;
        String xName;
        int xAge;
        double xSal;
        Emp x;
        while (true) {
            s = f.readLine();
            if (s == null || s.trim().equals("")) {
                break;
            }
            a = s.split("[|]");
            xName = a[0].trim();
            xAge = Integer.parseInt(a[1].trim());
            xSal = Double.parseDouble(a[2].trim());
            x = new Emp(xName, xAge, xSal);
            add(x);
        }
        f.close();
    }

    void input() {
        Emp x;
        int n, i;
        Scanner t = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        n = t.nextInt();
        for (i = 0; i < n; i++) {
            x = new Emp();
            x.input();
            add(x);
        }
    }

    void saveFile(String fname) throws IOException {
        if (isEmpty()) {
            return;
        }
        File f = new File(fname);
        if (f.exists()) {
            f.delete();
        }
        RandomAccessFile g = new RandomAccessFile(fname, "rw");
        int n, i;
        Emp x;
        n = t.size();
        for (i = 0; i < n; i++) {
            x = t.get(i);
            g.writeBytes(x.name + " | " + x.age + " | " + x.sal + "\r\n");
        }
        g.close();
    }

}
