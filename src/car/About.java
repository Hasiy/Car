package car;

/**
 * Created by zhuxiaoyao on 2017/6/25.
 */
        import java.awt.*;
        import javax.swing.*;
        import java.awt.event.*;
public class About extends JFrame implements ActionListener
{
    //  关于
    private static final long serialVersionUID = 1L;
    JLabel l_name,l_edition,l_text,l_warning,l_contact;
    JButton b_yes;
    JPanel pan1,pan2,pan3,pan4,pan5,mainpan;
    public About(){
        super("About Auto advance ticketing system");

        Image img=Toolkit.getDefaultToolkit().getImage(car.About.class.getResource("1.png"));
        setIconImage(img);
        mainpan=new JPanel();
        this.getContentPane().add(mainpan);

        mainpan.setLayout(new GridLayout(5,1));
        l_name=new JLabel("Name:Auto advance ticketing system");
        l_edition=new JLabel("Ver:2.3.3");
        l_text=new JLabel("Build id: 20170625-2352");
        l_warning=new JLabel("Powered by Hasiy");
        l_contact=new JLabel("2017 Hasiy Inc. ");
        b_yes=new JButton("确定");
        b_yes.setFont(new java.awt.Font("宋体", 1, 15));// 设置按钮的字体大小 颜按钮色
        b_yes.setBackground(Color.white);
        b_yes.setBorder(BorderFactory.createRaisedBevelBorder());
        b_yes.addActionListener(this);
        pan1=new JPanel();
        pan2=new JPanel();
        pan3=new JPanel();
        pan4=new JPanel();
        pan5=new JPanel();
        pan1.add(l_name);
        pan2.add(l_edition);
        pan3.add(l_text);
        pan4.add(l_warning);
        pan4.add(b_yes);
        pan5.add(l_contact);
        mainpan.add(pan1);
        mainpan.add(pan2);
        mainpan.add(pan3);
        mainpan.add(pan4);
        mainpan.add(pan5);
        setBounds(400,200,380,220);
        setResizable(false);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        //确定键
        if (ae.getSource()==b_yes)	{
            this.dispose();
        }
    }
    public static void main(String[] args){
        new About();
    }
}
