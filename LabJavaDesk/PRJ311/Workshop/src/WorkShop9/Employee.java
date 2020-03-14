/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WorkShop9;

import WorkShop8.*;

/**
 *
 * @author huyNguyen
 */
public class Employee {

    String code, name;
    double salary;
    int bonus;

    public Employee() {
    }

    public Employee(String code, String name, double salary, int bonus) {
        this.code = code;
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "code=" + code + ", name=" + name + ", salary=" + salary + ", bonus=" + bonus ;
    }

}
