import java.util.*;
class FloatList
   {float a[];int n;
    void nhap()
      {Scanner s = new Scanner(System.in);
       System.out.print("\nSo phan tu can nhap n = ");
       n = s.nextInt();
       a = new float[n];
       System.out.print("\nHay nhap "+ n + " so thuc(cach nhau bang dau cach): ");
       for(int i = 0;i<n;i++)  a[i]=s.nextFloat();
      }    
    void xem()
      {System.out.print("\nDay cac so thuc da nhap la: ");
       for(int i = 0;i<n;i++)  System.out.print(a[i]+ "   ");
       System.out.println();
      }    
   }
class Main
   {public static void main(String args[])
        {FloatList d = new FloatList(); 
         d.nhap();
         d.xem();      
        }
   }