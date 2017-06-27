package car;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Created by zhuxiaoyao on 2017/6/26.
 */
public class UserWindows extends JFrame implements ActionListener{
        private static final long serialVersionUID = 1L;
        //定义
        JButton b1,b2,b3,b4,b5;
        public UserWindows(){
            setTitle("Auto advance ticketing system");
            Image img=Toolkit.getDefaultToolkit().getImage(car.UserWindows.class.getResource("1.png"));
            setIconImage(img);
            setSize(700,470);
            setLocation(100,150);
            JLabel label = new JLabel(new ImageIcon(car.UserWindows.class.getResource("UserBackground.jpg")));
            label.setBounds(2,0,this.getWidth(), this.getHeight());
            JPanel imagePanel = (JPanel) this.getContentPane();
            imagePanel.setOpaque(false);
            this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
            setLayout(null);// 必须要有  设置按键布局
            setBounds(200,100,720,510);	 // 窗口位置 大小
            Container c = getContentPane();
            UIManager.put("Button.select",new Color(44, 162, 200)); //按钮按下后的颜色
            b1 = new JButton("查询车票"); // 创建按钮
            b2 = new JButton("订票");
            b3 = new JButton("查看已购车票");
            b4 = new JButton("退票");
            b5 = new JButton("退出");
            b1.setBounds(290, 120, 150, 40); // 设置按钮的位置与大小
            b2.setBounds(290, 180, 150, 40);
            b3.setBounds(290, 240, 150, 40);
            b4.setBounds(290, 300, 150, 40);
            b5.setBounds(290, 360, 150, 40);
            b1.setFont(new java.awt.Font("楷体", 1, 20));// 设置按钮的字体大小 颜按钮色
            b1.setBackground(Color.white);
            b2.setFont(new java.awt.Font("楷体", 1, 20));
            b2.setBackground(Color.white);
            b3.setFont(new java.awt.Font("楷体", 1, 20));
            b3.setBackground(Color.white);
            b4.setFont(new java.awt.Font("楷体", 1, 20));
            b4.setBackground(Color.white);
            b5.setFont(new java.awt.Font("楷体", 1, 20));
            b5.setBackground(Color.white);
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
            if(a.getActionCommand().equals("查询车票")){
                new QuerTrain();
            }
            if(a.getActionCommand().equals("订票")){
                new About();
            }
            if(a.getActionCommand().equals("查看已购车票")){
                new About();
            }
            if(a.getActionCommand().equals("退票")){
                new About();
            }
            if(a.getActionCommand()=="退出"){
                System.exit(0);
            }
        }
        public static void main(String[] args) {
            new UserWindows();
        }
    }


