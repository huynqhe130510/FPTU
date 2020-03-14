
import java.util.*;

public class Form1 extends javax.swing.JFrame {

    Locale loca;
    ResourceBundle bun;

    public Form1() {
        initComponents();
    }

    void setLanguage() {

        mnuFile.setText(bun.getString("Form1.mnuFile.text"));
        mnuEdit.setText(bun.getString("Form1.mnuEdit.text"));
        mnuFinish.setText(bun.getString("Form1.mnuFinish.text"));
        mnuItemNew.setText(bun.getString("Form1.mnuItemNew.text"));
        mnuItemOpen.setText(bun.getString("Form1.mnuItemOpen.text"));
        lblitle.setText(bun.getString("Form1.lblitle.text"));
        lblName.setText(bun.getString("Form1.lblName.text"));
        lblAge.setText(bun.getString("Form1.lblAge.text"));
        lblIncome.setText(bun.getString("Form1.lblIncome.text"));
        btnEnglish.setText(bun.getString("Form1.btnEnglish.text"));
        btnUSVietname.setText(bun.getString("Form1.btnUSVietname.text"));
        btnVietnam.setText(bun.getString("Form1.btnVietnam.text"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblitle = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        lblIncome = new javax.swing.JLabel();
        txtIncome = new javax.swing.JTextField();
        btnEnglish = new javax.swing.JButton();
        btnUSVietname = new javax.swing.JButton();
        btnVietnam = new javax.swing.JButton();
        menuBar1 = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuItemNew = new javax.swing.JMenuItem();
        mnuItemOpen = new javax.swing.JMenuItem();
        mnuEdit = new javax.swing.JMenu();
        mnuFinish = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblitle.setForeground(new java.awt.Color(51, 0, 255));
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        lblitle.setText(bundle.getString("Form1.lblitle.text")); // NOI18N

        lblName.setText(bundle.getString("Form1.lblName.text")); // NOI18N

        lblAge.setText(bundle.getString("Form1.lblAge.text")); // NOI18N

        lblIncome.setText(bundle.getString("Form1.lblIncome.text")); // NOI18N

        btnEnglish.setText(bundle.getString("Form1.btnEnglish.text")); // NOI18N
        btnEnglish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnglishActionPerformed(evt);
            }
        });

        btnUSVietname.setText(bundle.getString("Form1.btnUSVietname.text")); // NOI18N
        btnUSVietname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUSVietnameActionPerformed(evt);
            }
        });

        btnVietnam.setText(bundle.getString("Form1.btnVietnam.text")); // NOI18N
        btnVietnam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVietnamActionPerformed(evt);
            }
        });

        mnuFile.setText(bundle.getString("Form1.mnuFile.text")); // NOI18N

        mnuItemNew.setText(bundle.getString("Form1.mnuItemNew.text")); // NOI18N
        mnuFile.add(mnuItemNew);

        mnuItemOpen.setText(bundle.getString("Form1.mnuItemOpen.text")); // NOI18N
        mnuFile.add(mnuItemOpen);

        menuBar1.add(mnuFile);

        mnuEdit.setText(bundle.getString("Form1.mnuEdit.text")); // NOI18N
        menuBar1.add(mnuEdit);

        mnuFinish.setText(bundle.getString("Form1.mnuFinish.text")); // NOI18N
        mnuFinish.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuFinishMouseClicked(evt);
            }
        });
        menuBar1.add(mnuFinish);

        setJMenuBar(menuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(lblitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblIncome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName)
                                    .addComponent(lblAge))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUSVietname)
                            .addComponent(btnEnglish)
                            .addComponent(btnVietnam))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblitle)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAge)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnglish))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIncome)
                            .addComponent(txtIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnUSVietname)))
                .addGap(18, 18, 18)
                .addComponent(btnVietnam)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuFinishMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuFinishMouseClicked
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuFinishMouseClicked

    private void btnEnglishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnglishActionPerformed
        loca = new Locale("", "");
        bun = ResourceBundle.getBundle("Bundle", loca);
        setLanguage();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnglishActionPerformed

    private void btnUSVietnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUSVietnameActionPerformed
        loca = new Locale("vi", "US");
        bun = ResourceBundle.getBundle("Bundle", loca);
        setLanguage();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnUSVietnameActionPerformed

    private void btnVietnamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVietnamActionPerformed
        loca = new Locale("vi", "VN");
        bun = ResourceBundle.getBundle("Bundle", loca);
        setLanguage();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnVietnamActionPerformed

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
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnglish;
    private javax.swing.JButton btnUSVietname;
    private javax.swing.JButton btnVietnam;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblIncome;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblitle;
    private javax.swing.JMenuBar menuBar1;
    private javax.swing.JMenu mnuEdit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenu mnuFinish;
    private javax.swing.JMenuItem mnuItemNew;
    private javax.swing.JMenuItem mnuItemOpen;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtIncome;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
