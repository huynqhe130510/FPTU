/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.Worker;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author huyNguyen
 */
public class Validate {

    public boolean checkIndex(String code) {
        if (!Pattern.matches("[0-9]+", code)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkLocation(String location) {
        if (!Pattern.matches("[a-zA-Z0-9]*", location)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkSalary(String salary) {
        if (!Pattern.matches("[0-9]+", salary)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkName(String name) {
        if (!Pattern.matches("[A-Za-z]*", name)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkage(String age) {
        if (!Pattern.matches("[0-9]+", age)) {
            return false;
        }
        if (Integer.parseInt(age) < 18 || Integer.parseInt(age) > 50) {
            return false;
        }
        return true;
    }

    public boolean inputCode(String code, ArrayList<Worker> list) {
        for (Worker w : list) {
            if (w.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkSalaryDecrease(int oldSalary, int newSalary) {
        if (oldSalary < newSalary) {
            return false;
        }
        return true;
    }

    public boolean checkSalaryIncrease(int oldSalary, int newSalary) {
        if (oldSalary > newSalary) {
            return false;
        }
        return true;
    }

    public boolean checkCode(String code, ArrayList<Worker> list) {
        if (!Pattern.matches("[a-zA-Z0-9]+", code)) {
            return false;
        }
        if (list.size() > 0) {
            for (Worker w : list) {
                if (w.getCode().equalsIgnoreCase(code)) {
                    System.out.println("Code duplicate");
                    return false;
                }
            }
        }
        return true;
    }
}
