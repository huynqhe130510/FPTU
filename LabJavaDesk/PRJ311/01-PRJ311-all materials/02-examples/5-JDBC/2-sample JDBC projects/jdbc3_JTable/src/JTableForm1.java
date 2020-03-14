import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import com.context.DBContext;
public class JTableForm1 extends javax.swing.JFrame {
    DefaultTableModel t;
    Connection con;
    Statement s;
    ResultSet rs;
    String xSql;
    public JTableForm1() {
        initComponents();
        t = (DefaultTableModel) tbl1.getModel();
        con = null;
        s = null;
        rs = null;
        xSql = null;
    }
    
    void makeJdbcConnection() {
      DBContext u = new DBContext();  
      try {
        con = u.getConnection();
        lblConnectionResult.setText("Connection successful.");
        s = con.createStatement();
      }
      catch(Exception e) {
        lblConnectionResult.setText("Connection failed.");
      }
    }
    
    void clearTable() {
      int n,i; n = tbl1.getRowCount();
      for(i=0;i<n;i++) t.removeRow(0);
    }
    
    void updateTable() {
      if(xSql == null) return;
      if(s == null) return;
      clearTable();
      try {
        rs = s.executeQuery(xSql);
        String xRollNo, xName; int xMark;
        while(rs.next()) {
          xRollNo = rs.getString("rollNo");
          xName = rs.getString("name");
          xMark = rs.getInt("mark");
          Object [] a = {xRollNo, xName, xMark};
          t.addRow(a);
        }
       rs.close();   
      }
      catch(Exception e) {
          
      }
    }

    void addToStudent(String xRollNo, String xName, int xMark) {
      if(s == null) return;
      xSql = "select * from student where rollNo = '" + xRollNo + "'";
      try {
        rs = s.executeQuery(xSql);
        rs.next();
        if(rs.getRow() > 0) {
          JOptionPane.showMessageDialog(null,"Te rollno " + xRollNo + " already existx. Cannot insert.");
          rs.close();
          return;
        }
        
        xSql = "insert into Student values ('" + xRollNo + "','" + xName + "', '" + xMark + ")";
        s.execute(xSql);
        xSql = "select * from student";
        updateTable();
      }
      catch(Exception e) {
          
      }
    }
    
    void deleFromStudent(String xRollNo) {
      if(s == null) return;
      xSql = "delete from student where rollno = '" + xRollNo + "'";
      
      try {s.execute(xSql);} catch(Exception e) {}
      xSql = "select * from student";
      updateTable();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnLoadData = new javax.swing.JButton();
        lblConnectionResult = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        txtSName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRollNo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMark = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSortBy = new javax.swing.JButton();
        cboSortBy = new javax.swing.JComboBox<>();
        btnDeleSelected = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "rollNo", "name", "mark"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl1.setGridColor(new java.awt.Color(0, 0, 204));
        jScrollPane1.setViewportView(tbl1);
        if (tbl1.getColumnModel().getColumnCount() > 0) {
            tbl1.getColumnModel().getColumn(0).setMinWidth(30);
            tbl1.getColumnModel().getColumn(0).setPreferredWidth(40);
            tbl1.getColumnModel().getColumn(0).setMaxWidth(50);
            tbl1.getColumnModel().getColumn(1).setMinWidth(70);
            tbl1.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbl1.getColumnModel().getColumn(1).setMaxWidth(140);
            tbl1.getColumnModel().getColumn(2).setMinWidth(30);
            tbl1.getColumnModel().getColumn(2).setPreferredWidth(40);
            tbl1.getColumnModel().getColumn(2).setMaxWidth(50);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("List of students");

        btnLoadData.setText("Load data");
        btnLoadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDataActionPerformed(evt);
            }
        });

        lblConnectionResult.setText("Connection result ");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel2.setText("RollNo:");

        jLabel3.setText("Name:");

        jLabel4.setText("Mark:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSortBy.setText("Sort by");
        btnSortBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortByActionPerformed(evt);
            }
        });

        cboSortBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RollNo", "Name", "Mark" }));

        btnDeleSelected.setText("Delete selected row");
        btnDeleSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleSelectedActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLoadData)
                            .addComponent(btnSearch))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblConnectionResult, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSName, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAdd)
                                    .addComponent(btnDelete)
                                    .addComponent(btnSortBy)
                                    .addComponent(cboSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRollNo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtMark, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnDeleSelected)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoadData)
                    .addComponent(lblConnectionResult))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtSName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRollNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSortBy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboSortBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnDeleSelected)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataActionPerformed
      makeJdbcConnection();
      xSql = "select * from student";
      updateTable();
      // TODO add your handling code here:
    }//GEN-LAST:event_btnLoadDataActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
     String xName = txtSName.getText().trim();
     int k = xName.length();
     xSql = "select * from student where left(name," + k + ") = '" + xName + "'";
     updateTable();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
     String xRollNo = txtRollNo.getText().trim();
     String xName = txtName.getText().trim();
     String x = txtMark.getText().trim();
     int xMark = Integer.parseInt(x);
     addToStudent(xRollNo,xName,xMark);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
     String xRollNo = txtRollNo.getText().trim();
     deleFromStudent(xRollNo);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSortByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortByActionPerformed
      int k = cboSortBy.getSelectedIndex();
      String x = null;
      switch(k) {
        case 0: x = "rollNo"; break;
        case 1: x = "name"; break;
        case 2: x = "mark"; break;
    }
     xSql = "select * from student order by " + x;
     updateTable();


        // TODO add your handling code here:
    }//GEN-LAST:event_btnSortByActionPerformed

    private void btnDeleSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleSelectedActionPerformed
     int r = tbl1.getSelectedRow();
     String xRollNo = (String) tbl1.getValueAt(r, 0);
     deleFromStudent(xRollNo);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleSelectedActionPerformed

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
            java.util.logging.Logger.getLogger(JTableForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JTableForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JTableForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JTableForm1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JTableForm1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDeleSelected;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLoadData;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSortBy;
    private javax.swing.JComboBox<String> cboSortBy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblConnectionResult;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField txtMark;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRollNo;
    private javax.swing.JTextField txtSName;
    // End of variables declaration//GEN-END:variables
}
