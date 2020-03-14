/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

public class CheckEven {

/*
 * check even number
 * @param n is number needs to check
 * @return if correct return true and if incorrect return false
*/
    public static boolean checkEven(double n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
