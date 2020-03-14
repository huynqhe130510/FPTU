import java.sql.*;
import javax.swing.table.*;
public class H_JDBC_in_Form extends javax.swing.JFrame {
    Connection con;
    Statement s;
    ResultSet rs;
    String xSql;
    DefaultTableModel g;

    public H_JDBC_in_Form() {
      initComponents();
      g = (DefaultTableModel) tbl1.getModel();
      loadDB();
    }
    void loadDB() {
      DBConnect u = new DBConnect(); 
      try {
       con = u.getConnection();
       s = con.createStatement();
      }
      catch(Exception e) {
       e.printStackTrace();
      }
    }
    void runSQL() {
      String xRollNo, xName;
      int xMark;
      try {
      rs = s.executeQuery(xSql);
      g.setRowCount(0); // clear all rows of the table tbl1
      while(rs.next()) {
         xRollNo = new String(rs.getString("rollno"));
         xName = new String(rs.getString("name"));
         xMark = rs.getInt("mark");
         g.insertRow(tbl1.getRowCount(),new Object[]{xRollNo,xName,xMark});
        }
       rs.close();
      }
      catch(SQLException e) {
       e.printStackTrace();
      }

        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grDele = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        btnAll = new javax.swing.JButton();
        btnSearchByName = new javax.swing.JButton();
        txtSName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        btnSort = new javax.swing.JButton();
        cboSort = new javax.swing.JComboBox<>();
        btnInsert = new javax.swing.JButton();
        btnDeleByName = new javax.swing.JButton();
        radFirst = new javax.swing.JRadioButton();
        radAll = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRollNo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMark = new javax.swing.JTextField();
        btnDeleCurrRow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("List of students");

        btnAll.setText("Display all");
        btnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllActionPerformed(evt);
            }
        });

        btnSearchByName.setText("Search by name");
        btnSearchByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByNameActionPerformed(evt);
            }
        });

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RollNo", "Name", "Mark"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl1);

        btnSort.setText("Sort by");
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        cboSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RollNo", "Name", "Matk" }));

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnDeleByName.setText("Delete by name");
        btnDeleByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleByNameActionPerformed(evt);
            }
        });

        grDele.add(radFirst);
        radFirst.setText("First");

        grDele.add(radAll);
        radAll.setText("All");

        jLabel2.setText("Name:");

        jLabel3.setText("RollNo:");

        jLabel4.setText("Mark:");

        btnDeleCurrRow.setText("Delete slected row");
        btnDeleCurrRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleCurrRowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radAll, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(radFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAll)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearchByName, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSName, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeleByName, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSort)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cboSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(txtRollNo))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMark, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnInsert)
                                .addGap(52, 52, 52))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(btnDeleCurrRow)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDeleByName)
                        .addComponent(txtSName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAll)
                        .addComponent(btnSearchByName)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(radFirst)
                        .addGap(17, 17, 17)
                        .addComponent(radAll)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSort)
                            .addComponent(cboSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRollNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleCurrRow)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInsert))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllActionPerformed
      xSql = "select * from Student";
      runSQL();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAllActionPerformed

    private void btnSearchByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByNameActionPerformed
     String xName = txtSName.getText().trim();
     int r = xName.length();
     xSql = "select * from Student where left(name," + r + ") = '" + xName + "'";
     runSQL();           
    }//GEN-LAST:event_btnSearchByNameActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
     String xRollNo = txtRollNo.getText().trim();
     String xName = txtName.getText().trim();
     String sMark = txtMark.getText().trim();
     if(xRollNo.length()==0 || xName.length()==0 || sMark.length()==0) {
       javax.swing.JOptionPane.showMessageDialog(null,"You must enter data for RollNo, name and mark fields!");
       return; 
     }
     xSql = "select * from Student where RollNo = '" + xRollNo + "'";
     try {
     rs = s.executeQuery(xSql);
     rs.next();
     if(rs.getRow() > 0) {
       String sMess = "The RollNo " + xRollNo + " already exists, cannot insert";  
       javax.swing.JOptionPane.showMessageDialog(null,sMess);
       txtRollNo.requestFocus();
       return; 
     }
     int xMark = Integer.parseInt(sMark);
     xSql = "INSERT INTO Student (RollNo,Name,Mark) VALUES ('" + xRollNo + "','" + xName + "'," + xMark + ")";
     s.execute(xSql);
     xSql = "select * from Student";
     runSQL();
     }
     catch(SQLException e) {
       e.printStackTrace();
     }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnDeleByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleByNameActionPerformed
     String xName, xxName;
     xName = txtSName.getText().trim();
     int r = xName.length();
     if(r==0) {
       javax.swing.JOptionPane.showMessageDialog(null,"You must enter the (part of) name to be deleted!");
       txtSName.requestFocus();
       return; 
     }
     String xRollNo = null;
     xSql = "select * from Student where left(name," + r + ") = '" + xName + "'";
     try {
     rs = s.executeQuery(xSql);
     rs.next();
     if(rs.getRow() == 0) return; // not found
     
     if(radFirst.isSelected()) {
       boolean found = false;
       xSql = "select * from Student";
       rs = s.executeQuery(xSql);
       while(rs.next()) {
         xxName = new String(rs.getString("name"));
         if(xxName.substring(0,r).equals(xName)) {
          xRollNo = new String(rs.getString("rollno"));
          found = true;
          break;
         }
        }
       rs.close();
       if(found)
        xSql = "delete from Student where RollNo = '" + xRollNo + "'";
      }
     else if(radAll.isSelected()) {
      xSql = "delete from Student where left(name," + r + ") = '" + xName + "'";
     }
     else {
       javax.swing.JOptionPane.showMessageDialog(null,"You must select the type of deletion!");
       return; 
     }
     s.execute(xSql);
     xSql = "select * from Student";
     
     runSQL();           
    }
     catch(SQLException e) {
       e.printStackTrace();
     }


    }//GEN-LAST:event_btnDeleByNameActionPerformed

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
     if(cboSort.getSelectedItem().equals("RollNo")) {
      xSql = "select * from Student order by RollNo";   
     }
     else if(cboSort.getSelectedItem().equals("Name")) {
      xSql = "select * from Student order by Name";   
         
     }
     else {
      xSql = "select * from Student order by Mark";   
         
     }
     runSQL();           
    }//GEN-LAST:event_btnSortActionPerformed

    private void btnDeleCurrRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleCurrRowActionPerformed
      int row = tbl1.getSelectedRow();
      int col = 0;
      String xRollNo = g.getValueAt(row, col).toString().trim();
      xSql = "delete from Student where RollNo = '" + xRollNo + "'";
      try {
       s.execute(xSql);
       xSql = "select * from Student";
       runSQL();
      }
      catch(SQLException e) {
       e.printStackTrace();
     }

    }//GEN-LAST:event_btnDeleCurrRowActionPerformed

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
            java.util.logging.Logger.getLogger(H_JDBC_in_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(H_JDBC_in_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(H_JDBC_in_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(H_JDBC_in_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new H_JDBC_in_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnDeleByName;
    private javax.swing.JButton btnDeleCurrRow;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSearchByName;
    private javax.swing.JButton btnSort;
    private javax.swing.JComboBox<String> cboSort;
    private javax.swing.ButtonGroup grDele;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radAll;
    private javax.swing.JRadioButton radFirst;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField txtMark;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRollNo;
    private javax.swing.JTextField txtSName;
    // End of variables declaration//GEN-END:variables
}
