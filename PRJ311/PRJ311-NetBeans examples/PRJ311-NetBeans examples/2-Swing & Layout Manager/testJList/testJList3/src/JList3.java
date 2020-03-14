import java.io.*;
import java.util.*;
import javax.swing.*;
public class JList3 extends javax.swing.JFrame {
    DefaultListModel<Emp> t;

    public JList3() {
      initComponents();
       t = new DefaultListModel<Emp>();
       // Refresh list1 by t. From now the contents of the list1 and t are the same 
       list1.setModel(t);
    }
    
    int search(String xName) { // find and return positiom (0,1,2,...) return -1 if not found
     int n,i; n = t.size();
     String sName;
     for(i=0;i<n;i++) {
       sName = t.get(i).name;
       if(sName.equals(xName)) return(i);
      }
     return(-1);
    } 
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list1 = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        btnSelectedItem = new javax.swing.JButton();
        btnSelectedItems = new javax.swing.JButton();
        btnAllItems = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnAddUnique = new javax.swing.JButton();
        btnInsertAt = new javax.swing.JButton();
        txtPos1 = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSortByName = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnSortByAge = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnRemoveAll = new javax.swing.JButton();
        btnRemoveAt = new javax.swing.JButton();
        txtPos2 = new javax.swing.JTextField();
        btnRemoveAllSelected = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtIncome = new javax.swing.JTextField();
        btnSaveFile = new javax.swing.JButton();
        txtSaveFile = new javax.swing.JTextField();
        btnLoadFile = new javax.swing.JButton();
        txtLoadFile = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("JList  Demo 3");

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

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSortByName.setText("Sort by name");
        btnSortByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortByNameActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnSortByAge.setText("Sort by age");
        btnSortByAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortByAgeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddUnique)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnInsertAt)
                                .addGap(18, 18, 18)
                                .addComponent(txtPos1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSortByName)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearch))
                            .addComponent(btnSortByAge))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddUnique)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertAt)
                    .addComponent(txtPos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSortByName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSortByAge)
                .addContainerGap())
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

        jLabel2.setText("Store objects using toString() method");

        jLabel3.setText("Name:");

        jLabel4.setText("Age:");

        jLabel5.setText("Income:");

        txtName.setText("Hoa");

        txtAge.setText("21");

        txtIncome.setText("800");

        btnSaveFile.setText("Save to:");
        btnSaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveFileActionPerformed(evt);
            }
        });

        txtSaveFile.setText("emp.txt");

        btnLoadFile.setText("Load from");
        btnLoadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadFileActionPerformed(evt);
            }
        });

        txtLoadFile.setText("emp.txt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnSaveFile)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtSaveFile))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txtIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnLoadFile)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtLoadFile))))))
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSaveFile)
                            .addComponent(txtSaveFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLoadFile)
                            .addComponent(txtLoadFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectedItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectedItemsActionPerformed
     int n, i;
     List u = list1.getSelectedValuesList();
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
     Object s = list1.getSelectedValue();
     JOptionPane.showMessageDialog(null,s);
    }//GEN-LAST:event_btnSelectedItemActionPerformed

    private void btnRemoveAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAllActionPerformed
     t.removeAllElements();
     
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveAllActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
     String xName,sAge,sIncome; int xAge; double xIncome;
     xName = txtName.getText().trim();
     sAge = txtAge.getText().trim();
     sIncome = txtIncome.getText().trim();
     xAge = Integer.parseInt(sAge);
     xIncome = Double.parseDouble(sIncome);
     Emp x = new Emp(xName,xAge,xIncome);
     t.addElement(x);
     
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddUniqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUniqueActionPerformed
     String xName,sAge,sIncome; int xAge; double xIncome;
     xName = txtName.getText().trim();
     int k = search(xName);
     if(k>=0) {
        JOptionPane.showMessageDialog(null,"The employee \"" + xName + "\" already exists!");
        return;
      }        
     sAge = txtAge.getText().trim();
     sIncome = txtIncome.getText().trim();
     xAge = Integer.parseInt(sAge);
     xIncome = Double.parseDouble(sIncome);
     Emp x = new Emp(xName,xAge,xIncome);
     t.addElement(x);
     
    }//GEN-LAST:event_btnAddUniqueActionPerformed

    private void btnInsertAtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertAtActionPerformed
     String xName,sAge,sIncome; int xAge; double xIncome;
     xName = txtName.getText().trim();
     sAge = txtAge.getText().trim();
     sIncome = txtIncome.getText().trim();
     xAge = Integer.parseInt(sAge);
     xIncome = Double.parseDouble(sIncome);
     Emp x = new Emp(xName,xAge,xIncome);
        
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
     String xName = t.get(k).name;
     String s = "Do you remove the employee " + xName + "?";
     h = JOptionPane.showConfirmDialog(null, s);
     if(h==0) {
       t.remove(k);
       
     }

    }//GEN-LAST:event_btnRemoveAtActionPerformed

    private void btnRemoveAllSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAllSelectedActionPerformed
     int n, i;
     List u = list1.getSelectedValuesList();
     for(Object x : u) t.removeElement(x);
    }//GEN-LAST:event_btnRemoveAllSelectedActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
     String xName,sAge,sIncome; int xAge; double xIncome;
     xName = txtName.getText().trim();
     int k = search(xName);
     if(k == -1) {
        JOptionPane.showMessageDialog(null,"The employee \"" + xName + "\" is not found!");
        return;
      }        
     sAge = txtAge.getText().trim();
     sIncome = txtIncome.getText().trim();
     xAge = Integer.parseInt(sAge);
     xIncome = Double.parseDouble(sIncome);
     Emp x = new Emp(xName,xAge,xIncome);
     t.setElementAt(x, k); //t.set(k,x);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
     String xName = txtName.getText().trim();
     int k = search(xName);
     if(k == -1) {
        JOptionPane.showMessageDialog(null,"The employee \"" + xName + "\" is not found!");
        return;
      }        
     String s = "Do you remove the employee " + xName + "?";
     int h = JOptionPane.showConfirmDialog(null, s);
     if(h==0) {
       t.remove(k);
       
     }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSortByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortByNameActionPerformed
      Object [] a = t.toArray();
      int i,j,n; Emp x;
      n = a.length;
      Emp [] b = new Emp[n];
      for(i=0;i<n;i++) b[i] = (Emp) a[i];
      for(i=0;i<n-1;i++)
       for(j=i+1;j<n;j++)
         if(b[j].name.compareTo(b[i].name)<0) {
           x = b[i]; b[i] = b[j]; b[j] = x;  
         }
      t.clear();
      for(i=0;i<n;i++) t.add(i, b[i]);
    }//GEN-LAST:event_btnSortByNameActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
     String xName = JOptionPane.showInputDialog(null, "Enter name to be search: ");
     if(xName == null || xName.trim().equals("")) {
        JOptionPane.showMessageDialog(null,"Name is invalid!");
        return;
     }
     int k = search(xName);
     if(k == -1) {
        JOptionPane.showMessageDialog(null,"The employee \"" + xName + "\" is not found!");
        return;
      }        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSortByAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortByAgeActionPerformed
      Object [] a = t.toArray();
      int i,j,n; Emp x;
      n = a.length;
      Emp [] b = new Emp[n];
      for(i=0;i<n;i++) b[i] = (Emp) a[i];
      Comparator<Emp> u = new Comparator<Emp>() {
        public int compare(Emp x, Emp y) {
           if(x.age<y.age)
              return(-1);
             else
               if(x.age>y.age)
                 return(1);
                  else
                   return(0);
        }  
      };
      Arrays.sort(b,u);
      t.clear();
      for(i=0;i<n;i++) t.add(i, b[i]);
    }//GEN-LAST:event_btnSortByAgeActionPerformed

    private void btnSaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveFileActionPerformed
      String fname = txtSaveFile.getText().trim();
      File f = new File(fname);
      if(f.exists()) {
        int k = JOptionPane.showConfirmDialog(null,"The file " + fname + " already exists,, delete it?","",JOptionPane.YES_NO_OPTION);
        if(k==1) return; // No
      }        

      int n,i; n = t.size();
      try {
        RandomAccessFile g = new RandomAccessFile(fname,"rw");
        for(i=0; i<n; i++) {
             g.writeBytes(t.get(i).toString() + "\r\n");
          }
        g.close();
       } catch (IOException ex) {
        }
    }//GEN-LAST:event_btnSaveFileActionPerformed

    private void btnLoadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadFileActionPerformed
      String fname = txtLoadFile.getText().trim();
      File f = new File(fname);
      if(!f.exists()) {
        JOptionPane.showMessageDialog(null,"The file \"" + fname + "\" is not found!");
        return;
      }        
      int n,i;
      RandomAccessFile g;
      String s;
      String [] a;
      String xName,sAge,sIncome;
      int xAge; double xIncome;
      try {
       g = new RandomAccessFile(fname,"r");
       i = 0;
       Emp x;
       while(true) {
          s = g.readLine();
          if(s==null || s.trim().equals("")) break;
          a = s.split("[|]");
          xName = a[0].trim();
          sAge = a[1].trim();
          sIncome = a[2].trim();
          xAge = Integer.parseInt(sAge);
          xIncome = Double.parseDouble(sIncome);
          x = new Emp(xName,xAge,xIncome);
          t.addElement(x);
        }
        g.close();
       } catch (IOException ex) {   }
    }//GEN-LAST:event_btnLoadFileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JList3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddUnique;
    private javax.swing.JButton btnAllItems;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsertAt;
    private javax.swing.JButton btnLoadFile;
    private javax.swing.JButton btnRemoveAll;
    private javax.swing.JButton btnRemoveAllSelected;
    private javax.swing.JButton btnRemoveAt;
    private javax.swing.JButton btnSaveFile;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSelectedItem;
    private javax.swing.JButton btnSelectedItems;
    private javax.swing.JButton btnSortByAge;
    private javax.swing.JButton btnSortByName;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList list1;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtIncome;
    private javax.swing.JTextField txtLoadFile;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPos1;
    private javax.swing.JTextField txtPos2;
    private javax.swing.JTextField txtSaveFile;
    // End of variables declaration//GEN-END:variables
}
