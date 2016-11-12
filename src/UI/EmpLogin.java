package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import action.actionImp;
import entity.Emp;

public class EmpLogin extends JFrame implements ActionListener{
	
   static String name;

   private Emp emp;
   
   
	JButton login = new JButton("登录");
	JButton cancel = new JButton("取消");
	JButton zhaohui = new JButton("找回密码？");
	JButton jbque = new JButton("确定");
	JButton jbcancel = new JButton("返回");
	
	JPanel main = new JPanel();
	JPanel lookpass = new JPanel();
	
	JTextField jtname = new JTextField(15);
	JPasswordField jp = new JPasswordField(15);
	JPasswordField jp1 = new JPasswordField(15);
	
	
	
	private JLabel title = new JLabel("员工找回密码");
	private JLabel zhaoname = new JLabel("姓名：");
	private JLabel zhaoempno = new JLabel("编号：");
	private JLabel newpass = new JLabel("新密码：");
	private JLabel Name = new JLabel();
	private JLabel Empno = new  JLabel();
	
	private JLabel tupian = new JLabel();
	private JLabel jlname = new JLabel("姓名：");
	private JLabel jlpass = new JLabel("密码：");
	private JLabel jlyuangong = new JLabel("员工登录界面");
	private JLabel tishiname = new JLabel();
	private JLabel tishipass = new JLabel();
	private JLabel tishipasszhao = new JLabel();
	
	private actionImp action;//控制器对象


	public EmpLogin(){//初始化界面
		init();
	}
	/**初始化界面*/
	private void init(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension scn=kit.getScreenSize();
		int x = scn.width/2-this.getWidth()/2;
		int y = scn.height/2-this.getHeight()/2;
		this.setLocation(x-300, y-300);
		this.setLayout(null);
		setResizable(false);
		
		this.setTitle("员工登录界面");
		look();
		main();
		main.setVisible(true);
		lookpass.setVisible(false);
		main.setVisible(true);
		
		
		setSize(600,500);
		setVisible(true);
	
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//设置点击窗口关闭无操作
		addWindowListener(new WindowAdapter(){
			//添加处理窗口关闭事件的方法
			@Override
			public void windowClosing(WindowEvent e) {
				int var=JOptionPane.showConfirmDialog(EmpLogin.this, "确定关闭该窗口？");
				if(var==JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		});

	}

	
	 //修改标签大小
	 public void setfont(JLabel j){
		   Font font=new Font("Monospaced",Font.BOLD,20);
		   j.setFont(font);
	   }
	
	
	public  void look(){
		lookpass.setSize(600,500);
		lookpass.setLayout(null);
		
		setfont(title);
		setfont(Name);
		setfont(Empno);
		setfont(newpass);
		setfont(zhaoempno);
		setfont(zhaoname);
		
		title.setBounds(220,30,200,30);
		zhaoname.setBounds(100,100,100,30);
		zhaoempno.setBounds(100,200,100,30);
		newpass.setBounds(100,300,100,30);
		Name.setBounds(250,100,100,30);
		Empno.setBounds(250,200,100,30);
		jp1.setBounds(200,300,250,30);
		jbque.setBounds(120,400,100, 40);
		jbcancel.setBounds(310,400,100,40);
		tishipasszhao.setBounds(200,350,200,30);
		
		jbque.addActionListener(this);
		jbcancel.addActionListener(this);
		
		lookpass.add(tishipasszhao);
		lookpass.add(jbque);
		lookpass.add(jbcancel);
		lookpass.add(jp1);
		lookpass.add(title);
		lookpass.add(Name);
		lookpass.add(Empno);
		lookpass.add(newpass);
		lookpass.add(zhaoname);
		lookpass.add(zhaoempno);
		
		this.add(lookpass);
	}
	 
	 
	 
	 
	   public void main(){
		   main.setSize(600,500);
		   main.setLayout(null);
		   
		   ImageIcon icon = new ImageIcon("员工.jpg");
		   icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth(),icon.getIconHeight(),Image.SCALE_DEFAULT));
		   tupian.setIcon(icon);
		   tupian.setBounds(0,-90,1500,680);
		   
		   setfont(jlname);
		   setfont(jlpass);
		   setfont(jlyuangong);
		   //setfont(tishiname);
		   
		   jlyuangong.setBounds(200,20, 200, 50);
		   jlname.setBounds(100,100,100,30);
		   jlpass.setBounds(100,230, 200,30);
		   jtname.setBounds(200,100,230,30);
		   jp.setBounds(200,230,230,30);
		   login.setBounds(150,350,100,50);
		   cancel.setBounds(300,350,100,50);
		   tishiname.setBounds(200,130,360,30);
		   tishipass.setBounds(200,250,320,50);
		   
		   
		   zhaohui.setBounds(450,220,100,50);
		   zhaohui.setContentAreaFilled(false);
		   zhaohui.setBorderPainted(false);
		   
		   
		   
		   jtname.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) {
				String reg = "^(([\u4e00-\u9fa5]{2,8})|([a-zA-Z]{2,16}))$";
			     String name1 = jtname.getText();
			     
			     if (name1.equals("")) {
					tishiname.setText("姓名不能为空");
					tishiname.setForeground(Color.RED);
					tishiname.setFont(new Font("Monospaced",Font.BOLD,16));
				}else if (name1.matches(reg)==false) {
					 tishiname.setText("格式有错，只能是2-5位中文或2-10位的英文");
					 tishiname.setForeground(Color.RED);
					 tishiname.setFont(new Font("Monospaced",Font.BOLD,16));
				}else {
					tishiname.setText("格式正确");
					tishiname.setForeground(Color.green);
					tishiname.setFont(new Font("Monospaced",Font.BOLD,16));
				}
			}
			
			public void focusGained(FocusEvent arg0) {
				tishiname.setText(null);
				
				
			}
		});
		   
		   
		   jp.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				String reg = "^[^\\s]{6,16}$";
				String pass = new String(jp.getPassword());
				if (pass.equals("")) {
					tishipass.setText("密码不能为空");
					tishipass.setForeground(Color.RED);
					tishipass.setFont(new Font("Monospaced",Font.BOLD,16));
				}else if (pass.matches(reg)==false) {
					tishipass.setText("格式有错，6至16 位任意字符且不含空格");
					tishipass.setForeground(Color.RED);
					tishipass.setFont(new Font("Monospaced",Font.BOLD,16));
				}else {
					tishipass.setText("格式正确");
					tishipass.setForeground(Color.green);
					tishipass.setFont(new Font("Monospaced",Font.BOLD,16));
				}
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				tishipass.setText(null);
				
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
			
			@Override
			public void mouseExited(MouseEvent e) {
				String reg = "^[^\\s]{6,16}$";
				String pass = new String(jp1.getPassword());
				if (pass.equals("")) {
					tishipasszhao.setText("密码不能为空");
					tishipasszhao.setForeground(Color.RED);
					tishipasszhao.setFont(new Font("Monospaced",Font.BOLD,16));
				}else if (pass.matches(reg)==false) {
					tishipasszhao.setText("格式有错，6至16 位任意字符且不含空格");
					tishipasszhao.setForeground(Color.RED);
					tishipasszhao.setFont(new Font("Monospaced",Font.BOLD,16));
				}else {
					tishipasszhao.setText("格式正确");
					tishipasszhao.setForeground(Color.green);
					tishipasszhao.setFont(new Font("Monospaced",Font.BOLD,16));
				}
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				tishipass.setText(null);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		   
		   zhaohui.addActionListener(this);
		   login.addActionListener(this);
		   cancel.addActionListener(this);
		   
		   
		   
		   
		   main.add(zhaohui);
		   main.add(tishipass);
		   main.add(tishiname);
		   main.add(jlyuangong);
		   main.add(jlname);
		   main.add(jlpass);
		   main.add(jtname);
		   main.add(jp);
		   main.add(login);
		   main.add(cancel);
		   main.add(tupian);
		   this.add(main);
		   
	   }
	
	
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(login)) {
			 emp = new Emp();
			//1.获得用户输入用户名密码
			 name = jtname.getText();//获得用户名
			String pwd = new String(jp.getPassword());//获得密码
			//2.传递参数到控制器
			action = new actionImp();
			 emp = action.login1(name);
			
			if(emp.getAge()!=0){
				  if(name.equals(emp.getEname())&&pwd.equals(emp.getEpassword())){
				 	   new Empframe();
				       dispose();
				  }else{
					  JOptionPane.showMessageDialog(null, "密码错误");
					  Name.setText(emp.getEname());
					  Empno.setText(String.valueOf(emp.getEmpno()));
					  JOptionPane.showMessageDialog(null, "员工的初始密码为:666666");
				}
		      }else {
		    	  Name.setText("空！");
				  Empno.setText("空！");
				JOptionPane.showMessageDialog(null, "您输入的用户不存在");
			}
			
		}else if (e.getSource().equals(cancel)) {
			new TestSystemUi();
			dispose();
		}else if (e.getSource().equals(zhaohui)) {
			tishiname.setText(null);
			tishipass.setText(null);
			jtname.setText(null);
			jp.setText(null);
			main.setVisible(false);
			lookpass.setVisible(true);
		}else if(e.getSource().equals(jbcancel)) {
			  Name.setText(null);
			  Empno.setText(null);
			  jp1.setText(null);
			  main.setVisible(true);
			  lookpass.setVisible(false);
		}else if (e.getSource().equals(jbque)) {
			action = new actionImp();
			String newpass = new String(jp1.getPassword());
			boolean flag =  action.updateemppass(emp.getEmpno(),newpass);
			if (flag) {
				JOptionPane.showMessageDialog(null, "修改成功");
				Name.setText(null);
				Name.setText(null);
				jp1.setText(null);
			    main.setVisible(true);
				lookpass.setVisible(false);
			}
		}
		
	}
	
	public static void main(String[] args) {
		EmpLogin e = new EmpLogin();

//		String reg = "^(([\u4e00-\u9fa5]{2,5})|([a-zA-Z]{2,10}))$";
//		String name = "jack";
//		System.out.println(name.matches(reg));
		
		
	}
	
	
	
}
