package Exercise;

import java.util.Scanner;

public class Class {

    String s;

    public Class() {
    }

    public Class(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public StringBuilder reverseWord() {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = this.s.split(" ");
        for (int j = words.length - 1; j >= 0; j--) {
            stringBuilder.append(words[j]).append(' ');
        }
        return stringBuilder;
    }

    public StringBuffer reverseChar() {
        StringBuffer buffer = new StringBuffer(this.s);
        return buffer.reverse();
    }

    public void evenChar() {
        for (int i = 0; i < this.s.length(); i++) {
            if (i % 2 == 1) {
                System.out.print(this.s.charAt(i));
            }
        }
        System.out.println("");
    }

    public void evenWord() {
        String[] words = this.s.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (i % 2 == 1) {
                System.out.print(words[i]);
            }
        }
        System.out.println("");
    }

    public int sumChar() {
        int sum = 0;
        for (int i = 0; i < this.s.length(); i++) {
            sum += this.s.charAt(i);
        }
        return sum;
    }

    public int sumNum() {
        int sum = 0;
        for (int i = 0; i < this.s.length(); i++) {
            if (Character.isDigit(this.s.charAt(i)) == true) {
                sum += (this.s.charAt(i) - 48);
            }
        }
        return sum;
    }

    public int sumNum2() {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int so = 0;
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int j = 0;
                for (j = i;; j++) {
                    if (j >= s.length() || s.charAt(j) < '0' || s.charAt(j) > '9') {
                        break;
                    }
                }
                so = new Integer(s.substring(i, j));
                i = j;
            }
            sum += so;
        }
        return sum;
    }

    public int count() {
        int count = 0;
        String[] words = this.s.split("\\s+");
        for (String word : words) {
            int c = 0;
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == 'u' || word.charAt(j) == 'U'
                        || word.charAt(j) == 'e' || word.charAt(j) == 'E'
                        || word.charAt(j) == 'o' || word.charAt(j) == 'O'
                        || word.charAt(j) == 'a' || word.charAt(j) == 'A'
                        || word.charAt(j) == 'i' || word.charAt(j) == 'I') {
                    c++;
                }

            }
            if (c >= 1) {
                count++;
            }
        }
        return count;
    }

    public int count1() {
        int count = 0;
        String[] words = this.s.split(" ");
        for (String word : words) {
            if (word.charAt(0) == 'u' || word.charAt(0) == 'U'
                    || word.charAt(0) == 'e' || word.charAt(0) == 'E'
                    || word.charAt(0) == 'o' || word.charAt(0) == 'O'
                    || word.charAt(0) == 'a' || word.charAt(0) == 'A'
                    || word.charAt(0) == 'i' || word.charAt(0) == 'I') {
                count++;
            }
        }
        return count;
    }

    public int count2() {
        int count = 0;
        String[] words = this.s.split(" ");
        for (String word : words) {
            if (word.charAt(word.length() - 1) == 'u' || word.charAt(word.length() - 1) == 'U'
                    || word.charAt(word.length() - 1) == 'e' || word.charAt(word.length() - 1) == 'E'
                    || word.charAt(word.length() - 1) == 'o' || word.charAt(word.length() - 1) == 'O'
                    || word.charAt(word.length() - 1) == 'a' || word.charAt(word.length() - 1) == 'A'
                    || word.charAt(word.length() - 1) == 'i' || word.charAt(word.length() - 1) == 'I') {
                count++;
            }
        }
        return count;
    }

    public int count3() {
        int count = 0;
        String[] words = this.s.split(" ");
        for (String word : words) {
            if (Character.isUpperCase(word.charAt(0))) {
                count++;
            }
        }
        return count;
    }

    public int count4() {
        int count = 0;
        String[] words = this.s.split(" ");
        for (String word : words) {
            if (Character.isLowerCase(word.charAt(0))) {
                count++;
            }
        }
        return count;
    }

    public int count5() {
        int count = 0;
        String[] words = this.s.split(" ");
        for (String word : words) {
            if (Character.isDigit(word.charAt(0))) {
                count++;
            }
        }
        return count;
    }

    public int count6() {
        int count = 0;
        String[] words = this.s.split(" ");
        for (String word : words) {
            if (Character.isUpperCase(word.charAt(word.length() - 1))) {
                count++;
            }
        }
        return count;
    }

    public int count7() {
        int count = 0;
        String[] words = this.s.split(" ");
        for (String word : words) {
            if (Character.isLowerCase(word.charAt(word.length() - 1))) {
                count++;
            }
        }
        return count;
    }

    public int count8() {
        int count = 0;
        String[] words = this.s.split(" ");
        for (String word : words) {
            if (Character.isDigit(word.charAt(word.length() - 1))) {
                count++;
            }
        }
        return count;
    }

    public int count9() {
        int count = 0;
        String[] words = this.s.split(" ");
        for (String word : words) {
            if (word.substring(0, word.length() / 2).equals(new StringBuffer(
                    word.substring(word.length() - (word.length() / 2))).reverse().toString())) {
                count++;
            }
        }
        return count;
    }

    public int count10() {
        int count = 0;
        String[] words = this.s.split(" ");
        for (String word : words) {
            if (word.length() <= 5) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Enter String: ");
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        Class m = new Class(n);
//        System.out.println("");
//        System.out.println("" + m.reverseWord());
//        System.out.println("" + m.reverseChar());
//        m.evenChar();
//        m.evenWord();
//        System.out.println("" + m.sumChar());
//        System.out.println("" + m.sumNum());
//        System.out.println("" + m.sumNum2());
        System.out.println("" + m.count());
//        System.out.println("" + m.count1());
//        System.out.println("" + m.count2());
//        System.out.println("" + m.count3());
//        System.out.println("" + m.count4());
//        System.out.println("" + m.count5());
//        System.out.println("" + m.count6());
//        System.out.println("" + m.count7());
//        System.out.println("" + m.count8());
//        System.out.println("" + m.count9());
//        System.out.println(""+ m.count10());
//    }
    }
}
