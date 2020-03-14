
package entity;

public class Fruit {
    String FruitID;
    String fruitName;
    String price;
    String quantity;
    String origin;

    public Fruit() {
    }

    public Fruit(String FruitID, String fruitName, String price, String quantity, String origin) {
        this.FruitID = FruitID;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getFruitID() {
        return FruitID;
    }

    public String getFruitName() {
        return fruitName;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return FruitID + " " + fruitName + " " + price + " " + quantity + " " + origin;
    }
    
}
