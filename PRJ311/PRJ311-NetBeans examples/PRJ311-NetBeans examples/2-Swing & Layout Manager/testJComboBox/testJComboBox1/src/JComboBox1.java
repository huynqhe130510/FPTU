import java.util.*;
import javax.swing.*;
public class JComboBox1 extends javax.swing.JFrame {
    DefaultComboBoxModel t;

    public JComboBox1() {
      initComponents();
       t = new DefaultComboBoxModel();
       ComboBoxToModel();
       // Refresh combo1 by t. From now the contents of combo1 and t are the same 
       combo1.setModel(t); 
    }
    
    void ComboBoxToModel() {
       int n, i;
       ComboBoxModel v = (ComboBoxModel) combo1.getModel();
       n = v.getSize(); Object x;
       for(i=0;i<n;i++) {
        x = v.getElementAt(i);
        t.addElement(x);
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
        combo1 = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        txtNewItem = new javax.swing.JTextField();
        btnSelectedItems = new javax.swing.JButton();
        btnRemoveSelected = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("JComboBox  Demo 1");

        combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtNewItem.setText("New Item");

        btnSelectedItems.setText("Display selected item");
        btnSelectedItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectedItemsActionPerformed(evt);
            }
        });

        btnRemoveSelected.setText("Remove selected item");
        btnRemoveSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveSelectedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSelectedItems)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(txtNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnRemoveSelected)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel1)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNewItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd))
                .addGap(28, 28, 28)
                .addComponent(btnSelectedItems)
                .addGap(18, 18, 18)
                .addComponent(btnRemoveSelected)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectedItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectedItemsActionPerformed
     String x = (String) t.getSelectedItem(); // String x = (String) combo1.getSelectedItem();
     String s = "Selected item: " + x + "\r\n";
      JOptionPane.showMessageDialog(null,s);
    }//GEN-LAST:event_btnSelectedItemsActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
     String x = txtNewItem.getText().trim();
     t.addElement(x); // combo1.addItem(x);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveSelectedActionPerformed
     String x = (String) t.getSelectedItem();
     t.removeElement(x);
    }//GEN-LAST:event_btnRemoveSelectedActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JComboBox1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemoveSelected;
    private javax.swing.JButton btnSelectedItems;
    private javax.swing.JComboBox<String> combo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtNewItem;
    // End of variables declaration//GEN-END:variables
}
