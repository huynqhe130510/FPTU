/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author Chu Anh
 */
public class Caculator {

    BigDecimal num1 ;
    BigDecimal num2 ;
    BigDecimal result ;
    ArrayList<BigDecimal> save = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public void input() throws IndexOutOfBoundsException{
        try {
            System.out.println("Enter the first digit : ");
            num1 = in.nextBigDecimal();
        } catch (Exception e) {
            System.out.println("Error input !");
        }
        try {
            System.out.println("Enter the second digit : ");
            num2 = in.nextBigDecimal();
        } catch (Exception e) {
        }

        result = num1.multiply(num2);
        save.add(result);

    }
    public void display (){
        System.out.println("The equal : " +result);
        
    }

    public ArrayList<BigDecimal> getSave() {
        System.out.println("List " +save);
        return save;
    }
    
}
