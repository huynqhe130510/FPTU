import javax.swing.*;
import java.awt.*;
import static java.lang.Thread.sleep;
public class Form1 extends javax.swing.JFrame {
   Thread t, h; // t run, h change color
    public Form1() {
      initComponents();
      String x = lblTitle.getText().trim();
      x += " ";
      lblTitle.setText(x);
      initThreads();
    }
    void initThreads() {
       t = new Thread() {
       public void run() {
        while(true) {
          moveText();
          try {
           sleep(700);  
         }
         catch(InterruptedException e) {
           
        }
           
        }   
       }
      };

       h = new Thread() {
       public void run() {
        while(true) {
          changeColor();
          try {
           sleep(200);  
         }
         catch(InterruptedException e) {
           
        }
           
        }   
       }
      };
       
    }

    void changeColor() {
      Color x = lblTitle.getForeground();
      if(x == Color.red)
        lblTitle.setForeground(Color.blue);
        else
        lblTitle.setForeground(Color.red);
          
    } 

    void moveText() {
      String x = lblTitle.getText();
      x = x.substring(1) + x.charAt(0);
      lblTitle.setText(x);
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        btnCheckData = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtFood = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtA_Foods = new javax.swing.JTextArea();
        btnDisplay = new javax.swing.JButton();
        btnMoveText = new javax.swing.JButton();
        btnChangeColor = new javax.swing.JButton();
        btnStartRunning = new javax.swing.JButton();
        btnStartBlinking = new javax.swing.JButton();
        btnClearTextArea = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 51, 204));
        lblTitle.setText("Personal information");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Enter your name:");

        txtName.setText("Tran Hoa");

        jLabel2.setText("Enter your age:");

        txtAge.setText("25");

        btnCheckData.setText("Check data");
        btnCheckData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckDataActionPerformed(evt);
            }
        });

        jLabel3.setText("Enter food you like:");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtA_Foods.setColumns(20);
        txtA_Foods.setRows(5);
        txtA_Foods.setText("By using threads, we\ncan do 2 separate\nworks concurrently:\nRunning Text\nand\nChanging text's color\nperiodically\n ");
        jScrollPane1.setViewportView(txtA_Foods);

        btnDisplay.setText("Display data");
        btnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisplayActionPerformed(evt);
            }
        });

        btnMoveText.setText("Move text");
        btnMoveText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveTextActionPerformed(evt);
            }
        });

        btnChangeColor.setText("Change color");
        btnChangeColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeColorActionPerformed(evt);
            }
        });

        btnStartRunning.setText("Start Running");
        btnStartRunning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartRunningActionPerformed(evt);
            }
        });

        btnStartBlinking.setText("Start Blinking");
        btnStartBlinking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartBlinkingActionPerformed(evt);
            }
        });

        btnClearTextArea.setText("Clear text area");
        btnClearTextArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearTextAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTitle)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtName)
                                    .addComponent(txtAge)
                                    .addComponent(txtFood, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnClearTextArea)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCheckData)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnDisplay))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnMoveText)
                                .addComponent(btnChangeColor)
                                .addComponent(btnStartRunning)
                                .addComponent(btnStartBlinking)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitle)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(txtFood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnMoveText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnChangeColor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnStartRunning)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnStartBlinking))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDisplay)
                            .addComponent(btnCheckData)
                            .addComponent(btnClearTextArea))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCheckDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckDataActionPerformed

      boolean nameIsOk, ageIsOk;
      nameIsOk = true;
      ageIsOk = true;
      String x = txtName.getText();
      int n,i; char c;
      n = x.length();
      for(i=0;i<n;i++) {
        c = x.charAt(i);
        if(!(Character.isLetter(c) || c==' ')) {
          nameIsOk = false;
          break;
        }
      }

       String y = txtAge.getText();
       y = y.trim();
       int k;
       try {
        k = Integer.parseInt(y);
        if(k<0 || k > 140) ageIsOk = false; 

       }
       catch(Exception e) {
         ageIsOk = false;
        }

       String xMess = "";
       if(nameIsOk) 
         xMess = "Name is valid";
          else
           xMess = "Name is invalid";
       xMess = xMess + "\r\n";
       if(ageIsOk) 
         xMess += "Age is valid";
          else
           xMess += "Age is invalid";
       
       JOptionPane.showMessageDialog(this,xMess);
       if(!nameIsOk)
          txtName.setText(""); 
       if(!ageIsOk)
          txtAge.setText("");
       
    }//GEN-LAST:event_btnCheckDataActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

     String x = txtFood.getText().trim();
     if(x.equals("")) {
        JOptionPane.showMessageDialog(this, "You must enter food");
        return;
     }
     String s = txtA_Foods.getText();
     s += x + "\r\n";
     txtA_Foods.setText(s);
         

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisplayActionPerformed

     String s = "Data  in the form\r\n\r\n";
     s += "Name: " + txtName.getText().trim() + "\r\n";
     s += "Age: " + txtAge.getText().trim() + "\r\n";
     s += "List of foods you like:\r\n";
     s += txtA_Foods.getText().trim();
     JOptionPane.showMessageDialog(null,s);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDisplayActionPerformed

    private void btnMoveTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveTextActionPerformed
      moveText();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMoveTextActionPerformed

    private void btnChangeColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeColorActionPerformed
      changeColor();
    }//GEN-LAST:event_btnChangeColorActionPerformed

    private void btnStartRunningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartRunningActionPerformed
     t.start();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnStartRunningActionPerformed

    private void btnStartBlinkingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartBlinkingActionPerformed
     h.start();
   
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStartBlinkingActionPerformed

    private void btnClearTextAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearTextAreaActionPerformed
     txtA_Foods.setText("");
    }//GEN-LAST:event_btnClearTextAreaActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnChangeColor;
    private javax.swing.JButton btnCheckData;
    private javax.swing.JButton btnClearTextArea;
    private javax.swing.JButton btnDisplay;
    private javax.swing.JButton btnMoveText;
    private javax.swing.JButton btnStartBlinking;
    private javax.swing.JButton btnStartRunning;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea txtA_Foods;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtFood;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
