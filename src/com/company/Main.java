package com.company;
import org.apache.poi.xwpf.usermodel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = new JFrame("добро пожаловать:");
        JPanel jPanel = new JPanel(new GridBagLayout());
        jPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        JTextField jTextField = new JTextField(30);
        constraints.gridx=0;
        constraints.gridy=0;
        jPanel.add(jTextField,constraints);

        JButton button = new JButton();
        constraints.gridy=0;
        constraints.gridx=1;
        button.setText("create");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    XWPFDocument document = new XWPFDocument();
                    FileOutputStream fileOutputStream = new FileOutputStream(new File("text.docx"));
                    XWPFParagraph paragraph = document.createParagraph();
                    XWPFRun run = paragraph.createRun();

                    System.out.println("created_new_docx_file");
                    String text = jTextField.getText();
                    System.out.println(text);
                    run.setText(text);

                    document.write(fileOutputStream);
                    fileOutputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        jPanel.add(button,constraints);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setPreferredSize(new Dimension(400,700));
        jFrame.setVisible(true);
        jFrame.add(jPanel);
        jFrame.getContentPane().add(jPanel);
        jFrame.pack();


    }
}