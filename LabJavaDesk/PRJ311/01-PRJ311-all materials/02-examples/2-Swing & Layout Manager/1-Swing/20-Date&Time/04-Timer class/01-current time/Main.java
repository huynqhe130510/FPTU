import java.util.Calendar;
class Main 
 {public static String getCurrTime()
   {Calendar now = Calendar.getInstance();
    int h = now.get(Calendar.HOUR_OF_DAY);
    int m = now.get(Calendar.MINUTE);
    int s = now.get(Calendar.SECOND);
    return("" + h + ":" + m + ":" + s);
   }
  public static void main(String [] args)
   {
    System.out.println(" Current time: " + getCurrTime());
    long k = Calendar.getInstance().getTimeInMillis();
    System.out.println(" Current time in seconds: " + k);
    System.out.println(" Current time in seconds: " + System.currentTimeMillis());
   }
  }