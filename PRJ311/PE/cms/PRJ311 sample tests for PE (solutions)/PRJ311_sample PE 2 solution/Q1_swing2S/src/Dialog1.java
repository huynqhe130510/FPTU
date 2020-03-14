
import java.io.*;

public class Dialog1 extends javax.swing.JDialog {

    FormSwing2 h;

    public Dialog1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        h = (FormSwing2) parent;
    }

    String fileContent(String fname) {
        RandomAccessFile f;
        String s, x;
        s = x = null;
        try {
            f = new RandomAccessFile(fname, "r");
            s = "";
            while (true) {
                x = f.readLine();
                if (x == null) {
                    break;
                }
                s += x + "\r\n";
            }
        } catch (IOException e) {
        }
        return (s);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtFileName = new javax.swing.JTextField();
        chkShowFileSize = new javax.swing.JCheckBox();
        btnOpenFile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Open file");

        jLabel1.setText("File name:");

        txtFileName.setText("src\\Dialog1.java");

        chkShowFileSize.setText("Show file size");

        btnOpenFile.setText("Open file");
        btnOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnOpenFile)
                    .addComponent(chkShowFileSize))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(chkShowFileSize)
                .addGap(40, 40, 40)
                .addComponent(btnOpenFile)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenFileActionPerformed
        String x = h.getTxtA1();
        String fname = txtFileName.getText().trim();
        String s = fileContent(fname);
        s = "Content of the file:\r\n" + s;
        if (chkShowFileSize.isSelected()) {
            try {
                RandomAccessFile f = new RandomAccessFile(fname, "r");
                long k = f.length();
                s = "File size in bytes: " + k + "\r\n" + s;
            } catch (Exception e) {
            }
        }
        h.setTxtA1(s);
        this.dispose();

    }//GEN-LAST:event_btnOpenFileActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOpenFile;
    private javax.swing.JCheckBox chkShowFileSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtFileName;
    // End of variables declaration//GEN-END:variables
}
