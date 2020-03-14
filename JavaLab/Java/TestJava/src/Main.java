import java.io.*;
import java.util.*;
class Main {
   public static void main(String args[]) throws Exception {
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       System.out.print("Enter number of Laptop: ");
       int n = Integer.parseInt(in.readLine());
       ArrayList<Laptop> a = new ArrayList();      
       for(int i = 0; i < n; i++){
           System.out.println("");
           System.out.print("Laptop name: "); 
           String name = in.readLine();           
           System.out.print("Size of hdd: ");
           int HDD = Integer.parseInt(in.readLine());          
           a.add(new Laptop(name,HDD));
       }
       System.out.println(""); 
       System.out.print("Enter test function (1-f1;2-f2): ");
       int c = Integer.parseInt(in.readLine());
       ILaptop i = new MyLaptop();
       System.out.println("OUTPUT:");    
       if(c == 1)
          System.out.println(i.f1(a));       
       else if(c == 2)
          System.out.println(i.f2(a));
   }
 }
