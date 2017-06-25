package car;
/**
 * Created by zhuxiaoyao on 2017/6/25.
 */

import javax.swing.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.*;

public class UserLogin extends JFrame implements ActionListener {
    //	 登录c
    private static final long serialVersionUID = 1L;
    //定义
    JLabel lbUser, lbPass, lbTitle;
    JTextField tUser;
    JPasswordField password;
    JButton bLogin, bCancel;
    JPanel panelMain, panel1, panel2, panel3, panel4;

    public UserLogin() {
        //主面板
        super("Login User");
        Image img = Toolkit.getDefaultToolkit().getImage(car.UserLogin.class.getResource("1.png"));
        setIconImage(img);

        UIManager.put("Button.select", new Color(100, 200, 100));
        setLayout(null);
        panelMain = new JPanel();
        this.setContentPane(panelMain);
        //标题
        panel1 = new JPanel();
//		lbTitle=new JLabel("WELCOME");
        lbTitle = new JLabel(new ImageIcon(car.UserLogin.class.getResource("UserLogin.jpg")));
//		lbTitle.setFont(titleFont);
        panel1.add(lbTitle);
        //用户名
        panel2 = new JPanel();
        lbUser = new JLabel("用 户 名:");
        tUser = new JTextField(12);
        panel2.add(lbUser);
        panel2.add(tUser);
        //密码
        panel3 = new JPanel();
        lbPass = new JLabel("密    码 : ");
        password = new JPasswordField(12);
        panel3.add(lbPass);
        panel3.add(password);
        //按钮
        panel4 = new JPanel();
        bLogin = new JButton("登 陆");
        bLogin.setFont(new java.awt.Font("楷体", 1, 20));// 设置按钮的字体大小 颜按钮色
        bLogin.setBackground(Color.white);
        bLogin.setBorder(BorderFactory.createRaisedBevelBorder());
        bLogin.addActionListener(this);
        bCancel = new JButton("取 消");
        bCancel.setFont(new java.awt.Font("楷体", 1, 20));// 设置按钮的字体大小 颜按钮色
        bCancel.setBackground(Color.white);
        bCancel.setBorder(BorderFactory.createRaisedBevelBorder());
        bCancel.addActionListener(this);
        bLogin.setBounds(380, 480, 50, 50);
        bCancel.setBounds(390, 480, 50, 50);
        panel4.add(bLogin);
        panel4.add(bCancel);
        //子面板添加
        panelMain.add(panel1);
        panelMain.add(panel2);
        panelMain.add(panel3);
        panelMain.add(panel4);
        //窗体属性
        setBounds(400, 250, 430, 400);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //按钮事件
    public void actionPerformed(ActionEvent ae) {
        //登陆按钮
        if (ae.getSource() == bLogin) {
            if (tUser.getText().equals("") || password.getPassword().equals("")) {
                JOptionPane.showMessageDialog(null, "请输入");
            } else {
                Connection conn;
                Statement stat;
                ResultSet rs;
                try {
                    //数据库连接
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car", "sa", "512512");
                    stat = conn.createStatement();
                    rs = stat.executeQuery("select * from UserInfo where Name=" + "'" + String.valueOf(tUser.getText()) + "' and Password=" + "'" + String.valueOf(password.getPassword()) + "'");
                    if (rs.next()) {
                        this.dispose();
//
                        new Main();  /*   */
//							rs.close();
                        JOptionPane.showMessageDialog(null, "  欢迎登陆系统!", "提示", JOptionPane.INFORMATION_MESSAGE);
                    } else
                        JOptionPane.showMessageDialog(null, "用户或密码错误", "提示", JOptionPane.ERROR_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "连接失败!", "提示", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        //取消按钮
        if (ae.getSource() == bCancel) {
            this.dispose();
        }
    }

    public static void main(String[] args) throws SQLException {
        new UserLogin();
    }

}

