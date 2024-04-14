/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.chatapp.view;

import com.chatapp.model.Account;
import com.chatapp.model.FileMessage;
import com.chatapp.model.Message;
import com.chatapp.model.TextMessage;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ChatFrm extends javax.swing.JFrame {

    private Account account = new Account();
    private DataInputStream input;
    private DataOutputStream output;
    Thread receiverThread;
    // Tạo HashMap với khóa là tên người nhận tin nhắn và values là nội dung chat của người dùng hiện tại với khóa(người dùng dc chat chung)
//    protected HashMap<String, String> messageContent = new HashMap<String, String>();
    protected HashMap<String, List<Message>> messageContent = new HashMap<String, List<Message>>();

    public ChatFrm(Account users, DataInputStream dis, DataOutputStream dos) {
        initComponents();
        chatWindow.setContentType("text/html");
        System.out.println(users.getUserName());
        labelUserName.setText(users.getUserName());
        account.setUserName(users.getUserName());
        account = users;
        input = dis;
        output = dos;
        
        menu_Icon.add(panel_Icon);
        //Tạo luồng cho người vừa đăng nhập
        receiverThread = new Thread(new ChatFrm.Receiver(dis));
        receiverThread.start();
        panelAccount.setVisible(true);
        loadavatar();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/chatapp/image/chat.png")));
        scaleImage();
    }

    private void autoScroll() {
        jScrollPane2.getVerticalScrollBar().setValue(jScrollPane2.getVerticalScrollBar().getMaximum());
    }

    public void setAvatar(String avatar) {
        account.setAvatar(avatar);
        loadavatar();
    }

    private void loadavatar() {
        lblAvatar.setText("");
        lblAvatar.setIcon(new javax.swing.ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/chatapp/image/" + account.getAvatar())).getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
    }

    public void setPassword(String pass) {
        account.setPassword(pass);
    }
    
    // Load message của một người ra khung chat
    public void displayMessage(String friend) {
        List<Message> messages = messageContent.get(friend);
        
        for (Message mess : messages) {
            mess.printMessage(friend, chatWindow);
        }
    }
    
    // Thêm tin nhắn đi và đến từ một người bạn vào hashmap
    public void addMessage(String friend, Message message) {
        List<Message> currentMessage = messageContent.get(friend);
        currentMessage.add(message);
        messageContent.put(friend, currentMessage);
    }
    
    // Hiển thị tin nhắn dạng text
    public void displayTextMessage(String sender, String receiveString, String message, Boolean yourMessage) {
        TextMessage tm = new TextMessage(message, sender, receiveString, yourMessage);

        if (yourMessage == false && cbOnlineUsers.getSelectedItem().equals(sender) == false) {
            addMessage(sender, tm);
        } else if (yourMessage == false && sender.equals(cbOnlineUsers.getSelectedItem())) {
            tm.printMessage(sender, chatWindow);
            addMessage(sender, tm);
        } else {
            tm.printMessage(sender, chatWindow);
            addMessage((String) cbOnlineUsers.getSelectedItem(), tm);
        }
    }
    
    // Hiển thị tin nhắn dạng file
    public void displayFileMessage(String filename, byte[] file, String sender, String receiver, Boolean yourMessage) {
        FileMessage fm = new FileMessage(filename, file, sender, receiver, yourMessage);

        if (yourMessage == false && cbOnlineUsers.getSelectedItem().equals(sender) == false) {
            addMessage(sender, fm);
        } else if (yourMessage == false && sender.equals(cbOnlineUsers.getSelectedItem())) {
            fm.printMessage(sender, chatWindow);
            addMessage(sender, fm);
        } else {
            fm.printMessage(sender, chatWindow);                
            addMessage((String) cbOnlineUsers.getSelectedItem(), fm);
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

        panel_Icon = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        menu_Icon = new javax.swing.JPopupMenu();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelAccount = new javax.swing.JPanel();
        btnChangePassword = new javax.swing.JButton();
        btnChangeAvatar = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cbOnlineUsers = new javax.swing.JComboBox<>();
        labelChatWith = new javax.swing.JLabel();
        lblAvatar = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatWindow = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        txtChat = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        btnSendFile = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        labelUserName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout panel_IconLayout = new javax.swing.GroupLayout(panel_Icon);
        panel_Icon.setLayout(panel_IconLayout);
        panel_IconLayout.setHorizontalGroup(
            panel_IconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
        );
        panel_IconLayout.setVerticalGroup(
            panel_IconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_IconLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat App");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHAT APP");

        panelAccount.setBackground(new java.awt.Color(204, 255, 255));
        panelAccount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255)));
        panelAccount.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                panelAccountComponentMoved(evt);
            }
        });

        btnChangePassword.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnChangePassword.setForeground(new java.awt.Color(255, 51, 0));
        btnChangePassword.setText("Change Password");
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        btnChangeAvatar.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnChangeAvatar.setForeground(new java.awt.Color(255, 0, 133));
        btnChangeAvatar.setText("Change Avatar");
        btnChangeAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeAvatarActionPerformed(evt);
            }
        });

        btnLogOut.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(0, 0, 153));
        btnLogOut.setText("Log out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAccountLayout = new javax.swing.GroupLayout(panelAccount);
        panelAccount.setLayout(panelAccountLayout);
        panelAccountLayout.setHorizontalGroup(
            panelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccountLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChangeAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChangePassword))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAccountLayout.setVerticalGroup(
            panelAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAccountLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnChangeAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255)));

        cbOnlineUsers.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbOnlineUsers.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Online users" }));
        cbOnlineUsers.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbOnlineUsersItemStateChanged(evt);
            }
        });

        labelChatWith.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        labelChatWith.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelChatWith.setText("Chat with");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(cbOnlineUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(labelChatWith, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(labelChatWith, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(cbOnlineUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        lblAvatar.setText("avatar");

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));

        chatWindow.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        chatWindow.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        chatWindow.setForeground(new java.awt.Color(91, 90, 90));
        jScrollPane2.setViewportView(chatWindow);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Message", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txtChat.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        txtChat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255)));
        txtChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChatActionPerformed(evt);
            }
        });
        txtChat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtChatKeyPressed(evt);
            }
        });

        btnSend.setBackground(new java.awt.Color(30, 30, 30));
        btnSend.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnSend.setForeground(new java.awt.Color(255, 255, 255));
        btnSend.setText("Send");
        btnSend.setBorderPainted(false);
        btnSend.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnSendFile.setBackground(new java.awt.Color(51, 204, 255));
        btnSendFile.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSendFile.setText("File");
        btnSendFile.setBorderPainted(false);
        btnSendFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSendFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendFileActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Icon");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSendFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSend)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSendFile, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(txtChat))
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/chatapp/image/chatBoxIcon.png"))); // NOI18N
        jLabel3.setText("Connect with everyone on the world");

        labelUserName.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        labelUserName.setForeground(new java.awt.Color(255, 51, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblAvatar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(455, 455, 455)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtChatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtChatKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtChat.getText().equals("") && cbOnlineUsers.getSelectedItem() != null) {
                Thread sendTextThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String messageSent = "Text" + "," + labelUserName.getText() + ","
                                    + (String) cbOnlineUsers.getSelectedItem() + "," + txtChat.getText();

                            output.writeUTF(messageSent);
                            output.flush();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                            displayTextMessage("ERROR", "ERROR", "Network error!", true);
                        }
                        displayTextMessage(labelUserName.getText(), (String) cbOnlineUsers.getSelectedItem(), txtChat.getText(), true);
                        autoScroll();
                        txtChat.setText("");
                    }

                });
                sendTextThread.start();
            }
        }
    }//GEN-LAST:event_txtChatKeyPressed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        if (!txtChat.getText().equals("") && cbOnlineUsers.getSelectedItem() != null) {
            Thread sendTextThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String messageSent = "Text" + "," + labelUserName.getText() + ","
                                + (String) cbOnlineUsers.getSelectedItem() + "," + txtChat.getText();
                        output.writeUTF(messageSent);
                        output.flush();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        displayTextMessage("ERROR", "ERROR", "Network error!", true);
                    }
                    displayTextMessage(labelUserName.getText(), (String) cbOnlineUsers.getSelectedItem(), txtChat.getText(), true);
                    autoScroll();
                    txtChat.setText("");
                }

            });
            sendTextThread.start();
        }
    }//GEN-LAST:event_btnSendActionPerformed

    private void cbOnlineUsersItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbOnlineUsersItemStateChanged
        chatWindow.setText("");
        for (String i : messageContent.keySet()) {
            if (i.equals(cbOnlineUsers.getSelectedItem())) {
                displayMessage(i);
            }
        }
    }//GEN-LAST:event_cbOnlineUsersItemStateChanged

    private void txtChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChatActionPerformed

    private void btnSendFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendFileActionPerformed
        // TODO add your handling code here:
        Thread sendFileThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // Hiển thị hộp thoại cho người dùng chọn file để gửi
                JFileChooser fileChooser = new JFileChooser();
                int rVal = fileChooser.showOpenDialog(null);
                if (rVal == JFileChooser.APPROVE_OPTION) {
                    byte[] selectedFile = new byte[(int) fileChooser.getSelectedFile().length()];
                    BufferedInputStream bis;
                    try {
                        bis = new BufferedInputStream(new FileInputStream(fileChooser.getSelectedFile()));
                        // Đọc file vào biến selectedFile
                        bis.read(selectedFile, 0, selectedFile.length);

                        String messageSent = "File" + ","
                                + labelUserName.getText() + "," + (String) cbOnlineUsers.getSelectedItem() + ","
                                + fileChooser.getSelectedFile().getName() + "," + String.valueOf(selectedFile.length);
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException ex) {
                        }

                        output.writeUTF(messageSent);

                        int size = selectedFile.length;
                        int bufferSize = 2048;
                        int offset = 0;

                        // Lần lượt gửi cho server từng buffer cho đến khi hết file
                        while (size > 0) {
                            output.write(selectedFile, offset, Math.min(size, bufferSize));
                            offset += Math.min(size, bufferSize);
                            size -= bufferSize;
                        }

                        output.flush();

                        bis.close();

                        // In ra màn hình file
                        displayFileMessage(fileChooser.getSelectedFile().getName(), selectedFile,
                                labelUserName.getText(), (String) cbOnlineUsers.getSelectedItem(), true
                        );
                        autoScroll();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }

        });
        sendFileThread.start();

    }//GEN-LAST:event_btnSendFileActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        ChangePasswordFrm jframe = new ChangePasswordFrm(this, account, input, output);
        jframe.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    private void btnChangeAvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeAvatarActionPerformed
        ChangeAvatarFrm jframe = new ChangeAvatarFrm(this, account, input, output);
        jframe.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnChangeAvatarActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        int tmp = JOptionPane.showConfirmDialog(chatWindow, "Are you sure Log out?");
        if (tmp == 0) {

            try {
                output.writeUTF("Log out");

                LoginFrm jframe;
                jframe = new LoginFrm();
                jframe.setVisible(true);
                setVisible(false);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void panelAccountComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelAccountComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_panelAccountComponentMoved

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        int newX = jButton1.getLocation().x +240;
//        int newY = jButton1.getLocation().y + jButton1.getHeight() +310;
//
//        // Đặt vị trí mới cho menu_Icon
//        menu_Icon.setLocation(newX, newY);
//
//        // Hiển thị menu_Icon tại vị trí mới
//        menu_Icon.setVisible(true);
//
//        // Hiển thị panel_Icon bên trong menu_Icon
//        menu_Icon.add(panel_Icon);

        Thread sendTextThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String messageSent = "Text" + "," + labelUserName.getText() + ","
                            + (String) cbOnlineUsers.getSelectedItem() + "," + "<img src=\""+ getClass().getResource("/com/chatapp/image/chatBoxIcon.png") + "\"/>";
                    output.writeUTF(messageSent);
                    output.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    displayTextMessage("ERROR", "ERROR", "Network error!", true);
                }
                displayTextMessage(labelUserName.getText(), (String) cbOnlineUsers.getSelectedItem(), "<img src=\""+ getClass().getResource("/com/chatapp/image/chatBoxIcon.png") + "\"/>", true);
                autoScroll();
                txtChat.setText("");
            }

        });
        sendTextThread.start();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void scaleImage() {
//        ImageIcon thongtinKhachHang_icon = new ImageIcon(getClass().getResource("/com/chatapp/image/"));
//        Image thongtinKH_img = thongtinKhachHang_icon.getImage();
//         //Image thongtinKHImgScale = thongtinKH_img.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon thongtinKHScaledIcon = new ImageIcon(thongtinKHImgScale);
//        }
    }

    class Receiver implements Runnable {

        private DataInputStream input;

        public Receiver(DataInputStream dis) {
            this.input = dis;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    // Chờ thông điệp từ server
                    String[] messageReceived = input.readUTF().split(",");

                    if (messageReceived[0].equals("Text")) {
                        // Nhận một tin nhắn văn bản
                        String sender = messageReceived[1];
                        String receiver = messageReceived[2];
                        String message = messageReceived[3];
                        // In tin nhắn lên màn hình chat với người gửi
                        displayTextMessage(sender, receiver, message, false);
                        autoScroll();

                    } else if (messageReceived[0].equals("File")) {
                        // Nhận một file
                        String sender = messageReceived[1];
                        String receiver = messageReceived[2];
                        String filename = messageReceived[3];
                        int size = Integer.parseInt(messageReceived[4]);
                        int bufferSize = 2048;
                        byte[] buffer = new byte[bufferSize];
                        ByteArrayOutputStream file = new ByteArrayOutputStream();

                        while (size > 0) {
                            input.read(buffer, 0, Math.min(bufferSize, size));
                            file.write(buffer, 0, Math.min(bufferSize, size));
                            size -= bufferSize;
                        }
                        
                        // In tin nhắn lên màn hình chat
                        displayFileMessage(filename, file.toByteArray(), sender, receiver, false);
                        autoScroll();

                    } else if (messageReceived[0].equals("Online users")) {
                        // Nhận yêu cầu cập nhật danh sách người dùng trực tuyến
                        String[] users = input.readUTF().split(",");

                        String chat = (String) cbOnlineUsers.getSelectedItem();
                        cbOnlineUsers.removeAllItems();
                        boolean isChattingOnline = false;

                        for (String u : users) {
                            if (u.equals(account.getUserName()) == false) {
                                // Cập nhật danh sách các người dùng trực tuyến vào ComboBox onlineUsers (trừ bản thân)
                                cbOnlineUsers.addItem(u);
                                if (messageContent.get(u) == null) {
                                    messageContent.put(u, new ArrayList<>());
                                }
                            }
                            if ((chat != null) && chat.equals(u)) {
                                isChattingOnline = true;
                            }
                        }
                        if (isChattingOnline == true) {
                            cbOnlineUsers.setSelectedItem(chat);
                        } else if (cbOnlineUsers.getSelectedItem() != null) {
                            cbOnlineUsers.setSelectedIndex(0);
                        }
                        cbOnlineUsers.validate();
                    }

                }

            } catch (IOException ex) {
                System.err.println(ex);
            } finally {
                try {
                    if (input != null) {
                        input.close();
                    } else {
                        System.out.println("Have redundant data...");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ChatFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ChatFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ChatFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ChatFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ChatFrm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangeAvatar;
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnSendFile;
    private javax.swing.JComboBox<String> cbOnlineUsers;
    private javax.swing.JTextPane chatWindow;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelChatWith;
    private javax.swing.JLabel labelUserName;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JPopupMenu menu_Icon;
    private javax.swing.JPanel panelAccount;
    private javax.swing.JPanel panel_Icon;
    private javax.swing.JTextField txtChat;
    // End of variables declaration//GEN-END:variables
}
