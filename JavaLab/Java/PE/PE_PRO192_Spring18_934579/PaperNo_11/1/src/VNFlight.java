
public class VNFlight extends Flight {  
     String flightNo;
     int arr[];
    //behaviors
    public VNFlight() {
      
    }

    public VNFlight(String route, String flightNo, double fare) {
        this.route=route;
        this.flightNo=flightNo;
        this.fare=fare;
        
    }
    
    /*Complete the below function for second test case*/
    public double getSaleFare() {
       String s=flightNo.trim();
       if(s.startsWith("vn")||s.startsWith("VN")){
           return fare+fare*0.1 ;
       }
       else return (fare*1.05);
    }  
    
    @Override
    public String toString() {
        String s= String.format("%s %.1f    %s",route,fare,flightNo);
        return s;
    }
    public void display(){
        for(int i=0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    //add and complete your other methods here (if needed)

}
