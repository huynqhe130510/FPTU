
public class Course {   
     String name;
     double fee;
    public Course() {
        
    }

    
    public Course(String name, double fee) {
        this.name=name;
        this.fee=fee;
    }
 
    public String getName() {
       return (name);
    }
 
    //add and complete you other methods (if needed) here   

    @Override
    public String toString() {
       String s= String.format("%s, %.0f", name,fee);
        return s;
    }
    
     
}
