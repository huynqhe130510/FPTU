import java.util.*;
class Main
 {public static void main(String args[])
   {
     String s = "AxyzBCxyzDxyz";
     String u = "xyz";
      int k = 0;int h;
      h = u.length();
      int count=0;
      while(true)
        { k = s.indexOf(u,k);
          if(k==-1) break;
            else
             { k = k+h;
               count++;
             }
         }
     System.out.println("count = " + count);
     System.out.println();
   }
 }
