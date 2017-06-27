package car;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 * Created by zhuxiaoyao on 2017/6/27. todo 按起点站或终点站查
 */
    public class QuerTrain extends JFrame implements ActionListener
    {
        private static final long serialVersionUID = 1L;
        JRadioButton jrbOrigin,jrbTerminus;
        ButtonGroup changle;
        JLabel lName;
        JTextField tName;
        JButton bBack,bSearch;
        JPanel panel;
        JTable table;
        Container container;
        Object a[][];
        Object colname[]={"车次编号","起点站","终点站","票价","发车时间","座位数"};
        public QuerTrain()
        {
            super("按起点站或终点站查");

            Image img=Toolkit.getDefaultToolkit().getImage(car.QuerTrain.class.getResource("1.png"));
            setIconImage(img);

            a=new Object[50][6];
            table=new JTable(a,colname);
            setSize(50,50);
            setVisible(true);
            lName=new JLabel("输入站名：");
            tName=new JTextField(8);
            jrbOrigin=new JRadioButton("按起点站查找");
            jrbOrigin.addActionListener(this);
            jrbTerminus=new JRadioButton("按终点站查找");
            jrbTerminus.addActionListener(this);
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
            changle.add(jrbOrigin);
            changle.add(jrbTerminus);
            panel=new JPanel();
            panel.add(lName);
            panel.add(tName);
            panel.add(jrbOrigin);
            panel.add(jrbTerminus);
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
            else if(ae.getSource()==bSearch && jrbOrigin.isSelected()){
                if(tName.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"请输入站点名!","提示",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    int i=0;
                    Connection conn;
                    Statement stat;
                    ResultSet rst;
                    try{
                        int n=0;
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car","sa","512512");
                        stat=conn.createStatement();
                        rst=stat.executeQuery("select TrainNumber,OriginStation,TerminalStation,TicketPrice,DepartureTime,TicketsLeft from TrainNumberTable " +
                                "where OriginStation="+"'"+tName.getText()+"'");
                        while (rst.next()){
                            a[i][0]=rst.getString("TrainNumber");
                            a[i][1]=rst.getString("OriginStation");
                            a[i][2]=rst.getString("TerminalStation");
                            a[i][3]=rst.getString("TicketPrice");
                            a[i][4]=rst.getString("DepartureTime");
                            a[i][5]=rst.getString("TicketsLeft");
                            n++;
                            this.setVisible(false);
                            this.setVisible(true);
                            i++;
                        }
                        if(n==0)
                            JOptionPane.showMessageDialog(null,"Sorry没有此信息!","提示",JOptionPane.ERROR_MESSAGE);
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,"连接失败!","提示",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            else if(ae.getSource()==bSearch && jrbTerminus.isSelected()){
                int i=0;
                Connection conn;
                Statement stat;
                ResultSet rs;
                try{
                    int n=0;
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car","sa","512512");
                    stat=conn.createStatement();
                    rs=stat.executeQuery("select TrainNumber,OriginStation,TerminalStation,TicketPrice,DepartureTime,TicketsLeft from TrainNumberTable " +
                            "where TerminalStation="+"'"+tName.getText()+"'");
                    while(rs.next()){
                        n++;
                        a[i][0]=rs.getString("TrainNumber");
                        a[i][1]=rs.getString("OriginStation");
                        a[i][2]=rs.getString("TerminalStation");
                        a[i][3]=rs.getString("TicketPrice");
                        a[i][4]=rs.getString("DepartureTime");
                        a[i][5]=rs.getString("TicketsLeft");
                        i++;
                        this.setVisible(false);
                        this.setVisible(true);
                    }
                    if(n==0)
                        JOptionPane.showMessageDialog(null,"抱歉没有此信息!","提示",JOptionPane.ERROR_MESSAGE);
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null,"连接失败!","提示",JOptionPane.ERROR_MESSAGE);
                }
            }

        }
        public static void main(String[] args) {
            new QuerTrain();
        }

    }


