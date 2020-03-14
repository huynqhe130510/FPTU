
import java.util.*;

public class Exer1 {

    private static class Mysort {

        public Mysort() {

        }

        boolean CheckPrime(int n) {
            if (n < 2) {
                return false;
            } else {
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        return false;
                    }
                }
                return true;
            }
        }
        
        int sum(int n){
            int sum = 0;
            while(n >0){
                sum += n%10;
                n/=10;
            }
            return sum;
        }
        
        boolean doixung(int n){
            String s = "" ;
            while( n!=0){
                s += n%10;
                n/=10;
            }
            
            for (int i = 0; i < s.length(); i++) {
                for (int j = s.length()-1; j >=0; j--) {
                    if(s.charAt(i) == s.charAt(j)){
                        return true;
                    }
                }
            }
            return false;
        }

        void f1(ArrayList<Integer> a, int type) {
            if (type == 1) {
//                for (int i = 0; i < a.size(); i++) {
//                    for (int j = i + 1; j < a.size(); j++) {
//                        if (CheckPrime(a.get(i)) && CheckPrime(a.get(j))) {
//                            if(a.get(i) > a.get(j)){
//                                int temp = a.get(j);
//                                a.set(j, a.get(i));
//                                a.set(i, temp);
//                            }
//                        }
//                    }
//                }
                ArrayList<Integer> Prime = new ArrayList<>();
                for (int i = 0; i < a.size(); i++) {
                    if (CheckPrime(a.get(i))) {
                        Prime.add(a.get(i));
                    }
                }
                Collections.sort(Prime, (o1, o2) -> (o2 - o1));
                int k = 0;
                for (int i = 0; i < a.size(); i++) {
                    if (CheckPrime(a.get(i))) {
                        a.set(i, Prime.get(k ++));
                    }
                }
            }

            if (type == 2) {
                for (int i = 0; i < a.size(); i++) {
                    for (int j = i + 1; j < a.size(); j++) {
                        if (CheckPrime(a.get(i)) && CheckPrime(a.get(j))) {
                            if (a.get(i) < a.get(j)) {
                                int temp = a.get(j);
                                a.set(j, a.get(i));
                                a.set(i, temp);
                            }
                        }
                    }
                }
            }

            if (type == 3) {
                for (int i = 0; i < a.size(); i++) {
                    for (int j = 0; j < a.size(); j++) {
                        if (a.get(i) % 2 == 0 && a.get(i) > 0 && a.get(j) % 2 == 0 && a.get(j) > 0) {
                            if (a.get(i) < a.get(j)) {
                                int temp = a.get(j);
                                a.set(j, a.get(i));
                                a.set(i, temp);
                            }
                        }
                    }
                }
            }

            if (type == 4) {
                for (int i = 0; i < a.size(); i++) {
                    for (int j = 0; j < a.size(); j++) {
                        if (a.get(i) % 2 == 0 && a.get(i) < 0 && a.get(j) % 2 == 0 && a.get(j) < 0) {
                            if (a.get(i) < a.get(j)) {
                                int temp = a.get(j);
                                a.set(j, a.get(i));
                                a.set(i, temp);
                            }
                        }
                    }
                }
            }

            if (type == 5) {
                Collections.reverse(a);
            }

            if (type == 6) {
                ArrayList<Integer> b = new ArrayList<>();
                for (int i = 1; i < a.size(); i++) {
                    if (i % 2 == 0) {
                        b.add(a.get(i));
                    }
                }
                Collections.reverse(b);
                int k =0;
                for (int i = 1; i < a.size(); i++) {
                    if(i%2==0){
                        a.set(i, b.get(k++));
                    }
                }
                
            }
            
            if(type == 7){
                for (int i = 0; i < a.size(); i++) {
                    for (int j = 0; j < a.size(); j++) {
                        if (sum(a.get(i)) == 10 && sum(a.get(j)) == 10) {
                            if (a.get(i) < a.get(j)) {
                                int temp = a.get(j);
                                a.set(j, a.get(i));
                                a.set(i, temp);
                            }
                        }
                    }
                }
            }

            if(type == 8){
                for (int i = 0; i < a.size(); i++) {
                    for (int j = 0; j < a.size(); j++) {
                        if (doixung(a.get(i)) && doixung(a.get(j))) {
                            if (a.get(i) < a.get(j)) {
                                int temp = a.get(j);
                                a.set(j, a.get(i));
                                a.set(i, temp);
                            }
                        }
                    }
                }
            }
            
        }
    }

    public static void main(String[] args) {
        System.out.println("Nhap so phan tu cua list:");
        Scanner sc = new Scanner(System.in);
        ArrayList v = new ArrayList();
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("Cac phan tu la:");
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(sc.nextLine());
            v.add(x);
        }
        System.out.println(v);
        Mysort ms = new Mysort();
        System.out.println("Nhap type");
        int type = Integer.parseInt(sc.nextLine());
        ms.f1(v, type);
        System.out.println("OUTPUT:");
        System.out.println(v);

    }
}

// void f1(ArrayList<Integer>a, int type
// 1: sort tat ca cac so nguyen to theo thu tu tang dan
// 2: sort tat ca cac gia tri la so nguyen  to theo thu tu giam dan
// 3: sort tat ca cac so chan duong theo thu tu tang dan
// 4: sort tat ca cac gia tri la so chan am theo thu tu tang dan
// 5: reverse List a
// 6: reverse List a o vi tri chan
// 7: sort tat ca cac so co tong cac chu so = 10 theo thu tu tang dan
// 8: sort tat ca cac so doi xung theo thu tu giam dan
