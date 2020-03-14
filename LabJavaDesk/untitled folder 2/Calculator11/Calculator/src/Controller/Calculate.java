
import GUI.Main;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pc
 */
public class Calculate {

    private BigDecimal firstNum;
    private BigDecimal secondNum;
    private final JTextField text;
    private boolean reset = false;// xem có bấm vào sqrt,percent, flip, swap hoặc chương trình error ko thì reset = true
    private boolean isMR = false;
    private boolean process = false; // xem nó tính toán chưa, nếu tính rồi or nhấn vào dấu bằng thì process = true
    private int operator = -1;
    private BigDecimal memory = new BigDecimal("0");

    public Calculate(JTextField text) {
        this.text = text;
        operator = -1; // ?
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    //This function is display number  
    public void pressNumber(JButton btn) {
        BigDecimal temp;
        String value = btn.getText();
        // condition check if user calculate done or programming error 
        if (process || reset) {
            text.setText("0"); // ?
            process = false;
            reset = false;
        }
        isMR = false;
        temp = new BigDecimal(text.getText() + value);
        text.setText(temp + "");
    }

    //This function is add dot 
    public void pressDot() {
        // condition check if user calculate done or programming error 
        if (process || reset) {
            text.setText("0");
            process = false;
            reset = false;
        }
        // condition check text haven't dot
        if (!text.getText().contains(".")) {
            text.setText(text.getText() + ".");
        }
    }

    //This function return number
    public BigDecimal getValue() {
        //condition check if have value in memory
        if (isMR) {
            return memory;
        }
        String value = text.getText();
        BigDecimal temp = new BigDecimal(value);
        return temp;

    }

//    public boolean isMemory() {
//        return pressMR() != null; 
//    }
    //????
//    public BigDecimal changeValue() {
//        if (operator == 1 || operator == 2) {
//            return new BigDecimal("0");
//        } else {
//            return new BigDecimal("1");
//        }
//    }
    // clear all value of first number and second number
    public void pressClear() {
        firstNum = new BigDecimal("0");
        secondNum = new BigDecimal("0");
        //memory = new BigDecimal("0");
        operator = -1;
    }

    // This function is calculate +,-,*,/
    public void calculate() {
        String temp;
        //calculate sum, sub, mul, divide
        try {
            //condition check if user doesn't calculate 
            if (!process) {
                //condition check operator if operator from 1-4 then calculate else if operator = -1 then calculate by its case
                if (operator == -1) {
                    firstNum = getValue();
                } else {
                    secondNum = getValue();
                    switch (operator) {
                        case 1:
                            firstNum = firstNum.add(secondNum);
                            break;
                        case 2:
                            firstNum = firstNum.subtract(secondNum);
                            break;
                        case 3:
                            firstNum = firstNum.multiply(secondNum);
                            break;
                        case 4:
                            double result = firstNum.doubleValue() / secondNum.doubleValue();
                            temp = String.valueOf(result);
                            //condition check value display in screen contain dot and 0
                            if (temp.endsWith(".0")) {
                                temp = temp.replace(".0", "");
                            }
                            firstNum = new BigDecimal(temp + "");

                            break;
                    }
                }
                temp = String.valueOf(firstNum);
                if (temp.endsWith(".0")) {
                    temp = temp.replace(".0", "");
                }
                text.setText(temp + "");
                process = true;
            }
            //If the program is running which generates errors
        } catch (Exception e) {
            reset = true;
            text.setText("ERROR");
        }

    }

    // this function is display result 
    public void pressResult() {
        //condition to check text not equals error
        if (!text.getText().equals("ERROR")) {
            calculate();
            operator = -1;
        } else {
            text.setText(firstNum + "");
        }
    }

    //This function is display negate number
    public void pressNegate() {

        pressResult();
        text.setText(getValue().negate() + "");
        process = false;

        reset = true;
    }

    //This function is display square root of number or error if number illegal
    public void pressSqrt() {
        //calculate square root 
        try {
            pressResult();
            BigDecimal result = getValue();
            //condition to check result bigger than 0
            if (result.doubleValue() >= 0) {
                String display = Math.sqrt(result.doubleValue()) + "";
                //condition check value display in screen contain dot and 0
                if (display.endsWith(".0")) {
                    display = display.replace(".0", "");
                }
                text.setText(display);
                process = false;
            } else {
                text.setText("ERROR");
            }
            //If the program is running which generates errors
        } catch (Exception e) {
            text.setText("ERROR");
        }
        reset = true;
    }

    // This function is display percent number
    //ex 50% ---> 0.05
    public void pressPercent() {

        pressResult();
        text.setText((getValue().doubleValue()) / 100 + "");
        process = false;
        reset = true;
    }

    //This function is display fliped number
    public void pressInvert() {

        pressResult();
        double result = getValue().doubleValue();
        //condition to check if denominator isn't 0
        if (result != 0) {
            text.setText((1 / result) + "");
            process = false;
        } else {
            text.setText("ERROR");
        }

        reset = true;
    }

    //MC : xóa bỏ trong bộ nhớ xét memory =0
    //MR: lấy ra giá trị trong bộ nhớ 
    //ấn số: => M+ : lưu giá trị đó vào memory
    //ấn số: => M- : lưu giá trị đối của nó vào memory
    //Nhấn M+ / M- => MR đổi màu
    //Nhấn MC: => MR về màu cũ
    //This function is clear the value in memory
    public void pressMC() {
        memory = new BigDecimal("0");
    }

    //This function is display the value in memory
    public void pressMR() {
        text.setText(memory + "");
        isMR = true;
    }

    //This function is add to value stored in memory
    public void pressMAdd() {

        memory = memory.add(getValue());
        process = false;

        reset = true;
    }

    //This function is subtract from the value stored in memory
    public void pressMSub() {

        memory = memory.add(getValue().negate());
        process = false;

        reset = true;
    }
}
