
import com.sun.xml.internal.ws.api.pipe.Fiber;
import java.io.File;

public class Main {

    static int sum(int n) {
        if (n <= 1) {
            return n;
        } else {
            return n + sum(n - 1);
        }
    }

    static void tail(int n) {
        if (n >= 0) {
            System.out.println(n + " ");
            tail(n - 1);
        }
    }

    static int min(int a[], int n) {
        if (n == 1) {
            return a[0];
        }
        if (a[0] > a[n - 1]) {
            a[0] = a[n - 1];
        }
        return min(a, n - 1);
    }

    static int mystery(int a, int b) {
        if (b == 0) {
            return 0;
        } else if (b % 2 == 0) {
            return mystery(a + a, b / 2);
        } else {
            return (mystery(a + a, b / 2) + a);
        }
    }

    static void list(String folder) {
        //get all files/dirs under given folder
        File[] files = new File(folder).listFiles();
        for (File f : files) {
            if (f.isFile()) {
                System.out.println(f.getName());
            } else {
                System.out.print("\t");
                list(f.getAbsolutePath());

            }
        }
    }

    public static void main(String[] args) {
        list("D:/Movie");
        

    }

}
