import java.util.*;
class Main 
 {public static void main(String [] args) throws Exception
   {Date d = new Date();

    System.out.println(" Year: " + (1900 + d.getYear()));
    System.out.println(" Month: " + (d.getMonth()+1));
    System.out.println(" Day of week: " + (d.getDay()+1));
    System.out.println(" Hour: " + d.getHours());
    System.out.println(" Minute: " + d.getMinutes());
    System.out.println(" Second: " + d.getSeconds());
    System.out.println(" Milli seconds from 1900: " + System.currentTimeMillis());

    System.out.println();
   }
  }

