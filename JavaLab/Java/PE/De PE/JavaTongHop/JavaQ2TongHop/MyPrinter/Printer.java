package  Q2;
public class Printer {   
    String name;
    double price;
    
    public Printer() {
    }
    
    public Printer(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    
    //add and complete you other methods (if needed) here   

    @Override
    public String toString() {
        return name+" "+ price; //To change body of generated methods, choose Tools | Templates.
    }
 
}
