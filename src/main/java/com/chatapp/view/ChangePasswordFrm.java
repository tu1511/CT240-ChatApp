/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.chatapp.view;

import com.chatapp.model.Account;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ChangePasswordFrm extends javax.swing.JFrame {
    DataInputStream input;
    DataOutputStream output;
    Account account;
    String host = "localhost";
    private int port = 9999;
    private Socket socket;
    ChatFrm chatFrm;
    /**
     * Creates new form ChangePasswordFrm
     */
    public ChangePasswordFrm(ChatFrm chat,Account account, DataInputStream dis, DataOutputStream dos) {
        initComponents();
        chatFrm = chat;
        this.account = account;
        input = dis;
        output = dos;
        labelNotification.setVisible(false);
        
        txtCurrentPassword.setEchoChar('\u25cf');
        txtNewPassword.setEchoChar('\u25cf');
        txtConfirmPassword.setEchoChar('\u25cf');
        //this.lbHidePW.setVisible(false);       
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
        labelChangePass = new javax.swing.JLabel();
        txtCurrentPassword = new javax.swing.JPasswordField();
        labelCurrentPass = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        labelNewPass = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        labelConfirmPass = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btn_Change = new javax.swing.JButton();
        labelNotification = new javax.swing.JLabel();
        lbHidePW = new javax.swing.JLabel();
        btn_Cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(255, 255, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelChangePass.setFont(new java.awt.Font("Bahnschrift", 0, 36)); // NOI18N
        labelChangePass.setForeground(new java.awt.Color(0, 0, 153));
        labelChangePass.setText("Change Password");
        jPanel1.add(labelChangePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 300, 40));

        txtCurrentPassword.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtCurrentPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 255)));
        txtCurrentPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCurrentPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtCurrentPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 300, 30));

        labelCurrentPass.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        labelCurrentPass.setText("Current Password");
        jPanel1.add(labelCurrentPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 160, 30));

        txtNewPassword.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtNewPassword.setForeground(new java.awt.Color(91, 90, 90));
        txtNewPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 255)));
        jPanel1.add(txtNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 300, 30));

        labelNewPass.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        labelNewPass.setText("New Password");
        jPanel1.add(labelNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 160, 30));

        txtConfirmPassword.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtConfirmPassword.setForeground(new java.awt.Color(91, 90, 90));
        txtConfirmPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 255)));
        jPanel1.add(txtConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 300, 30));

        labelConfirmPass.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        labelConfirmPass.setText("Confirm Password");
        jPanel1.add(labelConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 170, 30));

        btnBack.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/chatapp/image/back.png"))); // NOI18N
        btnBack.setBorder(null);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 30, 30));

        btn_Change.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Change.setForeground(new java.awt.Color(0, 153, 51));
        btn_Change.setText("Change");
        btn_Change.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ChangeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Change, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 120, 39));

        labelNotification.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        labelNotification.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(labelNotification, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 300, 30));

        lbHidePW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbHidePWMousePressed(evt);
            }
        });
        jPanel1.add(lbHidePW, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 40, 30));

        btn_Cancel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_Cancel.setForeground(new java.awt.Color(255, 153, 0));
        btn_Cancel.setText("Reload");
        btn_Cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 120, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        chatFrm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btn_ChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ChangeActionPerformed
        String notification = checkPassword();
        if(notification.equals("OK")==false) {
            labelNotification.setVisible(true);
            labelNotification.setText(notification);
        }
        else{
            try {
                connectToServer();
                output.writeUTF("Change Password");
                output.writeUTF(account.getUserName());
                output.writeUTF(txtCurrentPassword.getText());
                output.writeUTF(txtNewPassword.getText());
                String respon = input.readUTF();
                if(respon.equals("Current Password does not match")){
                    labelNotification.setVisible(true);
                    labelNotification.setText(respon);
                }
                else if(respon.equals("Not Update")){
                    labelNotification.setVisible(true);
                    labelNotification.setText("ERROR");
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Update Successful");
                    account.setPassword(txtNewPassword.getText());
                    labelNotification.setText("");
                    labelNotification.setVisible(false);
                    txtConfirmPassword.setText("");
                    txtNewPassword.setText("");
                    txtCurrentPassword.setText("");
                    chatFrm.setPassword(account.getPassword());
                }
            } catch (IOException ex) {
                Logger.getLogger(ChangePasswordFrm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_ChangeActionPerformed

    private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelActionPerformed
        txtConfirmPassword.setText("");
        txtNewPassword.setText("");
        txtCurrentPassword.setText("");
    }//GEN-LAST:event_btn_CancelActionPerformed

    private void txtCurrentPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCurrentPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCurrentPasswordActionPerformed

    private void lbHidePWMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHidePWMousePressed

    }//GEN-LAST:event_lbHidePWMousePressed
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
    public String checkPassword(){
         if(txtCurrentPassword.getText().equals("") || txtNewPassword.getText().equals("") || txtConfirmPassword.getText().equals("")){
             return "Please enter full information";            
         }
         else if(txtNewPassword.getText().length()<8){
             return "Password must be at least 8 characters";
         }
         else if(txtNewPassword.getText().equals(txtConfirmPassword.getText())==false){
             return "Password does not match";
         }
         else return "OK";
        
    }
       
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_Change;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelChangePass;
    private javax.swing.JLabel labelConfirmPass;
    private javax.swing.JLabel labelCurrentPass;
    private javax.swing.JLabel labelNewPass;
    private javax.swing.JLabel labelNotification;
    private javax.swing.JLabel lbHidePW;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JPasswordField txtCurrentPassword;
    private javax.swing.JPasswordField txtNewPassword;
    // End of variables declaration//GEN-END:variables

   
}
