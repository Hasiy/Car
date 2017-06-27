package car;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
/**
 * Created by zhuxiaoyao on 2017/6/27.  todo 查询车票
 */
public class QueryTicket extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
    Object a[][];
    Object colname[]={"车票编号","起点站","终点站","票价","发车时间","座位数"};
    JTable table;
    JButton bBack,bSearch;
    Container container;
    JPanel panel1;

    public QueryTicket(){
        setTitle("查询车票");
        Image img=Toolkit.getDefaultToolkit().getImage(car.QueryTicket.class.getResource("1.png"));
        setIconImage(img);

        a=new Object[100][6];
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
                int i=0,n;
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car","sa","512512");
                stat=conn.createStatement();
                rs=stat.executeQuery("select distinct TrainNumber,OriginStation,TerminalStation,TicketPrice,DepartureTime,TicketsLeft from TrainNumberTable");
                n=0;
                while(rs.next()){
                    a[i][0]=rs.getString("TrainNumber");
                    a[i][1]=rs.getString("OriginStation");
                    a[i][2]=rs.getString("TerminalStation");
                    a[i][3]=rs.getString("TicketPrice");
                    a[i][4]=rs.getString("DepartureTime");
                    a[i][5]=rs.getString("TicketsLeft");
                    i++;
                    this.setVisible(false);
                    n++;
                    this.setVisible(true);
                }
                if(n==0)
                    JOptionPane.showMessageDialog(null,"抱歉没有车票信息!","提示",JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"连接数据库失败!","提示",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new QueryTicket();
    }
}
