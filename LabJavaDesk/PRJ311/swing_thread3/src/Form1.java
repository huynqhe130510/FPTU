
import java.awt.*;

public class Form1 extends javax.swing.JFrame {

    MyList u;
    Thread a;
    boolean isBlink;

    public Form1() {
        initComponents();
        u = new MyList();
        isBlink = false;
        initThread();
        a.start();
    }

    void initThread() {
        a = new Thread() {
            public void run() {
                while (true) {
                    changeColor();
                    try {
                        sleep(200);
                    } catch (InterruptedException e) {

                    }
                }
            }
        };
    }

    void updateList() {
        u.clear();
        if (chkRed.isSelected()) {
            u.add(Color.red);
        }
        if (chkBlue.isSelected()) {
            u.add(Color.blue);
        }
        if (chkYellow.isSelected()) {
            u.add(Color.yellow);
        }
        if (chkPink.isSelected()) {
            u.add(Color.pink);
        }
    }

    void changeColor() {
        if (u.isEmpty()) {
            return;
        }
        int n, i;
        Color x, y;
        n = u.size();
        x = lblTitle.getForeground();
        i = u.search(x);
        if (i == -1) {
            y = u.get(0);
        } else {
            y = u.get((i + 1) % n);
        }
        if (isBlink) {
            lblTitle.setForeground(y);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        chkRed = new javax.swing.JCheckBox();
        chkBlue = new javax.swing.JCheckBox();
        chkYellow = new javax.swing.JCheckBox();
        chkPink = new javax.swing.JCheckBox();
        btnStart = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setText("Hello World");

        chkRed.setText("Red");

        chkBlue.setText("Blue");

        chkYellow.setText("Yellow");

        chkPink.setText("Pink");

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(chkRed)
                        .addGap(18, 18, 18)
                        .addComponent(chkBlue)
                        .addGap(31, 31, 31)
                        .addComponent(chkYellow)
                        .addGap(18, 18, 18)
                        .addComponent(chkPink))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btnStart)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblTitle)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkRed)
                    .addComponent(chkBlue)
                    .addComponent(chkYellow)
                    .addComponent(chkPink))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(btnStart)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        updateList();
        isBlink = true;
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStartActionPerformed

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
    private javax.swing.JButton btnStart;
    private javax.swing.JCheckBox chkBlue;
    private javax.swing.JCheckBox chkPink;
    private javax.swing.JCheckBox chkRed;
    private javax.swing.JCheckBox chkYellow;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
