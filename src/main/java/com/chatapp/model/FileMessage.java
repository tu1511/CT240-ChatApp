/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chatapp.model;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

/**
 *
 * @author Admin
 */
public class FileMessage extends Message {
    String filename;
    byte[] file;
    
    private HyberlinkListener hyberLink;

    public FileMessage(String filename, byte[] file, String sender, String receiver, boolean yourMessage) {
        super(sender, receiver, yourMessage);
        this.filename = filename;
        this.file = file;
        
        hyberLink = new HyberlinkListener(filename, file);
    }

    @Override
    public void printMessage(String sender, JTextPane chatWindows) {
//        StyledDocument doc = chatWindows.getStyledDocument();
//        //SimpleAttributeSet right = new SimpleAttributeSet();
//        //StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
//
//        Style userStyle = doc.getStyle("User style");
//        if (userStyle == null) {
//            userStyle = doc.addStyle("User style", null);
//            StyleConstants.setBold(userStyle, true);
//        }
//
//        if (yourMessage == true) {
//            //StyleConstants.setForeground(userStyle, Color.red);
//            try {
//                StyleConstants.setForeground(userStyle, Color.red);
//                doc.insertString(doc.getLength(), "You: ", userStyle);
//            } catch (BadLocationException e) {
//            }
//        } else {
//            //StyleConstants.setForeground(userStyle, Color.BLUE);
//            try {
//                StyleConstants.setForeground(userStyle, new Color(19, 142, 24));
//                doc.insertString(doc.getLength(), sender + ": ", userStyle);
//            } catch (BadLocationException e) {
//            }
//        }
//
//        Style linkStyle = doc.getStyle("Link style");
//        if (linkStyle == null) {
//            linkStyle = doc.addStyle("Link style", null);
//            StyleConstants.setForeground(linkStyle, Color.BLUE);
//            StyleConstants.setUnderline(linkStyle, true);
//            StyleConstants.setBold(linkStyle, true);
//        }
//        linkStyle.addAttribute("link", new HyberlinkListener(filename, file) {});
//        
//        if (chatWindows.getMouseListeners() != null) {
//            for (MouseListener ml : chatWindows.getMouseListeners()) {
//                chatWindows.removeMouseListener(ml);
//            }
//        }
//
//        if (chatWindows.getMouseListeners() != null) {
//            // Tạo MouseListener cho các đường dẫn tải về file
//            chatWindows.addMouseListener(new MouseListener() {
//
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    @SuppressWarnings("deprecation")
//                    Element ele = doc.getCharacterElement(chatWindows.viewToModel(e.getPoint()));
//                    AttributeSet as = ele.getAttributes();
//                    HyberlinkListener listener = (HyberlinkListener) as.getAttribute("link");
//                    if (listener != null) {
//                        listener.execute();
//                    }
//                }
//
//                @Override
//                public void mousePressed(MouseEvent e) {
//                    // TODO Auto-generated method stub
//
//                }
//
//                @Override
//                public void mouseReleased(MouseEvent e) {
//                    // TODO Auto-generated method stub
//
//                }
//
//                @Override
//                public void mouseEntered(MouseEvent e) {
//                    // TODO Auto-generated method stub
//
//                }
//
//                @Override
//                public void mouseExited(MouseEvent e) {
//                    // TODO Auto-generated method stub
//
//                }
//
//            });
//        }
//
//        // In ra đường dẫn tải file
//        try {
//            doc.insertString(doc.getLength(), "<" + filename + ">", linkStyle);
//        } catch (BadLocationException e1) {
//            e1.printStackTrace();
//        }
//
//        // Xuống dòng
//        try {
//            doc.insertString(doc.getLength(), "\n", userStyle);
//        } catch (BadLocationException e1) {
//            e1.printStackTrace();
//        }

        HTMLDocument htmlDoc = (HTMLDocument) chatWindows.getDocument();
        HTMLEditorKit htmlKit = (HTMLEditorKit) chatWindows.getEditorKit();

        String htmlMessage;
        if (yourMessage) {
            htmlMessage = "<html><body><p><b style='color: red'>You: </b><a href=\"#\">" + filename + "</a></p></body></html>";
        } else{
            htmlMessage = "<html><body><p><b style='color: green'>" + sender + ": </b><a href=\"#\">" + filename + "</a></p></body></html>";
        }
        
        SimpleAttributeSet attrs = new SimpleAttributeSet();
        attrs.addAttribute("link", new HyberlinkListener(filename, file));
        
        try {
            htmlKit.insertHTML(htmlDoc, htmlDoc.getLength(), htmlMessage, 0, 0, null);
            htmlDoc.setCharacterAttributes(htmlDoc.getLength() - filename.length(), filename.length(), attrs, false);
        } catch (BadLocationException | IOException ex) {
            Logger.getLogger(TextMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        StyleSheet styleSheet = htmlDoc.getStyleSheet();
        styleSheet.addRule("body { font-family: Bahnschrift; font-size: 18pt; }");
        styleSheet.addRule("p { margin: 3px 2px; }");

        if (chatWindows.getMouseListeners() != null) {
            for (MouseListener ml : chatWindows.getMouseListeners()) {
                chatWindows.removeMouseListener(ml);
            }
        }
        chatWindows.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Element ele = htmlDoc.getCharacterElement(chatWindows.viewToModel(e.getPoint()));
                AttributeSet as = ele.getAttributes();
                HyberlinkListener link = (HyberlinkListener) as.getAttribute("link");
                if (link != null) {
                    link.execute();
                }
            }
        });
       
    }

    /**
     * MouseListener cho các đường dẫn tải file.
     */
    class HyberlinkListener extends AbstractAction {

        String filename;
        byte[] file;

        public HyberlinkListener(String filename, byte[] file) {
            this.filename = filename;
            this.file = Arrays.copyOf(file, file.length);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            execute();
        }

        public void execute() {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setSelectedFile(new File(filename));
            int rVal = fileChooser.showSaveDialog(null); //see it
            if (rVal == JFileChooser.APPROVE_OPTION) {

                // Mở file đã chọn sau đó lưu thông tin xuống file đó
                File saveFile = fileChooser.getSelectedFile();
                BufferedOutputStream bos = null;
                try {
                    bos = new BufferedOutputStream(new FileOutputStream(saveFile));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                // Hiển thị JOptionPane cho người dùng có muốn mở file vừa tải về không
                int nextAction = JOptionPane.showConfirmDialog(null, "Saved file to " + saveFile.getAbsolutePath() + "\nDo you want to open this file?", "Successful", JOptionPane.YES_NO_OPTION);
                if (nextAction == JOptionPane.YES_OPTION) {
                    try {
                        Desktop.getDesktop().open(saveFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (bos != null) {
                    try {
                        bos.write(this.file);
                        bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
