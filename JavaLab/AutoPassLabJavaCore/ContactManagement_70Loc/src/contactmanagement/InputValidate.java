/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagement;

import java.util.Scanner;

/**
 *
 * @author ニャット
 */
public class InputValidate {
    
    public static String removeUnnecessaryBlank(String input) {
        return input.trim().replaceAll("\\s+", " ");
    }

    public static String normalFormName(String input) {
        input = removeUnnecessaryBlank(input);
        String temp[] = input.split(" ");
        String result = "";
        for (int i = 0; i < temp.length; i++) {
            result += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) {
                result += " ";
            }
        }
        return result;
    }
    
    public static String getStringByRegex(String mess, String error, String regex) {
        Scanner scan = new Scanner(System.in);
        String output = null;
        while (true) {
            System.out.print(mess);
            output = scan.nextLine();
            if (output.matches(regex)) {
                return output;
            } else {
                System.err.println(error);
            }
        }
    }
    
    public static int getInputInt(String message, String error,int min, int max) {
        int number = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {            
            try {
                System.out.print(message);
                number = Integer.parseInt(sc.nextLine());
                if (number < min || number > max){
                    System.out.println(error);
                } else {
                    break;
                }                
            } catch (NumberFormatException e) {                
                System.out.println("Please enter an digit!");                
            }
        }
        return number;
    }
}
