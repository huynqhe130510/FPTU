import javax.swing.*;
public class FrmRadio extends javax.swing.JFrame {

    public FrmRadio() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        radOrange = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        radApple = new javax.swing.JRadioButton();
        radMango = new javax.swing.JRadioButton();
        radBanana = new javax.swing.JRadioButton();
        btnSelected = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("JRadioButton demo");

        radGroup.add(radOrange);
        radOrange.setText("Orange");

        jLabel2.setText("Select your fruit you like best:");

        radGroup.add(radApple);
        radApple.setText("Apple");

        radGroup.add(radMango);
        radMango.setText("Mango");
        radMango.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radMangoMouseClicked(evt);
            }
        });

        radGroup.add(radBanana);
        radBanana.setText("Banana");

        btnSelected.setText("Display selected item");
        btnSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(104, 104, 104))
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radBanana)
                    .addComponent(radMango)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radApple)
                            .addComponent(radOrange))
                        .addGap(72, 72, 72)
                        .addComponent(btnSelected)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(radOrange)
                        .addGap(18, 18, 18)
                        .addComponent(radApple))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(btnSelected)))
                .addGap(18, 18, 18)
                .addComponent(radMango)
                .addGap(18, 18, 18)
                .addComponent(radBanana)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectedActionPerformed
     String x = "";
     if(radOrange.isSelected()) 
       x = radOrange.getText();
     if(radApple.isSelected()) 
       x = radApple.getText();
     if(radMango.isSelected()) 
       x = radMango.getText();
     if(radBanana.isSelected()) 
       x = radBanana.getText();
     String s = "The selected item is \"" + x + "\".";
     JOptionPane.showMessageDialog(null,s);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSelectedActionPerformed

    private void radMangoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radMangoMouseClicked
      JOptionPane.showMessageDialog(null,"Mango is selected");
    }//GEN-LAST:event_radMangoMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrmRadio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRadio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRadio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRadio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRadio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelected;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton radApple;
    private javax.swing.JRadioButton radBanana;
    private javax.swing.ButtonGroup radGroup;
    private javax.swing.JRadioButton radMango;
    private javax.swing.JRadioButton radOrange;
    // End of variables declaration//GEN-END:variables
}
