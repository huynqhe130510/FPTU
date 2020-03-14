/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

/**
 *
 * @author anhnb
 */
public class NewClass {
    public static void main(String[] args) {
        EmployeeDAO em = new EmployeeDAO();
        System.out.println(em.getstring(1, 2, 2,"","1999-06-25",""));
    }
}
