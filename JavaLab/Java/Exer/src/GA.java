public class GA {
    String name;
    double weight;
    double price;

    public GA() {
    }

    public GA(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return  name + " " + price;
    }
    
}
