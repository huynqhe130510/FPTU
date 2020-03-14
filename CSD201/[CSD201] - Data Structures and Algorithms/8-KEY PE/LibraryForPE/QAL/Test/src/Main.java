/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KioT
 */
public class Main {

   static int count(int a, int b){
       return (a > b)? a:b;
   }
    public static void main(String[] args) {
        // TODO code application logic here
        int a = 10;
        int b = 20;
        System.out.println(count(a, b));
    }
    
}
