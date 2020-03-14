package sampletest;
public class Motor {
    String brandName;
    double price;
    
    public Motor() {
    }
    
    public Motor(String brandName, double price) {
        this.brandName = brandName;
        this.price = price;
    }    

    @Override
    public String toString() {
        return this.brandName +" "+this.price; //To change body of generated methods, choose Tools | Templates.
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
