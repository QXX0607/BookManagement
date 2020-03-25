package com.book.view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class record extends JFrame {

    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public record() {
        setTitle("Record");
        setVisible(true);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int windowsWedth = 400 ;
        int windowsHeight = 300;
        setBounds((width-windowsWedth)/2,(height-windowsHeight)/2,428,375);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton jb1 = new JButton("Borrow");
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                borrowrecord br = new borrowrecord();
            }
        });
        jb1.setBounds(143, 51, 137, 37);
        contentPane.add(jb1);

        JButton jb2 = new JButton("Return");
        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                returnrecord rr = new returnrecord();
            }
        });
        jb2.setBounds(143, 117, 137, 37);
        contentPane.add(jb2);

        JButton jb3 = new JButton("ShowBorrow");
        jb3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                show1 s1 = new show1();
            }
        });
        jb3.setBounds(143, 186, 137, 37);
        contentPane.add(jb3);

        JButton jb4 = new JButton("ShowReturn");
        jb4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                show2 s2 = new show2();
            }
        });
        jb4.setBounds(143, 259, 137, 37);
        contentPane.add(jb4);
    }

}
