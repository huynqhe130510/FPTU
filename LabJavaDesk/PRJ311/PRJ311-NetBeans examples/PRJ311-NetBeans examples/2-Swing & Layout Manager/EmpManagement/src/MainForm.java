import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
public class MainForm extends javax.swing.JFrame {
MyList g;
   DefaultTableModel u;

   public MainForm() {
        initComponents();
        g = new MyList();
        u = (DefaultTableModel) tbl1.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSal = new javax.swing.JTextField();
        txtBonus = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLoadData = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNameSearch = new javax.swing.JTextField();
        btnSearchExact = new javax.swing.JButton();
        btnSearchRel = new javax.swing.JButton();
        btnDeleByName = new javax.swing.JButton();
        btnSortByName = new javax.swing.JButton();
        btnClearAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 0));

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Code", "Name", "Salary", "Bonus"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl1);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Code:");

        jLabel3.setText("Name:");

        jLabel4.setText("Salary:");

        jLabel5.setText("Bonus:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnAdd))
                    .addComponent(txtSal, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtSal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addContainerGap())
        );

        jLabel1.setText("Employee information:");

        btnLoadData.setText("Load data from file");
        btnLoadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDataActionPerformed(evt);
            }
        });

        jLabel6.setText("Name:");

        btnSearchExact.setText("Exact Search");
        btnSearchExact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchExactActionPerformed(evt);
            }
        });

        btnSearchRel.setText("Relative Search");
        btnSearchRel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchRelActionPerformed(evt);
            }
        });

        btnDeleByName.setText("Delete by name");
        btnDeleByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleByNameActionPerformed(evt);
            }
        });

        btnSortByName.setText("Sort by name");
        btnSortByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortByNameActionPerformed(evt);
            }
        });

        btnClearAll.setText("Clear all");
        btnClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSearchRel)
                                    .addComponent(btnSearchExact)
                                    .addComponent(btnDeleByName)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnSortByName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLoadData)
                        .addGap(55, 55, 55)
                        .addComponent(btnClearAll)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadData)
                    .addComponent(btnClearAll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSortByName)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchExact)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchRel)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleByName))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataActionPerformed
      JFileChooser fc = new JFileChooser();
      fc.setCurrentDirectory(new File(System.getProperty("user.dir")));
      String fname = null;
      try {
            int result= fc.showOpenDialog(null);
            if (result==JFileChooser.APPROVE_OPTION) {
                File f= fc.getSelectedFile();
                fname = f.getName();
              }
             else
              return;
         } 
         catch(Exception e) {}
      g.loadFile(fname);
      if(!g.isEmpty()) udateTbl(g);        // TODO add your handling code here:


        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoadDataActionPerformed
    public boolean isExist(String xCode) {
      int n,i; String s;
      n = tbl1.getRowCount();
      for(i=0;i<n;i++) {
       s = (String) tbl1.getValueAt(i, 0);
       
       if(s!=null && s.trim().equalsIgnoreCase(xCode.trim())) return(true);
      }
      return(false);
    }
    public void addNewRow(Object [] a) {
      String xCode = (String) a[0];
      if(isExist(xCode)) {
        JOptionPane.showMessageDialog(null, "The code " + xCode + " already exists, cannot add!");
        return;
      }
      u.addRow(a);
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
     String xCode, xName, sSal, sBonus; int xSal, xBonus;
     xCode = txtCode.getText().trim();
     xName = txtName.getText().trim();
     sSal = txtSal.getText().trim();
     sBonus = txtBonus.getText().trim();
     boolean isOk = true;
     if(xCode.equals("")) isOk = false;
     if(xName.equals("")) isOk = false;
     if(sSal.equals("")) isOk = false;
     if(sBonus.equals("")) isOk = false;
     if(!isOk) {
      JOptionPane.showMessageDialog(null,"The data cannot be empty!");
      return;   
     }   
     xSal = Integer.parseInt(sSal);
     xBonus = Integer.parseInt(sBonus);
     g.add(new Emp(xCode,xName,xSal,xBonus));
     Object [] a = {xCode, xName, xSal, xBonus};
     addNewRow(a);        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchExactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchExactActionPerformed
     String xName = txtNameSearch.getText().trim();
     MyList h = new MyList();
     g.searchByName(h,xName);
     udateTbl(h);

// TODO add your handling code here:
    }//GEN-LAST:event_btnSearchExactActionPerformed

    private void btnSearchRelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchRelActionPerformed
     String xName = txtNameSearch.getText().trim();
     MyList h = new MyList();
     g.searchByNameRel(h,xName);
     udateTbl(h);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchRelActionPerformed

    private void btnDeleByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleByNameActionPerformed
     String xName, sName;
     xName = txtNameSearch.getText().trim();
     int i,n,k;
     i = g.searchByName(xName);
     g.dele(i);

     n = tbl1.getRowCount();
     k = -1;
     for(i=0;i<n;i++) {
       sName = (String) tbl1.getValueAt(i, 1);
       sName = sName.trim();
       if(sName.equals(xName)) k = i;
      }
     if(k>-0) u.removeRow(k);

// TODO add your handling code here:
    }//GEN-LAST:event_btnDeleByNameActionPerformed

    private void btnSortByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortByNameActionPerformed
     g.sortByName();
     udateTbl(g);        
    }//GEN-LAST:event_btnSortByNameActionPerformed

    private void btnClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAllActionPerformed
     clearTbl();
     g.clear();
    }//GEN-LAST:event_btnClearAllActionPerformed
 void clearTbl() {
   int n, i;
   n = tbl1.getRowCount();
   for(i=0;i<n;i++) u.removeRow(0);
    
}
void udateTbl(MyList v) {
   clearTbl();
   int n, i;Emp x;
   n = v.size();
   for(i=0;i<n;i++) {
    x = v.get(i);
    u.insertRow(tbl1.getRowCount(),new Object[4]);
    tbl1.setValueAt(x.code, i, 0);
    tbl1.setValueAt(x.name, i, 1);
    tbl1.setValueAt(x.sal, i, 2);
    tbl1.setValueAt(x.bonus, i, 3);
  }
 
 }

        
    
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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClearAll;
    private javax.swing.JButton btnDeleByName;
    private javax.swing.JButton btnLoadData;
    private javax.swing.JButton btnSearchExact;
    private javax.swing.JButton btnSearchRel;
    private javax.swing.JButton btnSortByName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField txtBonus;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNameSearch;
    private javax.swing.JTextField txtSal;
    // End of variables declaration//GEN-END:variables
}
