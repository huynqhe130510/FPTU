
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.UndoManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Asus
 */
public class NotePad extends javax.swing.JFrame {

    /**
     * Creates new form NotePad
     */
    static String Title = "Untitled";
    boolean edited = false;
    File file = null;
    UndoManager undoManager = new UndoManager();

    public NotePad() {
        initComponents();
        jTextArea1.getDocument().addUndoableEditListener((UndoableEditEvent e) -> {
            undoManager.addEdit(e.getEdit());
            edited = true;
        });

    }
    
    public void saveFile(String text) throws IOException {
        if (Title.equals("Untitled")) {
            JFileChooser fc = new JFileChooser();
            fc.setMultiSelectionEnabled(false);
            int returnVal = fc.showSaveDialog(NotePad.this);
            //if users select Open button
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //output content of f to textarea
                file.createNewFile();
                Title = file.getName();
                try (FileWriter fw = new FileWriter(file)) {
                    fw.write(text);
                } catch (Exception e) {

                }
            }

        }

        setTitle(Title);
        edited = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnFile = new javax.swing.JMenu();
        mnItemNew = new javax.swing.JMenuItem();
        mnItemOpen = new javax.swing.JMenuItem();
        mnItemSave = new javax.swing.JMenuItem();
        mnItemSaveAs = new javax.swing.JMenuItem();
        mnItemExit = new javax.swing.JMenuItem();
        mnEdit = new javax.swing.JMenu();
        mnItemSelect = new javax.swing.JMenuItem();
        mnItemcut = new javax.swing.JMenuItem();
        mnItemCopy = new javax.swing.JMenuItem();
        mnItemPaste = new javax.swing.JMenuItem();
        mnItemUndo = new javax.swing.JMenuItem();
        mnItemRedo = new javax.swing.JMenuItem();
        mnItemFind = new javax.swing.JMenuItem();
        mnItemReplace = new javax.swing.JMenuItem();
        mnItemFont = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        mnFile.setText("File");

        mnItemNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mnItemNew.setText("New");
        mnItemNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemNewActionPerformed(evt);
            }
        });
        mnFile.add(mnItemNew);

        mnItemOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mnItemOpen.setText("Open");
        mnItemOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemOpenActionPerformed(evt);
            }
        });
        mnFile.add(mnItemOpen);

        mnItemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnItemSave.setText("Save");
        mnItemSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemSaveActionPerformed(evt);
            }
        });
        mnFile.add(mnItemSave);

        mnItemSaveAs.setText("Save as");
        mnItemSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemSaveAsActionPerformed(evt);
            }
        });
        mnFile.add(mnItemSaveAs);

        mnItemExit.setText("Exit");
        mnItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemExitActionPerformed(evt);
            }
        });
        mnFile.add(mnItemExit);

        jMenuBar1.add(mnFile);

        mnEdit.setText("Edit");

        mnItemSelect.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mnItemSelect.setText("Select All");
        mnItemSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemSelectActionPerformed(evt);
            }
        });
        mnEdit.add(mnItemSelect);

        mnItemcut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        mnItemcut.setText("Cut");
        mnItemcut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemcutActionPerformed(evt);
            }
        });
        mnEdit.add(mnItemcut);

        mnItemCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mnItemCopy.setText("Copy");
        mnItemCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemCopyActionPerformed(evt);
            }
        });
        mnEdit.add(mnItemCopy);

        mnItemPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mnItemPaste.setText("Paste");
        mnItemPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemPasteActionPerformed(evt);
            }
        });
        mnEdit.add(mnItemPaste);

        mnItemUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        mnItemUndo.setText("Undo");
        mnItemUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemUndoActionPerformed(evt);
            }
        });
        mnEdit.add(mnItemUndo);

        mnItemRedo.setText("Redo");
        mnItemRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemRedoActionPerformed(evt);
            }
        });
        mnEdit.add(mnItemRedo);

        mnItemFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        mnItemFind.setText("Find");
        mnItemFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemFindActionPerformed(evt);
            }
        });
        mnEdit.add(mnItemFind);

        mnItemReplace.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        mnItemReplace.setText("Replace");
        mnItemReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemReplaceActionPerformed(evt);
            }
        });
        mnEdit.add(mnItemReplace);

        mnItemFont.setText("Change font");
        mnItemFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnItemFontActionPerformed(evt);
            }
        });
        mnEdit.add(mnItemFont);

        jMenuBar1.add(mnEdit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnItemNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemNewActionPerformed
        // TODO add your handling code here:
        if (!Title.equals("Untitled") && !edited) {
            jTextArea1.setText(null);
        } else if (edited) {
            try {
                exit();
            } catch (IOException ex) {
                Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
            }
            jTextArea1.setText(null);
            //myNotePad.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
        Title = "Untitled";
    }//GEN-LAST:event_mnItemNewActionPerformed

    private void mnItemOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemOpenActionPerformed
        // TODO add your handling code here:
        if (edited) {
            try {
                exit();
            } catch (IOException ex) {
                Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JFileChooser fc = new JFileChooser();
        fc.setMultiSelectionEnabled(false);
        int returnVal = fc.showOpenDialog(NotePad.this);
        //if users select Open button
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = fc.getSelectedFile();
            //output content of f to textarea
            Title = f.getName();
            setTitle(f.getName());
            try {
                LineNumberReader lnr = new LineNumberReader(new FileReader(f));
                String line = "";
                jTextArea1.setText("");//clear old data
                while ((line = lnr.readLine()) != null) {
                    jTextArea1.append(line + "\n");
                }
                lnr.close();
            } catch (Exception e) {

            }

        }

        edited = false;
    }//GEN-LAST:event_mnItemOpenActionPerformed

    private void mnItemSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemSaveActionPerformed
        try {
            // TODO add your handling code here:
            saveFile(jTextArea1.getText());
        } catch (IOException ex) {
            Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnItemSaveActionPerformed

    private void mnItemSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemSaveAsActionPerformed
        // TODO add your handling code here:
        Title = "Untitled";
        try {
            saveFile(jTextArea1.getText());
        } catch (IOException ex) {
            Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_mnItemSaveAsActionPerformed

    public void exit() throws IOException {
        //Title = file.getName();
        if (edited) {
            int option = JOptionPane.showConfirmDialog(this, "Do you want to save the changes made to " + Title, "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                saveFile(jTextArea1.getText());
            }
        }
    }
    private void mnItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemExitActionPerformed
        try {
            // TODO add your handling code here:
            exit();
        } catch (IOException ex) {
            Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_mnItemExitActionPerformed

    private void mnItemSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemSelectActionPerformed
        // TODO add your handling code here:
        jTextArea1.selectAll();
    }//GEN-LAST:event_mnItemSelectActionPerformed

    private void mnItemcutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemcutActionPerformed
        // TODO add your handling code here:
        jTextArea1.cut();
    }//GEN-LAST:event_mnItemcutActionPerformed

    private void mnItemCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemCopyActionPerformed
        // TODO add your handling code here:
        jTextArea1.copy();
    }//GEN-LAST:event_mnItemCopyActionPerformed

    private void mnItemPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemPasteActionPerformed
        // TODO add your handling code here:
        jTextArea1.paste();
    }//GEN-LAST:event_mnItemPasteActionPerformed

    public JDialog findDialog() {
        FindDialog find = new FindDialog(this, true);
        find.getBtnFind().addActionListener(new ActionListener() {
            int i = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                String text = jTextArea1.getText();
                Pattern pat = Pattern.compile(find.getTxtFind().getText());
                Matcher matcher = pat.matcher(text);
                if (matcher.find(i)) {
                    jTextArea1.setSelectionStart(matcher.start());
                    jTextArea1.setSelectionEnd(i = matcher.end());
                } else {
                    find.getJlbStatus().setText("No more words found");
                    find.getJlbStatus().repaint();
                }
            }
        });
        find.getBtnCancel().addActionListener((ActionEvent e) -> {
            find.dispose();
        });
        find.setVisible(true);
        find.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        return find;
    }
    private void mnItemFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemFindActionPerformed
        // TODO add your handling code here:
        findDialog();
    }//GEN-LAST:event_mnItemFindActionPerformed
    public JDialog replaceDialog() {
        ReplaceDialog replace = new ReplaceDialog(this, true);
        replace.getBtnReplace().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = jTextArea1.getText();
                Pattern pattern = Pattern.compile(replace.getTxtFind().getText());

                Matcher match = pattern.matcher(text);
                if (match.find()) {
                    System.out.println(match.start());
                    jTextArea1.setText(match.replaceFirst(replace.getTxtReplace().getText()));
                } else {
                    replace.getLblStatus().setText("No more words found");
                    replace.getLblStatus().repaint();
                }
            }
        });

        replace.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replace.dispose();
            }
        });
        replace.setVisible(true);
        replace.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        return replace;
    }
    private void mnItemReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemReplaceActionPerformed
        // TODO add your handling code here:
        replaceDialog();
    }//GEN-LAST:event_mnItemReplaceActionPerformed

    public JDialog fontDialog() {
        FontDialog font = new FontDialog(this, true);
        font.getBtnOK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        
        return font;
    }
    
    private void mnItemFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemFontActionPerformed
        // TODO add your handling code here:
        fontDialog();
    }//GEN-LAST:event_mnItemFontActionPerformed

    private void mnItemUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemUndoActionPerformed
        // TODO add your handling code here:  
        if (undoManager.canUndo()) {
            undoManager.undo();
        }
    }//GEN-LAST:event_mnItemUndoActionPerformed

    private void mnItemRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnItemRedoActionPerformed
        // TODO add your handling code here:
        if (undoManager.canRedo()) {
            undoManager.redo();
        }
    }//GEN-LAST:event_mnItemRedoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            // TODO add your handling code here:
            exit();
        } catch (IOException ex) {
            Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(NotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotePad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotePad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenu mnEdit;
    private javax.swing.JMenu mnFile;
    private javax.swing.JMenuItem mnItemCopy;
    private javax.swing.JMenuItem mnItemExit;
    private javax.swing.JMenuItem mnItemFind;
    private javax.swing.JMenuItem mnItemFont;
    private javax.swing.JMenuItem mnItemNew;
    private javax.swing.JMenuItem mnItemOpen;
    private javax.swing.JMenuItem mnItemPaste;
    private javax.swing.JMenuItem mnItemRedo;
    private javax.swing.JMenuItem mnItemReplace;
    private javax.swing.JMenuItem mnItemSave;
    private javax.swing.JMenuItem mnItemSaveAs;
    private javax.swing.JMenuItem mnItemSelect;
    private javax.swing.JMenuItem mnItemUndo;
    private javax.swing.JMenuItem mnItemcut;
    // End of variables declaration//GEN-END:variables
}
