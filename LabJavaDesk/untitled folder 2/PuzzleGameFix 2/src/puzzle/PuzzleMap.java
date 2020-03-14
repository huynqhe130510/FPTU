
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author TuanFPT
 */
public class PuzzleMap {

    Puzzle p;
    private JPanel pnLayout;
    private JLabel lbTime;
    private JLabel lbCount;

    private ArrayList<JButton> arrBtn;
    private int numMove = 0;
    private Timer t;
    private int second;
    boolean check = true;

    public PuzzleMap(JPanel pnLayout, JLabel lbTime, JLabel lbCount) {
        this.pnLayout = pnLayout;
        this.lbTime = lbTime;
        this.lbCount = lbCount;
    }

    public void setUp() {
        p.lbCount.setText("0");
        p.lbTime.setText("0");
    }

    public void countTime() {
        second = 0;
        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second++;
                /*if (second == 60) {
                    second = 0;
                    minutes++;
                }*/
                lbTime.setText(String.valueOf(second));
            }
        });
        t.start();
    }

    private boolean checkMove(JButton btn, int size) {
        if (btn.getText().equals("")) {
            return false;
        }
        int startCol = 0;
        int startRow = 0;
        int desCol = 0;
        int desRow = 0;
        // get vi tri
        for (int i = 0; i < arrBtn.size(); i++) {
            if (arrBtn.get(i).getText().equals(btn.getText())) {
                startCol = i % size;
                startRow = i / size;
            }
            if (arrBtn.get(i).getText().equals("")) {
                desCol = i % size;
                desRow = i / size;
            }
        }
        if (startCol == desCol) {
            if (startRow == (desRow - 1) || startRow == (desRow + 1)) {
                return true; // move up or down
            }
        }
        if (startRow == desRow) {
            if (startCol == (desCol - 1) || startCol == (desCol + 1)) {
                return true; // move left or right
            }
        }
        return false;
    }
//count button move

    private void moveBtn(JButton btn) { // move Button
        for (int i = 0; i < arrBtn.size(); i++) {
            if (arrBtn.get(i).getText().equals("")) {
                arrBtn.get(i).setText(btn.getText());
                break;
            }
        }
        btn.setText("");
        numMove++;
        lbCount.setText(String.valueOf(numMove));
    }

    public String getPos(String[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j].equals("")) {
                    return i + " " + j;
                }
            }
        }
        return null;
    }

    private ArrayList randomMatrix(int size) { // return a random array
        ArrayList<String> data = new ArrayList<>();
        Random rd = new Random();
        int a, b;
        String[][] arr = new String[size][size];
        int k = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = k++ + "";
            }
        }
        arr[size - 1][size - 1] = "";
        for (int i = 0; i < 100; i++) {
            a = Integer.parseInt(getPos(arr).split(" ")[0]);
            b = Integer.parseInt(getPos(arr).split(" ")[1]);
            int x = rd.nextInt(4);
            switch (x) {
                case 0:
                    if (b > 0) {
                        String temp = arr[a][b];
                        arr[a][b] = arr[a][b - 1];
                        arr[a][b - 1] = temp;
                    }
                    break;
                case 1:
                    if (a > 0) {
                        String temp = arr[a][b];
                        arr[a][b] = arr[a - 1][b];
                        arr[a - 1][b] = temp;
                    }
                    break;
                case 2:
                    if (b < arr.length - 1) {
                        String temp = arr[a][b];
                        arr[a][b] = arr[a][b + 1];
                        arr[a][b + 1] = temp;
                    }
                    break;
                case 3:
                    if (a < arr.length - 1) {
                        String temp = arr[a][b];
                        arr[a][b] = arr[a + 1][b];
                        arr[a + 1][b] = temp;
                    }
                    break;
            }

        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                data.add(arr[i][j]);
            }
        }
        return data;
    }

    public void initButon(int size) { // khởi tạo button ban đầu
        arrBtn = new ArrayList<>();
        ArrayList<String> data = new ArrayList<>();

        data = randomMatrix(size);

        pnLayout.removeAll();
        pnLayout.setLayout(new GridLayout(0, size, 10, 10));
        if (t == null) {
            check = false;
        } else {
            check = true;
        }
        for (int i = 0; i < data.size(); i++) {
            JButton btn = new JButton(data.get(i));

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (check) {
                        if (checkMove(btn, size)) {
                            moveBtn(btn);
                            if (checkWin()) {
                                t.stop();
                                isWon();
                                check = false;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Press 'New Game' to start!");
                    }
                }
            });

            pnLayout.add(btn);
            arrBtn.add(btn);
        }

    }

    private boolean checkWin() {
        ArrayList<String> btnText = new ArrayList<>();
        for (int i = 0; i < arrBtn.size() - 1; i++) {
            btnText.add(arrBtn.get(i).getText());
        }
        for (int i = 0; i < btnText.size(); i++) {
            for (int j = i; j < btnText.size(); j++) {
                if (btnText.get(j).equals("")) {
                    return false;
                }
                if (Integer.parseInt(btnText.get(j)) < Integer.parseInt(btnText.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    // set panel
    private void setWindowsSize(int num) {
        int heightButton = 50;
        int widthButton = 50;

        //pnLayout.setSize(new Dimension(widthButton*num, heightButton*num));
        pnLayout.setPreferredSize(new Dimension(widthButton * num + 10 * (num - 1), heightButton * num + 10 * (num - 1)));
        pnLayout.setMaximumSize(new Dimension(widthButton * num + 10 * (num - 1), heightButton * num + 10 * (num - 1)));
        pnLayout.setMinimumSize(new Dimension(widthButton * num + 10 * (num - 1), heightButton * num + 10 * (num - 1)));

        //pnLayout.setBackground(Color.red);
        p.setResizable(false);
        p.pack();

    }

    public void startMatrix() {

        String s = p.cmbSize.getSelectedItem().toString();
        String[] temp = s.split("x");
        initButon(Integer.parseInt(temp[0]));
        setWindowsSize(Integer.parseInt(temp[0]));
        System.out.println(temp[0]);
    }

    private void isWon() {
        JOptionPane.showMessageDialog(null, "You Won!");
    }

    public void newGame() {
        if (t != null && !checkWin()) {
            t.stop();
            int confirm = JOptionPane.showConfirmDialog(null, "Do you must be want to make new game?", "New Game", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                setUp();
                numMove = 0;
                countTime();
                startMatrix();

            } else if (confirm == JOptionPane.NO_OPTION) {
                t.start();
            }

        } else {
            setUp();
            numMove = 0;
            countTime();
            startMatrix();
        }
    }
}
