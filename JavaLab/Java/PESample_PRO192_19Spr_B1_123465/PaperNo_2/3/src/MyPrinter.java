
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NQH
 */
public class MyPrinter implements IPrinter{

    @Override
    public void f1(List<Printer> a, double price) {
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i).getPrice() <= price ){
                a.remove(a.get(i).getName());
            }
        }
    }

    @Override
    public int f2(List<Printer> a, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
