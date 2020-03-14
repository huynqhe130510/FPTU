
public class Seller extends Employee {  
    
    double revenue;
    public Seller() {
       
    }

    public Seller(String name, double revenue, double salary) {
        this.name=name;
        this.revenue=revenue;
        this.salary=salary;
    }
    
     /*Complete the below function for second test case*/
    public double getSalary() {
        double bonus;
        if(revenue<30000) bonus=revenue*0.05;
        else bonus= revenue*0.1;
        return (salary+bonus);
    }  
    
    public String toString() {
        String s= String.format("%s   %.1f  %.1f", name,salary,revenue);
        return s;
    }
    
}
