/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import ui.CheckInputNumber;

/**
 *
 * @author NQH
 */
public class IBMCal {

    public static void BMICalculator() {
        System.out.print("Enter Weight(kg): ");
        double weight = CheckInputNumber.checkInputDouble();
        System.out.print("Enter Height(cm): ");
        double height = CheckInputNumber.checkInputDouble();
        double bmi = weight * 10000 / (height * height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + IBMStatus.BMIStatus(bmi));
    }
}
