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

class book extends JFrame {

    private JPanel contentPane;
    private JTextField jt1;
    private JTextField jt2;
    private JTextField jt3;
    private JTextField jt4;
    private JTextField jt5;
    private JTextField jt6;

    Connection coon = null;
    PreparedStatement st;
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/mydb";
    public static final String user = "root";
    public static final String password = "1492949670";
    String sql = "insert into book values(?,?,?,?,?,?)";
    /**
     * Launch the application.
     */
    /**
     * Create the frame.
     */
    public book() {
        setVisible(true);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int windowsWedth = 520 ;
        int windowsHeight = 520;
        setBounds((width-windowsWedth)/2,(height-windowsHeight)/2,windowsWedth,windowsHeight);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel jlb1 = new JLabel("Name");
        jlb1.setBounds(57, 39, 66, 39);
        contentPane.add(jlb1);

        JLabel jlb2 = new JLabel("Author");
        jlb2.setBounds(57, 88, 66, 32);
        contentPane.add(jlb2);

        JLabel jlb3 = new JLabel("Press");
        jlb3.setBounds(57, 139, 66, 32);
        contentPane.add(jlb3);

        JLabel jlb4 = new JLabel("ISBN");
        jlb4.setBounds(57, 190, 54, 36);
        contentPane.add(jlb4);

        JLabel jlb5 = new JLabel("PubDate");
        jlb5.setBounds(57, 236, 66, 37);
        contentPane.add(jlb5);

        JLabel jlb6 = new JLabel("Pages");
        jlb6.setBounds(57, 292, 66, 29);
        contentPane.add(jlb6);

        JButton jb1 = new JButton("Input");
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Class.forName(driver);
                    coon = DriverManager.getConnection(url,user,password);
                    st = coon.prepareStatement(sql);
                    String str1  = jt1.getText();
                    String str2  = jt2.getText();
                    String str3  = jt3.getText();
                    String str4  = jt4.getText();
                    String str5  = jt5.getText();
                    String str6  = jt6.getText();
                    st.setString(1, str1);
                    st.setString(2, str2);
                    st.setString(3, str3);
                    st.setString(4, str4);
                    st.setString(5,str5);
                    st.setString(6,str6);
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
        jb1.setBounds(57, 378, 124, 52);
        contentPane.add(jb1);

        JButton jb2 = new JButton("Exit");
        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jt1.setText("");
                jt2.setText("");
                jt3.setText("");
                jt4.setText("");
                jt5.setText("");
                jt6.setText("");
            }
        });
        jb2.setBounds(273, 378, 124, 52);
        contentPane.add(jb2);
        jt1 = new JTextField();
        jt1.setBounds(151, 46, 215, 32);
        contentPane.add(jt1);
        jt1.setColumns(10);
        jt2 = new JTextField();
        jt2.setBounds(151, 91, 215, 29);
        contentPane.add(jt2);
        jt2.setColumns(10);
        jt3 = new JTextField();
        jt3.setBounds(151, 143, 215, 32);
        contentPane.add(jt3);
        jt3.setColumns(10);
        jt4 = new JTextField();
        jt4.setBounds(151, 194, 215, 32);
        contentPane.add(jt4);
        jt4.setColumns(10);
        jt5 = new JTextField();
        jt5.setBounds(151, 242, 215, 31);
        contentPane.add(jt5);
        jt5.setColumns(10);
        jt6 = new JTextField();
        jt6.setBounds(151, 300, 215, 32);
        contentPane.add(jt6);
        jt6.setColumns(10);
    }
}
