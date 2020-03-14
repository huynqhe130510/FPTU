public class Printer {
    double  price;
    String name;

    public Printer() {
    }

    public Printer(String name,double price ) {
        this.price = price;
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    
}
