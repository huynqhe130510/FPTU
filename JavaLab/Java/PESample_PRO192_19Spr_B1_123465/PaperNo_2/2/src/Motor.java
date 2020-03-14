/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NQH
 */
public class Motor {
    String brandName;
    double price;

    public Motor() {
    }

    public Motor(String brandName, double price) {
        this.brandName = brandName;
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public String getBrandName() {
        return brandName;
    }

    @Override
    public String toString() {
        return brandName + " " + price;
    }

    
    
}
