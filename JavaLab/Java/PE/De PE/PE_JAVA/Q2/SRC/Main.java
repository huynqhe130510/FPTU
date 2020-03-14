// ======= DO NOT EDIT MAIN FUNCTION ============
import java.io.*;
import java.util.*;
public class Main {
    
   public static void OutputList(List<Movie> c) {
       for(Movie x : c) {
           System.out.printf("%-20s%-10d\n",x.getTitle(),x.getLength());
       }
   }  
    
   public static void main(String args[]) throws Exception {
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       List<Movie> a = new ArrayList();
       a.add(new Movie("The Beep", 180));
       a.add(new Movie("Golden Bell", 115));
       a.add(new Movie("A Time", 110));
       System.out.print("Add more how many movie: ");
       int n = Integer.parseInt(in.readLine());
       for(int i = 0; i < n; i++){
           System.out.println("");
           System.out.print("Movie title: ");
           String title = in.readLine();           
           System.out.print("Movie length: ");
           int len = Integer.parseInt(in.readLine());             
           a.add(new Movie(title, len));
       }
       System.out.print("Enter test function (1-f1;2-f2;3-f3): ");
       int c = Integer.parseInt(in.readLine());
       IMovie i = new MyMovie();
       int len = 0;
       if(c == 1 || c == 3) {
           System.out.print("Enter given movie length: ");
           len = Integer.parseInt(in.readLine());
       }
       System.out.println("");
       System.out.println("OUTPUT:");    
       if(c == 1) {
           i.f1(a, len);
           OutputList(a);
       }
       else if(c == 2) {
          i.f2(a);
          OutputList(a);  
       } else if(c == 3) {
           System.out.println(i.f3(a, len));  
       }
   }
 }
