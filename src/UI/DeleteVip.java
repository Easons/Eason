package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Util.util;
import action.actionImp;

public class DeleteVip extends JFrame implements ActionListener{ 

	   actionImp action;
	

    //创建一个面板	
	   JPanel xiugai = new JPanel();
	   
	   //创建标签
	   JLabel lbl = new JLabel("请输入您的选择");
	   JLabel lbl1 = new JLabel("会员姓名：");
	   JLabel lbl2 = new JLabel("会员编号：");
	 

	   
	   //创建文本框
	   private JTextField jf = new JTextField();
	   private JTextField jp1 = new JTextField();
	   
	   //创建按钮
	   private JButton jxiu = new JButton("删除");
	   private JButton cancel = new JButton("取消");	   
	   
	   public DeleteVip() {
		   init();
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
//		   this.setDefaultCloseOperation(zeng.EXIT_ON_CLOSE);
	       //在 中央显示窗体
		   this.setLocationRelativeTo(null);
		   //不允许其改变窗体的大小
		   this.setResizable(false);
		   
		   main_xiugai();
        this.setVisible(true);
        //显示面板
        xiugai.setVisible(true);
	} 
	   public void setfont(JLabel j){
		   Font font=new Font("Monospaced",Font.BOLD,15);
		   j.setFont(font);
	   }
	   
	   private void main_xiugai() {
		 setfont(lbl1);
		 setfont(lbl2);
		
		 
		 lbl1.setBounds(175,100,150,50);
		 lbl2.setBounds(175,200,150,50);
		
		 
		 
		 jf.setBounds(300,115,300,30);
		 jp1.setBounds(300,215,300,30);
		 
		 
		 cancel.addActionListener(this);
		 jxiu.addActionListener(this);
		
		 jxiu.setBounds(250,400, 100,40);
		 cancel.setBounds(500,400,100,40);
      
		
		 xiugai.add(lbl1);
		 xiugai.add(lbl2);
		 xiugai.add(cancel);
		 xiugai.add(jxiu);
		 xiugai.add(jp1);
		 xiugai.add(jf);
		 
		 xiugai.setSize(800,500);
		 xiugai.setLayout(null);
		 this.add(xiugai);
	}
	  
    public void actionPerformed(ActionEvent e) {
	   if (e.getSource().equals(jxiu)) {
		  action = new actionImp();
		  String name = jf.getText();
		  int vno = Integer.valueOf(jp1.getText());
		  if (vno==0) {
			JOptionPane.showMessageDialog(null, "无该会员！");
		}
		  boolean flag = action.deletevip(name,vno);
		  if (flag) {
			JOptionPane.showMessageDialog(null, "删除成功");
		} 
	    }else if (e.getSource().equals(cancel)) {
		new EmpVip();
		dispose();
	}
	
}
    public static void main(String[] args) {
		DeleteVip  d = new DeleteVip();
	}
    
    
}
