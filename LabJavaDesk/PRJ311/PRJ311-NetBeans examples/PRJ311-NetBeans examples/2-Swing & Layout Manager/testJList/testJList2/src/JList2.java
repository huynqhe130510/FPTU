import java.util.*;
import javax.swing.*;
public class JList2 extends javax.swing.JFrame {
    DefaultListModel t;

    public JList2() {
      initComponents();
       t = new DefaultListModel();
       listToModel();
       // Refresh list1 by t. From now the contents of the list1 and t are the same 
       list1.setModel(t);
    }
    
    void listToModel() {
       int n, i;
       ListModel u = list1.getModel();
       n = u.getSize();
       Object x;
       for(i=0;i<n;i++) {
        x = u.getElementAt(i);
        t.addElement(x);
       }
    }
    int search(String x) { // find and return positiom (0,1,2,...) return -1 if not found
     int n,i;
     ListModel u = list1.getModel();
     n = u.getSize();
     String y;
     for(i=0;i<n;i++) {
      y = (String) u.getElementAt(i);
      if(x.equalsIgnoreCase(y)) return(i);
      }
     return(-1);
     } 
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        btnSelectedItem = new javax.swing.JButton();
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
        btnRemoveAllSelected = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("JList  Demo 2");

        list1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(list1);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSelectedItem.setText("Display (first) selected item");
        btnSelectedItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectedItemActionPerformed(evt);
            }
        });

        btnSelectedItems.setText("Display selected items");
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
                    .addComponent(btnSelectedItem)
                    .addComponent(btnSelectedItems)
                    .addComponent(btnAllItems))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSelectedItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSelectedItems)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAllItems)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        btnRemoveAllSelected.setText("Remove all selected items");
        btnRemoveAllSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveAllSelectedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemoveAll)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnRemoveAt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPos2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRemoveAllSelected))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btnRemoveAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveAt)
                    .addComponent(txtPos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemoveAllSelected)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel1)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectedItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectedItemsActionPerformed
     int n, i;
     List<String> u = list1.getSelectedValuesList();
     n = u.size();
     String s = "";
     for(i=0;i<n;i++) 
       s += u.get(i) + "\r\n";
     JOptionPane.showMessageDialog(null,s);
    }//GEN-LAST:event_btnSelectedItemsActionPerformed

    private void btnAllItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllItemsActionPerformed
     int n, i;
     ListModel v = list1.getModel();
     n = v.getSize();
     String s = "";
     for(i=0;i<n;i++) 
        s +=  v.getElementAt(i) + "\r\n";
     JOptionPane.showMessageDialog(null,s);
    }//GEN-LAST:event_btnAllItemsActionPerformed

    private void btnSelectedItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectedItemActionPerformed
     String s = (String) list1.getSelectedValue();
     JOptionPane.showMessageDialog(null,s);
    }//GEN-LAST:event_btnSelectedItemActionPerformed

    private void btnRemoveAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAllActionPerformed
     t.removeAllElements();
     
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveAllActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
     String x = txtNewItem.getText().trim();
     t.addElement(x);
     
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddUniqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUniqueActionPerformed
     String x = txtNewItem.getText().trim();
     int k = search(x);
     if(k>=0) {
        JOptionPane.showMessageDialog(null,"The item \"" + x + "\" already exists!");
        return;
      }        
     t.addElement(x);
     
    }//GEN-LAST:event_btnAddUniqueActionPerformed

    private void btnInsertAtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertAtActionPerformed
     String x = txtNewItem.getText().trim();
     String y = txtPos1.getText().trim();
     int k = Integer.parseInt(y);
     ListModel v = list1.getModel();
     int n = v.getSize();
     if(k<0 || k>n) return;
     t.add(k, x);
     
    }//GEN-LAST:event_btnInsertAtActionPerformed

    private void btnRemoveAtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAtActionPerformed
     int n,k,h;
     String y = txtPos2.getText().trim();
     k = Integer.parseInt(y);

     ListModel v = list1.getModel();
     n = v.getSize();
     if(k<0 || k>n-1) return;
     String x = (String) t.get(k);
     String s = "Do you remove the item " + x + "?";
     h = JOptionPane.showConfirmDialog(null, s);
     if(h==0) {
       t.remove(k);
       
     }

    }//GEN-LAST:event_btnRemoveAtActionPerformed

    private void btnRemoveAllSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAllSelectedActionPerformed
     int n, i;
     List<String> u = list1.getSelectedValuesList();
     for(String x : u) t.removeElement(x);
    }//GEN-LAST:event_btnRemoveAllSelectedActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JList2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddUnique;
    private javax.swing.JButton btnAllItems;
    private javax.swing.JButton btnInsertAt;
    private javax.swing.JButton btnRemoveAll;
    private javax.swing.JButton btnRemoveAllSelected;
    private javax.swing.JButton btnRemoveAt;
    private javax.swing.JButton btnSelectedItem;
    private javax.swing.JButton btnSelectedItems;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list1;
    private javax.swing.JTextField txtNewItem;
    private javax.swing.JTextField txtPos1;
    private javax.swing.JTextField txtPos2;
    // End of variables declaration//GEN-END:variables
}
