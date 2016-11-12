package UI;

import java.awt.BorderLayout;
import java.awt.Color;
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
import entity.Manager;

public class ManagerLogin extends JFrame implements ActionListener{
	
	public static  String userName;
	private Manager m ;
	
	
	JButton jbregister = new JButton("ע��");
	JButton login = new JButton("��¼");
	JButton cancel = new JButton("ȡ��");
	JButton zhaohui = new JButton("�һ����룿");
	JButton jbque = new JButton("ȷ��");
	JButton jbcancel = new JButton("����");
	
	JPanel main = new JPanel();
	JPanel lookpass = new JPanel();
	
	JTextField jtname = new JTextField(15);
	JPasswordField jp = new JPasswordField(15);
	JPasswordField jp1 = new JPasswordField(15);
	
	
	private JLabel title = new JLabel("����Ա�һ�����");
	private JLabel zhaoname = new JLabel("������");
	private JLabel newpass = new JLabel("�����룺");
	private JLabel Name = new JLabel();
	
	private JLabel tupian = new JLabel();
	private JLabel jlname = new JLabel("������");
	private JLabel jlpass = new JLabel("���룺");
	private JLabel jlyuangong = new JLabel("����Ա��¼����");
	private JLabel tishiname = new JLabel();
	private JLabel tishipass = new JLabel();
	private JLabel tishipasszhao = new JLabel();
	
	private actionImp action;//����������
	
	
	
	
	
	
	
	
	
	
	
	
//	private actionImp action;//����������
//	private JTextField userIdField;//�û���
//	private JPasswordField userPwd;//����
//	public ManagerLogin(actionImp action){
//		this();
//		this.action = action;
//	}
	public ManagerLogin(){//��ʼ������
		init();
	}
	/**��ʼ������*/
	private void init(){
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension scn=kit.getScreenSize();
		int x = scn.width/2-this.getWidth()/2;
		int y = scn.height/2-this.getHeight()/2;
		this.setLocation(x-300, y-300);
		this.setLayout(null);
		setResizable(false);
		
		this.setTitle("����Ա��¼����");
		look();
		main();
		main.setVisible(true);
		lookpass.setVisible(false);
		main.setVisible(true);
		
		
		setSize(600,500);
		setVisible(true);
	
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//���õ�����ڹر��޲���
		addWindowListener(new WindowAdapter(){
			//��Ӵ����ڹر��¼��ķ���
			public void windowClosing(WindowEvent e) {
				int var=JOptionPane.showConfirmDialog(ManagerLogin.this, "ȷ���رոô��ڣ�");
				if(var==JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		});
	}
	
	
	 //�޸ı�ǩ��С
	 public void setfont(JLabel j){
		   Font font=new Font("Monospaced",Font.BOLD,20);
		   j.setFont(font);
	   }
		
	 public  void look(){
			lookpass.setSize(600,500);
			lookpass.setLayout(null);
			
			setfont(title);
			setfont(Name);
			setfont(newpass);
			setfont(zhaoname);
			
			title.setBounds(220,30,200,30);
			zhaoname.setBounds(100,100,100,30);
			newpass.setBounds(100,300,100,30);
			Name.setBounds(250,100,100,30);
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
			lookpass.add(newpass);
			lookpass.add(zhaoname);
			
			this.add(lookpass);
		}
	 public void main(){
		   main.setSize(600,500);
		   main.setLayout(null);
		   
		   ImageIcon icon = new ImageIcon("Ա��.jpg");
		   icon.setImage(icon.getImage().getScaledInstance(icon.getIconWidth(),icon.getIconHeight(),Image.SCALE_DEFAULT));
		   tupian.setIcon(icon);
		   tupian.setBounds(0,-90,1500,680);
		   
		   setfont(jlname);
		   setfont(jlpass);
		   setfont(jlyuangong);
		   
		   jlyuangong.setBounds(200,20, 200, 50);
		   jlname.setBounds(100,100,100,30);
		   jlpass.setBounds(100,230, 200,30);
		   jtname.setBounds(200,100,230,30);
		   jp.setBounds(200,230,230,30);
		   login.setBounds(250,350,100,50);
		   cancel.setBounds(400,350,100,50);
		   tishiname.setBounds(200,130,360,30);
		   tishipass.setBounds(200,250,320,50);
		   jbregister.setBounds(100, 350,100,50);
		   
		   zhaohui.setBounds(450,220,100,50);
		   zhaohui.setContentAreaFilled(false);
		   zhaohui.setBorderPainted(false);
		   
		   
		   
		   jtname.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent arg0) {
				String reg = "^(([\u4e00-\u9fa5]{2,8})|([a-zA-Z]{2,16}))$";
			     String name1 = jtname.getText();
			     
			     if (name1.equals("")) {
					tishiname.setText("��������Ϊ��");
					tishiname.setForeground(Color.RED);
					tishiname.setFont(new Font("Monospaced",Font.BOLD,16));
				}else if (name1.matches(reg)==false) {
					 tishiname.setText("��ʽ�д�ֻ����2-5λ���Ļ�2-10λ��Ӣ��");
					 tishiname.setForeground(Color.RED);
					 tishiname.setFont(new Font("Monospaced",Font.BOLD,16));
				}else {
					tishiname.setText("��ʽ��ȷ");
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
					tishipass.setText("���벻��Ϊ��");
					tishipass.setForeground(Color.RED);
					tishipass.setFont(new Font("Monospaced",Font.BOLD,16));
				}else if (pass.matches(reg)==false) {
					tishipass.setText("��ʽ�д�6��16 λ�����ַ��Ҳ����ո�");
					tishipass.setForeground(Color.RED);
					tishipass.setFont(new Font("Monospaced",Font.BOLD,16));
				}else {
					tishipass.setText("��ʽ��ȷ");
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
					tishipasszhao.setText("���벻��Ϊ��");
					tishipasszhao.setForeground(Color.RED);
					tishipasszhao.setFont(new Font("Monospaced",Font.BOLD,16));
				}else if (pass.matches(reg)==false) {
					tishipasszhao.setText("��ʽ�д�6��16 λ�����ַ��Ҳ����ո�");
					tishipasszhao.setForeground(Color.RED);
					tishipasszhao.setFont(new Font("Monospaced",Font.BOLD,16));
				}else {
					tishipasszhao.setText("��ʽ��ȷ");
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
		   
		   jbregister.addActionListener(this);
		   zhaohui.addActionListener(this);
		   login.addActionListener(this);
		   cancel.addActionListener(this);
		   
		   
		   
		   main.add(jbregister);
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
			  m  = new Manager();
				//1.����û������û�������
				 userName = jtname.getText();//����û���
				String pwd = new String(jp.getPassword());//�������
				//2.���ݲ�����������
				action = new actionImp();
				 m = action.login(userName);
				
				if(m!=null){
					  if(userName.equals(m.getMname())&&pwd.equals(m.getMpassword())){
					 	   new Managerframe();
					       dispose();
					  }else{
						  JOptionPane.showMessageDialog(null, "�������");
						  Name.setText(m.getMname());
					}
			      }else {
			    	  Name.setText("�գ�");
					  JOptionPane.showMessageDialog(null, "������Ĺ���Ա������");
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
		}else if (e.getSource().equals(jbcancel)) {
			  Name.setText(null);
			  jp1.setText(null);
			  main.setVisible(true);
			  lookpass.setVisible(false);
		}else if (e.getSource().equals(jbque)) {
			action = new actionImp();
			String newpass = new String(jp1.getPassword());
			boolean flag =  action.updatemanagerpass(m.getMname(),newpass);
			if (flag) {
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				Name.setText(null);
				Name.setText(null);
				jp1.setText(null);
			    main.setVisible(true);
				lookpass.setVisible(false);
			}
		}else if (e.getSource().equals(jbregister)) {
			 new Registermanager();
			    dispose();
		}
		}
			
		
		
		
		
		
//		Toolkit kit = Toolkit.getDefaultToolkit();
//		Dimension scn=kit.getScreenSize();
//		int x = scn.width/2-this.getWidth()/2;
//		int y = scn.height/2-this.getHeight()/2;
//		this.setLocation(x-300, y-300);
//		setResizable(false);
//		setSize(500,350);
//		setVisible(true);
//		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//���õ�����ڹر��޲���
//		addWindowListener(new WindowAdapter(){
//			public void windowClosing(WindowEvent e) {
//				int var=JOptionPane.showConfirmDialog(ManagerLogin.this, "ȷ���رոô��ڣ�");
//				if(var==JOptionPane.YES_OPTION){
//					System.exit(0);
//				}
//			}
//		});
//		setContentPane(createContentPane());//���ô������
//	}
//	/**�����������*/
//	private JPanel createContentPane(){
//		JPanel p = new JPanel();
//		p.setLayout(new BorderLayout());//���ñ߿򲼾�
//		p.add(BorderLayout.SOUTH,createButtonPane());//�����(��)��Ӱ�ť���
//		p.add(BorderLayout.NORTH,createUserPwdPane());//�����(��)�����������
//		return p; 
//	}
//	/**������ť���**/
//	private JPanel createButtonPane(){
//		JPanel p = new JPanel();//��Ű�ť���
//		p.setLayout(new FlowLayout());//����˳�򲼾�
//		JButton login = new JButton("��¼");
//		JButton cancel = new JButton("ȡ��");
//		JButton register = new JButton("ע��");
//		//ע���¼��ť�����¼���������¼����
//		login.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				//1.����û������û�������
//				userName = userIdField.getText();//����û���
//				String pwd = new String(userPwd.getPassword());//�������
//				//2.���ݲ�����������
//				action = new actionImp();
//				boolean flag = action.login(userName,pwd);
//			    if (flag) {
//			    	//setVisible(false);
//					new Managerframe();
//					dispose();
//				}
//			}
//			
//		});
		
//		register.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			   // setVisible(false);
//			    new Registermanager();
//			    dispose();
//			}
//		});
//		
//		cancel.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//setVisible(false);
//				TestSystemUi.main(null);
//				dispose();
//				
//			}
//		});
//		p.add(register);
//		p.add(login);//��¼��ť
//		p.add(cancel);//ȡ����ť
//		return p;
//	}
	
//	/**�����û�����������*/
//	private JPanel createUserPwdPane(){
//		JPanel p = new JPanel();
//		//GridLayout���񲼾�(����,����),ˮƽ��϶0,��ֱ��϶8
//		p.setLayout(new GridLayout(3,1,50,50));
//		//�����ǩ��Ĭ������룬���þ���
//		p.add(new JLabel("����Ա��¼",JLabel.CENTER));
//		p.add(createUserIdPane());//����û�����ǩ���
//		p.add(createPwdPane());//��������ǩ���
//		//��������봰��֮���������ұ߾��Ϊ10
//		p.setBorder(new EmptyBorder(10,10,10,10));
//		return p;
//	}
//	/**�����û���ǩ��������**/
//	private JPanel createUserIdPane(){
//		JPanel p = new JPanel();
//		p.setLayout(new BorderLayout());//�߿򲼾�
//		p.add(BorderLayout.WEST,new JLabel("������"));//�����(��)��ӱ�ű�ǩ
//		userIdField=new JTextField();//�û��������Ը�ֵ
//		p.add(BorderLayout.CENTER,userIdField);//���������û������
//		return p;
//	}
//	/**���������ǩ��������**/
//	private JPanel createPwdPane() {
//		JPanel p = new JPanel();
//		p.setLayout(new BorderLayout());//�߿򲼾�
//		p.add(BorderLayout.WEST,new JLabel("���룺"));//�����(��)��������ǩ
//		userPwd=new JPasswordField();//�û������������Ը�ֵ
//		p.add(BorderLayout.CENTER,userPwd);//�����������������
//		return p;
//	}
	
	
	
	public static void main(String[] args) {
		ManagerLogin m = new ManagerLogin();
		//l.setVisible(true);
	}
}
