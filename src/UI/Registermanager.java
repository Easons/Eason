package UI;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import action.actionImp;

public class Registermanager extends JFrame implements ActionListener{
	private  actionImp action;
	JLabel jl = new JLabel("����������:");
	JLabel jl1 = new JLabel("����������:");
	JLabel jl2 = new JLabel("���ٴ���������:");
	private JTextField userIdField = new JTextField();
	private JPasswordField userPwd = new JPasswordField();
	private JPasswordField userpwd2 = new JPasswordField();
	private JPanel j = new JPanel();
	private JButton j1 = new JButton("ȷ��");
	private JButton j2 = new JButton("ȡ��");
	public Registermanager() {
		init();
	}
	
	private void init() {
		
		this.setTitle("����Աע��");
		this.setBounds(10,10,600,450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension scn=kit.getScreenSize();
		int x = scn.width/2-this.getWidth()/2;
		int y = scn.height/2-this.getHeight()/2;
		this.setLocation(x-50, y-50);
		setResizable(false);
		setpanel();
		
		this.setVisible(true);
	}
	private void setpanel() {
	   jl.setBounds(50,50,100,30);
	  
	   jl1.setBounds(50,120,100,30);
	   jl2.setBounds(50,180,100,30);
	   
	   userIdField.setBounds(150,50,300,30);
	   
	   userPwd.setBounds(150,120,300,30);
	   userpwd2.setBounds(150,180,300,30);
	   
	   
	   j.setLayout(null);
       j1.setBounds(160,300, 80, 40) ;
       j1.addActionListener(this);
       j2.setBounds(350,300,80,40);
       j2.addActionListener(this);
       
       j.add(jl2);
       j.add(jl1);
       j.add(jl);
       j.add(j1);
       j.add(j2);
       j.add(userIdField);
       j.add(userPwd);
       j.add(userpwd2);
       j.setSize(400,300);
       this.add(j);
       
	}
	public void actionPerformed(ActionEvent e) {
		action = new actionImp();
		if (e.getSource().equals(j1)) {
			String name = userIdField.getText();
			String password = new String(userPwd.getPassword());
			boolean flag = action.addmanager(name, password);
			if (flag) {
				JOptionPane.showMessageDialog(this, "ע��ɹ�");
				setVisible(false);
				new ManagerLogin();
			
		}
		}else if(e.getSource().equals(j2)){
		    setVisible(false);
	        new ManagerLogin();
	}
		
	}
	
	public static void main(String[] args) {
		Registermanager r = new Registermanager();
		r.init();
	}
}
