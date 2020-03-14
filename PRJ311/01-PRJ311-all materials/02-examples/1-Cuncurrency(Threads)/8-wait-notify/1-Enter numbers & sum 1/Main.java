import java.util.*;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> t = new ArrayList<Integer>();
    OutputThread u = new OutputThread(t);
    InputThread v = new InputThread(t,u);
    u.setName("La");
    v.setName("Hoa");
    u.start();
    v.start();
    System.out.println();
   }
 }
