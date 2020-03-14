//import javax.swing.*;

import java.awt.*;

public class FormThread1 extends javax.swing.JFrame {

    Thread t;
    int timePeriod = 200;

    public FormThread1() {
        initComponents();
        initThread();
        t.start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new javax.swing.JLabel();
        slider1 = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 0, 255));
        label1.setText("Java is cool");

        slider1.setMajorTickSpacing(100);
        slider1.setMaximum(1000);
        slider1.setMinimum(200);
        slider1.setMinorTickSpacing(100);
        slider1.setPaintLabels(true);
        slider1.setPaintTicks(true);
        slider1.setSnapToTicks(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(label1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(slider1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(label1)
                .addGap(71, 71, 71)
                .addComponent(slider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void changeColor() {
        Color c = label1.getForeground();
        if (c == Color.RED) {
            label1.setForeground(Color.BLUE);
        } else {
            label1.setForeground(Color.RED);
        }
    }

    void initThread() {
        t = new Thread() {
            public void run() {
                while (true) {
                    try {
                        timePeriod = slider1.getValue();
                        changeColor();
                        sleep(timePeriod);
                    } catch (InterruptedException e) {

                    }
                }
            }
        };
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormThread1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label1;
    private javax.swing.JSlider slider1;
    // End of variables declaration//GEN-END:variables
}
