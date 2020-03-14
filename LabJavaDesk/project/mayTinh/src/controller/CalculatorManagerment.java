package controller;

import ui.mayTinh;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CalculatorManagerment implements ActionListener {

    private mayTinh mayTinh;
    DecimalFormat decimalFormat = new DecimalFormat("#.#####");
    boolean k = true;
    double result = 0;

    public CalculatorManagerment(mayTinh mt) {
        this.mayTinh = mt;
        decimalFormat.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US));
        mt.getBt0().addActionListener(this);
        mt.getBt1().addActionListener(this);
        mt.getBt2().addActionListener(this);
        mt.getBt3().addActionListener(this);
        mt.getBt4().addActionListener(this);
        mt.getBt5().addActionListener(this);
        mt.getBt6().addActionListener(this);
        mt.getBt7().addActionListener(this);
        mt.getBt8().addActionListener(this);
        mt.getBt9().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String number = e.getActionCommand();
        if (k == true) {
            result = getCurrentNumber();
            setText(number);
            k = false;
        } else {
            setText(getCurrentText() + number);
        }
    }

    public double getCurrentNumber() {
        return Double.parseDouble(getCurrentText());
    }

    public String getCurrentText() {
        return mayTinh.jTextField1.getText();
    }

    public void setText(String s) {
        mayTinh.jTextField1.setText(s);
    }

    private boolean haveDot() {
        return mayTinh.jTextField1.getText().contains(".");
    }

    public void addDot() {
        if (!haveDot() && k == false) {
            setText(getCurrentText() + ".");
            k = false;
        }
        if (k) {
            setText("0.");
            k = false;
        }
    }

}
