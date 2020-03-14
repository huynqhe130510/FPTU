
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ChatServer extends JFrame {

    ServerSocket server;
    Socket client;
    DataInputStream in;
    DataOutputStream ou;
    JTextArea txtAreaIn, txtAreaOut;

    ChatServer() {
        initComponents();
        makeConnectToClient();
        Thread u = new Thread() {
            public void run() {
                receiveDataFromClient();
            }
        };
        u.start();
    }

    void initComponents() {
        Container con = getContentPane();
        con.setLayout(new FlowLayout());
        txtAreaIn = new JTextArea(5, 10);
        txtAreaOut = new JTextArea(5, 10);
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
        setTitle("The Server");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void makeConnectToClient() {
        server = null;
        try {
            server = new ServerSocket(4321);
        } catch (IOException e) {
            System.out.println("Error on port: 4321 " + ", " + e);
            System.exit(1);
        }
        System.out.println("Server already setup and waiting for client connection ...");

        client = null;
        try {
            client = server.accept();
            ou = new DataOutputStream(client.getOutputStream());
            in = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            System.out.println("Did not accept connection: " + e);
            System.exit(1);
        }
    }

    public void btnSendActionPerformed(ActionEvent ev) {
        try {
            String s = txtAreaOut.getText().trim();
            ou.writeBytes(s + "\n");
            txtAreaOut.setText("");
        } catch (IOException e) {
            System.err.println("I/O error with client");
        }
    }

    void receiveDataFromClient() {
        try {
            boolean done = false;
            String s, s1;
            s = "";
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
            in.close();
            client.close();
            server.close();
        } catch (IOException e) {
            System.out.println("IO Error in streams " + e);
        }
    }
}
