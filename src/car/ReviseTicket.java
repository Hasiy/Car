package car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by zhuxiaoyao on 2017/6/27. TODO 车票修改
 */
    public class ReviseTicket extends JFrame implements ActionListener {//添加 通过
        private static final long serialVersionUID = 1L;
        JLabel lTrainNumber,lOriginStation,lTerminalStation,lTicketPrice,lDepartureTime,lTicketsLeft;
        JTextField tTrainNumber,tOriginStation,tTerminalStation,tTicketPrice,tDepartureTime,tTicketsLeft;
        JButton bAdd,bBack;
        JPanel panelMain,panel1,panel2,panel3,panel4,panel5,panel6,panel7,panel8;
        public ReviseTicket(){
            super("ReviseTicket");
            Image img=Toolkit.getDefaultToolkit().getImage(car.AddTicket.class.getResource("1.png"));
            setIconImage(img);
            setBounds(200,100,400,400);// 窗口位置 大小
            UIManager.put("Button.select",new Color(44, 162, 200)); //按钮按下后的颜色
            panelMain=new JPanel();
            JPanel panelMain=new JPanel(new GridLayout(8,1));
            this.setContentPane(panelMain);
            lTrainNumber=new JLabel("车   次 ： ");
            lTrainNumber.setFont(new Font("楷体",0, 20));
            lOriginStation=new JLabel("起 点 站： ");
            lOriginStation.setFont(new Font("楷体",0, 20));
            lTerminalStation=new JLabel("终 点 站： ");
            lTerminalStation.setFont(new Font("楷体",0, 20));
            lTicketPrice=new JLabel("票  价 ：  ");
            lTicketPrice.setFont(new Font("楷体",0, 20));
            lDepartureTime=new JLabel("发车时间 : ");
            lDepartureTime.setFont(new Font("楷体",0, 20));
            lTicketsLeft=new JLabel("余  票 ：  ");
            lTicketsLeft.setFont(new Font("楷体",0, 20));
            tTrainNumber=new JTextField(10);
            tOriginStation=new JTextField(10);
            tTerminalStation=new JTextField(10);
            tTicketPrice=new JTextField(10);
            tDepartureTime=new JTextField(10);
            tTicketsLeft=new JTextField(10);
            panel1=new JPanel();
            panel1.add(lTrainNumber);panel1.add(tTrainNumber);
            panel2=new JPanel();
            panel2.add(lOriginStation);panel2.add(tOriginStation);
            panel3=new JPanel();
            panel3.add(lTerminalStation);panel3.add(tTerminalStation);
            panel4=new JPanel();
            panel4.add(lTicketPrice);panel4.add(tTicketPrice);
            panel5=new JPanel();
            panel5.add(lDepartureTime);panel5.add(tDepartureTime);
            panel6=new JPanel();
            panel6.add(lTicketsLeft);panel6.add(tTicketsLeft);
            bAdd=new JButton("修改");
            bAdd.setFont(new java.awt.Font("楷体", 0, 20));// 设置按钮的字体大小 颜按钮色
            bAdd.setBackground(new Color(255, 255, 255));
            bAdd.setBorder(BorderFactory.createRaisedBevelBorder());
            bAdd.addActionListener(this);
            bBack=new JButton("返回");
            bBack.setFont(new java.awt.Font("楷体", 0, 20));// 设置按钮的字体大小 颜按钮色
            bBack.setBackground(new Color(255, 255, 255));
            bBack.setBorder(BorderFactory.createRaisedBevelBorder());
            bBack.addActionListener(this);
            panel7=new JPanel();
            panel7.add(bAdd);
            panel8=new JPanel();
            panel8.add(bBack);
            panelMain.add(panel1);
            panelMain.add(panel2);
            panelMain.add(panel3);
            panelMain.add(panel4);
            panelMain.add(panel5);
            panelMain.add(panel6);
            panelMain.add(panel7);
            panelMain.add(panel8);
            setVisible(true);
        }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==bBack){
                dispose();
            }
            else if(ae.getSource()==bAdd){
                if(tTrainNumber.getText().equals("") || tOriginStation.getText().equals("") || tTerminalStation.getText().equals("")||tTicketPrice.getText().equals("")||tDepartureTime.getText().equals("")||tTicketsLeft.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"添加信息不能为空!","提示",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    String a1,a2,a3,a4,a5,a6;
                    int z;
                    a1="'"+tTrainNumber.getText().trim()+"'";
                    a2="'"+tOriginStation.getText().trim()+"'";
                    a3="'"+tTerminalStation.getText().trim()+"'";
                    a4="'"+tTicketPrice.getText().trim()+"'";
                    a5="'"+tDepartureTime.getText().trim()+"'";
                    a6="'"+tTicketsLeft.getText().trim()+"'";
                    String d="insert into TrainNumberTable (TrainNumber,OriginStation,TerminalStation,TicketPrice,DepartureTime,TicketsLeft) VALUES ("+a1+","+a2+","+a3+","+a4+","+a5+","+a6+")";
                    Connection connn;
                    PreparedStatement stat;
                    try{
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        connn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car","sa","512512");
                        stat=connn.prepareStatement(d);
                        z=stat.executeUpdate();
                        if(z<1){
                            JOptionPane.showMessageDialog(null,"添加车票失败!","提示",JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"添加车票成功!","提示",JOptionPane.INFORMATION_MESSAGE);
                        }
                        connn.close();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        public static void main(String[] args) {
            new ReviseTicket();
        }
    }



