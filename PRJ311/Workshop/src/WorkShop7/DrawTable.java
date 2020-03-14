package WorkShop7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javafx.scene.shape.Polyline;

public class DrawTable extends javax.swing.JFrame {

    Graphics g;

    public DrawTable() {
        initComponents();
        g = this.jPanel1.getGraphics();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        x = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfX = new javax.swing.JTextField();
        tfY = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Draw Table");

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );

        x.setText("x :");

        jLabel1.setText("y :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(x)
                .addGap(18, 18, 18)
                .addComponent(tfX, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tfY, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(x)
                    .addComponent(jLabel1)
                    .addComponent(tfX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked

        int x = evt.getX();
        int y = evt.getY();
        tfX.setText("" + x);
        tfY.setText("" + y);

        int x1[] = {100, 300, 200, 0, 100};
        int y1[] = {0, 0, 100, 100, 0};
        g.setColor(Color.gray);
        g.fillPolygon(x1, y1, 5);

        int x2[] = {0, 200, 200, 0, 0};
        int y2[] = {100, 100, 130, 130, 100};
        g.setColor(Color.darkGray);
        g.fillPolygon(x2, y2, 5);

        int x3[] = {200, 200, 300, 300, 200};
        int y3[] = {100, 130, 30, 0, 100};
        g.setColor(Color.darkGray);
        g.fillPolygon(x3, y3, 5);

        g.setColor(Color.black);
        g.fillRect(0, 130, 30, 100);

        int x4[] = {30, 50, 50, 30, 30};
        int y4[] = {130, 130, 210, 230, 130};
        g.fillPolygon(x4, y4, 5);

        g.fillRect(170, 150, 50, 120);

//        int x5[] = {200, 220, 220, 200, 200};
//        int y5[] = {130, 110, 210, 230, 130};
//        g.fillPolygon(x5, y5, 5);

        int x6[] = {300, 300, 280, 280, 300};
        int y6[] = {30, 130, 150, 50, 30};
        g.fillPolygon(x6, y6, 5);

        int x7[] = {280, 280, 250, 250, 280};
        int y7[] = {50, 150, 150, 80, 50};
        g.fillPolygon(x7, y7, 5);
        
        g.setColor(Color.WHITE);
        g.fillOval(80, 20, 150, 70);
        
        g.setColor(Color.YELLOW);
        g.fillOval(106, 24, 50, 50);
        
        g.setColor(Color.BLUE);
        g.fillOval(150, 17, 50, 50);
        
        g.setColor(Color.RED);
        g.fillOval(162, 22, 50, 50);
        
        g.setColor(Color.GREEN);
        g.fillOval(135, 37, 50, 50);
        
    }//GEN-LAST:event_jPanel1MouseClicked

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
            java.util.logging.Logger.getLogger(DrawTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DrawTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DrawTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DrawTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DrawTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfX;
    private javax.swing.JTextField tfY;
    private javax.swing.JLabel x;
    // End of variables declaration//GEN-END:variables
}
