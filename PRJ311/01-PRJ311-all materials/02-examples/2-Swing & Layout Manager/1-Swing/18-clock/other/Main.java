import java.io.*;
class MyUtil
 {static public String getClock()
   {java.util.Calendar c = java.util.Calendar.getInstance();
    int ho,mi,se;
    ho = c.get(c.HOUR);
    mi = c.get(c.MINUTE);
    se = c.get(c.SECOND);
    String s = "" + ho + ":" + mi + ":" + se;
    return(s); 
   }
 }
public class Main
 {public static void main(String args[]) throws Exception
   {
    System.out.println(" current time = " + MyUtil.getClock());
   }
 }
