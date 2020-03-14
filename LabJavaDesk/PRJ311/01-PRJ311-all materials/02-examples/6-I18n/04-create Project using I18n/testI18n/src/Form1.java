
import java.util.*;

public class Form1 extends javax.swing.JFrame {

    Locale loca;
    ResourceBundle bund;

    public Form1() {
        initComponents();
    }

    void setLang() {
        lblTitle.setText(bund.getString("Form1.lblTitle.text"));
        lblName.setText(bund.getString("Form1.lblName.text"));
        lblSalary.setText(bund.getString("Form1.lblSalary.text"));
        btnEN.setText(bund.getString("Form1.lblEN.text"));
        btnVN.setText(bund.getString("Form1.lblVN.text"));
        btnVN_USA.setText(bund.getString("Form1.btnVN_USA.text"));
    }

    void setEN() {
        loca = new Locale("", "");
        bund = ResourceBundle.getBundle("Bundle", loca);
        setLang();
    }

    void setVN() {
        loca = new Locale("vi", "VN");
        bund = ResourceBundle.getBundle("Bundle", loca);
        setLang();
    }

    void setVN_USA() {
        loca = new Locale("vi", "US");
        bund = ResourceBundle.getBundle("Bundle", loca);
        setLang();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblSalary = new javax.swing.JLabel();
        txtSalary = new javax.swing.JTextField();
        btnEN = new javax.swing.JButton();
        btnVN = new javax.swing.JButton();
        btnVN_USA = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 255));
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        lblTitle.setText(bundle.getString("Form1.lblTitle.text")); // NOI18N

        lblName.setText(bundle.getString("Form1.lblName.text")); // NOI18N

        lblSalary.setText(bundle.getString("Form1.lblSalary.text")); // NOI18N

        btnEN.setText(bundle.getString("Form1.btnEN.text")); // NOI18N
        btnEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnENActionPerformed(evt);
            }
        });

        btnVN.setText(bundle.getString("Form1.btnVN.text")); // NOI18N
        btnVN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVNActionPerformed(evt);
            }
        });

        btnVN_USA.setText(bundle.getString("Form1.btnVN_USA.text")); // NOI18N
        btnVN_USA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVN_USAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblSalary))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                            .addComponent(txtSalary))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEN)
                            .addComponent(btnVN)
                            .addComponent(btnVN_USA))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSalary)
                            .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnEN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVN)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVN_USA)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnENActionPerformed
        setEN();
    }//GEN-LAST:event_btnENActionPerformed

    private void btnVNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVNActionPerformed
        setVN();
    }//GEN-LAST:event_btnVNActionPerformed

    private void btnVN_USAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVN_USAActionPerformed
        setVN_USA();
    }//GEN-LAST:event_btnVN_USAActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEN;
    private javax.swing.JButton btnVN;
    private javax.swing.JButton btnVN_USA;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSalary;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSalary;
    // End of variables declaration//GEN-END:variables
}
