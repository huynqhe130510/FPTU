
public class Sinhvien extends Person {

    double GPA;

    public double getGAP() {
        return GPA;
    }

    public void setGAP(double GAP) {
        this.GPA = GAP;
    }

    public Sinhvien() {
        super();//-->person();

    }

    public Sinhvien(double GPA, String id, String name, boolean gender, int Age) {
        super(id, name, gender, Age);
        this.GPA = GPA;
    }

    public String toString() {
        return null;
    }

}
