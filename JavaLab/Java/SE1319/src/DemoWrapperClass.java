import java.util.Scanner;

public class DemoWrapperClass {
    static int tong(String s1, String s2){
        int i = Integer.parseInt(s1);
        int j = Integer.parseInt(s2);
        int s=0;
        s = i+j;
        //gia su s1,s2 la chuoi so nguyen sieu lon
        //ting tong s1+s2 ket qua tra ve ham tong
        return s;
    }
    static int tich(String s1, int n){
        int i = Integer.parseInt(s1);
        int tich = i*n;
        //gia su s1,s2 la chuoi so nguyen sieu lon
        //tinh nhan s1 voi n, kq tra ve ham tich cua s1 va n
        return tich;
    }
    static int tich2(String s1, String s2){
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int tich2 = a*b;
            //return s1*s2
            return tich2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String 1: ");
        String s1 = sc.nextLine(); 
        System.out.print("Enter String 2: ");
        String s2 = sc.nextLine();    
        int tong = DemoWrapperClass.tong(s1, s2);
        System.out.println("Tong s1 + s2 : " +tong );
        int tich2 = DemoWrapperClass.tich2(s1, s2);
        System.out.println("Tich s1 x s2 : "+ tich2);
        System.out.print("Nhap n: ");
        int n;
        n = sc.nextInt();
        int tich = DemoWrapperClass.tich(s1, n);
        System.out.println("Tich s1 x n : " +tich);   
    }
}