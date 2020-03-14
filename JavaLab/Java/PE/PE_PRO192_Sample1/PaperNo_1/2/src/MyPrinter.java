

 
import java.util.*;

public class MyPrinter implements IPrinter { 

    @Override
    public void f1(List<Printer> a, double price) {
        int i;
        for(i=0;i<a.size();i++){
            if(a.get(i).price<=price){ 
                a.remove(i);
                i--;
            }
            
        }
    }
    

    @Override
    public int f2(List<Printer> a, String name) {
        int i;
        int count=0;
        for(i=0;i<a.size();i++){
            if(a.get(i).getName().toUpperCase().contains(name.toUpperCase())) count++; 
        }
        return count;
    }

   
    
    
     
}
