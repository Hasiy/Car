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
public class DeleteUser extends JFrame implements ActionListener{
    //删除 通过
    private static final long serialVersionUID = 1L;
    JLabel lNO,lbTitle;
    JTextField tNO;
    JButton bDelete,bBack;
    JPanel panelMain,panel11,panel1,panel2,panel3,panel4;
    public DeleteUser(){
        super("用户删除");
        Image img=Toolkit.getDefaultToolkit().getImage(car.DeleteUser.class.getResource("1.png"));
        setIconImage(img);
        UIManager.put("Button.select",new Color(100,200,100));
        setLayout(null);
        panelMain=new JPanel();
        this.setContentPane(panelMain);
        panel11 = new JPanel();
        lbTitle = new JLabel(new ImageIcon(car.DeleteUser.class.getResource("ManagerLogin.jpg")));
        panel11.add(lbTitle);

        panel1=new JPanel();
        panel2=new JPanel();
        lNO=new JLabel("用户编号:");
        tNO=new JTextField(6);
        panel1.add(lNO);
        panel2.add(tNO);

        panel3=new JPanel();
        bDelete=new JButton("删除");
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
        else if(ae.getActionCommand()=="删除"){
            Connection con;
            PreparedStatement stat;
            String b="delete from UserInfo where IDnumbered="+"'"+tNO.getText()+"'"+"";
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=car","sa","512512");
                stat=con.prepareStatement(b);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"删除用户成功!","提示",JOptionPane.INFORMATION_MESSAGE);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new DeleteUser();
    }
}

