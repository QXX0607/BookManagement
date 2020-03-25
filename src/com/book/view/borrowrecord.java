package com.book.view;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class borrowrecord extends JFrame {

    private JPanel contentPane;
    private JTextField jtf2;
    private JLabel jlb1;
    private JLabel jlb2;
    private JTextField jtf3;
    private JLabel lblNewLabel_1;
    private JTextField jtf1;

    Connection coon = null;
    PreparedStatement st;
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/mydb";
    public static final String user = "root";
    public static final String password = "1492949670";
    String sql = "insert into borrow values(?,?,?)";
    /**
     * Create the frame.
     */
    public borrowrecord() {
        setTitle("Record");
        setVisible(true);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int windowsWedth = 430 ;
        int windowsHeight = 400;
        setBounds((width-windowsWedth)/2,(height-windowsHeight)/2,windowsWedth,windowsHeight);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        jtf2 = new JTextField();
        jtf2.setBounds(160, 88, 200, 40);
        contentPane.add(jtf2);
        jtf2.setColumns(10);
        jlb1 = new JLabel("Bookname");
        jlb1.setBounds(47, 95, 76, 33);
        contentPane.add(jlb1);
        jlb2 = new JLabel("BorrowDate");
        jlb2.setBounds(47, 155, 98, 40);
        contentPane.add(jlb2);
        JButton jb1 = new JButton("Set");
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Class.forName(driver);
                    coon = DriverManager.getConnection(url,user,password);
                    st = coon.prepareStatement(sql);
                    String str1  = jtf1.getText();
                    String str2  = jtf2.getText();
                    String str3  = jtf3.getText();
                    st.setString(1, str1);
                    st.setString(2, str2);
                    st.setString(3, str3);
                    st.executeUpdate();
                }catch(ClassNotFoundException e) {
                    e.printStackTrace();
                }catch (SQLException e) {
                    e.printStackTrace();
                }
                if (null != coon) {
                    try {
                        coon.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "关闭数据库失败！", "提示", 1);
                        e.printStackTrace();
                    }
                }

            }
        });
        jb1.setBounds(71, 247, 93, 23);
        contentPane.add(jb1);

        JButton jb2 = new JButton("Reset");
        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jtf1.setText("");
                jtf2.setText("");
                jtf3.setText("");
            }
        });
        jb2.setBounds(274, 247, 93, 23);
        contentPane.add(jb2);

        jtf3 = new JTextField();
        jtf3.setBounds(160, 155, 200, 40);
        contentPane.add(jtf3);
        jtf3.setColumns(10);

        lblNewLabel_1 = new JLabel("Username");
        lblNewLabel_1.setBounds(47, 40, 76, 38);
        contentPane.add(lblNewLabel_1);

        jtf1 = new JTextField();
        jtf1.setBounds(160, 37, 200, 39);
        contentPane.add(jtf1);
        jtf1.setColumns(10);
    }
}
