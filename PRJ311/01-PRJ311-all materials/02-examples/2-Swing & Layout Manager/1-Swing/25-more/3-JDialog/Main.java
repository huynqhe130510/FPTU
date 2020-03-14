import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
class SimpleTextInputDialog extends JDialog implements ActionListener {
 
    private JTextField  inputField;
    private JButton     okButton;
    private JButton     cancelButton;
    private String      value;
    
    private SimpleTextInputDialog() {
        setTitle("Enter a value");
        setModal(true);
        
        inputField = new JTextField(20);
        JPanel textPanel = new JPanel();
        textPanel.add(inputField);
        getContentPane().add(textPanel, BorderLayout.CENTER);
        
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        
        JPanel buttonPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
    }
 
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == okButton ) {
            value = inputField.getText();
        }
        dispose();
    }
    
    public static String getValue() {
        SimpleTextInputDialog dlg = new SimpleTextInputDialog();
        dlg.setVisible(true);
        return dlg.value;
    }
    
}    

public class Main
  {
    public static void main(String[] args) {
        String value = SimpleTextInputDialog.getValue();
        System.out.println("Entered value: " + value);
    }
  }
