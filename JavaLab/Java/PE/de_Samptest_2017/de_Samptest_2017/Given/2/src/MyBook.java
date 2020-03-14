
import java.util.*;
//Your task is to complete this class 

public class MyBook implements IBook {

    //write the definition of method f1 here 
    @Override
    public String f1(ArrayList<Book> a) {
        String s = "";
        for (int i = 0; i < a.size(); i++) {
            if(i==0){
                s += a.get(i).getName();
            }
        }
        return s;
    }

    //write the definition of method f2 here 
    @Override
    public int f2(ArrayList<Book> a, int price) {
        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            int temp = a.get(i).getPrice();
            if(price < temp){
                count++;
            }
        }
        return count;

    }
}
