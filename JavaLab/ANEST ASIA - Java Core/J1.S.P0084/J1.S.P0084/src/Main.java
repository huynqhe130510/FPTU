
import GUI.Caculator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chu Anh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        Caculator ca =new Caculator();
        ca.input();
        ca.display();
        ca.getSave();
    }
    
}
