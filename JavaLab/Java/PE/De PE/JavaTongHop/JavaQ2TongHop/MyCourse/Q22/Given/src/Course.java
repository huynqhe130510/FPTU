
public class Course {   
     
   
    String name;
    double fee;
    public Course() {
    }

    public Course(String name, double fee) {
        this.name = name;
        this.fee = fee;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return this.name; //To change body of generated methods, choose Tools | Templates.
    }
     
}
