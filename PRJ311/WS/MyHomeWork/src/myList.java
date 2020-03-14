import java.util.*;
import java.awt.*;

public class myList {
    ArrayList<Color> t;
    myList(){
        t = new ArrayList<Color>();
    }
    
    void clear(){
        t.clear();
    }
    
    boolean isEmpty(){
        return(t.isEmpty());
    }
    
    int search(Color x){
        Color y;
        int n, i;
        n = t.size();
        for (i = 0; i < n; i++) {
            y = (Color) t.get(i);
            if(y==x) return i;
        }
        return -1;
    }
    
    void add(Color x){
        t.add(x);
    }
    
    Color get(int i){
        return t.get(i);
    }
    
    int size(){
        return t.size();
    }
}
