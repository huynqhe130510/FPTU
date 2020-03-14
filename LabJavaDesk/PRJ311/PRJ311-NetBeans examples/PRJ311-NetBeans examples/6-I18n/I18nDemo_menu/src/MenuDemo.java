import javax.swing.*;
import java.util.*;
public class MenuDemo extends javax.swing.JFrame {
    Locale loca;
    ResourceBundle bund;
    public MenuDemo() {
        initComponents();
    }
void setLang() {
  menuFile.setText(bund.getString("MenuDemo.menuFile.text"));
  menuEdit.setText(bund.getString("MenuDemo.menuEdit.text"));
  menuExit.setText(bund.getString("MenuDemo.menuExit.text"));
  menuSaveAs.setText(bund.getString("MenuDemo.menuSaveAs.text"));
  menuItemNew.setText(bund.getString("MenuDemo.menuItemNew.text"));
  menuItemOpen.setText(bund.getString("MenuDemo.menuItemOpen.text"));
  menuItemTextFile.setText(bund.getString("MenuDemo.menuItemTextFile.text"));
  menuItemPDFFile.setText(bund.getString("MenuDemo.menuItemPDFFile.text"));
  lblTitle.setText(bund.getString("MenuDemo.lblTitle.text"));
  lblCode.setText(bund.getString("MenuDemo.lblCode.text"));
  lblName.setText(bund.getString("MenuDemo.lblName.text"));
  btnReset1.setText(bund.getString("MenuDemo.btnReset1.text"));
  btnVietnam1.setText(bund.getString("MenuDemo.btnVietnam1.text"));
  btnVietnam2.setText(bund.getString("MenuDemo.btnVietnam2.text"));
  lblAge.setText(bund.getString("MenuDemo.lblAge.text"));

}
          
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        lblCode = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        btnVietnam1 = new javax.swing.JButton();
        btnReset1 = new javax.swing.JButton();
        btnVietnam2 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuItemOpen = new javax.swing.JMenuItem();
        menuItemNew = new javax.swing.JMenuItem();
        menuSaveAs = new javax.swing.JMenu();
        menuItemTextFile = new javax.swing.JMenuItem();
        menuItemPDFFile = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        menuExit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        lblTitle.setText(bundle.getString("MenuDemo.lblTitle.text")); // NOI18N

        lblName.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblName.setText(bundle.getString("MenuDemo.lblName.text")); // NOI18N

        txtCode.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        lblCode.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblCode.setText(bundle.getString("MenuDemo.lblCode.text")); // NOI18N

        txtName.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        lblAge.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lblAge.setText(bundle.getString("MenuDemo.lblAge.text")); // NOI18N

        txtAge.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        btnVietnam1.setText(bundle.getString("MenuDemo.btnVietnam1.text")); // NOI18N
        btnVietnam1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVietnam1ActionPerformed(evt);
            }
        });

        btnReset1.setText(bundle.getString("MenuDemo.btnReset1.text")); // NOI18N
        btnReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset1ActionPerformed(evt);
            }
        });

        btnVietnam2.setText(bundle.getString("MenuDemo.btnVietnam2.text")); // NOI18N
        btnVietnam2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVietnam2ActionPerformed(evt);
            }
        });

        menuFile.setText(bundle.getString("MenuDemo.menuFile.text")); // NOI18N

        menuItemOpen.setText(bundle.getString("MenuDemo.menuItemOpen.text")); // NOI18N
        menuFile.add(menuItemOpen);

        menuItemNew.setText(bundle.getString("MenuDemo.menuItemNew.text")); // NOI18N
        menuFile.add(menuItemNew);

        menuSaveAs.setText(bundle.getString("MenuDemo.menuSaveAs.text")); // NOI18N

        menuItemTextFile.setText(bundle.getString("MenuDemo.menuItemTextFile.text")); // NOI18N
        menuItemTextFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTextFileActionPerformed(evt);
            }
        });
        menuSaveAs.add(menuItemTextFile);

        menuItemPDFFile.setText(bundle.getString("MenuDemo.menuItemPDFFile.text")); // NOI18N
        menuSaveAs.add(menuItemPDFFile);

        menuFile.add(menuSaveAs);

        menuBar.add(menuFile);

        menuEdit.setText(bundle.getString("MenuDemo.menuEdit.text")); // NOI18N
        menuBar.add(menuEdit);

        menuExit.setText(bundle.getString("MenuDemo.menuExit.text")); // NOI18N
        menuExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuExitMouseClicked(evt);
            }
        });
        menuBar.add(menuExit);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblCode)
                        .addGap(18, 18, 18)
                        .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblName)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAge)
                                .addGap(27, 27, 27)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(115, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVietnam2)
                    .addComponent(btnVietnam1))
                .addGap(50, 50, 50))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(288, Short.MAX_VALUE)
                    .addComponent(btnReset1)
                    .addGap(51, 51, 51)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCode)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAge)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(btnVietnam1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVietnam2)
                .addGap(24, 24, 24))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(156, Short.MAX_VALUE)
                    .addComponent(btnReset1)
                    .addGap(100, 100, 100)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemTextFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTextFileActionPerformed
      JOptionPane.showMessageDialog(null, "Text file selected");
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemTextFileActionPerformed

    private void menuExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuExitMouseClicked
      System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_menuExitMouseClicked

    private void btnVietnam1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVietnam1ActionPerformed
      loca = new Locale("vi","VN");
      bund = ResourceBundle.getBundle("Bundle", loca);
      setLang();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnVietnam1ActionPerformed

    private void btnReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset1ActionPerformed
     loca = new Locale("","");
     bund = ResourceBundle.getBundle("Bundle", loca);
     setLang();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReset1ActionPerformed

    private void btnVietnam2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVietnam2ActionPerformed
     loca = new Locale("de","DE");
     bund = ResourceBundle.getBundle("Bundle", loca);
     setLang();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVietnam2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look    d feel */
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
            java.util.logging.Logger.getLogger(MenuDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuDemo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuDemo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset1;
    private javax.swing.JButton btnVietnam1;
    private javax.swing.JButton btnVietnam2;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenu menuExit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuItemNew;
    private javax.swing.JMenuItem menuItemOpen;
    private javax.swing.JMenuItem menuItemPDFFile;
    private javax.swing.JMenuItem menuItemTextFile;
    private javax.swing.JMenu menuSaveAs;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
