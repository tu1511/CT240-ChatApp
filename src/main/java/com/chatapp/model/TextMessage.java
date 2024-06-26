/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chatapp.model;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

/**
 *
 * @author Admin
 */
public class TextMessage extends Message{
    
    String message;

    public TextMessage(String message, String sender, String receiver, boolean yourMessage) {
        super(sender, receiver, yourMessage);
        this.message = message;
    }

    @Override
    public void printMessage(String sender, JTextPane chatWindows) {
//        StyledDocument doc = chatWindows.getStyledDocument();
//        SimpleAttributeSet right = new SimpleAttributeSet();
//        StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
//        SimpleAttributeSet left = new SimpleAttributeSet();
//        StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
//
//        Style userStyle = doc.getStyle("User style");
//        if (userStyle == null) {
//            userStyle = doc.addStyle("User style", null);
//            StyleConstants.setBold(userStyle, true);
//        }
//
//        if (yourMessage == true) {
//            //StyleConstants.setForeground(userStyle, Color.RED);
//            //doc.setParagraphAttributes(doc.getLength(), 1, right, false);
//            // In ra tên người gửi
//            try {
//                StyleConstants.setForeground(userStyle, Color.red);
//                doc.insertString(doc.getLength(), "You: ", userStyle);
//            } catch (BadLocationException e) {
//            }
//        } else {
//            try {
//                StyleConstants.setForeground(userStyle, new Color(19, 142, 24));
//                doc.insertString(doc.getLength(), sender + ": ", userStyle);
//            } catch (BadLocationException e) {
//            }
//        }
//
//        Style messageStyle = doc.getStyle("Message style");
//        if (messageStyle == null) {
//            messageStyle = doc.addStyle("Message style", null);
//            StyleConstants.setForeground(messageStyle, Color.BLACK);
//            StyleConstants.setBold(messageStyle, false);
//        }
//
//        // In ra nội dung tin nhắn
//        try {
//            doc.insertString(doc.getLength(), message + "\n", messageStyle);
//        } catch (BadLocationException e) {
//        }

        HTMLDocument htmlDoc = (HTMLDocument) chatWindows.getDocument();
        HTMLEditorKit htmlKit = (HTMLEditorKit) chatWindows.getEditorKit();

        String displayedMessage;
        if (yourMessage) {
            displayedMessage = "<html><body><p><b style='color: red'>You: </b>" + message + "</p></body></html>";
        } else{
            displayedMessage = "<html><body><p><b style='color: green'>" + sender + ": </b>" + message + "</p></body></html>";
        }
        
        try {
            htmlKit.insertHTML(htmlDoc, htmlDoc.getLength(), displayedMessage, 0, 0, null);
        } catch (BadLocationException | IOException ex) {
            Logger.getLogger(TextMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
        StyleSheet styleSheet = htmlDoc.getStyleSheet();
        styleSheet.addRule("body { font-family: Bahnschrift; font-size: 18pt; }");
        styleSheet.addRule("p { margin: 3px 2px; }");
    }
}
