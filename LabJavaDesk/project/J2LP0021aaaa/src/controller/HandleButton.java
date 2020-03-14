package controller;

import form.GameForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import controller.Controller;
import java.util.ArrayList;

/**
 *
 * @author Thaycacac
 */
public class HandleButton {

    // handle when user click one button
    public void addActionButton(ArrayList<JButton> listButton, GameForm game, JButton button, Thread time) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String text = button.getText();
//                boolean check = swappAble(text, listButton, game);
//                System.out.println(check + "Swap");
                System.out.println("confirm swap");
                if (swappAble(text, listButton, game)) {
                    time.resume();
                    swap(listButton, game);
                    // update count                    
                    updateMoveCount(game);
                    // check user win or not
                    checkWin(listButton, game);

                }
            }
        });
    }

    // process swap button click and button empty
    private void swap(ArrayList<JButton> listButton, GameForm game) {
        int positionCurrent = game.getPositionCurrent();
        int positionEmpty = game.getPositionEmpty();
        String textCurrent = listButton.get(positionCurrent).getText();
        System.out.println(textCurrent);
        System.out.println("positionEmpty:" + positionEmpty);
        listButton.get(positionEmpty).setText(textCurrent);
        listButton.get(positionCurrent).setText("");
        game.setPositionEmpty(positionCurrent);

    }

    // update count move
    private void updateMoveCount(GameForm game) {
        int countCurrent = game.getCount();
        game.setCount(++countCurrent);
        game.getTxtCount().setText(String.valueOf(countCurrent));

    }

    // check user win or not to show result
    public void checkWin(ArrayList<JButton> listButton, GameForm game) {
        if (isWin(listButton, game)) {
            JOptionPane.showMessageDialog(game, "You Win!!!", "Congratulate", 1);
            game.setFlag(false);
            removeActionButton(listButton);
        }
    }

    // check user win or not
    public boolean isWin(ArrayList<JButton> listButton, GameForm game) {
        int size = game.getSizeGame();
        int positionEmpty = game.getPositionEmpty();
        if (positionEmpty == size * size - 1) {
            for (int i = 0; i < listButton.size(); i++) {
                //      System.out.println("Check Win");
                JButton value = listButton.get(i);
                String text = value.getText();
                if (!text.equals("")) {
                    int num = Integer.parseInt(text);
                    if (num != i + 1) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    // remove all action when win
    public void removeActionButton(ArrayList<JButton> listButton) {
        for (JButton btn : listButton) {
            JButton value = btn;
            for (ActionListener e : value.getActionListeners()) {
                value.removeActionListener(e);
            }
        }
    }

    // check when possition user click can swap or not
    private boolean swappAble(String text, ArrayList<JButton> listButton, GameForm game) {
        for (int i = 0; i < listButton.size(); i++) {
            System.out.println(listButton.get(i).getText());
        }
        return isTop(text, listButton, game) || isBottom(text, listButton, game)
                || isLeft(text, listButton, game) || isRight(text, listButton, game);
    }

    // check button click is top button empty
    public boolean isTop(String text, ArrayList<JButton> listButton, GameForm game) {
        int positionEmpty = game.getPositionEmpty();
        int size = game.getSizeGame();
        int positionCurrentCheck = positionEmpty + size;
        System.out.println(positionCurrentCheck + "top");
//        System.out.println(game.getPositionCurrent() +"Top");
//        System.out.println(game.getPositionEmpty() +"Empty TOp");
        System.out.println(text + "textInTop");
   //     System.out.println(listButton.get(positionCurrentCheck).getText());
        if (positionCurrentCheck < size * size && listButton.get(positionCurrentCheck).getText().equals(text) && positionCurrentCheck >= 0) {
            System.out.println("COnfirm");
            game.setPositionCurrent(positionCurrentCheck);
            return true;
        }
        return false;
    }

    // check button click is button empty
    public boolean isBottom(String text, ArrayList<JButton> listButton, GameForm game) {
        int positionEmpty = game.getPositionEmpty();
        int size = game.getSizeGame();
        int positionCurrentCheck = positionEmpty - size;
        System.out.println(positionCurrentCheck + "bottom");
        System.out.println(text + "textInBottom");
//        System.out.println(game.getPositionCurrent() + "Bottom");
//         System.out.println(game.getPositionEmpty() +"Empty Bottom");
   //     System.out.println(listButton.get(positionCurrentCheck).getText());
        if (positionCurrentCheck < size * size
                && positionCurrentCheck >= 0
                && listButton.get(positionCurrentCheck).getText().equals(text)) {
            System.out.println("COnfirm");
            game.setPositionCurrent(positionCurrentCheck);
            return true;
        }
        return false;
    }

    //check button click is button right
    public boolean isRight(String text, ArrayList<JButton> listButton, GameForm game) {
        int positionEmpty = game.getPositionEmpty();
        int size = game.getSizeGame();
        int positionCurrentCheck = positionEmpty + 1;
        System.out.println(positionCurrentCheck + "right");
        System.out.println(text + "textInRight");
//        System.out.println(game.getPositionCurrent() +"RIGHT");
//         System.out.println(game.getPositionEmpty() +"Empty Right");
   //     System.out.println(listButton.get(positionCurrentCheck).getText());
        if (positionCurrentCheck < size * size
                && positionCurrentCheck >= 0
                && listButton.get(positionCurrentCheck).getText().equals(text) && positionEmpty % size != (size - 1)) {
            System.out.println("COnfirm");
            game.setPositionCurrent(positionCurrentCheck);
            return true;
        }
        return false;
    }

    //check button click is button right
    public boolean isLeft(String text, ArrayList<JButton> listButton, GameForm game) {
        int positionEmpty = game.getPositionEmpty();
        int size = game.getSizeGame();
        int positionCurrentCheck = positionEmpty - 1;
        System.out.println(positionCurrentCheck + "left");
        System.out.println(text + "textInLeft");
//        System.out.println(game.getPositionCurrent() +"LEFT");
//         System.out.println(game.getPositionEmpty() +"Empty Left");
  //      System.out.println(listButton.get(positionCurrentCheck).getText());
        if (positionCurrentCheck < size * size
                && positionCurrentCheck >= 0
                && listButton.get(positionCurrentCheck).getText().equals(text) && positionEmpty % size != 0) {
            System.out.println("COnfirm");
            game.setPositionCurrent(positionCurrentCheck);
            return true;
        }
        return false;
    }
}
