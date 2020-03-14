
import java.awt.*;
import static java.lang.Thread.sleep;
import java.util.ArrayList;

public class ChangeColor extends javax.swing.JFrame {

    Thread a;

    public ChangeColor() {
        initComponents();
        initThreadA();
    }

    void ChangeColor() {
        Color x = Label.getForeground();
        ArrayList<Color> arr = new ArrayList();
        if (Red.isSelected() == true) {
            arr.add(Color.RED);
        }
        if (Blue.isSelected()==true) {
            arr.add(Color.BLUE);
        }
        if (Yellow.isSelected()==true) {
            arr.add(Color.YELLOW);
        }
        if (Pink.isSelected()==true) {
            arr.add(Color.PINK);
        }
        while(true){
            for (int i = 0; i < arr.size(); i++) {
                Label.setForeground(arr.get(i));
                try{
                    sleep(200);
                }
                catch(InterruptedException e){
                    
                }
            }
        }
    }

    void initThreadA() {
        a = new Thread() {
            public void run() {
                while (true) {
                    ChangeColor();
                }
            }
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Red = new javax.swing.JCheckBox();
        Label = new javax.swing.JLabel();
        Blue = new javax.swing.JCheckBox();
        Yellow = new javax.swing.JCheckBox();
        Pink = new javax.swing.JCheckBox();
        OK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Red.setText("Red");
        Red.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedActionPerformed(evt);
            }
        });

        Label.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Label.setText("Hello World");

        Blue.setText("Blue");

        Yellow.setText("Yellow");

        Pink.setText("Pink");

        OK.setText("Start");
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(Label))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(Red)
                        .addGap(95, 95, 95)
                        .addComponent(Blue)
                        .addGap(79, 79, 79)
                        .addComponent(Yellow)
                        .addGap(79, 79, 79)
                        .addComponent(Pink))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(OK)))
                .addContainerGap(273, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(Label)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Red)
                    .addComponent(Blue)
                    .addComponent(Yellow)
                    .addComponent(Pink))
                .addGap(86, 86, 86)
                .addComponent(OK)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RedActionPerformed

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        a.start();
    }//GEN-LAST:event_OKActionPerformed

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
            java.util.logging.Logger.getLogger(ChangeColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeColor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeColor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Blue;
    private javax.swing.JLabel Label;
    private javax.swing.JButton OK;
    private javax.swing.JCheckBox Pink;
    private javax.swing.JCheckBox Red;
    private javax.swing.JCheckBox Yellow;
    // End of variables declaration//GEN-END:variables
}
