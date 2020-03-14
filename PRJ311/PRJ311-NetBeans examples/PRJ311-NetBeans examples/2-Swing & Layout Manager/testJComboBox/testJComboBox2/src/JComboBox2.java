import java.util.*;
import javax.swing.*;
public class JComboBox2 extends javax.swing.JFrame {
    DefaultComboBoxModel model1;

    public JComboBox2() {
      initComponents();
       model1 = new DefaultComboBoxModel();
       ComboBoxToModel();
       // Refresh combo1 by model1. From now the contents of combo1 and model1 are the same 
       combo1.setModel(model1); 
    }
    
    void ComboBoxToModel() {
       int n, i;
       ComboBoxModel v = (ComboBoxModel) combo1.getModel();
       n = v.getSize(); Object x;
       for(i=0;i<n;i++) {
        x = v.getElementAt(i);
        model1.addElement(x);
       }
    }

    int search(String x) { // find and return positiom (0,1,2,...) return -1 if not found
     ComboBoxModel v = (ComboBoxModel) combo1.getModel();
     int n,i;
     n = v.getSize();
     String y;
     for(i=0;i<n;i++) {
      y = (String) v.getElementAt(i);
      if(x.equalsIgnoreCase(y)) return(i);
      }
     return(-1);
     } 
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSelectedItems = new javax.swing.JButton();
        btnAllItems = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        txtNewItem = new javax.swing.JTextField();
        btnAddUnique = new javax.swing.JButton();
        btnInsertAt = new javax.swing.JButton();
        txtPos1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnRemoveAll = new javax.swing.JButton();
        btnRemoveAt = new javax.swing.JButton();
        txtPos2 = new javax.swing.JTextField();
        btnRemoveSelected = new javax.swing.JButton();
        combo1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("JComboBox  Demo 2");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSelectedItems.setText("Display selected item");
        btnSelectedItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectedItemsActionPerformed(evt);
            }
        });

        btnAllItems.setText("Display all items");
        btnAllItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllItemsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSelectedItems)
                    .addComponent(btnAllItems))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSelectedItems)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAllItems)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtNewItem.setText("New Item");

        btnAddUnique.setText("Add unique");
        btnAddUnique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUniqueActionPerformed(evt);
            }
        });

        btnInsertAt.setText("Insert at");
        btnInsertAt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertAtActionPerformed(evt);
            }
        });

        txtPos1.setText("2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(txtNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAddUnique)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnInsertAt)
                        .addGap(18, 18, 18)
                        .addComponent(txtPos1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(txtNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddUnique)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertAt)
                    .addComponent(txtPos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnRemoveAll.setText("Remove all items");
        btnRemoveAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveAllActionPerformed(evt);
            }
        });

        btnRemoveAt.setText("Remove item at");
        btnRemoveAt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveAtActionPerformed(evt);
            }
        });

        txtPos2.setText("2");

        btnRemoveSelected.setText("Remove selected item");
        btnRemoveSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveSelectedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnRemoveAt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPos2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRemoveAll)
                            .addComponent(btnRemoveSelected))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(btnRemoveAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveAt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(btnRemoveSelected)
                .addContainerGap())
        );

        combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectedItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectedItemsActionPerformed
     String x = (String) model1.getSelectedItem(); // String x = (String) combo1.getSelectedItem();
     String s = "Selected item: " + x + "\r\n";
      JOptionPane.showMessageDialog(null,s);
    }//GEN-LAST:event_btnSelectedItemsActionPerformed

    private void btnAllItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllItemsActionPerformed
     int n, i;
     ComboBoxModel v = (ComboBoxModel) combo1.getModel();
     n = v.getSize();
     String s = "";
     for(i=0;i<n;i++) 
        s +=  v.getElementAt(i) + "\r\n";
     JOptionPane.showMessageDialog(null,s);
    }//GEN-LAST:event_btnAllItemsActionPerformed

    private void btnRemoveAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAllActionPerformed
     model1.removeAllElements();
    }//GEN-LAST:event_btnRemoveAllActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
     String x = txtNewItem.getText().trim();
     model1.addElement(x); // combo1.addItem(x);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddUniqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUniqueActionPerformed
     String x = txtNewItem.getText().trim();
     int k = search(x);
     if(k>=0) {
        JOptionPane.showMessageDialog(null,"The item \"" + x + "\" already exists!");
        return;
      }        
     model1.addElement(x);
    }//GEN-LAST:event_btnAddUniqueActionPerformed

    private void btnInsertAtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertAtActionPerformed
     String x = txtNewItem.getText().trim();
     String y = txtPos1.getText().trim();
     int k = Integer.parseInt(y);
     ComboBoxModel v = combo1.getModel();
     int n = v.getSize();
     if(k<0 || k>n) return;
     model1.insertElementAt(x,k);
    }//GEN-LAST:event_btnInsertAtActionPerformed

    private void btnRemoveAtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAtActionPerformed
     int n,k,h;
     String y = txtPos2.getText().trim();
     k = Integer.parseInt(y);

     ComboBoxModel v = (ComboBoxModel) combo1.getModel();
     n = v.getSize();
     if(k<0 || k>n-1) return;
     String x = (String) model1.getElementAt(k);
     String s = "Do you remove the item " + x + "?";
     h = JOptionPane.showConfirmDialog(null, s);
     if(h==0) {
       model1.removeElementAt(k);
       
     }

    }//GEN-LAST:event_btnRemoveAtActionPerformed

    private void btnRemoveSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveSelectedActionPerformed
     String x = (String) model1.getSelectedItem();
     model1.removeElement(x);
    }//GEN-LAST:event_btnRemoveSelectedActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JComboBox2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddUnique;
    private javax.swing.JButton btnAllItems;
    private javax.swing.JButton btnInsertAt;
    private javax.swing.JButton btnRemoveAll;
    private javax.swing.JButton btnRemoveAt;
    private javax.swing.JButton btnRemoveSelected;
    private javax.swing.JButton btnSelectedItems;
    private javax.swing.JComboBox<String> combo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtNewItem;
    private javax.swing.JTextField txtPos1;
    private javax.swing.JTextField txtPos2;
    // End of variables declaration//GEN-END:variables
}
