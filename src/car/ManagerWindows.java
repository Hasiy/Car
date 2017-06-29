package car;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Created by zhuxiaoyao on 2017/6/26.
 */
public class ManagerWindows extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
    //定义
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    public ManagerWindows(){
        setTitle("Auto advance ticketing system");
        Image img=Toolkit.getDefaultToolkit().getImage(car.ManagerWindows.class.getResource("1.png"));
        setIconImage(img);

        setSize(700,470);
        setLocation(100,150);
        JLabel label = new JLabel(new ImageIcon(car.ManagerWindows.class.getResource("ManagerBackground.jpg")));
        label.setBounds(2,0,this.getWidth(), this.getHeight());
        JPanel imagePanel = (JPanel) this.getContentPane();
        imagePanel.setOpaque(false);
        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        setLayout(null);// 必须要有  设置按键布局
        setBounds(200,100,720,510);	 // 窗口位置 大小
        Container c = getContentPane();
        UIManager.put("Button.select",new Color(44, 162, 200)); //按钮按下后的颜色
        b1 = new JButton("用户查询"); // 创建按钮
        b2 = new JButton("用户添加");
        b3 = new JButton("用户修改");
        b4 = new JButton("用户删除");
        b5 = new JButton("车次查询");
        b6 = new JButton("车次添加");
        b7 = new JButton("车次修改");
        b8 = new JButton("车次删除");
        b9 = new JButton("退出");
        b1.setBounds(150, 120, 120, 40); // 设置按钮的位置与大小
        b2.setBounds(150, 180, 120, 40);
        b3.setBounds(150, 240, 120, 40);
        b4.setBounds(150, 300, 120, 40);
        b5.setBounds(430, 120, 120, 40);
        b6.setBounds(430, 180, 120, 40);
        b7.setBounds(430, 240, 120, 40);
        b8.setBounds(430, 300, 120, 40);
        b9.setBounds(290, 380, 120, 40);
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
        b6.setFont(new java.awt.Font("楷体", 1, 20));
        b6.setBackground(Color.white);
        b7.setFont(new java.awt.Font("楷体", 1, 20));
        b7.setBackground(Color.white);
        b8.setFont(new java.awt.Font("楷体", 1, 20));
        b8.setBackground(Color.white);
        b9.setFont(new java.awt.Font("楷体", 1, 20));
        b9.setBackground(Color.white);
        b1.setBorder(BorderFactory.createRaisedBevelBorder()); //设置按钮样式 凸
        b2.setBorder(BorderFactory.createRaisedBevelBorder());
        b3.setBorder(BorderFactory.createRaisedBevelBorder());
        b4.setBorder(BorderFactory.createRaisedBevelBorder());
        b5.setBorder(BorderFactory.createRaisedBevelBorder());
        b6.setBorder(BorderFactory.createRaisedBevelBorder());
        b7.setBorder(BorderFactory.createRaisedBevelBorder());
        b8.setBorder(BorderFactory.createRaisedBevelBorder());
        b9.setBorder(BorderFactory.createRaisedBevelBorder());
        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(b4);
        c.add(b5);
        c.add(b6);
        c.add(b7);
        c.add(b8);
        c.add(b9);
        b1.addActionListener(this);//注册监听
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent a){    // 按钮事件监听
        if(a.getActionCommand().equals("用户查询")){
            new QueryUser();
        }
        if(a.getActionCommand().equals("用户添加")){
            new AddUser();
        }
        if(a.getActionCommand().equals("用户修改")){
            new ReviseUser();
        }
        if(a.getActionCommand().equals("用户删除")){
            new DeleteUser();
        }
        if(a.getActionCommand().equals("车次查询")){
            new QueryTicket();
        }
        if(a.getActionCommand().equals("车次添加")){
            new AddTicket();
        }
        if(a.getActionCommand().equals("车次修改")){
            new ReviseTicket();
        }
        if(a.getActionCommand().equals("车次删除")){
            new DeleteTicket();
        }
        if(a.getActionCommand()=="退出"){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new ManagerWindows();
    }
}


