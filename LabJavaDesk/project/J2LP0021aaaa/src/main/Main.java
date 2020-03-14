package main;

import controller.Controller;
import form.GameForm;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;

/**
 *
 * @author Thaycacac
 */
public class Main {

    public static void main(String[] args) {
        GameForm game = new GameForm();
         ArrayList<JButton> listButton = new ArrayList<>();
        Controller control = new Controller();
        // start thread
        Thread elapse = control.initThread(game);       
//        elapse.resume();
        elapse.start();;
        // add acction button
        
        // create game
        
        control.createGame(game, listButton,elapse);
        
        control.addActionButton(game, listButton, elapse);
        
    }
}
