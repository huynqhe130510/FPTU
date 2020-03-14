package exer;

import java.util.*;


public class Exer {

    String s;

    public Exer(String s) {
        this.s = s;
    }

    public int Count() {
        int count = 0;
        String[] words = this.s.split(" ");
        for (String word : words) {
            if (word.length() <= 5) {
                count++;
            }
        }
        return count;
    }

    boolean check(String s) {
        int a = 0;
        int b = 0;
        int c = 0;
        if (s.length() >= 4) {
            a = 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.codePointAt(i) > 64 && s.codePointAt(i) < 91) {
                b = 2;
            }
        }
        String special = "!@#$%^&*()";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < special.length(); j++) {
                if (s.charAt(i) == special.charAt(j)) {
                    c = 3;
                }
            }
        }
        if (a == 1 && b == 2 && c == 3) {
            return true;
        }
        return false;
    }

    int f1() {
        String[] s1 = s.split("\\s+");
        int count = 0;
        for (int i = 0; i < s1.length; i++) {
            if (check(s1[i])) {
                count++;
            }
        }
        return count;
    }

    public String f11() {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isLowerCase(s.charAt(i))) {
                result += Character.toUpperCase(s.charAt(i));
            } else if (Character.isUpperCase(s.charAt(i))) {
                result += Character.toLowerCase(s.charAt(i));
            } else {
                result += s.charAt(i);
            }
        }
        return result;
    }

    public String f12() {
        int count = 0;
        String[] s1 = s.split("\\s+");
        for (int i = 0; i < s1.length; i++) {
            if (check(s1[i])) {
                count = i;
                break;
            }   
        }
        return s1[count];
    }
    
        //    public int CountMyKey() {
        //        int count = 0;
        //        String[] words = this.s.split("\\s+");
        //        for (String word : words) {
        //            if (word.length() >= 4 ) {
        //                for (int i = 0; i < word.length(); i++) {
        //                    if(Character.isUpperCase(word.charAt(i))){
        //                        for (int j = 0; j < word.length(); j++) {
        //                            if(!(Character.isDigit(word.charAt(i))) && !(Character.isAlphabetic(word.charAt(j))))
        //                                count++;
        //                        }
        //                    }
        //                }
        //            }
        //        }
        //     return count;   
        //    }
    public static void main(String[] args) {
        System.out.println("Enter String: ");
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        Exer m = new Exer(n);
        System.out.println("So tu co do dai lon nhat bang 5: " + m.Count());
        System.out.println("So MyKeyWord: " + m.f1());
        System.out.println("Tu dau tien la MyKeyWord: " + m.f12());
        System.out.println("Chuoi moi sau khi dao: " + m.f11());
    }

}
