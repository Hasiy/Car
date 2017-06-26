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
    JButton b1,b2,b3,b4;
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
        b1 = new JButton("用户管理"); // 创建按钮
        b2 = new JButton("站点管理");
        b3 = new JButton("车次管理");
        b4 = new JButton("退出");
        b1.setBounds(310, 150, 120, 40); // 设置按钮的位置与大小
        b2.setBounds(310, 210, 120, 40);
        b3.setBounds(310, 270, 120, 40);
        b4.setBounds(310, 330, 120, 40);
        b1.setFont(new java.awt.Font("楷体", 1, 20));// 设置按钮的字体大小 颜按钮色
        b1.setBackground(Color.white);
        b2.setFont(new java.awt.Font("楷体", 1, 20));
        b2.setBackground(Color.white);
        b3.setFont(new java.awt.Font("楷体", 1, 20));
        b3.setBackground(Color.white);
        b4.setFont(new java.awt.Font("楷体", 1, 20));
        b4.setBackground(Color.white);
        b1.setBorder(BorderFactory.createRaisedBevelBorder()); //设置按钮样式 凸
        b2.setBorder(BorderFactory.createRaisedBevelBorder());
        b3.setBorder(BorderFactory.createRaisedBevelBorder());
        b4.setBorder(BorderFactory.createRaisedBevelBorder());
        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(b4);
        b1.addActionListener(this);//注册监听
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent a){    // 按钮事件监听
        if(a.getActionCommand().equals("用户管理")){
            new UserManagement();
        }
        if(a.getActionCommand().equals("车次管理")){
            new SiteManagement();
        }
        if(a.getActionCommand().equals("车次管理")){
            new SiteManagement();
        }
        if(a.getActionCommand()=="退出"){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new ManagerWindows();
    }
}


