public class Motor {
    String brandName;
    double price;
    
    public Motor()
    {
        
    }

    public Motor(String branName, double price) {
        this.brandName = branName;
        this.price = price;
    }
    
    String getBrandName(){
        return brandName;
    }
    double getPrice(){
        return price;
    }
    @Override
    public String toString(){
        return brandName + " "+ price;
    }
}
    

