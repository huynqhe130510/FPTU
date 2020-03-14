
public class Employee {
    String name;
    double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.name +" "+ this.salary; //To change body of generated methods, choose Tools | Templates.
    }
  
}
