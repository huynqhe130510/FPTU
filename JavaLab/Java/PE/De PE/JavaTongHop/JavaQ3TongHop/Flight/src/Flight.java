
import java.util.StringTokenizer;

public class Flight {
    private String route;
    private int fare;

    public Flight() {
    }

    public Flight(String route, int fare) {
        this.route = route;
        this.fare = fare;
    }
  
  
    /*Complete the below function for second test case*/
    public String getDeparture() {

           //C1: 
//           String[] depart = route.split("[-]");
//                return depart[0];
            

       //w2: use FOR and SUBSTRING
        int i;
        for( i =0; i<route.length();i++){
            if(route.charAt(i)=='-') break;
        }
            route= route.substring(0,i);
        return route;


        //C3: User StringTokenizer
//        StringTokenizer s = new StringTokenizer(route."-");
//         return route.substring(0,route.indexOf("-");

         //C4:
//         StringTokenizer s = new StringTokenizer(route."-");
//         return (string)s.nextElement();  
       // }
       //add and complete your other methods here (if needed)
}
    @Override
    public String toString() {
        return this.route+ " "+ this.fare; //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
