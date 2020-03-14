/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Expenses;
import java.util.ArrayList;

/**
 *
 * @author huyNguyen
 */
public class AddExpense {
    /**
     * add an expense 
     * @param le: array list of expenses
     * @param e: object expense (id, date, amount, content)
     */
     public static void addExpense(ArrayList<Expenses> le,Expenses e) {
        le.add(e);
    }
}
