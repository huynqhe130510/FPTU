
public class Laptop {
    String name;
    int HDD;

    public Laptop() {
    }

    public Laptop(String name, int HDD) {
        this.name = name;
        this.HDD = HDD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHDD(int HDD) {
        this.HDD = HDD;
    }

    public String getName() {
        return name;
    }

    public int getHDD() {
        return HDD;
    }
    
}
