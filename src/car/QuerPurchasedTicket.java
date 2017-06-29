package car;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * Created by zhuxiaoyao on 2017/6/27.    查询已购车票   user
 */
    public class QuerPurchasedTicket extends JFrame implements ActionListener
    {
        private static final long serialVersionUID = 1L;
        ButtonGroup changle;
        JLabel lName;
        JTextField tName;
        JButton bBack,bSearch;
        JPanel panel;
        JTable table;
        Container container;
        Object a[][];
        Object colname[]={"车次编号","座位号","起点站","终点站","票价","发车时间","用户名","车票编号"};
        public QuerPurchasedTicket()
        {
            super("查询已购车票");
            Image img=Toolkit.getDefaultToolkit().getImage(car.QuerPurchasedTicket.class.getResource("1.png"));
            setIconImage(img);
            a=new Object[50][8];
            table=new JTable(a,colname);
            setSize(50,50);
            setVisible(true);
            lName=new JLabel("输入用户名：");
            tName=new JTextField(15);
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
            changle=new ButtonGroup();
            panel=new JPanel();
            panel.add(lName);
            panel.add(tName);
            panel.add(bSearch);
            panel.add(bBack);
            container=getContentPane();
            container.add(panel,BorderLayout.SOUTH);
            container.add(new JScrollPane(table),BorderLayout.CENTER);
            setBounds(400,200,600,400);
        }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==bBack){
                dispose();
            }
            else
                if(ae.getSource()==bSearch){
                if(tName.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"请输用户名!","提示",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    int i=0;
                    Connection conn;
                    Statement stat;
                    ResultSet rst;
                    try{
                        int n=0;
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car","sa","512512");
                        stat=conn.createStatement();
                        rst=stat.executeQuery("select TrainNumber,SetNumber,OriginStation,TerminalStation,TicketPrice,DepartureTime,UserName,IDNumber from TicketInfo "
                                + "where UserName="+"'"+tName.getText()+"'");
                        while(rst.next()){
                            a[i][0]=rst.getString("TrainNumber");
                            a[i][1]=rst.getString("SetNumber");
                            a[i][2]=rst.getString("OriginStation");
                            a[i][3]=rst.getString("TerminalStation");
                            a[i][4]=rst.getString("TicketPrice");
                            a[i][5]=rst.getString("DepartureTime");
                            a[i][6]=rst.getString("UserName");
                            a[i][7]=rst.getString("IDNumber");
                            i++;n++;
                            this.setVisible(false);
                            this.setVisible(true);
                        }
                        if(n==0)
                            JOptionPane.showMessageDialog(null,"Sorry没有用户信息!","提示",JOptionPane.ERROR_MESSAGE);
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,"连接失败!","提示",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        }
        public static void main(String[] args) {
            new car.QuerPurchasedTicket();
        }

    }
