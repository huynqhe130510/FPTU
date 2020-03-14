import javax.swing.*;
import java.util.*;
public class JList1 extends javax.swing.JFrame {
    DefaultListModel t;
    public JList1() {
        initComponents();
        t = new DefaultListModel();
        list1.setModel(t);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        list1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txtNewItem = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDispSelectedItem = new javax.swing.JButton();
        btnDelSelectedItem = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        btnDispAllSelectedItems = new javax.swing.JButton();
        btnDelAllSelectedItems = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        list1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(list1);

        jLabel1.setText("Enter new item:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDispSelectedItem.setText("Display (first) selected item");
        btnDispSelectedItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDispSelectedItemActionPerformed(evt);
            }
        });

        btnDelSelectedItem.setText("Delete selected item");
        btnDelSelectedItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelSelectedItemActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("JList demo 1");

        btnDispAllSelectedItems.setText("Display all selected items");
        btnDispAllSelectedItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDispAllSelectedItemsActionPerformed(evt);
            }
        });

        btnDelAllSelectedItems.setText("Delete all selected items");
        btnDelAllSelectedItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelAllSelectedItemsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDispSelectedItem)
                            .addComponent(btnAdd)
                            .addComponent(btnDispAllSelectedItems)
                            .addComponent(btnDelSelectedItem)
                            .addComponent(btnDelAllSelectedItems)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(174, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDispSelectedItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDispAllSelectedItems)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(btnDelSelectedItem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelAllSelectedItems)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
      String x = txtNewItem.getText();
      t.addElement(x);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDispSelectedItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDispSelectedItemActionPerformed
     String x = list1.getSelectedValue();
     JOptionPane.showMessageDialog(null, "Selected item is " + x);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDispSelectedItemActionPerformed

    private void btnDelSelectedItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelSelectedItemActionPerformed
      int k = list1.getSelectedIndex();
      t.remove(k);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelSelectedItemActionPerformed

    private void btnDispAllSelectedItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDispAllSelectedItemsActionPerformed
      List h = list1.getSelectedValuesList();
      String s = "";
      Iterator u = h.iterator();
      while(u.hasNext()) s += u.next() + "\r\n";
      JOptionPane.showMessageDialog(null,s);
    }//GEN-LAST:event_btnDispAllSelectedItemsActionPerformed

    private void btnDelAllSelectedItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelAllSelectedItemsActionPerformed
     int n, i;
     List<String> u = list1.getSelectedValuesList();
     for(String x : u) t.removeElement(x);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelAllSelectedItemsActionPerformed

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
            java.util.logging.Logger.getLogger(JList1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JList1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JList1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JList1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JList1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelAllSelectedItems;
    private javax.swing.JToggleButton btnDelSelectedItem;
    private javax.swing.JButton btnDispAllSelectedItems;
    private javax.swing.JButton btnDispSelectedItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list1;
    private javax.swing.JTextField txtNewItem;
    // End of variables declaration//GEN-END:variables
}
