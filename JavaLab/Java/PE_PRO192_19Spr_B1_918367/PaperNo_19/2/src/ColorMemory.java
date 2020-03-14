public class ColorMemory extends Memory{
    int serie;

    public ColorMemory() {
    }

    public ColorMemory(int serie) {
        this.serie = serie;
    }

    public ColorMemory( String code, int serie, double price) {
        super(code, price);
        this.serie = serie;
    }

    @Override
    public double getPrice() {
        if(serie > 3000){
            return price = price + price * 10/100;
        }
        return price;
        
    }

    @Override
    public String toString() {
        return code + ' ' + serie + ' ' + price ;
    }
}
