/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testq1;

/**
 *
 * @author Kudo
 */
public class MuaHangHoa extends HangHoa{
    double trigia ;
    int soluong;

    public MuaHangHoa() {
    }
    
    public MuaHangHoa( String name,double trigia ,int soluong) {
        super(name);
        this.trigia = trigia;
        this.soluong = soluong;
    }
   public double getCost() {
       double cost;
       cost = trigia * soluong;
       int len = name.length();
       if(name.charAt(len-1) == 'B' || name.charAt(len-1) == 'b'){
           Math.ceil(cost);
       }
       else Math.round(cost);
       return cost;
    }

    @Override
    public String toString() {
        return this.name +" "+this.trigia+" "+this.soluong; //To change body of generated methods, choose Tools | Templates.
    }
     
    
}
