package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entity.Emp;

import action.actionImp;

/**
 * 对员工的管理
 * 对房间的管理
 * 
 * @author p
 *
 */
public class Managerframe extends JFrame implements ActionListener{
	
	   //static String name = null;
	
	   String username = ManagerLogin.userName;
	   private actionImp action;
	   JPanel main = new JPanel();
	   JPanel xiugai = new JPanel();
	   
	   JLabel lbl = new JLabel("请输入您的选择");
	   JLabel lbltime = new JLabel();
	   JLabel lbl1 = new JLabel("输入您的旧密码：");
	   JLabel lbl2 = new JLabel("输入您的新密码：");
	   JLabel lbl3 = new JLabel("确认您的新密码：");
	   JLabel tishi = new JLabel();
	   
	   JLabel tishioldpass = new JLabel();
	   JLabel tishinewpass1 = new JLabel();
	   JLabel tishinewpass2 = new JLabel();
	   
	   private JTextField jf = new JTextField();
	   private JPasswordField jp1 = new JPasswordField();
	   private JPasswordField jp2 = new JPasswordField();
	   
	   private JButton jxiu = new JButton("确认修改");
	   private JButton cancel = new JButton("取消");
	   private JButton jb = new JButton("对员工的管理");
	   private JButton jb1 = new JButton("对房间的管理");
	   private JButton jb2 = new JButton("修改个人密码");
	   private JButton jbzhuxiao = new JButton("注销");	   
	   
	   public Managerframe() {
		   init();
	   }

	   public void setfont(JLabel j){
		   Font font=new Font("Monospaced",Font.BOLD,15);
		   j.setFont(font);
	   }
	   private void init() {
		   Font font=new Font("Monospaced",Font.BOLD,20);//设置字体格式和大小
		   lbl.setForeground(Color.BLACK);//设置前景色
		   lbl.setFont(font);
		   this.setLayout(null);
		   this.setSize(800,600);
		   this.setTitle("管理员界面");
		   this.setDefaultCloseOperation(Managerframe.EXIT_ON_CLOSE);
		   this.setLocationRelativeTo(null);
		   //不允许其改变窗体的大小
		   this.setResizable(false);
		   
		   main_xiugai();
           manager_main();
           this.setVisible(true);
           main.setVisible(true);
           xiugai.setVisible(false);
	}
	   
	   private void main_xiugai() {
		 setfont(lbl1);
		 setfont(lbl2);
		 setfont(lbl3);
		 setfont(tishioldpass);
		 lbl1.setBounds(150,50,150,50);
		 lbl2.setBounds(150,150,150,50);
		 lbl3.setBounds(150,250,150,50);
		 
		 tishioldpass.setBounds(300,100,300,30);
		 tishinewpass1.setBounds(300,190,300,30);
		 tishinewpass2.setBounds(300,290,300,30);
		 
		 
		 jf.setBounds(300,62,250,30);
		 jp1.setBounds(300,150,250,30);
		 jp2.setBounds(300,250,250,30);
		 
		 
		 //添加鼠标监听者
		 jp2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			public void mouseExited(MouseEvent e) {
				String newpass2 = new String(jp2.getPassword());
				String reg = "^[^\\s]{6,16}$";
				if (newpass2.equals("")) {
					tishinewpass2.setText("密码不能为空");
					tishinewpass2.setForeground(Color.red);;
				}
				
				if (newpass2.equals("")) {
					tishinewpass2.setText("密码不能为空");
					tishinewpass2.setForeground(Color.RED);
					tishinewpass2.setFont(new Font("Monospaced",Font.BOLD,16));
				}else if (newpass2.matches(reg)==false) {
					tishinewpass2.setText("格式有错,6至16 位任意字符且不含空格");
					tishinewpass2.setForeground(Color.RED);
					tishinewpass2.setFont(new Font("Monospaced",Font.BOLD,16));
				}else {
					tishinewpass2.setText("格式正确");
					tishinewpass2.setForeground(Color.green);
					tishinewpass2.setFont(new Font("Monospaced",Font.BOLD,16));
				}
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				tishinewpass2.setText(null);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		 
		 jp1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				String newpass = new String(jp1.getPassword());
				String reg = "^[^\\s]{6,16}$";
				if (newpass.equals("")) {
					tishinewpass1.setText("密码不能为空");
					tishinewpass1.setForeground(Color.red);;
				}
				
				if (newpass.equals("")) {
					tishinewpass1.setText("密码不能为空");
					tishinewpass1.setForeground(Color.RED);
					tishinewpass1.setFont(new Font("Monospaced",Font.BOLD,16));
				}else if (newpass.matches(reg)==false) {
					tishinewpass1.setText("格式有错,6至16 位任意字符且不含空格");
					tishinewpass1.setForeground(Color.RED);
					tishinewpass1.setFont(new Font("Monospaced",Font.BOLD,16));
				}else {
					tishinewpass1.setText("格式正确");
					tishinewpass1.setForeground(Color.green);
					tishinewpass1.setFont(new Font("Monospaced",Font.BOLD,16));
				}
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				tishinewpass1.setText(null);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		 
		 jf.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				String oldpass = jf.getText();
				String reg = "^[^\\s]{6,16}$";
				if (oldpass.equals("")) {
					tishioldpass.setText("密码不能为空");
					tishioldpass.setForeground(Color.red);;
				}
				
				if (oldpass.equals("")) {
					tishioldpass.setText("密码不能为空");
					tishioldpass.setForeground(Color.RED);
					tishioldpass.setFont(new Font("Monospaced",Font.BOLD,16));
				}else if (oldpass.matches(reg)==false) {
					tishioldpass.setText("格式有错,6至16 位任意字符且不含空格");
					tishioldpass.setForeground(Color.RED);
					tishioldpass.setFont(new Font("Monospaced",Font.BOLD,16));
				}else {
					tishioldpass.setText("格式正确");
					tishioldpass.setForeground(Color.green);
					tishioldpass.setFont(new Font("Monospaced",Font.BOLD,16));
				}
				
				
				
			}
			
			public void mouseEntered(MouseEvent e) {
				tishioldpass.setText(null);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		 
		 
		 
		 
		 
		 tishi.setBounds(550,240,150,50);
		 
		 jxiu.setBounds(250,400, 100,40);
		 cancel.setBounds(500,400,100,40);
		 jxiu.addActionListener(this);
		 cancel.addActionListener(this);
         
		 
		 xiugai.add(tishioldpass);
		 xiugai.add(tishinewpass1);
		 xiugai.add(tishinewpass2);
		 xiugai.add(tishi);
		 xiugai.add(lbl1);
		 xiugai.add(lbl2);
		 xiugai.add(lbl3);
		 xiugai.add(cancel);
		 xiugai.add(jxiu);
		 xiugai.add(jp2);
		 xiugai.add(jp1);
		 xiugai.add(jf);
		 
		 xiugai.setSize(800,500);
		 xiugai.setLayout(null);
		 this.add(xiugai);
	}



	public void manager_main() {
		 Font font=new Font("Monospaced",Font.BOLD,20);//设置字体格式和大小
		 lbltime.setForeground(Color.BLACK);//设置前景色
		 lbltime.setFont(font);
		
		
		  lbl.setBounds(100,80,200,100);
		  lbltime.setBounds(100,10, 400,100);
		  new Timer().schedule(new TimerTask() {
			public void run() {
				Date a = new java.util.Date();
				Date b = new java.sql.Date(a.getTime());
				Time c = new java.sql.Time(a.getTime());
				lbltime.setText("北京时间："+b+" "+c);
				
			}
		},0, 1000);
		  
		  
          jb.setBounds(50,250,115,50);
		  jb1.setBounds(200,250,120,50);
		  jb2.setBounds(360,250,130,50); 
		  jbzhuxiao.setBounds(540,250,100,50);
		   
		  jb.addActionListener(this);
		  jb1.addActionListener(this);
		  jb2.addActionListener(this);
		  jbzhuxiao.addActionListener(this);
		  
		  main.setLayout(null);
		  
		  
		  main.setSize(700,550);
		  main.add(lbl);
		  main.add(lbltime);
		  main.add(jb);
		  main.add(jb1);
		  main.add(jb2);
		  main.add(jbzhuxiao);
		  this.add(main);


		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//设置点击窗口关闭无操作
		addWindowListener(new WindowAdapter(){
			//添加处理窗口关闭事件的方法
			@Override
			public void windowClosing(WindowEvent e) {
				int var=JOptionPane.showConfirmDialog(Managerframe.this, "确定关闭页面？");
				if(var==JOptionPane.YES_OPTION){
					dispose();
					//TestSystemUi.main(null);
				}
			}
		});
	}	
	   public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jb2)) {
			main.setVisible(false);
			xiugai.setVisible(true);
		}else if (e.getSource().equals(cancel)) {
			tishinewpass1.setText(null);
			tishinewpass2.setText(null);
			tishioldpass.setText(null);
			xiugai.setVisible(false);
			main.setVisible(true);
		}else if (e.getSource().equals(jxiu)) {
			String oldpass = jf.getText();
			String newpass = new String(jp1.getPassword());
			String newpass2 = new String(jp2.getPassword());
			if(!newpass.equals(newpass2)){
				tishi.setText("两次输入的密码不一致");
				tishi.setForeground(Color.RED);
			}else{
				action = new actionImp();
				boolean flag = action.managerpassword(username, oldpass, newpass2);
				if (flag) {
					JOptionPane.showMessageDialog(null,"修改成功");
					jf.setText(null);
					jp1.setText(null);
					jp2.setText(null);
					tishi.setText(null);
					xiugai.setVisible(false);
					main.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"您的旧密码错误");
					xiugai.setVisible(false);
					dispose();
					new Managerframe();
				}	
			}
		  }else if (e.getSource().equals(jb)) {
			   this.dispose();
			   new ManagerEmp(this);
		  }else if (e.getSource().equals(jbzhuxiao)) {
            dispose();
			new ManagerLogin();
		  }else if (e.getSource().equals(jb1)) {
			this.dispose();
			new RoomFrame(this);
		  }
	    }
		
 
    public static void main(String[] args) {
    	Managerframe e = new Managerframe();
	}
}
