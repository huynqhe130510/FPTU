package q1_23_3_2018;
import java.io.*;
import static java.lang.Math.ceil;
import static java.lang.Math.floor;

public class Candy extends DessertItem {
    Double price, weight;

    public Candy() {
    }

    public Candy(String name,Double price, Double weight) {
        super(name);
        this.price = price;
        this.weight = weight;
    }

    public double getCost() {
        double cost = price * weight;
        
        if(name.charAt(0) == 'C' || name.charAt(0) == 'c'){
                Math.ceil(cost);
            }
        else Math.floor(cost);
        return cost;
    }
    @Override
    public String toString() {
        return name + " " + price + " " + weight;
    }

}
