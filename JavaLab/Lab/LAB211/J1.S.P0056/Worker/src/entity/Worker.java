/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author huyNguyen
 */
public class Worker {

    private String code;
    private String name;
    private int age;
    private String location;
    private int currentSalary;
    private List<SalaryHistory> history = new ArrayList<>();
   

    public Worker() {
    }

    public Worker(String code, String name, int age, String location, int currentSalary) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.location = location;
        this.currentSalary = currentSalary;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(int currentSalary) {
        this.currentSalary = currentSalary;
    }

    public List<SalaryHistory> getHistory() {
        return history;
    }

    public void addSalaryHistory(SalaryHistory sh) {
        history.add(sh);
    }

}
