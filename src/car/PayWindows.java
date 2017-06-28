package car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    /**
     * Created by zhuxiaoyao on 2017/6/26.
     */
    public class PayWindows extends JFrame implements ActionListener {
        private static final long serialVersionUID = 1L;
        //定义
        JButton b1,b2,b3,b4,b5;
        public PayWindows(){
            setTitle("Auto advance ticketing system");
            Image img=Toolkit.getDefaultToolkit().getImage(car.PayWindows.class.getResource("1.png"));
            setIconImage(img);
            setSize(700,470);
            setLocation(100,150);
            JLabel label = new JLabel(new ImageIcon(car.PayWindows.class.getResource("PayBackground.jpg")));
            label.setBounds(2,0,this.getWidth(), this.getHeight());
            JPanel imagePanel = (JPanel) this.getContentPane();
            imagePanel.setOpaque(false);
            this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
            setLayout(null);// 必须要有  设置按键布局
            setBounds(400,200,720,510);	 // 窗口位置 大小
            Container c = getContentPane();
            UIManager.put("Button.select",new Color(44, 162, 200)); //按钮按下后的颜色
            b1 = new JButton("确认付款"); // 创建按钮
            b2 = new JButton("取消付款");
            b1.setBounds(290, 180, 120, 60); // 设置按钮的位置与大小
            b2.setBounds(290, 280, 120, 60);
            b1.setFont(new java.awt.Font("楷体", 1, 20));// 设置按钮的字体大小 颜按钮色
            b1.setBackground(Color.white);
            b2.setFont(new java.awt.Font("楷体", 1, 20));
            b2.setBackground(Color.white);
            b1.setBorder(BorderFactory.createRaisedBevelBorder()); //设置按钮样式 凸
            b2.setBorder(BorderFactory.createRaisedBevelBorder());
            c.add(b1);
            c.add(b2);
            b1.addActionListener(this);//注册监听
            b2.addActionListener(this);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        public void actionPerformed(ActionEvent a){    // 按钮事件监听
            if(a.getActionCommand()=="确认付款"){
                dispose();
            }
            if(a.getActionCommand()=="取消付款"){
                dispose();
            }
        }
        public static void main(String[] args) {
            new PayWindows();
        }
    }




