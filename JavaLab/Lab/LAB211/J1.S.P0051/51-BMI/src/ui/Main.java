/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import business.IBMCal;
import business.NomalCal;

/**
 *
 * @author NQH
 */
public class Main {

    public static void main(String[] args) {
        //loop until user want to exit
        while (true) {
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = CheckInput.checkInputIntLimit(1, 3);

            switch (choice) {
                case 1:
                    NomalCal nc = new NomalCal();
                    double memory = 0,
                     number;
                    System.out.print("Enter number: ");
                    number = CheckInputNumber.checkInputDouble();
                    memory = nc.addCal(number);
                    while (true) {

                        System.out.print("Enter operator: ");
                        String operator = CheckInputOperator.checkInputOperator();

                        if (operator.equalsIgnoreCase("+")) {
                            System.out.print("Enter number: ");
                            number = CheckInputNumber.checkInputDouble();
                            memory = nc.addCal(number);
                            System.out.println("Memory: " + memory);
                        }
                        if (operator.equalsIgnoreCase("-")) {
                            System.out.print("Enter number: ");
                            number = CheckInputNumber.checkInputDouble();
                            memory = nc.subCal(number);
                            System.out.println("Memory: " + memory);
                        }
                        if (operator.equalsIgnoreCase("*")) {
                            System.out.print("Enter number: ");
                            number = CheckInputNumber.checkInputDouble();
                            memory = nc.mulCal(number);
                            System.out.println("Memory: " + memory);
                        }
                        if (operator.equalsIgnoreCase("/")) {
                            System.out.print("Enter number: ");
                            number = CheckInputNumber.checkInputDouble();
                            memory = nc.divCal(number);
                            System.out.println("Memory: " + memory);
                        }
                        if (operator.equalsIgnoreCase("^")) {
                            System.out.print("Enter number: ");
                            number = CheckInputNumber.checkInputDouble();
                            memory = nc.powCal(number);
                            System.out.println("Memory: " + memory);
                        }
                        if (operator.equalsIgnoreCase("=")) {
                            System.out.println("Result: " + memory);
                            return;
                        }
                    }
                case 2:
                    IBMCal.BMICalculator();
                    break;
                case 3:
                    return;
            }
        }

    }
}
