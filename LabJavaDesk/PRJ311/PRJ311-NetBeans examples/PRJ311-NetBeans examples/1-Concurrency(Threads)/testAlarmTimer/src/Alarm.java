public class Alarm {
   int hour,minute,second;
   String message;
   Alarm() {
       
   }
   Alarm(int xHour, int xMinute, int xSecond, String xMessage) {
      hour=xHour;minute=xMinute;second=xSecond;message=xMessage; 
   }
   public String toString() {
     String  s = "" + hour + ":";
        s += minute + ":";
        s += second + ",";
        s += message;
        return(s);

   }
   public boolean equals(Object x) {
     Alarm y = (Alarm) x;
     return(hour==y.hour && minute==y.minute && second==y.second);
   }
}
