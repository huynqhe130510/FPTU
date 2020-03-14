
public class Employee {

    String name;
    double salary;
    
    public Employee() {
       
    }
    
    public Employee(String name, double salary) {
        this.name=name;
        this.salary=salary;
    }  
    
   //add and complete your other methods here (if needed)

    @Override
    public String toString() {
        String s= String.format("%s   %.1f", name,salary);
        return s;
    }
    
}
