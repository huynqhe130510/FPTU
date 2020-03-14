package WorkShop3A;

import javax.swing.JOptionPane;

public class Workshop3a extends javax.swing.JFrame {

    public Workshop3a() {
        setLocation(500, 150);
        initComponents();
    }

    void checkName() {

        if (tfage.getText().matches("[a-zA-Z ]+")) {
            ta1.setText("Name: Valid");
        } else {
            ta1.setText(ta1.getText() + "Name: Invalid");
        }
    }

    void checkName1() {

        String name = tfname1.getText();

        if (name.matches("[a-zA-Z ]+")) {
            ta1.setText("Name1: Valid");
        } else {
            ta1.setText(ta1.getText() + "Name1: Invalid");
        }
    }

    void checkAge() {
        int n;
        if (tfage.getText().matches("\\d+")) {
            try {
                n = Integer.parseInt(tfage.getText());
                if (n >= 18 && n <= 60) {
                    ta1.setText(ta1.getText() + "Age1: Valid");
                } else {
                    ta1.setText(ta1.getText() + "Age1: Invalid");
                    tfage.requestFocus();
                    tfage.setText("");
                }
            } catch (Exception ex) {

            }
        } else {
            ta1.setText(ta1.getText() + "Age1: Invalid");
            tfage.requestFocus();
            tfage.setText("");
        }
    }

    void checkAge1() {
        int n;
        if (tfage1.getText().matches("\\d+")) {
            try {
                n = Integer.parseInt(tfage1.getText());
                if (n >= 18 && n <= 60) {
                    ta1.setText(ta1.getText() + "\nName1: Valid");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                    tfage1.requestFocus();
                    tfage1.setText("");
                }
            } catch (Exception ex) {

            }
        } else {
            JOptionPane.showMessageDialog(null, "Name1: Invalid");
            tfage1.requestFocus();
            tfage1.setText("");
        }
    }

    void checkSex() {

        if (rbfemale.isSelected() || rbmale.isSelected()) {
            if (rbfemale.isSelected()) {
                ta.setText(ta.getText() + "\nSex: Female");
            }
            if (rbmale.isSelected()) {
                ta.setText(ta.getText() + "\nSex: Male");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please choose an option");
        }
    }

    void checkFruit() {
        if (cbApple.isSelected() || cbMango.isSelected() || cbOrange.isSelected()) {
            ta.setText(ta.getText() + "\nPreferable fruits: ");
            if (cbApple.isSelected()) {
                ta.setText(ta.getText() + "Apple, ");
            }
            if (cbMango.isSelected()) {
                ta.setText(ta.getText() + "Mango, ");
            }
            if (cbOrange.isSelected()) {
                ta.setText(ta.getText() + "Orange");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please choose an option");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tfname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfage = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rbmale = new javax.swing.JRadioButton();
        rbfemale = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        cbMango = new javax.swing.JCheckBox();
        cbApple = new javax.swing.JCheckBox();
        cbOrange = new javax.swing.JCheckBox();
        btcheck = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        tfname1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfage1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta1 = new javax.swing.JTextArea();
        btCheck1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name");

        tfname.setText("Hoa12");

        jLabel2.setText("Age");

        tfage.setText("61");

        jLabel3.setText("Sex");

        buttonGroup1.add(rbmale);
        rbmale.setText("Male");

        buttonGroup1.add(rbfemale);
        rbfemale.setText("Female");

        jLabel4.setText("Preferable fruits ");

        cbMango.setText("Mango");

        cbApple.setText("Apple");

        cbOrange.setText("Orange");

        btcheck.setText("Check");
        btcheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcheckActionPerformed(evt);
            }
        });

        ta.setColumns(20);
        ta.setRows(5);
        jScrollPane1.setViewportView(ta);

        jLabel5.setText("Name2");

        tfname1.setText("Hoa");

        jLabel6.setText("Age2");

        tfage1.setText("60");

        ta1.setColumns(20);
        ta1.setRows(5);
        jScrollPane2.setViewportView(ta1);

        btCheck1.setText("Check2");
        btCheck1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCheck1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfname, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfage, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btcheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbfemale)
                            .addComponent(rbmale)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbApple)
                            .addComponent(cbMango)
                            .addComponent(cbOrange))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(tfname1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfage1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCheck1)
                        .addGap(82, 82, 82))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfage, tfname});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rbmale))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbfemale)
                    .addComponent(btCheck1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbMango))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbApple)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbOrange)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btcheck)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btcheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcheckActionPerformed
        checkName();
        checkAge();
        checkSex();
        checkFruit();
    }//GEN-LAST:event_btcheckActionPerformed

    private void btCheck1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCheck1ActionPerformed
        checkName();
        checkAge();
        checkName1();
        checkAge1();
    }//GEN-LAST:event_btCheck1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Workshop3a.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Workshop3a.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Workshop3a.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Workshop3a.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Workshop3a().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCheck1;
    private javax.swing.JButton btcheck;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbApple;
    private javax.swing.JCheckBox cbMango;
    private javax.swing.JCheckBox cbOrange;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbfemale;
    private javax.swing.JRadioButton rbmale;
    private javax.swing.JTextArea ta;
    private javax.swing.JTextArea ta1;
    private javax.swing.JTextField tfage;
    private javax.swing.JTextField tfage1;
    private javax.swing.JTextField tfname;
    private javax.swing.JTextField tfname1;
    // End of variables declaration//GEN-END:variables
}
