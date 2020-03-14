

 
import java.util.*;

public class MyPrinter implements IPrinter { 

    @Override
    public void f1(List<Printer> a, double price){ 
        int i;
        for(i=0;i<a.size();i++){
            if(a.get(i).price<price) {
                a.remove(i);
                i--;
            }
    }
    }
    @Override
    public int f2(List<Printer> a, String name) {
        int count=0;
        int i;
        for(i=0;i<a.size();i++){
           if(a.get(i).getName().toLowerCase().contains(name.toLowerCase())) count++;
        }
        return count;
    }
    
    public void f3(List<Printer> a){
        int i=0;
        double max=a.get(0).price;
        for(i=0;i<a.size();i++){
            if(a.get(i).price>max) max=a.get(i).price;
        }
        for(i=0;i<a.size();i++){
            if(a.get(i).price==max) {
                a.remove(i);
                break;
            }
        }
    }
    public void f4(List<Printer> a, String name){
        int i;
        for(i=0;i<a.size();i++){
            if(a.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                a.remove(i);
            }
        }
    }
}
