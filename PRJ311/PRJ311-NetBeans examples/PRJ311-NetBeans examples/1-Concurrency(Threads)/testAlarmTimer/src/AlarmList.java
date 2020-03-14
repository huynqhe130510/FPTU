import java.util.*;
public class AlarmList {
 ArrayList<Alarm> t;
 AlarmList() {
   t = new ArrayList<Alarm>();  
 }
 boolean isEmpty() {
   return(t.isEmpty());  
 }
 void clear() {
   t.clear();  
 }
 void add(Alarm x) {
   t.add(x);  
 }
 Alarm get(int i) {
   return(t.get(i));  
 } 
 int size() {
   return(t.size());  
 }
 void display() {
   int i,n; n=size();
   Alarm x;
   for(i=0;i<n;i++) {
     x = get(i);
     System.out.println(x);
   }
 }
}
