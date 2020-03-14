
import java.util.Scanner;


public class GaChoi extends GA {

    double Fightingindex;

    public GaChoi(double Fightingindex) {
        this.Fightingindex = Fightingindex;
    }

    public GaChoi(String name, double weight, double price, double Fightingindex) {
        super(name, weight, price);
        this.Fightingindex = Fightingindex;
    }

    public double getFightingindex() {
        return Fightingindex;
    }

    public void setFightingindex(double Fightingindex) {
        this.Fightingindex = Fightingindex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    double getRealPrice() {
        return price = price * Fightingindex * 10 * weight;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter weight: ");
        double weight = Double.parseDouble(sc.nextLine());
        System.out.print("Enter price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Enter fightingindex: ");
        double fight = Double.parseDouble(sc.nextLine());
        GaChoi g = new GaChoi(name, weight, price, fight);
        System.out.print(g.getRealPrice());
    }
}
