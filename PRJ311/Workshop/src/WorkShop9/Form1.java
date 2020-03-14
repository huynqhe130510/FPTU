package WorkShop9;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class student{
    String code, name;

    public student() {
    }

    public student(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return code + "-" + name;
    }
    
}

public final class Form1 extends javax.swing.JFrame {

    DBContext a = new DBContext();
    Statement stm;
    ResultSet rs;
    DefaultTableModel tableModel;
    Locale locale;
    ResourceBundle bun;
    boolean b = true;
    JTable table = new JTable(tableModel);

    public Form1() {
        setLocation(400, 150);
        initComponents();
        stm = a.connectDB();
        tableModel = (DefaultTableModel) jTable1.getModel();
        loadTable();
        txt1.setEnabled(false);
        
        JComboBox j = new JComboBox();
        JFrame f = new JFrame();
        f.add(j);
        j.addItem(new student("1", "h"));
        j.addItem(new student("2", "b"));
        
    }

    void setLanguage() {

        jLabel1.setText(bun.getString("Form1.jLabel1.text"));
        jLabel2.setText(bun.getString("Form1.jLabel2.text"));
        jLabel3.setText(bun.getString("Form1.jLabel3.text"));
        jLabel4.setText(bun.getString("Form1.jLabel4.text"));
        jLabel5.setText(bun.getString("Form1.jLabel5.text"));
        jLabel6.setText(bun.getString("Form1.jLabel6.text"));
        jLabel7.setText(bun.getString("Form1.jLabel7.text"));
        jLabel8.setText(bun.getString("Form1.jLabel8.text"));
        btnAdd.setText(bun.getString("Form1.btnAdd.text"));
        btnSearch.setText(bun.getString("Form1.btnSearch.text"));
        btnSort.setText(bun.getString("Form1.btnSort.text"));
        btEngvie.setText(bun.getString("Form1.btEngvie.text"));
    }

    public void loadTable() {
        try {
            rs = stm.executeQuery("select * from worker");
            tableModel.setRowCount(0);
            while (rs.next()) {
                String code = rs.getString("Code");
                String name = rs.getString("Name");
                int salary = Integer.parseInt(rs.getString("Salary"));
                int bonus = Integer.parseInt(rs.getString("Bonus"));
                tableModel.insertRow(tableModel.getRowCount(), new Object[]{code, name, salary, bonus});
            }
        } catch (NumberFormatException | SQLException e) {
        }
    }

    public boolean checkEmpty() {
        if (!tfCode.getText().isEmpty() && !tfName.getText().isEmpty() && !tfSalary.getText().isEmpty() && !tfBonus.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean checkDuplicate(String code_check) {

        try {
            rs = stm.executeQuery("SELECT * FROM worker");
            while (rs.next()) {
                String code = rs.getString("code");

                if (code_check.equalsIgnoreCase(code)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfCode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfSalary = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfBonus = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnSort = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        tfSearched = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt1 = new javax.swing.JTextArea();
        btEngvie = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("Bundle"); // NOI18N
        jLabel1.setText(bundle.getString("Form1.jLabel1.text")); // NOI18N

        jLabel2.setText(bundle.getString("Form1.jLabel2.text")); // NOI18N

        jLabel3.setText(bundle.getString("Form1.jLabel3.text")); // NOI18N

        jLabel4.setText(bundle.getString("Form1.jLabel4.text")); // NOI18N

        jLabel5.setText(bundle.getString("Form1.jLabel5.text")); // NOI18N

        jLabel6.setText(bundle.getString("Form1.jLabel6.text")); // NOI18N

        btnAdd.setText(bundle.getString("Form1.btnAdd.text")); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSort.setText(bundle.getString("Form1.btnSort.text")); // NOI18N
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Salary", "Bonus"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("Form1.jTable1.columnModel.title0")); // NOI18N
            jTable1.getColumnModel().getColumn(1).setHeaderValue(bundle.getString("Form1.jTable1.columnModel.title1")); // NOI18N
            jTable1.getColumnModel().getColumn(2).setHeaderValue(bundle.getString("Form1.jTable1.columnModel.title2")); // NOI18N
            jTable1.getColumnModel().getColumn(3).setHeaderValue(bundle.getString("Form1.jTable1.columnModel.title3")); // NOI18N
        }

        jLabel7.setText(bundle.getString("Form1.jLabel7.text")); // NOI18N

        btnSearch.setText(bundle.getString("Form1.btnSearch.text")); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txt1.setColumns(20);
        txt1.setRows(5);
        jScrollPane2.setViewportView(txt1);

        btEngvie.setText(bundle.getString("Form1.btEngvie.text")); // NOI18N
        btEngvie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEngvieActionPerformed(evt);
            }
        });

        jLabel8.setText(bundle.getString("Form1.jLabel8.text")); // NOI18N

        jTextField1.setText(bundle.getString("Form1.jTextField1.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(btnSort))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfCode, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfSearched, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearch)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btEngvie)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfBonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnSort))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(tfSearched, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEngvie)
                    .addComponent(jLabel8)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            if (checkEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Not found employee");
            } else {
                String code = tfCode.getText().trim();
                String name = tfName.getText().trim();
                int salary = Integer.parseInt(tfSalary.getText().trim());
                int bonus = Integer.parseInt(tfBonus.getText().trim());
                if (checkDuplicate(code)) {
                    JOptionPane.showMessageDialog(rootPane, "The code is exist");
                } else {
                    String sql = "INSERT INTO worker VALUES('" + code + "','" + name + "','" + salary + "','" + bonus + "')";
                    stm.execute(sql);
                    loadTable();
                    JOptionPane.showMessageDialog(rootPane, "Add successfully !");
                }
            }
        } catch (HeadlessException | NumberFormatException | SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        try {
            rs = stm.executeQuery("select * from worker order by salary");
            tableModel.setRowCount(0);
            while (rs.next()) {
                String code = rs.getString("code");
                String name = rs.getString("name");
                int salary = Integer.parseInt(rs.getString("salary"));
                int bonus = Integer.parseInt(rs.getString("bonus"));
                tableModel.insertRow(tableModel.getRowCount(), new Object[]{code, name, salary, bonus});
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnSortActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if (tfSearched.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "The code in not empty");
        } else {
            String codeSearch = tfSearched.getText().trim();
            if (checkDuplicate(codeSearch)) {
                try {
                    String sql = "select * from worker where code = '" + codeSearch + "'";
                    ArrayList<Employee> list = new ArrayList<>();
                    Employee employee;

                    try {
                        rs = stm.executeQuery(sql);
                        while (rs.next()) {
                            employee = new Employee(rs.getString("code"), rs.getString("name"), Double.parseDouble(rs.getString("salary")), Integer.parseInt(rs.getString("bonus")));
                            list.add(employee);
                        }
                    } catch (NumberFormatException | SQLException e) {
                    }

                    String result = "";
                    for (int i = 0; i < list.size(); i++) {
                        employee = list.get(i);
                        result += employee.toString() + "\n";
                    }
                    txt1.setEnabled(true);
                    txt1.setText(result);
                    JOptionPane.showMessageDialog(rootPane, "Search successfully !");

                } catch (HeadlessException e) {
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "The code does not exist");
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btEngvieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEngvieActionPerformed

        if (b == true) {
            locale = new Locale("vi", "VN");
            b = false;
        } else {
            locale = new Locale("", "");
            b = true;
        }

        bun = ResourceBundle.getBundle("Bundle", locale);
        setLanguage();


    }//GEN-LAST:event_btEngvieActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEngvie;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField tfBonus;
    private javax.swing.JTextField tfCode;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfSalary;
    private javax.swing.JTextField tfSearched;
    private javax.swing.JTextArea txt1;
    // End of variables declaration//GEN-END:variables
}
