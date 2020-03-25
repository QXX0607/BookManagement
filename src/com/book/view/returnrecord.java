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

public class returnrecord extends JFrame {

    private JPanel contentPane;
    private JTextField jtf3;
    private JTextField jtf2;
    private JTextField jtf1;

    Connection coon = null;
    PreparedStatement st;
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/mydb";
    public static final String user = "root";
    public static final String password = "1492949670";
    String sql = "insert into returnr values(?,?,?)";
    /**
     * Create the frame.
     */
    public returnrecord() {
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

        JLabel jlb1 = new JLabel("Bookname");
        jlb1.setBounds(52, 102, 87, 39);
        contentPane.add(jlb1);

        JLabel jlb2 = new JLabel("ReturnDate");
        jlb2.setBounds(52, 169, 108, 33);
        contentPane.add(jlb2);

        jtf3 = new JTextField();
        jtf3.setBounds(168, 169, 193, 33);
        contentPane.add(jtf3);
        jtf3.setColumns(10);

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
        jb1.setBounds(71, 242, 108, 33);
        contentPane.add(jb1);

        JButton jb2 = new JButton("Reset");
        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jtf1.setText("");
                jtf2.setText("");
                jtf3.setText("");
            }
        });
        jb2.setBounds(245, 242, 108, 33);
        contentPane.add(jb2);

        jtf2 = new JTextField();
        jtf2.setBounds(168, 108, 193, 33);
        contentPane.add(jtf2);
        jtf2.setColumns(10);

        JLabel jlb3 = new JLabel("Username");
        jlb3.setBounds(52, 60, 69, 32);
        contentPane.add(jlb3);

        jtf1 = new JTextField();
        jtf1.setBounds(168, 67, 193, 31);
        contentPane.add(jtf1);
        jtf1.setColumns(10);
    }
}
