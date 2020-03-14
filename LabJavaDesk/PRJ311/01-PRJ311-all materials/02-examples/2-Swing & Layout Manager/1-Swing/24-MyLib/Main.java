class MyLib
 {String reverse(String s)
   {StringBuffer r = new StringBuffer(s);
    String s1 = r.reverse().toString();
    return(s1);
   }
  String reverse2(String s)
   {int n = s.length();
    String s1 = "";
    for(int i=0;i<n;i++) s1 += s.charAt(n-1-i); 
    return(s1);
   }
  String myClock()
   {java.util.Calendar t = java.util.Calendar.getInstance();
    int ho,mi,se;
    ho = t.get(java.util.Calendar.HOUR_OF_DAY);
    mi = t.get(java.util.Calendar.MINUTE);
    se = t.get(java.util.Calendar.SECOND);
    String s = "" + ho + ":" + mi + ":" + se;
    return(s);
   }
 }
public class Main
 {public static void main(String[] args)
   {MyLib h = new MyLib();
    String s = "ABCD";
    String s1 = h.reverse(s);
    String s2 = h.reverse2(s);
    System.out.println(s1);
    System.out.println(s2);
    System.out.println(" The current time is " + h.myClock());
   }
}