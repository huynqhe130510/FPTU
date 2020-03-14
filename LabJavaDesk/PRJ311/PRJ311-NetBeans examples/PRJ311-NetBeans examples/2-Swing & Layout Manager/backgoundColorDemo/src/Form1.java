public class Form1 extends javax.swing.JFrame {

    public Form1() {
        initComponents();
        this.setSize(480, 400);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tabPane1 = new javax.swing.JTabbedPane();
        panel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnToTab2 = new javax.swing.JButton();
        btnToTab3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jButton1.setText("Tab1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(122, 0, 57, 23);

        jButton2.setText("Tab2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(189, 0, 57, 23);

        jButton3.setText("Tab3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(252, 0, 57, 23);

        panel1.setLayout(null);

        jLabel1.setText("jLabel1");
        panel1.add(jLabel1);
        jLabel1.setBounds(34, 27, 34, 14);

        btnToTab2.setText("go to tab 2");
        btnToTab2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToTab2ActionPerformed(evt);
            }
        });
        panel1.add(btnToTab2);
        btnToTab2.setBounds(184, 107, 85, 23);

        btnToTab3.setText("go to tab 3");
        btnToTab3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToTab3ActionPerformed(evt);
            }
        });
        panel1.add(btnToTab3);
        btnToTab3.setBounds(184, 136, 85, 23);

        jLabel4.setIcon(new javax.swing.ImageIcon("D:\\JavaEXS\\backgoundColorDemo\\images\\pathstones.jpg")); // NOI18N
        panel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 310, 170);

        tabPane1.addTab("tab1", panel1);

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel2)
                .addContainerGap(192, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel2)
                .addContainerGap(101, Short.MAX_VALUE))
        );

        tabPane1.addTab("tab2", panel2);

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap(208, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(72, 72, 72))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(87, 87, 87))
        );

        tabPane1.addTab("tab3", panel3);

        getContentPane().add(tabPane1);
        tabPane1.setBounds(63, 70, 319, 201);

        jLabel5.setIcon(new javax.swing.ImageIcon("D:\\JavaEXS\\backgoundColorDemo\\images\\Ocean.JPG")); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 450, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

     tabPane1.setSelectedComponent(panel1);
     //tabPane1.setSelectedIndex(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
tabPane1.setSelectedIndex(1);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

tabPane1.setSelectedComponent(panel3);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnToTab2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToTab2ActionPerformed
tabPane1.setSelectedIndex(1);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnToTab2ActionPerformed

    private void btnToTab3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToTab3ActionPerformed
tabPane1.setSelectedComponent(panel3);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnToTab3ActionPerformed

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
    private javax.swing.JButton btnToTab2;
    private javax.swing.JButton btnToTab3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel3;
    private javax.swing.JTabbedPane tabPane1;
    // End of variables declaration//GEN-END:variables
}
