
public class Flight {
    String route;
    double fare;
    public Flight() {
    }

    public Flight(String route, double fare) {
        this.route = route;
        this.fare = fare;
    }

    public double getFare() {
        return fare;
    }

    public String getRoute() {
        return route;
    }

   
    @Override
    public String toString() {
        return this.route+" "+this.fare;
    }
    //add and complete your other methods here (if needed)
}
