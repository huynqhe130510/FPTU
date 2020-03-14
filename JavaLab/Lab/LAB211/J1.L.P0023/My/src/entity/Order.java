/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author huyNguyen
 */
public class Order {
    
    String name;
    ArrayList<FruitOrder> fruitOrder;

    public Order() {
    }

    public Order(String name, ArrayList<FruitOrder> fruitOrder) {
        this.name = name;
        this.fruitOrder = fruitOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<FruitOrder> getFruitOrder() {
        return fruitOrder;
    }

    public void setFruitOrder(ArrayList<FruitOrder> fruitOrder) {
        this.fruitOrder = fruitOrder;
    }
    
    
    
}
