
public class Printer {   
     String name;
     double price;
    public Printer() {
        
    }
    
    public Printer(String name, double price) {
        this.name= name;
        this.price=price;
    }


    public String getName() {
       return this.name;
    }

    //add and complete you other methods (if needed) here  

    @Override
    public String toString() {
        String s= String.format("%s, %.0f",name, price);
        return s;
    }
    
 
}
