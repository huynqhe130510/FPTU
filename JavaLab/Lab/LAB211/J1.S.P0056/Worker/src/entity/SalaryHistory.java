/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author huyNguyen
 */
public class SalaryHistory {

    private int oldSalary;
    private int newSalary;
    private String date;

    public SalaryHistory(int oldSalary, int newSalary) {
        this.oldSalary = oldSalary;
        this.newSalary = newSalary;
        setDate(currentDate());
    }

    public SalaryHistory(int newSalary) {
        this.newSalary = newSalary;
    }

    public int getOldSalary() {
        return oldSalary;
    }

    public void setOldSalary(int oldSalary) {
        this.oldSalary = oldSalary;
    }

    public int getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(int newSalary) {
        this.newSalary = newSalary;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String currentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return this.date = formatter.format(date);
    }
    
    public String getStatus() {
        String status = null;
        if (newSalary > 0 && oldSalary > 0) {
            if (newSalary > oldSalary) {
                status = "UP";
            } else {
                status = "DOWN";
            }
        }
        return status;
    }
}
