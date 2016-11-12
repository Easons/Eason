package UI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import action.actionImp;
import entity.Vip;

public class Xiugaivip  extends JFrame{
	private static final long serialVersionUID = -4268313734866758507L;
	private actionImp action;
	JPanel main = new JPanel();
	  JPanel xiugai = new JPanel();
	  public String username;
	  
	  JLabel tishi = new JLabel("请输入要修改vip的身份证号：");
	  JLabel lblxm = new JLabel("vip姓名：");
	  JLabel lblbh = new JLabel("vip编号：");
	  JLabel lblsfz = new JLabel("vip身份证号：");
	  JLabel lbldh = new JLabel("vip电话号：");
	  
	  JTextField ts = new JTextField();
	  JTextField jf = new JTextField();
	  JTextField jf2 = new JTextField();
	  JTextField jpf = new JTextField();
	  JTextField jpf2 = new JTextField();
	  
	   JLabel lbl = new JLabel();
	   JLabel tupian = new JLabel();
	  
	    JButton jbchaxun = new JButton("查询");
	    String name;
	   
	

       private JButton jbqueren = new JButton("确认修改");
	   private JButton jbcancel = new JButton("取消");
   
	   
	   public   Xiugaivip(){
		   init();
	   }
	   
	   public void init() {
		this.setSize(800,700);
		this.setLayout(null);
		
		this.setTitle("vip信息修改界面");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	     //不允许其改变窗体的大小
	    this.setResizable(false);	
	    main_xiugai();
	    this.setVisible(true);
	    xiugai.setVisible(true);
	    
	   }   
		  
		 //修改标签大小
		 public void setfont(JLabel j){
			   Font font=new Font("Monospaced",Font.BOLD,15);
			   j.setFont(font);
		   }
		 public void main_xiugai(){
			xiugai.setLayout(null);
			xiugai.setSize(800,700);
			
	
			
			setfont(tishi);
			tishi.setBounds(1,1,300,150); 
			ts.setBounds(280,60,350,30);
			
			
			setfont(lblxm);
			lblxm.setBounds(100,90,150,150); 
			jf.setBounds(280,150,350,30);
			
			setfont(lblbh);
			lblbh.setBounds(100,200,150,150);
			jf2.setBounds(280,260,350,30);
			
			setfont(lblsfz);
			lblsfz.setBounds(100,300,150,150);
			jpf.setBounds(280,360,350,30);
			
			setfont(lbldh);
			lbldh.setBounds(100,410,150,150);
			jpf2.setBounds(280,470,350,30);
			
			jbchaxun.setBounds(670,60,80,30);
			jbqueren.setBounds(300,550,100,50);
			jbcancel.setBounds(500,550,100,50);
			
			jbchaxun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String sfz = ts.getText();
					Vip v = new Vip();
					action = new actionImp();
					
					v = action.queryvip(sfz);
					name = v.getVname();
					jf.setText(v.getVname());
					jf2.setText(String.valueOf(v.getVno()));
					jpf.setText(v.getVcard());
					jpf2.setText(String.valueOf(v.getTel()));
					
				}
			});
			
	
			jbqueren.addActionListener(new ActionListener() {
					
				public void actionPerformed(ActionEvent e) {
					action = new actionImp();
					String newname = jf.getText();				
					int vno = Integer.valueOf(jf2.getText());
					String Vcard =jpf.getText();
					Long Tel = Long.valueOf(jpf2.getText());
					boolean flag = action.updateVip(vno, newname, Vcard, Tel,name);
					if (flag) {
						name = newname;
						JOptionPane.showMessageDialog(null, "修改成功");
						jf.setText(null);
						jf2.setText(null);
						jpf.setText(null);
						jpf2.setText(null);
						ts.setText(null);
					}
				}
			});
				
			jbcancel.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					new EmpVip();
					dispose();
					
				}
			});
			xiugai.add(ts);
			xiugai.add(tishi);
			xiugai.add(jbcancel);
			xiugai.add(jbqueren);
			xiugai.add(jbchaxun);
			xiugai.add(jf);
			xiugai.add(jf2);
			xiugai.add(jpf);
			xiugai.add(jpf2);
			xiugai.add(lblxm);
			xiugai.add(lblbh);
			xiugai.add(lblsfz);
			xiugai.add(lbldh);
			
			this.add(xiugai);			   
 }
		 public static void main(String[] args) {
			Xiugaivip x = new Xiugaivip();
		}
}
