package  Q2;

 
import java.util.*;

public class MyPrinter implements IPrinter { 

    @Override
    public void f1(List<Printer> a, double price) {
        Printer P;
        for(int i = a.size() -1; i >= 0; i--){
            P = a.get(i);
            if(price > P.price){
                a.remove(P);
                i++;
            }
        }
    }
    

    @Override
    public int f2(List<Printer> a, String name) {
        int count = 0;
        for(Printer P: a){
            if(P.name.toUpperCase().contains(name.toUpperCase())){
                count++;
            }
        }
        return count;
    }

   
    
    
     
}
