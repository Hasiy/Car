package car;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by zhuxiaoyao on 2017/6/27.  用户修改
 */
    public class ReviseUser extends JFrame implements ActionListener {
        private static final long serialVersionUID = 1L;
        JLabel lNo,lName,lId,lPassword,lMobile;
        JTextField tNo,tName,tId,tPassword,tMobile;
        JButton bAdd,bBack;
        JPanel panelMain,panel1,panel2,panel3,panel4,panel5,panel6,panel7;
        public ReviseUser(){
            super("ReviseUser");
            Image img=Toolkit.getDefaultToolkit().getImage(car.AddUser.class.getResource("1.png"));
            setIconImage(img);
            setBounds(200,100,400,400);// 窗口位置 大小
            UIManager.put("Button.select",new Color(44, 162, 200)); //按钮按下后的颜色
            panelMain=new JPanel();
            JPanel panelMain=new JPanel(new GridLayout(7,1));
            this.setContentPane(panelMain);
            lNo=new JLabel("编        号：");
            lNo.setFont(new Font("楷体",0, 20));
            lName=new JLabel("姓        名：");
            lName.setFont(new Font("楷体",0, 20));
            lPassword=new JLabel("密        码：");
            lPassword.setFont(new Font("楷体",0, 20));
            lId=new JLabel("身 份 证 号 ：");
            lId.setFont(new Font("楷体",0, 20));
            lMobile=new JLabel("手   机   号: ");
            lMobile.setFont(new Font("楷体",0, 20));
            tNo=new JTextField(10);
            tName=new JTextField(10);
            tId=new JTextField(10);
            tPassword=new JTextField(10);
            tMobile=new JTextField(10);
            panel1=new JPanel();
            panel1.add(lNo);panel1.add(tNo);
            panel2=new JPanel();
            panel2.add(lName);panel2.add(tName);
            panel3=new JPanel();
            panel3.add(lPassword);panel3.add(tPassword);
            panel4=new JPanel();
            panel4.add(lId);panel4.add(tId);
            panel5=new JPanel();
            panel5.add(lMobile);panel5.add(tMobile);
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
            panel6=new JPanel();
            panel6.add(bAdd);
            panel7=new JPanel();
            panel7.add(bBack);
            panelMain.add(panel1);
            panelMain.add(panel2);
            panelMain.add(panel3);
            panelMain.add(panel4);
            panelMain.add(panel5);
            panelMain.add(panel6);
            panelMain.add(panel7);
            setVisible(true);

        }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==bBack){
                dispose();
            }
            else if(ae.getSource()==bAdd){
                if(tNo.getText().equals("") || tName.getText().equals("")||tId.getText().equals("")||tPassword.getText().equals("")||tMobile.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"修改信息不能为空!","提示",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    String a1,a2,a3,a4,a5,a6="";
                    char temp = 0;
                    int r,z,i;
                    a1="'"+tNo.getText().trim()+"'";
                    a2="'"+tName.getText().trim()+"'";
                    a3=tPassword.getText().trim();
                    a4="'"+tId.getText().trim()+"'";
                    a5="'"+tMobile.getText().trim()+"'";

                    for(i=1;i<a3.length();i++) {
                        if((a3.charAt(i-1) > 32 && a3.charAt(i-1) < 107) )
                            temp=(char) (a3.charAt(i-1) + 20);
                        else if((a3.charAt(i-1) > 106 && a3.charAt(i-1) < 127))
                            temp=(char) (a3.charAt(i-1) -74 );
                        a6+=temp;
                    }
                    a6="'"+a6+"'";// 密码的加密
                    String d="delete from UserInfo where IDnumbered="+"'"+tNo.getText()+"'"+"";
                    String b="insert into UserInfo(IDnumbered,Name,Password,IDcard,Mobile) VALUES ("+a1+","+a2+","+a6+","+a4+","+a5+")";
                    Connection conn;
                    PreparedStatement stat1,stat2;
                    try{
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        conn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car","sa","512512");
                        stat1=conn.prepareStatement(d);
                        r=stat1.executeUpdate();
                        stat2=conn.prepareStatement(b);
                        z=stat2.executeUpdate();
                        if(r<1||z<1){
                            JOptionPane.showMessageDialog(null,"修改用户失败!","提示",JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"修改用户成功!","提示",JOptionPane.INFORMATION_MESSAGE);
                        }
                        conn.close();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        public static void main(String[] args) {
            new ReviseUser();
        }
    }


