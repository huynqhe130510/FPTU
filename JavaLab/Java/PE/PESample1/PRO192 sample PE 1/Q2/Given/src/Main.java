// ======= DO NOT EDIT MAIN FUNCTION ============
import java.io.*;
import java.util.*;
public class Main {
    
   /*public static void OutputList(List<Printer> c) {
       for(Printer x : c) {
           System.out.println(x.getName());
       }
   }  
    
   public static void main(String args[]) throws Exception {
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       List<Printer> a = new ArrayList();
       a.add(new Printer("HP 200J", 110));
       a.add(new Printer("HP 2000G", 150));
       a.add(new Printer("Canon G1240", 120));
       System.out.print("Add more how many printer: ");
       int n = Integer.parseInt(in.readLine());
       for(int i = 0; i < n; i++){
           System.out.println("");
           System.out.print("Printer name: ");
           String name = in.readLine();           
           System.out.print("Printer price: ");
           double price = Double.parseDouble(in.readLine());             
           a.add(new Printer(name, price));
       }
       System.out.println("");
       System.out.print("Enter test function (1-f1;2-f2): ");
       int c = Integer.parseInt(in.readLine());
       IPrinter i = new MyPrinter();
       double givenPrice = 0;
       String givenName = "";
       if(c == 1) {
           System.out.print("Enter given printer price: ");
           givenPrice = Double.parseDouble(in.readLine());
       }else if (c == 2) {
            System.out.print("Enter given printer name: ");
            givenName = in.readLine();
       }
       System.out.println("");
       System.out.println("OUTPUT:");    
       if(c == 1) {
           i.f1(a, givenPrice);
           OutputList(a);
       }
       else if(c == 2) {
          System.out.println(i.f2(a,givenName));  
       }
   }*/
   static void display(List<Printer> a){
       for(int i=0;i<a.size();i++){
           System.out.println(a.get(i));
       }
       System.out.println("");
   }
   public static void main(String args[]){
       ArrayList<Printer> a =new ArrayList<Printer>();
       a.add(new Printer("A",7));
       a.add(new Printer("B",9));
       a.add(new Printer("C",6));
       a.add(new Printer("D",9)); 
       display(a);
       MyPrinter t = new MyPrinter();
       t.f3(a);
       display(a);
       a.clear();
       a.add(new Printer("aBxy",1));
       a.add(new Printer("aABy",2));
       a.add(new Printer("Abx",3));
       display(a);
       t.f4(a, "ab");
       display(a);
   }
  
 }
