/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package W2;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class QLHoaDon implements IHOADON{

    @Override
    public void f1(ArrayList<HoaDon> a) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of Invoice: ");
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            System.out.println("");
            System.out.print("Issue to customer: ");
            String name = in.readLine();
            System.out.print("Total amount:  ");
            double money = Double.parseDouble(in.readLine());
            a.add(new HoaDon(name, money));
        }  
       }

    @Override
    public void f2(ArrayList<HoaDon> a) {
        for(HoaDon hd: a){
            if(hd.name.charAt(0) == 'A' || hd.name.charAt(0) == 'a'){
                System.out.println(hd.name + " "+ hd.money);
            }
        }        
        
    }
   

 
 }
