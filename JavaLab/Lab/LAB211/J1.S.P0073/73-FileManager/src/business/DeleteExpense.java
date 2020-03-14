/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.Expenses;
import java.util.ArrayList;
import ui.Validate;

/**
 *
 * @author huyNguyen
 */
public class DeleteExpense {
    
    /**
     * Detele an expense 
     * @param le: array list contains expenses
     * @return type validate (success or fail)
     */
    public static int deleteExpense(ArrayList<Expenses> le) {
        int type = 0;
        int id = Validate.checkInputInt();
        int checkIdExist = Validate.checkIdExist(le, id);
        if (checkIdExist != -1) {
            le.remove(checkIdExist);
            type = 1;
            for (int i = id - 1; i < le.size(); i++) {
                le.get(i).setId(le.get(i).getId() - 1);
            }
        } else {
            type = 2;
        }
        return type;
    }

}
