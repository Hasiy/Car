package car;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
/**
 * Created by zhuxiaoyao on 2017/6/27.    订票 订票后 座位数 -1  IDnumber（车票编号=用户编号+车次编号）
 */
    public class   ReserveTicket   extends JFrame implements ActionListener
    {
        private static final long serialVersionUID = 1L;
        ButtonGroup changle;
        JLabel lName,lUser;
        JTextField tName,tUser;
        JButton bBack,bSearch;
        JPanel panel;
        JTable table;
        Container container;
        Object a[][];
        Object colname[]={"车次编号","座位号","起点站","终点站","票价","发车时间","用户名","车票编号"};
        public  ReserveTicket () {
            super("定购车票");
            Image img=Toolkit.getDefaultToolkit().getImage(car.QuerPurchasedTicket.class.getResource("1.png"));
            setIconImage(img);
            a=new Object[50][8];
            table=new JTable(a,colname);
            setSize(50,50);
            setVisible(true);
            lName=new JLabel("输入要购买的车次：");
            tName=new JTextField(10);
            lUser=new JLabel("输入用户名：");
            tUser=new JTextField(10);
            bBack=new JButton("返回");
            bBack.setFont(new java.awt.Font("楷体", 1, 20));// 设置按钮的字体大小 颜按钮色
            bBack.setBackground(Color.white);
            bBack.setBorder(BorderFactory.createRaisedBevelBorder());
            bBack.addActionListener(this);
            bSearch=new JButton("定购");
            bSearch.setFont(new java.awt.Font("楷体", 1, 20));// 设置按钮的字体大小 颜按钮色
            bSearch.setBackground(Color.white);
            bSearch.setBorder(BorderFactory.createRaisedBevelBorder());
            bSearch.addActionListener(this);
            changle=new ButtonGroup();
            panel=new JPanel();
            panel.add(lUser);
            panel.add(tUser);
            panel.add(lName);
            panel.add(tName);
            panel.add(bSearch);
            panel.add(bBack);
            container=getContentPane();
            container.add(panel,BorderLayout.SOUTH);
            container.add(new JScrollPane(table),BorderLayout.CENTER);
            setBounds(400,200,720,400);
        }

        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==bBack){
                dispose();
            }
            else
            if(ae.getSource()==bSearch){
                if(tName.getText().equals("")||tUser.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"请入车次编号/用户名","提示",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    int i,z,x;
                    Connection conn;
                    Statement stat,stat1,stat2,stat3,stat4;
                    ResultSet rst,rs1,rs2;
                    try{
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car","sa","512512");
                        System.out.println("已经连接到数据库...");
                        stat=conn.createStatement();
                        stat1=conn.createStatement();
                        stat2=conn.createStatement();
                        stat3=conn.createStatement();
                        stat4=conn.createStatement();
                        rs1=stat1.executeQuery("select IDnumbered,Name from UserInfo "
                                + "where Name="+"'"+tUser.getText()+"'");
//                        System.out.println("已经连接UserInfo...");
                            System.out.println(rs1.next());
                            String strIDnumbered=rs1.getString("IDnumbered");
                            String strName=rs1.getString("Name");
//                            System.out.println("ID:"+ strIDnumbered);
//                            System.out.println("Name："+ strName);
                            String strTrainNumber=tName.getText();
                            String strIDNumber=strIDnumbered+strTrainNumber;
//                            System.out.println("IDNumber："+ strIDNumber);      //计算车票号
                        rs2=stat2.executeQuery("select OriginStation,TerminalStation,TicketPrice,DepartureTime,TicketsLeft,TicketAll from TrainNumberTable "
                                + "where TrainNumber="+"'"+tName.getText()+"'");
                        System.out.println("已经连接到TrainNumberTable...");
                            System.out.println(rs2.next());
                            int strTicketsLeft=rs2.getInt("TicketsLeft");
                            int strTicketAll=rs2.getInt("TicketAll");
//                            System.out.println("TicketsLeft:"+ strTicketsLeft);
//                            System.out.println("TicketAll："+ strTicketAll);
                            int strSetNumber=strTicketAll-strTicketsLeft;
//                            System.out.println("SetNumber："+strSetNumber);//计算座位号
                            String strOriginStation=rs2.getString("OriginStation");
                            String strTerminalStation=rs2.getString("TerminalStation");
                            String strTicketPrice=rs2.getString("TicketPrice");
                            String strDepartureTime=rs2.getString("DepartureTime");
//                            System.out.println("OriginStation: "+ strOriginStation);
//                            System.out.println("TerminalStation："+ strTerminalStation);
//                            System.out.println("TicketPrice: "+ strTicketPrice);
//                            System.out.println("DepartureTime: "+ strDepartureTime);
                        String b1;
                        strTicketsLeft=strTicketsLeft-1;
                        System.out.println("剩余车票："+ strTicketsLeft);
                        if(strTicketsLeft<1){
                            JOptionPane.showMessageDialog(null,"购买车票失败!","提示",JOptionPane.ERROR_MESSAGE);
                        }else {
                            String a1,a2,a3,a4,a5,a6,a7,a8;
                            a1="'"+strTrainNumber+"'";
                            a2="'"+strSetNumber+"'";
                            a3="'"+strOriginStation+"'";
                            a4="'"+strTerminalStation+"'";
                            a5="'"+strTicketPrice+"'";
                            a6="'"+strDepartureTime+"'";
                            a7="'"+strName+"'";
                            a8="'"+strIDNumber+"'";
                            String ins ="insert into TicketInfo " + "VALUES ("+a1+","+a2+","+a3+","+a4+","+a5+","+a6+","+a7+","+a8+")";
                            System.out.println("正在向TicketInfo添加信息...");
                            z=stat3.executeUpdate(ins);
                            System.out.println("添加："+ z);

                            b1 = "'" + strTicketsLeft + "'";
                            String up = "update TrainNumberTable SET TicketsLeft =" + b1 + " WHERE TrainNumber=" + "'" + tName.getText() + "'";
                            x = stat4.executeUpdate(up);
                            System.out.println("更新：" + x); // 购票后 座位数 -1

                            rst=stat.executeQuery("select TrainNumber,SetNumber,OriginStation,TerminalStation,TicketPrice,DepartureTime,UserName,IDNumber from TicketInfo " +
                                    "where IDNumber="+"'"+strIDNumber+"'");
                            System.out.println("已经添加到TicketInfo...");
                            i=0;
                            while(rst.next()){
                                a[i][0]=rst.getString("TrainNumber");
                                a[i][1]=rst.getString("SetNumber");
                                a[i][2]=rst.getString("OriginStation");
                                a[i][3]=rst.getString("TerminalStation");
                                a[i][4]=rst.getString("TicketPrice");
                                a[i][5]=rst.getString("DepartureTime");
                                a[i][6]=rst.getString("UserName");
                                a[i][7]=rst.getString("IDNumber");
                                i++;
                                this.setVisible(false);
                                this.setVisible(true);
                                 }// 购票后 显示已购车票
                            new PayWindows();
                         }
                    }
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null,"连接失败!","提示",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        }
        public static void main(String[] args) {
            new  ReserveTicket ();
        }

    }


