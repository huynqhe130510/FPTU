
import java.util.Calendar;
import java.util.Random;


public class Main {

    
    public static void main(String[] args) throws Exception{
        
        int n = 50000;
        int []a = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(n);
        } 
        Sorting st = new Sorting();
        long start = Calendar.getInstance().getTimeInMillis();
        st.mergesort(a, 0, n);
        long end = Calendar.getInstance().getTimeInMillis();
        st.save(a, n);
        System.out.println("Time : " + (end - start));
    }
    
}
