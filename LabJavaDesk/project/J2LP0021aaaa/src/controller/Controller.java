package controller;

import form.GameForm;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Thaycacac
 */
public class Controller {

    // create thread
    public Thread initThread(GameForm game) {
        Thread threadTime = new Thread() {
            @Override
            public void run() {               
                while (true) {
                    try {
                        // check game is playing
                        if (game.isFlag()) {
                            int timeCurrent = getTimeCurrent(game);
                            game.getTxtElapsed().setText(++timeCurrent + " sec");
                        }
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        return threadTime;
    }

    // add action button
    public void addActionButton(GameForm game, ArrayList<JButton> listButton, Thread elapse) {
        game.getBtnNewGame().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Confirm NewGAme");                
                elapse.suspend(); 
                int result = JOptionPane.showConfirmDialog(game, "Continue?", "Confirm", 0, 0);
                if (result == JOptionPane.YES_OPTION) {
                    listButton.clear();
                    game.setTime(0);
                    game.setCount(0);
                    game.getTxtElapsed().setText("0 sec");
                    game.getTxtCount().setText("0");
                    elapse.resume();
                    createGame(game, listButton,elapse);
                } else {
                    elapse.resume();
                    return;
                }
            }
        });
        game.getCbbSize().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                elapse.suspend();
                int result = JOptionPane.showConfirmDialog(game, "Continue?", "Confirm", 0, 0);
                if (result == JOptionPane.YES_OPTION) {
                    listButton.clear();
                    int size = getSizeWhenClick(game);
                    game.setSize(size);
                    game.setTime(0);
                    game.setCount(0);
                    game.getTxtElapsed().setText("0 sec");
                    game.getTxtCount().setText("0");
                    elapse.resume();
                    createGame(game, listButton,elapse);
                } else {
                    elapse.resume();
                    return;
                }
            }
        });
    }

    // add area game
    public void createGame(GameForm game, ArrayList<JButton> listButton, Thread time) {        
        int size = game.getSizeGame();
        time.suspend();
        ArrayList<Integer> listShuffle = listShuffle(size, game);
        game.getJpnGame().removeAll();
        game.getJpnGame().setLayout(new GridLayout(size, size));
        HandleButton handleButton = new HandleButton();
        // loop until end array to create and set value to button
        for (int i = 0; i < size * size; i++) {
            int number = listShuffle.get(i);
            JButton newButton = new JButton();
            if (number == 0) {
                game.setPositionEmpty(i);
            }
            newButton.setText((number == 0) ? "" : String.valueOf(number));
            newButton.setPreferredSize(new Dimension(40, 40));
            game.getJpnGame().add(newButton);
            listButton.add(newButton);
            handleButton.addActionButton(listButton, game, newButton, time);
        }       
        game.setSize(90 * size, 60 * 2 * size);
        game.setFlag(true);
        game.setVisible(true);
    }

    // get list shuffle number
    public ArrayList listShuffle(int size, GameForm game) {
        ArrayList<Integer> listSuffle = new ArrayList<>();
        for (int i = 1; i < size * size; i++) {
            listSuffle.add(i);
        }
        listSuffle.add(0);
        Random ran = new Random();
        for (int i = 0; i < 20; i++) {
            switch (ran.nextInt(4)) {
                case 0:
                    swapListShuffle(listSuffle, size, size);
//                    System.out.println("0");
                    System.out.println(listSuffle);
                    break;
                case 1:
                    swapListShuffle(listSuffle, size, -size);
//                    System.out.println("1");
                    System.out.println(listSuffle);

                    break;
                case 2:
//                    if (size == 4 && positionEmpty % size == 3) {
//                        System.out.println("2");
//                        break;
//                    } else {
                    swapListShuffle(listSuffle, size, 1);
//                    }
//                    System.out.println("22222");
//                    System.out.println(listSuffle);
                    break;
                case 3:
                    //   if (size == 4 && positionEmpty % size == 0) {
                    //      System.out.println("3");
                    //     break;
                    //  } else {
                    swapListShuffle(listSuffle, size, -1);
                    //  }
//                    System.out.println("3333");
//                    System.out.println(listSuffle);
                    break;
            }
        }
        return listSuffle;
    }

    // swap list shuffle
    public ArrayList swapListShuffle(ArrayList<Integer> listShuffle, int size, int valueChange) {
        int emptyPosition = -1;
        for (Integer num : listShuffle) {
            if (num == 0) {
                emptyPosition = listShuffle.indexOf(num);
                break;
            }
        }
        int checkPosition = emptyPosition + valueChange;
        if (checkPosition >= 0 && checkPosition < size * size) {
            if ((size == 4 && emptyPosition % size == 0 && valueChange == -1) || (size == 4 && emptyPosition % size == 3 && valueChange == 1)) {
                //     System.out.println("Not Swap");
                System.out.println(valueChange);
            } else {
                listShuffle.set(emptyPosition, listShuffle.get(checkPosition));
                listShuffle.set(checkPosition, 0);
            }
        }
        return listShuffle;
    }

    // get size when user change value
    public int getSizeWhenClick(GameForm game) {
        String[] textSize = game.getCbbSize().getSelectedItem().toString().split("");
        int size = Integer.parseInt(textSize[0]);
        return size;
    }

    // get time currentt
    public int getTimeCurrent(GameForm game) {
        String[] textEsclape = game.getTxtElapsed().getText().split(" ");
        return Integer.parseInt(textEsclape[0]);
    }

}
