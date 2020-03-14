
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ChatClient extends JFrame {

    String host;
    Socket client;
    DataOutputStream ou;
    DataInputStream in;
    JTextArea txtAreaOut, txtAreaIn;

    ChatClient() {
        initComponents();
        makeConnectToServer();
        Thread u = new Thread() {
            public void run() {
                receiveDataFromServer();
            }
        };
        u.start();
    }

    void initComponents() {
        Container con = getContentPane();
        con.setLayout(new FlowLayout());
        txtAreaOut = new JTextArea(5, 10);
        txtAreaIn = new JTextArea(5, 10);
        txtAreaIn.setEditable(false);
        con.add(new JScrollPane(txtAreaOut));
        con.add(new JScrollPane(txtAreaIn));
        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                txtAreaIn.setText("");
            }
        }
        );
        JButton btnSend = new JButton("Send");
        btnSend.addActionListener(
                new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                btnSendActionPerformed(ev);
            }
        }
        );
        con.add(btnSend);
        con.add(btnRefresh);
        setSize(300, 300);
        setTitle("The client");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void makeConnectToServer() {
        host = "localhost";
        try {
            client = new Socket(host, 4321);
            ou = new DataOutputStream(client.getOutputStream());
            in = new DataInputStream(client.getInputStream());
        } catch (UnknownHostException e) {
            System.err.println(host + ": unknown host.");
        } catch (IOException e) {
            System.err.println("I/O error with " + host);
        }
    }

    public void btnSendActionPerformed(ActionEvent ev) {
        try {
            String s = txtAreaOut.getText().trim();
            ou.writeBytes(s + "\n");
            txtAreaOut.setText("");
        } catch (IOException e) {
            System.err.println("I/O error with " + host);
        }
    }

    void receiveDataFromServer() {
        String s, s1;
        s = "";
        s1 = "";
        boolean done = false;
        try {
            while (!done) {
                s1 = in.readLine();

                if (s1.equalsIgnoreCase(".bye")) {
                    done = true;
                } else {
                    s += s1 + "\n";
                    txtAreaIn.setText(s);
                }
            }

        } catch (IOException e) {
            System.out.println("IO Error in streams " + e);
        }
    }

    public void finalize() {
        try {
            ou.close();
            client.close();
        } catch (IOException e) {
            System.err.println("I/O error with " + host);
        }
    }
}
