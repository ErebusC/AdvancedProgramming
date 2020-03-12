/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package advancedprogramming;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author CarryMeBabY
 */
public class Login extends javax.swing.JFrame {

    String filepath1 = "IDs.txt";
    File file = new File(filepath1);
    String uID;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btncontinue = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btncontinue.setText("Continue");
        btncontinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncontinueActionPerformed(evt);
            }
        });

        jLabel1.setText("Username:");

        Username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UsernameKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btncontinue)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btncontinue)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncontinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncontinueActionPerformed

        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath1));

            String line;
            uID = Username.getText();

            while ((line = br.readLine()) != null) {

                if (line.equals(uID)) {
                    Thread starter = new Thread(new ServerStart());
                    starter.start();
                    MainScreen temp = new MainScreen();
                    String usern = Username.getText();
                    temp.setResizable(false);
                    temp.setLocationRelativeTo(null);
                    temp.setUniqueId(usern);
                    dispose();
                    temp.setVisible(true);

                    break;

                }
            }
            br.close();
            if (line == null) {
                JOptionPane.showMessageDialog(new JFrame(), "Error! Entered Unique ID doesn't exist in the database.");
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);

        }
        }//GEN-LAST:event_btncontinueActionPerformed

        private void UsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UsernameKeyPressed
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(filepath1));

                    String line;
                    uID = Username.getText();

                    while ((line = br.readLine()) != null) {

                        if (line.equals(uID)) {
                            Thread starter = new Thread(new ServerStart());
                            starter.start();
                            MainScreen temp = new MainScreen();
                            String usern = Username.getText();
                            temp.setResizable(false);
                            temp.setLocationRelativeTo(null);
                            temp.setUniqueId(usern);
                            dispose();

                            temp.setVisible(true);
                            FileWriter writers = new FileWriter("ips.txt", true);
                            writers.write("");
                            writers.close();

                            break;

                        }
                    }
                    br.close();
                    if (line == null) {
                        JOptionPane.showMessageDialog(new JFrame(), "Error! Entered Unique ID doesn't exist in the database.");
                    }

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);

                } catch (IOException ex) {
                    Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);

                }
            }
        }//GEN-LAST:event_UsernameKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing


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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login log = new Login();
                log.setVisible(true);

            }
        });
    }

    ArrayList clientOutputStreams;
    ArrayList<String> users; // user1 is for the server users that it receives (Trying to combine them with client users breaks everything)
    // This is server part Handling client

    public class ClientHandler implements Runnable {

        BufferedReader reader;
        Socket sock;
        PrintWriter client;

        public ClientHandler(Socket clientSocket, PrintWriter user) {
            client = user;
            try {
                sock = clientSocket;

                //System.out.println("client socket: "+sock);
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (Exception ex) {

            }

        }

        @Override
        public void run() {
            String message, connect = "Connect", disconnect = "Disconnect", chat = "Chat", disconnectt = "Disconnectt";
            String[] data;
            
            //looks into every situation that it gets from the server if it is connect or sent message or dissconnect
            try { 
                while ((message = reader.readLine()) != null) {

                    data = message.split(":");
                    if (data[2].equals(connect)) {
                        System.out.println("goes through connect");

                        tellEveryone((data[0] + ":" + data[1] + ":" + chat + ":" + data[3] + ":" + data[4]));
                        userAdd(data[0]);

                    } else if (data[2].equals(disconnect)) {
                        System.out.println("Reached dissconnect");
                        tellEveryone((data[0] + ":has disconnected." + ":" + chat + ":" + data[2] + ":" + data[3]));
                        userRemove(data[0]);
                    } else if (data[2].equals(disconnectt)) {
                        System.out.println("Reached dissconnect");
                        tellEveryone((data[0] + ":has disconnected" + ":" + chat + ":" + data[2] + ":" + data[3]));
                        userRemove(data[0]);
                    } else if (data[2].equals(chat)) {
                        System.out.println("goes through chat in login ");
                        tellEveryone(message);
                    } else {
                        System.out.println("else in client handler run() in login.java");
                    }
                }
            } catch (Exception ex) {

                ex.printStackTrace();
                clientOutputStreams.remove(client);
            }
        }
    }

    //Starts the server
    public class ServerStart implements Runnable {

        @Override
        public void run() {
            clientOutputStreams = new ArrayList();
            users = new ArrayList();

            try {
                InetAddress IpAddrs = InetAddress.getByName(NetInterface.IpUser());

                ServerSocket serverSock = new ServerSocket(7721, 50, IpAddrs);

                System.out.println("serverSock.getInetAddress(): " + serverSock.getInetAddress());

                while (true) {
                    Socket clientSock = serverSock.accept();
                    PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
                    clientOutputStreams.add(writer);

                    Thread listener = new Thread(new ClientHandler(clientSock, writer));
                    listener.start();

                }
            } catch (Exception ex) {

            }
        }
    }

    public void userAdd(String data) {
        String message, add = ": :Connect", done = "Server: :Done", name = data;

        users.add(name);

        String[] tempList = new String[(users.size())];
        users.toArray(tempList);

        for (String token : tempList) {
            message = (token + add);
            tellEveryone(message);
        }
        tellEveryone(done);
    }

    public void userRemove(String data) {
        String message, add = ": :Connect", done = "Server: :Done", name = data;
        users.remove(name);
        String[] tempList = new String[(users.size())];
        users.toArray(tempList);

        for (String token : tempList) {
            message = (token + add);
            tellEveryone(message);
        }
        tellEveryone(done);
    }

    public void tellEveryone(String message) {
        Iterator it = clientOutputStreams.iterator();

        while (it.hasNext()) {
            try {
                PrintWriter writer = (PrintWriter) it.next();
                writer.println(message);
                writer.flush();

            } catch (Exception ex) {

            }
        }
    }

    public String currTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("[HH.mm.ss] ");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Username;
    private javax.swing.JButton btncontinue;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
