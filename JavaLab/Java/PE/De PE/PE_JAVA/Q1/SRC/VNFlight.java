
public class VNFlight extends Flight {  
    String flightNo;
    //behaviors
    public VNFlight() {
        
    }

    public VNFlight(String route, String flightNo, double fare) {
        super(route, fare);
        this.flightNo = flightNo;
    }
    
    /*Complete the below function for second test case*/
    public double getSaleFare() {
        double saleFare;
        if(flightNo.substring(0, 2).equals("vn") || flightNo.substring(0, 2).equals("VN")){
            saleFare = fare +0.1* fare;
        }
        else {
            saleFare = fare+ 0.05*fare;
        }
        return saleFare;
    }  
    
    @Override
    public String toString() {
        return this.route+" "+this.fare+" "+this.flightNo;
    }
    
    //add and complete your other methods here (if needed)

}
