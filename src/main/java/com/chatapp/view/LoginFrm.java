/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.chatapp.view;

import com.chatapp.model.Account;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Admin
 */
public class LoginFrm extends javax.swing.JFrame {
    private Account account;
    private DataInputStream input;
    private DataOutputStream output;
    private String host = "localhost";
    private int port = 9999;
    private Socket socket;
    
    /**
     * Creates new form LoginFrm
     */
    public LoginFrm() {
        initComponents();
        setLocationRelativeTo(null);
        labelNotification.setVisible(false);
        txtPassword.setEchoChar('\u25cf');
        scaleImage();
//        lbShow.setVisible(false);
    }
    // kiem tra ten tai khoan co chua khoang trong khong
    public boolean checkUsername(String name) {
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (ch == ' ') {
                return false;
            }

        }
        return true;
    }

    public String check() {

        if (txtUserName.getText().equals("") && txtPassword.getText().equals("")) {
            return "Please enter username and password.";
        } else if (txtUserName.getText().equals("")) {
            return "Please enter your password.";
        } else if (txtPassword.getText().equals("")) {
        } else if (txtPassword.getText().length() < 8) {
            return "Password must be at least 8 characters.\n";
        } else if (!checkUsername(txtUserName.getText())) {
            return "Username does not contain spaces.";
        }
        return "OK";
    }

    public String login(Account a) {
        try {
            connectToServer();
            output.writeUTF("Log in");
            output.writeUTF(a.getUserName());
            output.writeUTF(a.getPassword());
            output.flush();
            String response;
            response = input.readUTF();
            String linkavatar = input.readUTF();
            account.setAvatar(linkavatar);
            System.out.println("da" + response);
            return response;
        } catch (IOException e) {
            return "Network error: " + e.getMessage();
        }
    }

    public String signup(Account acc) {
        try {
            connectToServer();
            output.writeUTF("Sign up");
            output.writeUTF(acc.getUserName());
            output.writeUTF(acc.getPassword());
            output.flush();
            String response = input.readUTF();
            return response;
        } catch (IOException e) {
            return "Network error: " + e.getMessage();
        }
    }
    public void connectToServer() {
        try {
            if (socket != null) {
                socket.close();
            }
            socket = new Socket(host, port);
            this.input = new DataInputStream(socket.getInputStream());
            this.output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        labelNotification = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        passwordCheckbox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 204, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHAT APP ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Username");

        txtUserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUserName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 255)));
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Password");

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 255)));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        labelNotification.setForeground(new java.awt.Color(255, 0, 0));

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(0, 0, 255));
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnSignUp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSignUp.setForeground(new java.awt.Color(0, 0, 255));
        btnSignUp.setText("SIGN UP");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/chatapp/image/logo_128.png"))); // NOI18N

        passwordCheckbox.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        passwordCheckbox.setText("Show password");
        passwordCheckbox.setFocusPainted(false);
        passwordCheckbox.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        passwordCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordCheckboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSignUp))
                                .addComponent(labelNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(lblLogo)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogo)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSignUp)
                    .addComponent(btnLogin))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        if (!check().equals("OK")) {
            labelNotification.setVisible(true);
            labelNotification.setForeground(Color.red);
            labelNotification.setText(check());
        } else {
            labelNotification.setVisible(false);
            account = new Account();
            account.setUserName(txtUserName.getText());
            account.setPassword(txtPassword.getText());
            String response = login(account);
            if (response.equals("Login successful")) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            ChatFrm frame = new ChatFrm(account, input, output);
                            frame.setVisible(true);
                            setVisible(false);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else {
                labelNotification.setVisible(true);
                btnLogin.setEnabled(true);
                btnSignUp.setEnabled(true);
                txtPassword.setText("");
                labelNotification.setText(response);
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        // TODO add your handling code here:
        if (check().equals("OK")) {
            labelNotification.setVisible(false);
            Account newUser = new Account();
            newUser.setUserName(txtUserName.getText());
            newUser.setPassword(txtPassword.getText());
            String response = signup(newUser);
            if (response.equals("Sign up successful")) {
                JOptionPane.showMessageDialog(rootPane, "Sign up successful");
                labelNotification.setText(" ");
            } else {
                labelNotification.setVisible(true);
                labelNotification.setText(response);
            }
        } else {
            labelNotification.setVisible(true);
            labelNotification.setText(check());
        }
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!check().equals("OK")) {
                labelNotification.setVisible(true);
                labelNotification.setForeground(Color.red);
                labelNotification.setText(check());
            } else {
                labelNotification.setVisible(false);
                account = new Account();
                account.setUserName(txtUserName.getText());
                account.setPassword(txtPassword.getText());
                String response = login(account);
                if (response.equals("Login successful")) {
                    EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                ChatFrm frame = new ChatFrm(account, input, output);
                                frame.setVisible(true);
                                setVisible(false);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } else {
                    labelNotification.setVisible(true);
                    btnLogin.setEnabled(true);
                    btnSignUp.setEnabled(true);
                    txtPassword.setText("");
                    labelNotification.setText(response);
                }
            }

        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void passwordCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordCheckboxActionPerformed
        boolean isChecked = passwordCheckbox.isSelected();
        
        if (isChecked) {
            txtPassword.setEchoChar((char) 0);
            passwordCheckbox.setText("Hide password");
        } else {
            txtPassword.setEchoChar('\u25cf');
            passwordCheckbox.setText("Show password");
        }
    }//GEN-LAST:event_passwordCheckboxActionPerformed
    
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
            java.util.logging.Logger.getLogger(LoginFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    new LoginFrm().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LoginFrm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(LoginFrm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(LoginFrm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(LoginFrm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelNotification;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JCheckBox passwordCheckbox;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables

    private void scaleImage() {
        //logo
//        ImageIcon thongtinKhachHang_icon = new ImageIcon(getClass().getResource("/com/chatapp/image/Martz90-Hex-Messenger.128.png"));
//        Image thongtinKH_img = thongtinKhachHang_icon.getImage();
//        Image thongtinKHImgScale = thongtinKH_img.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon thongtinKHScaledIcon = new ImageIcon(thongtinKHImgScale);
//       //Show password icon
//        ImageIcon show_icon = new ImageIcon(getClass().getResource("/com/chatapp/image/Iconoir-Team-Iconoir-Eye-empty.32.png"));
//        Image showicon_img = show_icon.getImage();
//        Image showIconImgScale = showicon_img.getScaledInstance(lbShow.getWidth(), lbShow.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon showIconScaledIcon = new ImageIcon(showIconImgScale);
//        lbShow.setIcon(showIconScaledIcon);
//
//        //Hide password icon
//        ImageIcon hide_icon = new ImageIcon(getClass().getResource("/com/chatapp/image/Iconoir-Team-Iconoir-Eye-off.32.png"));
//        Image hideicon_img = hide_icon.getImage();
//        Image hideIconImgScale = hideicon_img.getScaledInstance(lbHide.getWidth(), lbHide.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon hideIconScaledIcon = new ImageIcon(hideIconImgScale);
//        lbHide.setIcon(hideIconScaledIcon);
    }
    
}
