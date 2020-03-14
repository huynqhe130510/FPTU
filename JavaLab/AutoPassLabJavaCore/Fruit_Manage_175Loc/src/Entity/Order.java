/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author ニャット
 */
/*Hold information of a order 
exp: Tram anh: once times buy in this shop
    have bought: orange 3, mango 4, strawberry 5
    this.order hold only info of orange 3...
 */
public class Order {

    private String id;
    private String FruitName;
    private int quantity;
    /*price is cash of 1 fruit.*/
    private double price;
    /*total cash of fruit quantity * price*/
    private double amount;

    public Order() {
    }

    public Order(String id, String FruitName, int quantity, double price) {
        this.id = id;
        this.FruitName = FruitName;
        this.quantity = quantity;
        this.price = price;
        this.amount = price * quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFruitName() {
        return FruitName;
    }

    public void setFruitName(String FruitName) {
        this.FruitName = FruitName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        System.out.printf("%-20s%-20d%-20s%.3f%s", FruitName, quantity, price + "$", amount, "$");
        return "";
    }

}
