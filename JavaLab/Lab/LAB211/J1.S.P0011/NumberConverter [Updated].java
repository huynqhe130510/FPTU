package test;




import java.util.Scanner;

public class NumberConverter {
    String baseDigits = "0123456789ABCDEF";
    public String DecimalToOtherBase(String input, int base){
        String result="";
        int inputInt = Integer.parseInt(input); //Chuyen String ve so int
        while (inputInt!=0){
            result = baseDigits.charAt(inputInt%base) +result;
            inputInt /= base;
        }
        return result;
    }
    
    public String OtherBaseToDecimal(String input, int base){
        int result=0;
        int n = input.length();
        for (int i =0; i<n; i++){
            result += baseDigits.indexOf(input.charAt(i))*Math.pow(base, n-1-i);
        }
        return Integer.toString(result);
    }
    
    String binaryValid ="[01]+";
    String decimalValid ="[0-9]+";
    String hexaValid ="[0-9A-Fa-f]+";
    
    public String inputBin(){
        Scanner sc = new Scanner(System.in);
        String result ="";
        System.out.print("INPUT A VALID VALUE TO CONVERT: ");
        do{
            result = sc.nextLine();
            if(!result.matches(binaryValid)){
                System.out.print("INVALID INPUT FOR BINARY. INPUT AGAIN: ");
            }
        }while(!result.matches(binaryValid));
        return result;
    }
    
    public String inputDec(){
        Scanner sc = new Scanner(System.in);
        String result ="";
        System.out.print("INPUT A VALID VALUE TO CONVERT: ");
        do{
            result = sc.nextLine();
            if(!result.matches(decimalValid)){
                System.out.print("INVALID INPUT FOR DECIMAL. INPUT AGAIN: ");
            }
        }while(!result.matches(decimalValid));
        return result;
    }
    
    public String inputHexa(){
        Scanner sc = new Scanner(System.in);
        String result ="";
        System.out.print("INPUT A VALID VALUE TO CONVERT: ");
        do{
            result = sc.nextLine();
            if(!result.matches(hexaValid)){
                System.out.print("INVALID INPUT FOR HEXADECIMAL. INPUT AGAIN: ");
            }
        }while(!result.matches(hexaValid));
        return result;
    }
    String validBase ="(2)|(10)|(16)";
    
    public int inputBase(){
        Scanner sc = new Scanner(System.in);
        String result ="";
        do{
            result = sc.nextLine();
            if(!result.matches(validBase)){
                System.out.print("INVALID INPUT FOR BASE. INPUT AGAIN: ");
            }
        }while(!result.matches(validBase));
        return Integer.parseInt(result);
    }
    
    
    public static void main (String[] args){ 
        NumberConverter m = new NumberConverter();
        Scanner sc = new Scanner(System.in);
        String input, result, temp;
        int baseInput =0;
        int baseOutput =0;
        System.out.print("Base number input(2|10|16): ");
        baseInput = m.inputBase();
        System.out.print("Base number output(2|10|16): ");
        baseOutput = m.inputBase();
        switch(baseInput){
            case 2:
                input = m.inputBin();
                if (baseOutput == 10){
                    result = m.OtherBaseToDecimal(input, 2);
                    System.out.println("Converted: " + result);
                }else if(baseOutput == 16){
                    temp = m.OtherBaseToDecimal(input, 2);
                    result = m.DecimalToOtherBase(temp, 16);
                    System.out.println("Converted: " + result);
                }
                break;
            case 10:
                input = m.inputDec();
                if (baseOutput == 2){
                    result = m.DecimalToOtherBase(input, 2);
                    System.out.println("Converted: " + result);
                }else if(baseOutput == 16){
                    result = m.DecimalToOtherBase(input, 10);
                    System.out.println("Converted: " + result);
                }
                break;
            case 16:
                input = m.inputHexa();
                if (baseOutput == 2){
                    temp = m.OtherBaseToDecimal(input, 16);
                    result = m.DecimalToOtherBase(temp, 2);
                    System.out.println("Converted: " + result);
                }else if(baseOutput == 10){
                    result = m.OtherBaseToDecimal(input, 16);
                    System.out.println("Converted: " + result);
                }
                break;
        }
    }
}
