package com.petrenko.lab0103;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class StringReader extends JFrame {

    public JButton inputButton;
    public JLabel label;
    public JTextField textField;

    public StringReader(String title) {
        Scanner s = null;
        try {
            s = new Scanner(new File("text.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();
        
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(new BorderLayout());

        label = new JLabel("Проста програма");
        inputButton = new JButton("Кнопка");
        textField = new JTextField("");

        panel.add(textField, BorderLayout.NORTH);
        panel.add(label);
        panel.add(inputButton, BorderLayout.SOUTH);

        setContentPane(panel);
        setPreferredSize(new Dimension(300, 150));
        pack();



        inputButton.addActionListener(new ActionListener() {
            int counter = 0;
            public void actionPerformed(ActionEvent arg0) {
                textField.setText(list.get(counter++));
                if (list.size() == counter) {
                    counter = 0;
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
