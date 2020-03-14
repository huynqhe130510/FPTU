

 
import java.util.*;

public class MyMovie implements IMovie { 

    
    @Override
    public void f1(List<Movie> a, int len) {
       for(int i=0;i<a.size();i++){
           if(a.get(i).getLength()<=120) a.get(i).length+=len;
       }
    }
    

    @Override
    public void f2(List<Movie> a) {
        Comparator u= new Comparator<Movie>(){
           @Override
           public int compare(Movie x, Movie y){
               return x.getTitle().compareTo(y.getTitle());
            }
        };
        Collections.sort(a,u);
    }
    
    @Override
    public int f3(List<Movie> a, int len) {
       int count=0;
       for(int i=0;i<a.size();i++){
           if(a.get(i).getLength()>=len) count ++;
       }
       return count;
    }
    
}
