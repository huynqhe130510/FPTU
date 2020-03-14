
public class Seller extends Employee {  
    double revenue;
   
    public Seller() {
    }

    public Seller(String name, double revenue, double salary) {
        super(name, salary);
        this.revenue = revenue;
    }
    
     /*Complete the below function for second test case*/
    public double getSalary() {
        if(revenue < 30000){
            return salary + 0.05* revenue;
        }
        else{
            return salary + 0.1*revenue;
        }
    }  
    
    //add and complete your other methods here (if needed)
    @Override
    public String toString() {
        return this.name+" "+this.salary+" "+this.revenue; //To change body of generated methods, choose Tools | Templates.
    }
}
