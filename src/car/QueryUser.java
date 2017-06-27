package car;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
/**
 * Created by zhuxiaoyao on 2017/6/27.
 */
public class QueryUser extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
    Object a[][];
    Object colname[]={"编号","姓名","身份证号","手机号"};
    JTable table;
    JButton bBack,bSearch;
    Container container;
    JPanel panel1;

    public QueryUser(){
        setTitle("查所用户");
        Image img=Toolkit.getDefaultToolkit().getImage(car.QueryUser.class.getResource("1.png"));
        setIconImage(img);

        a=new Object[100][4];
        table=new JTable(a,colname);

        bBack=new JButton("返回");
        bBack.setFont(new java.awt.Font("楷体", 1, 20));// 设置按钮的字体大小 颜按钮色
        bBack.setBackground(Color.white);
        bBack.setBorder(BorderFactory.createRaisedBevelBorder());
        bBack.addActionListener(this);

        bSearch=new JButton("查找");
        bSearch.setFont(new java.awt.Font("楷体", 1, 20));// 设置按钮的字体大小 颜按钮色
        bSearch.setBackground(Color.white);
        bSearch.setBorder(BorderFactory.createRaisedBevelBorder());
        bSearch.addActionListener(this);

        panel1=new JPanel();
        panel1.add(bBack);
        panel1.add(bSearch);

        container=getContentPane();
        container.add(panel1,BorderLayout.SOUTH);

        container.add(new JScrollPane(table),BorderLayout.CENTER);
        setBounds(380,200,500,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==bBack){
            dispose();
        }
        else if(ae.getSource()==bSearch){

            Connection conn;
            Statement stat;
            ResultSet rs;
            try{
                int i=0;
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car","sa","512512");
                stat=conn.createStatement();
                rs=stat.executeQuery("select distinct IDnumbered,NAME,IDcard,Mobile from UserInfo");
                while(rs.next()){
                    a[i][0]=rs.getString("IDnumbered");
                    a[i][1]=rs.getString("NAME");
                    a[i][2]=rs.getString("IDcard");
                    a[i][3]=rs.getString("Mobile");
                    i++;
                    this.setVisible(false);
                    this.setVisible(true);
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"连接失败!","提示",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new QueryUser();
    }
}
