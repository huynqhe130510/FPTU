/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author huyNguyen
 */
public class OrderItem {

    String item;
    String fruitName;
    int quantity;
    double price;

    public OrderItem() {
    }

    public OrderItem(String item, String fruitName, int quantity, double price) {
        this.item = item;
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
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
        return price * quantity;
    }

    @Override
    public String toString() {
        String s = String.format("%-20s%-20s%-20s%-20s\n", getFruitName(), getQuantity(), getPrice(), getAmount());
        return s;
    }

}
