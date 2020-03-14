
public class Motor {
    
    String brandName;
    double price;
    public Motor() {
       
    }
    
    public Motor(String brandName, double price) {
        this.brandName=brandName;
        this.price=price;
    }    
    

    @Override
    public String toString() {
        String s= String.format("%s  %.1f",brandName, price);
        return  s ;
    }
    
}
