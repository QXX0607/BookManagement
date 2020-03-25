package com.book.view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class mainPage extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainPage frame = new mainPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * Create the frame.
     */
    public mainPage() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int windowsWedth = 450;
        int windowsHeight = 300;
        setBounds((width-windowsWedth)/2,(height-windowsHeight)/2,windowsWedth,windowsHeight);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton jb1 = new JButton("\u7BA1\u7406\u5458");//管理员界面
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                login_admin l1 = new login_admin();
            }
        });
        jb1.setBounds(127, 60, 165, 68);
        contentPane.add(jb1);

        JButton jb2 = new JButton("\u7528\u6237");      //用户界面
        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                login_user l2 = new login_user();
            }
        });
        jb2.setBounds(133, 153, 159, 68);
        contentPane.add(jb2);
    }
}
