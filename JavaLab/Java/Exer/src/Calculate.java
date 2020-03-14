
import java.util.ArrayList;
import java.util.Scanner;

public class Calculate {

    public String f3(String s) {
        char[] a;
        String b="";
        a = s.toCharArray();
        int i;
        for (i = 0; i < a.length; i++) {
            if (Character.isAlphabetic(a[i])) {
                if (a[i]=='a') {
                    b=b+'0';
                } else if (a[i] == 'e') {
                    b=b+ '1';
                } else if (a[i] == 'i') {
                    b=b+'2';
                } else if (a[i] == 'o') {
                   b=b+'3';
                } else if (a[i] == 'u') {
                    b=b+'4';
                } else if (a[i] == 'A') {
                    b=b+'5';
                } else if (a[i] == 'E') {
                    b=b+'6';
                } else if (a[i] == 'I') {
                   b=b+'7';
                } else if (a[i] == 'O') {
                    b=b+'8';
                } else if (a[i] == 'U') {
                    b=b+'9';
                }
                else{
                    b=b+a[i];
                }
            } else if (Character.isDigit(a[i])) {
                if (a[i] == '0') {
                    b=b+'a';
                }
                else if (a[i] == '1') {
                    b=b+'e';
                }
                else if (a[i] == '2') {
                   b=b+'i';
                }
                else if (a[i] == '3') {
                    b=b+'o';
                }
                else if (a[i] == '4') {
                    b=b+'u';
                }
                else if (a[i] == '5') {
                    b=b+'A';
                }
                else if (a[i] == '6') {
                    b=b+ 'E';
                }
                else if (a[i] == '7') {
                    b=b+'I';
                }
                else if (a[i] == '8') {
                   b=b+'O';
                }
                else if (a[i] == '9') {
                    b=b+'U';
                }
                else
                {
                    b=b+a[i];
                }
            }
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculate c = new Calculate();
        String s = sc.nextLine();
        System.out.println(c.f3(s));
        //System.out.println(c.change(s));
    }
}
