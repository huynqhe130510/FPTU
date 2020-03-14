package q2;


import java.util.*;
//Your task is to complete this class 

public class MyInvoice implements IInvoice {

    //write the definition of method f1 here 
    @Override
    public String f1(ArrayList<Invoice> a) {
        
        Collections.sort(a, new ComparatorImpl());
         return a.get(1).name;
    }

    //write the definition of method f2 here 
    @Override
    public int f2(ArrayList<Invoice> a) {
        int x= -1, y =-1;
        //find max amount
        for(Invoice iv :a){
            if(iv.amount > x){
                x = iv.amount;
            }
        }
        for(Invoice iv :a){
            if(iv.amount > y && y < x){
                y = iv.amount;
            }
        }
        
        Invoice iv;
        Iterator<Invoice> in = a.iterator();
        while(in.hasNext()){
            iv = in.next();
            if(iv.amount == x || iv.amount == y){
                in.remove();
            }
        }
        int sum = 0;
        for(Invoice i : a){
            sum += i.amount;
        }
        return sum;
    }
    
    
    //add and complete you other methods (if needed) here : use inner class 

    private static class ComparatorImpl implements Comparator<Invoice> {

        public ComparatorImpl() {
        }

        @Override
        public int compare(Invoice o1, Invoice o2) {
            if(o1.name.compareTo(o2.name) > 0) return 1;
            else if(o1.name.compareTo(o2.name) < 0) return -1;
            else {
                if(o1.amount > o2.amount){
                    return 1;
                }
                else if(o1.amount < o2.amount){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        }
    }
}
