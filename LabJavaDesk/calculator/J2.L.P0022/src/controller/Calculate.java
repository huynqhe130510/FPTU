/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author huyNguyen
 */
public class Calculate {

    double firstNumber;
    double secondNumber;
    int operator;
    boolean checkClick;
    boolean process;
    double memory;
    boolean checkWrong;
    JTextField text;

    public Calculate(JTextField text) {
        this.text = text;
        operator = -1;
        checkClick = true;
        memory = 0;
        checkWrong = false;
    }

    public void acAction() {
        text.setText("0");
        checkClick = true;
        operator = -1;
        firstNumber = 0;
        checkWrong = false;
    }

    public void setOperator(int oper) {
        this.operator = oper;
    }

    public void pressNumber(JButton button) {
        if (checkWrong == false) {
            String result = null;
            if (checkClick == true) {
                result = button.getText();
                if (result.compareTo("0") == 0) {

                } else {
                    if (result.compareTo(".") == 0) {
                        result = "0" + result;
                    }
                    checkClick = false;
                }
            } else {
                result = text.getText() + button.getText();
            }
            if (process) {
                process = false;
            }
            if (result.contains(String.valueOf((char) 46)) == true) {
                text.setText(result);
            } else {
                DecimalFormat d = new DecimalFormat("###,###.##########");
                String format = d.format(Double.parseDouble(result.replaceAll(",", "")));
                text.setText(format);
            }
        }
    }

    public void calculate1() {
        if (checkWrong == false) {
            if (process == false) {
                if (operator == -1) {
                    firstNumber = Double.parseDouble(text.getText().replaceAll(",", ""));
                } else {
                    secondNumber = Double.parseDouble(text.getText().replaceAll(",", ""));
                    switch (operator) {
                        case 1:
                            firstNumber = firstNumber + secondNumber;
                            break;
                        case 2:
                            firstNumber = firstNumber - secondNumber;
                            break;
                        case 3:
                            firstNumber = firstNumber * secondNumber;
                            break;
                        case 4:
                            if (secondNumber == 0) {
                                checkWrong = true;
                                text.setText("ERROR");
                                return;
                            } else {
                                firstNumber = firstNumber * (1 / secondNumber);
                            }
                            break;
                    }
                }
                process = true;
                checkClick = true;
                operator = -1;
                format(String.valueOf(firstNumber));
            }
        }
    }

    public void format(String input) {
        if (input.endsWith(".")) {
            text.setText(input);
        } else {
            String result = input.replaceAll(",", "");
            DecimalFormat d = new DecimalFormat("###,###.#########");
            String lastResult = d.format(Double.parseDouble(result));
            if (lastResult.length() > 15) {
                text.setText(lastResult.substring(0, 19));
            } else {
                text.setText(lastResult);
            }
        }
    }

    public void backDelete() {
        if (checkWrong == false) {
            if (checkClick == false) {
                String textField = text.getText();
                if (textField.length() >= 3) {
                    text.setText(textField.substring(0, textField.length() - 1));
                } else if (textField.length() == 2 && textField.contains("-")) {
                    text.setText("0");
                } else {
                    if (textField.length() == 1) {
                        text.setText("0");
                        checkClick = true;
                    } else {
                        String z = textField.substring(0, textField.length() - 1);
                        text.setText(z);
                    }
                }
            }
        }
    }

    public void reverse() {
        if (checkWrong == false) {
            double temp = Double.parseDouble(text.getText().replaceAll(",", ""));
            if (temp == 0) {
                checkWrong = true;
                text.setText("ERROR");
            } else {
                format(String.valueOf(1 / temp));
            }
        }
    }

    public void sqrt() {
        if (checkWrong == false) {
            double temp = Double.parseDouble(text.getText().replaceAll(",", ""));
            if (temp > 0) {
                format(String.valueOf(Math.sqrt(temp)));
            } else {
                checkWrong = true;
                text.setText("ERROR");
            }
        }
    }

    public void percent() {
        if (checkWrong == false) {
            double temp = Double.parseDouble(text.getText().replaceAll(",", ""));
            format(String.valueOf(temp * 0.01));
        }
    }

    public void negative() {
        if (checkWrong == false) {
            if (text.getText().matches("[0//.//]+") == true) {

            } else {
                format(String.valueOf(Double.parseDouble(text.getText().replaceAll(",", "")) * -1));
            }
        }
    }

    public void MSAction() {
        if (checkWrong == false) {
            memory = Double.parseDouble(text.getText().replaceAll(",", ""));
            checkClick = true;
        }
    }

    public void MRAction() {
        if (checkWrong == false) {
            format(String.valueOf(memory));
        }
    }

    public void MAdd() {
        if (checkWrong == false) {
            memory = memory + Double.parseDouble(text.getText().replaceAll(",", ""));
            checkClick = true;
        }
    }

    public void MSub() {
        if (checkWrong == false) {
            memory = memory - Double.parseDouble(text.getText().replaceAll(",", ""));
            checkClick = true;
        }
    }

    public void MClear() {
        if (checkWrong == false) {
            memory = 0;
        }
    }
}
