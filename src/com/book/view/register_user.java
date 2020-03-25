package com.book.view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

class register_user extends JFrame {

    private JPanel contentPane;
    private JTextField jt1;
    private JTextField jt2;
    private JButton jb1;
    private JButton jb2;
    public String[] typelist = {"用户","管理员"};
    //数据库信息
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/mydb";
    public static final String user = "root";
    public static final String password = "1492949670";
    Connection coon = null;
    PreparedStatement st;
    /**
     * Create the frame.
     */
    public register_user() {
        setTitle("\u6CE8\u518C");
        setVisible(true);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int windowsWedth = 450;
        int windowsHeight = 300;
        setBounds((width-windowsWedth)/2,(height-windowsHeight)/2,windowsWedth,windowsHeight);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel jlb1 = new JLabel("Username");
        jlb1.setBounds(42, 57, 76, 21);
        contentPane.add(jlb1);

        JLabel jlb2 = new JLabel("Password");
        jlb2.setBounds(42, 109, 76, 18);
        contentPane.add(jlb2);

        jt1 = new JTextField();
        jt1.setBounds(152, 57, 178, 21);
        contentPane.add(jt1);
        jt1.setColumns(10);

        jt2 = new JTextField();
        jt2.setBounds(151, 106, 179, 21);
        contentPane.add(jt2);
        jt2.setColumns(10);


        jb2 = new JButton("\u91CD\u7F6E");
        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jt1.setText("");
                jt2.setText("");
            }
        });
        jb2.setBounds(267, 194, 93, 23);
        contentPane.add(jb2);

        JLabel lblNewLabel = new JLabel("Type");
        lblNewLabel.setBounds(42, 153, 54, 15);
        contentPane.add(lblNewLabel);

        JComboBox comboBox = new JComboBox(typelist);
        comboBox.setBounds(148, 150, 182, 23);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String str3 = comboBox.getSelectedItem().toString();
            }
        });
        contentPane.add(comboBox);

        String sql = "insert into register values(?,?,?)";
        jb1 = new JButton("\u6CE8\u518C");
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Class.forName(driver);
                    coon = (Connection) DriverManager.getConnection(url,user,password);
                    st = (PreparedStatement) coon.prepareStatement(sql);
                    String str1 = jt1.getText();
                    String str2 = jt2.getText();
                    String str3 = comboBox.getSelectedItem().toString();
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
                        JOptionPane.showMessageDialog(null,"关闭数据库失败！","提示",1);
                        e.printStackTrace();
                    }
                }
            }
        });
        jb1.setBounds(87, 194, 93, 23);
        contentPane.add(jb1);

    }
}

