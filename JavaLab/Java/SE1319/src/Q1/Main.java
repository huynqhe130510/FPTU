package Q1;

import java.util.Scanner;

public class Main {

    public String f1(String s) {
        int strLeng = s.length() - 1;
        String reverse = "", temp = "";
        for (int i = 0; i <= strLeng; i++) {
            temp += s.charAt(i);
            if ((s.charAt(i) == ' ') || (i == strLeng)) {
                for (int j = temp.length() - 1; j >= 0; j--) {
                    reverse += temp.charAt(j);
                    if ((j == 0) && (i != strLeng)) {
                        reverse += " ";
                    }
                }
                temp = "";
            }
        }
        return reverse;
    }

    public int f3(String s) {
        int tong = 0;
        for (int i = 0; i < s.length(); i++) {
            int so = 0;
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int j = 0;
                for (j = i;; j++) {
                    if (j >= s.length() || s.charAt(j) < '0' || s.charAt(j) > '9') {
                        break;
                    }
//                    so = so * 10 + s.charAt(j) - 48;
                }
//                so = Integer.parseInt(s.substring(i, j));
                so = new Integer(s.substring(i, i));
                i = j;
            }
            tong += so;
        }
        return tong;
    }

    public int f2(String s) {
        int tong = 0;
        String[] s1 = s.split("\\s+");
        for (int i = 0; i < s1.length; i++) {
            if (check(s1[i])) {
                tong++;
            }
        }
        return tong;
    }

    private boolean check(String s) {
        char[] vovel = {'a', 'e', 'i', 'o', 'u', 'y'};
        s = s.toLowerCase();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < vovel.length; j++) {
                if (s.charAt(i) == vovel[j]) {
                    count++;
                }
            }
        }
        return count == 2;
    }

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chuoi string s");
        String s = sc.nextLine();
        System.out.println("OUTPUT");
        System.out.println(m.f1(s));
//        System.out.println(m.f2(s));
//        System.out.println(m.f3(s));
    }

}
