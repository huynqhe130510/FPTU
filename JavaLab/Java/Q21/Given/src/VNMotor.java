
public class VNMotor extends Motor {

    String series;

    public VNMotor() {
    }

    public VNMotor(String series) {
        this.series = series;
    }

    public VNMotor(String brandName, String series , double price) {
        super(brandName, price);
        this.series = series;
    }

    public double getSalePrice() {
        if (price < 3000) {
            return price = price * 0.95;
        }
        return price * 0.9;
    }

    @Override
    public String toString() {
        return brandName + " " + series + " " + price;
    }
}
