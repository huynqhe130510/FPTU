

 
import java.util.*;

public class MyMovie implements IMovie { 

    
    @Override
    public void f1(List<Movie> a, int len) {
        for(Movie m : a){
            if(m.length <= 120){
                m.length += len;
            }
        }
    }
    

    @Override
    public void f2(List<Movie> a) {
        Collections.sort(a);
    }
    
    @Override
    public int f3(List<Movie> a, int len) {
        int count = 0;
        for(Movie m:a){
            if(m.length >= len){
                count ++;
            }
        }
        return count;
    }
    
}
