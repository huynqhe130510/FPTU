public class Memory {
    double price;
    String code;

    public Memory() {
    }

    public Memory(String code,double price) {
        this.code = code;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ' ' + price;
    }
    
    
    
    
}
