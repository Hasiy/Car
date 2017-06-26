package car;
import javax.swing.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.*;
/**
 * Created by zhuxiaoyao on 2017/6/25.
 */
public class Login extends JFrame implements ActionListener{
        private static final long serialVersionUID = 1L;
        //定义
        JButton b1,b2,b3,b4,b5;
        public Login(){
            setTitle("Auto advance ticketing system");
            Image img=Toolkit.getDefaultToolkit().getImage(car.Login.class.getResource("1.png"));
            setIconImage(img);
            setSize(420,540);
            setLocation(100,150);
            JLabel label = new JLabel(new ImageIcon(car.Login.class.getResource("Login.jpg")));
            label.setBounds(-8,-5,this.getWidth(), this.getHeight());
            JPanel imagePanel = (JPanel) this.getContentPane();
            imagePanel.setOpaque(false);
            this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
            setLayout(null);// 必须要有  设置按键布局
            setBounds(200,100,420,550);	 // 窗口位置 大小
            Container c = getContentPane();
            UIManager.put("Button.select",new Color(100,200,100)); //按钮按下后的颜色
            b1 = new JButton("管理员"); // 创建按钮
            b2 = new JButton("用户");
            b3 = new JButton("注册");
            b4 = new JButton("关于");
            b5 = new JButton("退出");
            b1.setBounds(160, 190, 100, 40); // 设置按钮的位置与大小
            b2.setBounds(160, 250, 100, 40);
            b3.setBounds(160, 310, 100, 40);
            b4.setBounds(160, 370, 100, 40);
            b5.setBounds(160, 430, 100, 40);
            b1.setFont(new java.awt.Font("楷体", 1, 20));// 设置按钮的字体大小 颜按钮色
            b1.setBackground(new Color(146, 163, 255));
            b2.setFont(new java.awt.Font("楷体", 1, 20));
            b2.setBackground(new Color(146, 163, 255));
            b3.setFont(new java.awt.Font("楷体", 1, 20));
            b3.setBackground(new Color(146, 163, 255));
            b4.setFont(new java.awt.Font("楷体", 1, 20));
            b4.setBackground(new Color(146, 163, 255));
            b5.setFont(new java.awt.Font("楷体", 1, 20));
            b5.setBackground(new Color(146, 163, 255));
            b1.setBorder(BorderFactory.createRaisedBevelBorder()); //设置按钮样式 凸
            b2.setBorder(BorderFactory.createRaisedBevelBorder());
            b3.setBorder(BorderFactory.createRaisedBevelBorder());
            b4.setBorder(BorderFactory.createRaisedBevelBorder());
            b5.setBorder(BorderFactory.createRaisedBevelBorder());
            c.add(b1);
            c.add(b2);
            c.add(b3);
            c.add(b4);
            c.add(b5);
            b1.addActionListener(this);//注册监听
            b2.addActionListener(this);
            b3.addActionListener(this);
            b4.addActionListener(this);
            b5.addActionListener(this);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        public void actionPerformed(ActionEvent a){    // 按钮事件监听
            if(a.getActionCommand().equals("管理员")){
                new ManagerLogin();
            }
            if(a.getActionCommand().equals("用户")){
                new UserLogin();
            }
            if(a.getActionCommand().equals("注册")){
                new AddUser();
            }
            if(a.getActionCommand().equals("关于")){
                new About();
            }
            if(a.getActionCommand()=="退出"){
                System.exit(0);
            }
        }
        public static void main(String[] args) {
            new Login();
        }
    }


