
public class Worker extends Person {
    int salary ;
    String deptName;
    
    public Worker(String name, int salary, String deptName) {
        super(name);
        this.salary = salary;
        this.deptName = deptName;
    }

    public int getSalary() {
        return salary;        
    }

    @Override
    public String toString() {
        return name + ' ' + salary + ' ' + deptName ;
    }
    
}
