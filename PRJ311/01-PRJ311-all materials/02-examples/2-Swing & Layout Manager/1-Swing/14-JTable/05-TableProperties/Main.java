import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class TablePropertiesDemo extends JApplet {
  // Create table column names
  private String[] columnNames =
    {"Country", "Capital", "Population in Millions", "Democracy"};

  // Create table data
  private Object[][] rowData = {
    {"USA", "Washington DC", new Integer(280), new Boolean(true)},
    {"Canada", "Ottawa", new Integer(32), new Boolean(true)},
    {"United Kingdom", "London", new Integer(60), new Boolean(true)},
    {"Germany", "Berlin", new Integer(83), new Boolean(true)},
    {"France", "Paris", new Integer(60), new Boolean(true)},
    {"Norway", "Oslo", new Double(4.5), new Boolean(true)},
    {"India", "New Deli", new Integer(1046), new Boolean(true)}
  };

  // Create a table
  private JTable jTable1 = new JTable(rowData, columnNames);

  // Create two spinners
  private JSpinner jspiRowHeight =
    new JSpinner(new SpinnerNumberModel(16, 1, 50, 1));
  private JSpinner jspiRowMargin =
    new JSpinner(new SpinnerNumberModel(1, 1, 50, 1));

  // Create a checkbox
  private JCheckBox jchkShowGrid = new JCheckBox("showGrid", true);

  // Create a combo box
  private JComboBox jcboAutoResizeMode = new JComboBox(new String[]{
    "AUTO_RESIZE_OFF", "AUTO_RESIZE_LAST_COLUMN",
    "AUTO_RESIZE_SUBSEQUENT_COLUMNS", "AUTO_RESIZE_NEXT_COLUMN",
    "AUTO_RESIZE_ALL_COLUMNS"});

  public TablePropertiesDemo() {
    JPanel panel1 = new JPanel();
    panel1.add(new JLabel("rowHeight"));
    panel1.add(jspiRowHeight);
    panel1.add(new JLabel("rowMargin"));
    panel1.add(jspiRowMargin);
    panel1.add(jchkShowGrid);

    JPanel panel2 = new JPanel();
    panel2.add(new JLabel("autoResizeMode"));
    panel2.add(jcboAutoResizeMode);

    getContentPane().add(panel1, BorderLayout.SOUTH);
    getContentPane().add(panel2, BorderLayout.NORTH);
    getContentPane().add(new JScrollPane(jTable1));

    // Initialize jTable1
    jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    jTable1.setGridColor(Color.BLUE);
    jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    jTable1.setSelectionBackground(Color.RED);
    jTable1.setSelectionForeground(Color.WHITE);

    // Register and create a listener for jspiRowHeight
    jspiRowHeight.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        jTable1.setRowHeight(
          ((Integer)(jspiRowHeight.getValue())).intValue());
      }
    });

    // Register and create a listener for jspiRowMargin
    jspiRowMargin.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        jTable1.setRowMargin(
          ((Integer)(jspiRowMargin.getValue())).intValue());
      }
    });

    // Register and create a listener for jchkShowGrid
    jchkShowGrid.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jTable1.setShowGrid(jchkShowGrid.isSelected());
      }
    });

    // Register and create a listener for jcboAutoResizeMode
    jcboAutoResizeMode.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String selectedItem =
          (String)jcboAutoResizeMode.getSelectedItem();

        if (selectedItem.equals("AUTO_RESIZE_OFF"))
          jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        else if (selectedItem.equals("AUTO_RESIZE_LAST_COLUMN"))
          jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        else if (selectedItem.equals
                 ("AUTO_RESIZE_SUBSEQUENT_COLUMNS"))
          jTable1.setAutoResizeMode(
            JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        else if (selectedItem.equals("AUTO_RESIZE_NEXT_COLUMN"))
          jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        else if (selectedItem.equals("AUTO_RESIZE_ALL_COLUMNS"))
          jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
      }
    });
  }
 }
public class Main
 { 
  public static void main(String[] args) {
    TablePropertiesDemo applet = new TablePropertiesDemo();
    JFrame frame = new JFrame();
    //EXIT_ON_CLOSE == 3
    frame.setDefaultCloseOperation(3);
    frame.setTitle("TablePropertiesDemo");
    frame.getContentPane().add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setSize(400,320);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation((d.width - frame.getSize().width) / 2,
                      (d.height - frame.getSize().height) / 2);
    frame.setVisible(true);
  }
}

