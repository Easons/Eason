package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import entity.Emp;


import action.actionImp;
/**
 * 入住(会员，普通用户)
 * 预定
 * 点菜
 * 会员的增删改查
 * 修改该员工的个人密码(只限密码)
 * 结账
 * @author p
 *
 */

public class Empframe extends JFrame implements ActionListener{
	  private actionImp action ;
	  JPanel main = new JPanel();
	  JPanel xiugai = new JPanel();
	  public String username;
	  
	  JLabel tishi = new JLabel();
	  JLabel lbloldpass = new JLabel("输入您的旧密码：");
	  JLabel lblnew = new JLabel("输入您的新密码：");
	  JLabel lblnewpass = new JLabel("确认您的新密码：");
	  JLabel tishipass1 = new JLabel();
	  
	  JTextField jf = new JTextField();
	  JPasswordField jpf = new JPasswordField();
	  JPasswordField jpf2 = new JPasswordField();
	  
	   JLabel lbl = new JLabel();
	   JLabel tupian = new JLabel();
	  
	   private JButton jbqueren = new JButton("确认修改");
	   private JButton jbcancel = new JButton("取消");
	   
//	   jbzhuxiao = new JButton("注销",icon);
	   private JButton jbcaidanguanli = new JButton("菜单管理");
	   private JButton jbzhuxiao = new JButton("注销");
	   private JButton jbruzhu = new JButton("入住与退订");
	   private JButton jbyuding = new JButton("预定");
	   private JButton jbdiancai = new JButton("点菜");
	   private JButton jbhuiyuan = new JButton("会员管理");
	   private JButton jbjiezhang = new JButton("结账");
	   private JButton jbxiugai = new JButton("修改密码");
	   private JButton jbjilu = new JButton("记录查询");
//	   private JButton jbchaxunbuff = new JButton("房间状态查询");
	   
	   public Empframe(){
		   init();
	   }
	   
	   public void init() {
		this.setSize(800,650);
		//this.setLayout(null);
		
		this.setTitle("员工界面");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	     //不允许其改变窗体的大小
	    this.setResizable(false);	
	    emp();
	    main_xiugai();
	    this.setVisible(true);
	    main.setVisible(true);
	    xiugai.setVisible(false);
	    
	   }   
   
		 //主界面  
		 public void emp(){
		   ImageIcon icon = new ImageIcon("酒店.jpg");
		   icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth(),icon.getIconHeight(),Image.SCALE_DEFAULT));
		   tupian.setIcon(icon);
		   tupian.setBounds(0,-36,1500,680);
		 
		    new Timer().schedule(new TimerTask() {
			   public void run() {
				  Date a = new java.util.Date();
				  Date b = new java.sql.Date(a.getTime());
				  Time c = new java.sql.Time(a.getTime());
				  lbl.setText("北京时间："+b+" "+c);
				 
			  }
		   },0,1000);
		 
		 Font font=new Font("Monospaced",Font.BOLD,25);//设置字体格式和大小
		 lbl.setForeground(Color.BLACK);//设置前景色
		 lbl.setFont(font); 
		 lbl.setBounds(180,40,400,50); 
		
		 
		 jbzhuxiao.setPreferredSize(new Dimension(90,40));
		 jbcaidanguanli.setPreferredSize(new Dimension(100,40));
		 jbdiancai.setPreferredSize(new Dimension(90,40));
		 jbhuiyuan.setPreferredSize(new Dimension(90,40));
		 jbjiezhang.setPreferredSize(new Dimension(90,40));
		 jbjilu.setPreferredSize(new Dimension(90,40));
		 jbruzhu.setPreferredSize(new Dimension(100,40));
		 jbyuding.setPreferredSize(new Dimension(90,40));
		 jbxiugai.setPreferredSize(new Dimension(90,40));
//		 jbchaxunbuff.setPreferredSize(new Dimension(130,40));
		 
		 jbcancel.addActionListener(this);
		 jbqueren.addActionListener(this);
		 jbdiancai.addActionListener(this);
		 jbhuiyuan.addActionListener(this);
		 jbjiezhang.addActionListener(this);
		 jbjilu.addActionListener(this);
		 jbruzhu.addActionListener(this);
		 jbxiugai.addActionListener(this);
		 jbyuding.addActionListener(this);
		 jbzhuxiao.addActionListener(this);
		 jbcaidanguanli.addActionListener(this);
		 //main.setLayout(null);
		 main.setSize(800,700);
		 
		 
		 main.add(jbyuding);
		 main.add(jbruzhu);
		 main.add(jbdiancai);
		 main.add(jbjiezhang);
		 main.add(jbqueren);
		 
		 main.add(jbxiugai);
		 
		 main.add(jbhuiyuan);
		 
		 main.add(jbjilu);
		 main.add(jbcaidanguanli);
//		 main.add(jbchaxunbuff);
		 main.add(jbzhuxiao);
		 main.add(lbl);
		 main.add(tupian);
		 
		 this.add(main);
		 
	 

		 setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//设置点击窗口关闭无操作
		addWindowListener(new WindowAdapter(){
			//添加处理窗口关闭事件的方法
			@Override
			public void windowClosing(WindowEvent e) {
				int var=JOptionPane.showConfirmDialog(Empframe.this, "确定退出登录？");
				if(var==JOptionPane.YES_OPTION){
					xiugai.setVisible(false);
					dispose();
					
					
				}
			}
		});
		 
 }  
		 //修改标签大小
		 public void setfont(JLabel j){
			   Font font=new Font("Monospaced",Font.BOLD,15);
			   j.setFont(font);
		   }
		 public void main_xiugai(){
			xiugai.setLayout(null);
			xiugai.setSize(800,700);
			
			setfont(lbloldpass);
			lbloldpass.setBounds(150,50,150,150); 
			jf.setBounds(300,110,350,30);
			
			
			
			
			setfont(lblnew);
			lblnew.setBounds(150,160,150,150);
			jpf.setBounds(300,220,350,30);
			
			setfont(lblnewpass);
			lblnewpass.setBounds(150,270,150,150);
			jpf2.setBounds(300,330,350,30);
			
			tishipass1.setBounds(300,260,450,50);
			
			
			jpf.addMouseListener(new MouseListener() {
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				public void mouseExited(MouseEvent e) {
					String reg = "^[^\\s]{6,16}$";
					String pass = new String(jpf.getPassword());
	
					if (pass.equals("")) {
						tishipass1.setText("密码不能为空");
						tishipass1.setForeground(Color.RED);
						tishipass1.setFont(new Font("Monospaced",Font.BOLD,16));
					}else if (pass.matches(reg)==false) {
						tishipass1.setText("格式有错，6至16 位任意字符且不含空格");
						tishipass1.setForeground(Color.RED);
						tishipass1.setFont(new Font("Monospaced",Font.BOLD,16));
					}else {
						tishipass1.setText("格式正确");
						tishipass1.setForeground(Color.green);
						tishipass1.setFont(new Font("Monospaced",Font.BOLD,16));
					}
					
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					tishi.setText(null);
					tishipass1.setText(null);
					
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
			
			
			
			
			
			tishi.setBounds(500,350,150,40);
			
			jbqueren.setBounds(300,500,100,50);
			jbcancel.setBounds(500,500,100,50);
		
			xiugai.add(tishipass1);
			xiugai.add(tishi);
			xiugai.add(jbcancel);
			xiugai.add(jbqueren);
			xiugai.add(jpf2);
			xiugai.add(jpf);
			xiugai.add(jf);
			xiugai.add(lblnewpass);
			xiugai.add(lblnew);
			xiugai.add(lbloldpass);
			
			this.add(xiugai);
			
			
//			jpf2.addFocusListener(new FocusListener() {
//				public void focusGained(FocusEvent e) {
//				}
//				public void focusLost(FocusEvent e) {
//					String pass = new String(jpf.getPassword());
//					String pass2 = new String(jpf2.getPassword());
//					if(!pass.equals(pass2)){
//						tishi.setText("两次输入的密码不一致");
//						tishi.setForeground(Color.RED);
//					}
//				}
//			});
			   
 }
   
		   
     
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jbzhuxiao)) {
			 dispose();
			 new EmpLogin();
		}else if (e.getSource().equals(jbxiugai)) {
			main.setVisible(false);
			xiugai.setVisible(true);
		}else if(e.getSource().equals(jbqueren)){
				String pass = new String(jpf.getPassword());
				String pass2 = new String(jpf2.getPassword());
				if(!pass.equals(pass2)){
					tishi.setText("两次输入的密码不一致");
					tishi.setForeground(Color.RED);
					}else{
					action = new actionImp();
					username = EmpLogin.name;
					String oldpass = jf.getText();
					System.out.println(username);
					String newpass = new String(jpf.getPassword());
					boolean flag = action.emppass(username, oldpass, newpass);
					if (flag) {
							JOptionPane.showMessageDialog(null,"修改成功");
							
							jf.setText(null);
							jpf.setText(null);
							jpf2.setText(null);
							tishi.setText(null);
							xiugai.setVisible(false);
                             main.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null,"您的旧密码错误或您输入的为空");
						}	
						
						
					}
		}else if (e.getSource().equals(jbcancel)) {
			 main.setVisible(true);
			 xiugai.setVisible(false);
		}else if (e.getSource().equals(jbyuding)) {
			new YuDingFrame();
			dispose();
		}else if (e.getSource().equals(jbcaidanguanli)) {
			new EmpMenus(this);
			dispose();
		}else if (e.getSource().equals(jbruzhu)) {
			new BookRuZhu();
			dispose();
		}else if (e.getSource().equals(jbjiezhang)) {
			new JieZhang();
			dispose();
		}else if (e.getSource().equals(jbjilu)) {
			new JiLuFrame(this);
			dispose();
		}else if (e.getSource().equals(jbdiancai)) {
			new DianCaiFrame(this);
			dispose();
		}else if (e.getSource().equals(jbhuiyuan)) {
			new EmpVip();
			dispose();
		}
		
	}
	
	
	public static void main(String[] args){
		Empframe e = new Empframe();
	}
}
