package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import action.actionImp;
import entity.Vip;

public class Chaxunvip extends JFrame implements ActionListener{
	 JPanel main = new JPanel();
	  
	 private actionImp action;
	   //创建标签
	   JLabel lbl = new JLabel("请输入您的选择");
	   JLabel lbl1 = new JLabel("会员身份证号： ");
	   JLabel lbl2 = new JLabel("会员姓名：");
	   JLabel lbl3 = new JLabel("会员编号：");
	   JLabel lbl4 = new JLabel("会员电话号码：");

	   //创建文本框
	   private JTextField jf = new JTextField();
	   private JTextField jp1 = new JTextField();
	   private JTextField jp2 = new JTextField();
	   private JTextField jp3 = new JTextField();
	   
	   //创建按钮
	   private JButton jxiu = new JButton("查询");
	   private JButton cancel = new JButton("取消");	   
	   
	   public Chaxunvip() {
		   init();
	   }

	   //设置字体大小
	   public void setfont(JLabel j){
		   Font font=new Font("Monospaced",Font.BOLD,15);
		   j.setFont(font);
	   }
	   
	   //初始化窗体
	   private void init() {
		   Font font=new Font("Monospaced",Font.BOLD,20);//设置字体格式和大小
		   lbl.setForeground(Color.BLACK);//设置前景色
		   lbl.setFont(font);
		   //设置窗体为空布局
		   this.setLayout(null);
		   this.setSize(800,600);
		   this.setTitle("管理员界面");

		//点了x之后关闭窗体
		   this.setDefaultCloseOperation(Chaxunvip.EXIT_ON_CLOSE);
		   //在中央显示窗体
		   this.setLocationRelativeTo(null);
		   //不允许其改变窗体的大小
		   this.setResizable(false);
		   
		   main_xiugai();
         this.setVisible(true);
         //显示面板
         main.setVisible(true);
	}
	   
	   private void main_xiugai() {
		 setfont(lbl1);
		 setfont(lbl2);
		 setfont(lbl3);
		 setfont(lbl4);
		 lbl1.setBounds(150,13,150,50);
		 lbl2.setBounds(150,100,150,50);
		 lbl3.setBounds(150,200,150,50);
		 lbl4.setBounds(150,300,150,50);
		 
		 
		 jf.setBounds(300,25,250,30);
		 jp1.setBounds(300,100,250,30);
		 jp2.setBounds(300,200,250,30);
		 jp3.setBounds(300, 300, 250, 30);
		 
		 
		 
		 jxiu.setBounds(600,25, 100,40);
		 cancel.setBounds(500,400,100,40);
		 jxiu.addActionListener(this);
		 cancel.addActionListener(this);
       
		 main.add(jp3);
		 main.add(lbl1);
		 main.add(lbl2);
		 main.add(lbl3);
		 main.add(lbl4);
		 main.add(cancel);
		 main.add(jxiu);
		 main.add(jp2);
		 main.add(jp1);
		 main.add(jf);
		 
		 main.setSize(800,500);
		 main.setLayout(null);
		 this.add(main);
	}


	public void actionPerformed(ActionEvent e) {
	    if (e.getSource().equals(jxiu)) {
			action = new actionImp();
			String card = jf.getText();
			Vip v = new Vip();
			v = action.queryvip(card);
			jp1.setText(String.valueOf(v.getVname()));
			jp2.setText(String.valueOf(v.getVno()));
			jp3.setText(String.valueOf(v.getTel()));		
		}if (e.getSource().equals(cancel)) {
			new EmpVip();
			dispose();
		}
		
	}
	
	
	public static void main(String[] args) {
		Chaxunvip c = new Chaxunvip();
	}
}
