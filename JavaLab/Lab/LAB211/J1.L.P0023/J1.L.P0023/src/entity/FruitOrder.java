package entity;

public class FruitOrder {

    String product;
    String quantity;
    String price;
    String amount;

    public FruitOrder() {
    }

    public FruitOrder(String product, String quantity, String price, String amount) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return product + " " + quantity + " " + price + " " + amount;
    }

}
