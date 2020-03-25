package com.book.view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

class login_admin extends JFrame {

    private JPanel contentPane;
    private JPasswordField passwordField;
    private JTextField jtf1;

    //数据库信息
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/mydb";
    public static final String user = "root";
    public static final String password = "1492949670";
    Connection coon = null;
    /**
     * Create the frame.
     */
    public login_admin() {
        setVisible(true);
        setTitle("Welcome");
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int windowsWedth = 450 ;
        int windowsHeight = 300;
        setBounds((width-windowsWedth)/2,(height-windowsHeight)/2,windowsWedth,windowsHeight);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel jlb1 = new JLabel("User");
        jlb1.setBounds(70, 59, 56, 44);
        contentPane.add(jlb1);

        JLabel jlb2 = new JLabel("Password");
        jlb2.setBounds(45, 125, 81, 35);
        contentPane.add(jlb2);

        passwordField = new JPasswordField();
        passwordField.setBounds(143, 129, 187, 31);
        contentPane.add(passwordField);

        jtf1 = new JTextField();
        jtf1.setBounds(143, 72, 186, 31);
        contentPane.add(jtf1);
        jtf1.setColumns(10);

        JButton jb1 = new JButton("\u767B\u5F55");		//登录按钮
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String str1 = jtf1.getText();
                String str2 = passwordField.getPassword().toString();
                try {
                    Class.forName(driver);
                    coon = (Connection) DriverManager.getConnection(url,user,password);
                    String sql="select count(1) from register where user='"+str1+"' and password ='"+str2+"'";
                    if (sql!=null) {
                        JOptionPane.showMessageDialog(null, "登录成功！", "提示", 1);
                        book bo = new book();
                    }
                }catch(ClassNotFoundException e) {
                    e.printStackTrace();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
                if (null != coon) {
                    try {
                        coon.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null,"关闭数据库失败！","提示",1);
                        e.printStackTrace();
                    }
                }

            }
        });
        jb1.setBounds(70, 199, 93, 23);
        contentPane.add(jb1);

        JButton jb2 = new JButton("\u6CE8\u518C");		//注册按钮
        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                register_admin re = new register_admin();
            }
        });
        jb2.setBounds(253, 199, 93, 23);
        contentPane.add(jb2);
    }
}
