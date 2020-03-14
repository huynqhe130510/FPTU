/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagement;

/**
 *
 * @author ニャット
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContactManager cm = new ContactManager();
        while(true){
            cm.ui();
            int choice = InputValidate.getInputInt("Please choose 1-4 : ", "Choose only 1-4 !", 1, 4);
            switch(choice){
                case 1:
                    cm.addContact();
                    break;
                case 3:                    
                    cm.deleteContact();
                    break;
                case 2:
                    cm.display();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
    
}
