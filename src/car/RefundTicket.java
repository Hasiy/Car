package car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 * Created by zhuxiaoyao on 2017/6/27.   退票  删除用户选择的票号 todo 退票后座位数+1
 */
    public class RefundTicket extends JFrame implements ActionListener {
        //删除 通过
        private static final long serialVersionUID = 1L;
        JLabel lNO,lbTitle;
        JTextField tNO;
        JButton bDelete,bBack;
        JPanel panelMain,panel11,panel1,panel2,panel3,panel4;
        public RefundTicket(){
            super("车票退订");
            Image img=Toolkit.getDefaultToolkit().getImage(car.RefundTicket.class.getResource("1.png"));
            setIconImage(img);
            UIManager.put("Button.select",new Color(100,200,100));
            setLayout(null);
            panelMain=new JPanel();
            this.setContentPane(panelMain);
            panel11 = new JPanel();
            lbTitle = new JLabel(new ImageIcon(car.DeleteTicket.class.getResource("UserLogin.jpg")));
            panel11.add(lbTitle);

            panel1=new JPanel();
            panel2=new JPanel();
            lNO=new JLabel("车票编号:");
            tNO=new JTextField(6);
            panel1.add(lNO);
            panel2.add(tNO);

            panel3=new JPanel();
            bDelete=new JButton("退订");
            bDelete.setFont(new java.awt.Font("楷体", 1, 20));// 设置按钮的字体大小 颜按钮色
            bDelete.setBackground(Color.white);
            bDelete.setBorder(BorderFactory.createRaisedBevelBorder());

            panel4=new JPanel();
            bBack=new JButton("返回");
            bBack.setFont(new java.awt.Font("楷体", 1, 20));// 设置按钮的字体大小 颜按钮色
            bBack.setBackground(Color.white);
            bBack.setBorder(BorderFactory.createRaisedBevelBorder());

            panel3.add(bDelete);
            panel4.add(bBack);

            panelMain.add(panel11);
            panelMain.add(panel1);
            panelMain.add(panel2);
            panelMain.add(panel3);
            panelMain.add(panel4);
            setBounds(500,300,430,340);
            bDelete.addActionListener(this);
            bBack.addActionListener(this);
            setVisible(true);
            setResizable(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        public void actionPerformed(ActionEvent ae){
            if(ae.getActionCommand()=="返回"){
                this.dispose();
            }
            else if(ae.getActionCommand()=="退订"){
                Connection con;
                PreparedStatement stat;
                String b="delete from TicketInfo where IDNumber="+"'"+tNO.getText()+"'"+"";
                try{
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car","sa","512512");



                    stat=con.prepareStatement(b);
                    stat.executeUpdate();
                    JOptionPane.showMessageDialog(null,"退订车票成功!退款稍后到达您账户","提示",JOptionPane.INFORMATION_MESSAGE);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        public static void main(String[] args) {
            new car.RefundTicket();
        }
    }




