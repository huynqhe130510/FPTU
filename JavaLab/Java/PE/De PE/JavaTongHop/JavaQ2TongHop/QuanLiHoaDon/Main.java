package W2;

// ======= DO NOT EDIT MAIN FUNCTION ============
import java.io.*;
import java.util.*;

class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<HoaDon> a = new ArrayList();
        System.out.println("");
        System.out.print("Enter test function (1-f1;2-f2): ");
        int c = Integer.parseInt(in.readLine());
        IHOADON i = new QLHoaDon();
        while (c != 0) {
            System.out.println("OUTPUT:");
            if (c == 1) {
                i.f1(a);
            } else if (c == 2) {
                i.f2(a);
            }
            System.out.print("Enter test function (1-f1;2-f2): ");
            c = Integer.parseInt(in.readLine());
        }
    }
}
