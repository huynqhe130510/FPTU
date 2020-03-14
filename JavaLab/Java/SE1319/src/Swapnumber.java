
class MyNumber {

    int x, y;
}

public class Swapnumber {

    void swap(int a, int b) {
        int t = a;
        a = b;
        b = t;
        a++;
        b--;
    }

    void swap(MyNumber m) {
        m.x = m.x ^ m.y;
        m.y = m.x ^ m.y;
        m.x = m.x ^ m.y;
    }

    int sum(int... x) {
        int t = 0;
        for (int i : x) {
            t += i;
        }
        return t;
    }

    public static void main(String[] args) {
        Swapnumber sn = new Swapnumber();
        System.out.println("tTong tu 1 den 9 la " + sn.sum(1, 2, 3, 4, 5, 6, 7, 8, 9));
//        int a=10,b=20;
//        sn.swap(a, b);
//        System.err.println("sau khi doi cho a= "+a+"b="+b);
    }
}
