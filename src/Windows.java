/**
 * Created by zhuxiaoyao on 2017/6/25.
 */
//public class Windows {
//}
        import java.awt.*;
        import javax.swing.*;
        import java.awt.event.*;
//import java.awt.Graphics.*;
public class Windows extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
    //定义
    JButton b1,b2,b3,b4,b5;
    public Windows(){
     setTitle("酒店管理系统");

//        Image img=Toolkit.getDefaultToolkit().getImage(客房管理.controlwindows.class.getResource("2.png"));
//        setIconImage(img);

        setSize(722,449);
        setLocation(100, 150);
//         String path ="src/主背景.jpg";
//         ImageIcon background = new ImageIcon(path);
//        JLabel label = new JLabel(new ImageIcon(客房管理.controlwindows.class.getResource("主背景.jpg")));
//        label.setBounds(2, 2, this.getWidth(), this.getHeight());
        JPanel imagePanel = (JPanel) this.getContentPane();
        imagePanel.setOpaque(false);
//        this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
        setLayout(null);// 必须要有  设置按键布局
        setBounds(200,100,742,450);	 // 窗口位置 大小
        Container c = getContentPane();
        UIManager.put("Button.select",new Color(100,200,100)); //按钮按下后的颜色
        b1 = new JButton("登录"); // 创建按钮
        b2 = new JButton("查询");
        b3 = new JButton("登记");
        b4 = new JButton("关于");
        b5 = new JButton("退出");
        b1.setBounds(330, 100, 80, 40); // 设置按钮的位置与大小
        b2.setBounds(330, 165, 80, 40);
        b3.setBounds(330, 230, 80, 40);
        b4.setBounds(330, 295, 80, 40);
        b5.setBounds(330, 360, 80, 40);
        b1.setFont(new java.awt.Font("宋体", 1, 20));// 设置按钮的字体大小 颜按钮色
        b1.setBackground(Color.white);
        b2.setFont(new java.awt.Font("宋体", 1, 20));
        b2.setBackground(Color.white);
        b3.setFont(new java.awt.Font("宋体", 1, 20));
        b3.setBackground(Color.white);
        b4.setFont(new java.awt.Font("宋体", 1, 20));
        b4.setBackground(Color.white);
        b5.setFont(new java.awt.Font("宋体", 1, 20));
        b5.setBackground(Color.white);
//	     b4.setBackground(new Color(250,100,100));
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
        if(a.getActionCommand().equals("登录")){
            new About();
        }
        if(a.getActionCommand().equals("查询")){
            new About();
        }
        if(a.getActionCommand().equals("登记")){
            new About();
        }
        if(a.getSource()==b4){
            new About();
        }
        if(a.getActionCommand()=="退出"){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new Windows();
    }
}
