//package UI;
//
//	import java.awt.Color;
//
//	import java.awt.GridBagConstraints;
//	import java.awt.GridBagLayout;
//	import java.awt.Insets;
//
//	import java.awt.event.ActionEvent;
//	import java.awt.event.ActionListener;
//	import java.awt.event.FocusEvent;
//	import java.awt.event.FocusListener;
//
//	import javax.swing.ButtonGroup;
//	import javax.swing.JButton;
//
//	import javax.swing.JFrame;
//	import javax.swing.JLabel;
//	import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//	import javax.swing.JRadioButton;
//	import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//
//import action.actionImp;
//
//import entity.Emp;
//
//
//	public class Addemp extends JFrame {
//		
//		  private actionImp action;
//		   private GridBagLayout gbl =  new GridBagLayout();
//		       //设置一个约束
//		   private GridBagConstraints  gbc = new GridBagConstraints();
//		   private JLabel lblsname = new JLabel("员工 姓 名",SwingConstants.CENTER);
//		   private JLabel lblsage = new JLabel("员工 年 龄",SwingConstants.CENTER);
//		   private JLabel lblssex = new JLabel("员工性 别",SwingConstants.CENTER);
//		   private JLabel lblempno = new JLabel("员工编号",SwingConstants.CENTER);
//		   private JLabel lblsal = new JLabel("员工工资",SwingConstants.CENTER);
//
//		   private JLabel lblsnametip = new JLabel();
//		   private JLabel lblsagetip = new JLabel("(提示：年龄必须是数字且在18-60)");
//		   //文本框
//		   private JTextField  sname = new JTextField(15);
//		   private JTextField  jfsage = new JTextField(15);
//		   private JTextField  jfcid = new JTextField(15);
//		   private JTextField  jfssal = new JTextField(15);
//
//		   //单选框
//		   private JRadioButton  boy = new JRadioButton("男");
//		   private JRadioButton  girl = new JRadioButton("女");
//		   private JButton jb = new JButton("确  定  增  加");
//		   private JButton jb1 = new JButton("返回上一层");
//		   private ButtonGroup bg = new ButtonGroup();
//		   
//		   
//		   public Addemp() {
//			this.setSize(600,500);
//			this.setTitle("增加员工");
//			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			this.setLocationRelativeTo(null);
//			//不允许其改变窗体的大小
//			this.setResizable(false);
//			JPanel stuinfoPanel = new JPanel();
//			//设成网袋布局
//			stuinfoPanel.setLayout(gbl);
//			jb.setActionCommand("b");
//			jb1.setActionCommand("a");
////			jb1.addActionListener(al);
////			jb.addActionListener(al);
//			
//			
//			boy.setSelected(true);
//			bg.add(boy);
//			bg.add(girl);
//
//			gbc.gridx = 1;
//			gbc.gridy = 0;
//			gbc.insets = new Insets(0,5, 5, 5);
//			gbl.setConstraints(lblsname,gbc);
//			stuinfoPanel.add(lblsname);
//
//			gbc.gridx = 1;
//			gbc.gridy = 3;
//			gbl.setConstraints(lblsage,gbc);
//			stuinfoPanel.add(lblsage);
//
//			gbc.gridx = 1;
//			gbc.gridy = 4;
//			gbl.setConstraints(lblssex,gbc);
//			stuinfoPanel.add(lblssex);
//
//			//员工编号标签
//			gbc.gridx = 1;
//			gbc.gridy = 6;
//			gbl.setConstraints(lblempno,gbc);
//			stuinfoPanel.add(lblempno);
//
//			//工资标签
//			gbc.gridx = 1;
//			gbc.gridy = 15;
//			gbl.setConstraints(lblsal,gbc);
//			stuinfoPanel.add(lblsal);
//
//			gbc.gridx = 3;
//			gbc.gridy = 0;
//			gbl.setConstraints(sname,gbc);
//			stuinfoPanel.add(sname);
//
//			gbc.gridx = 4;
//			gbc.gridy = 0;
//			gbl.setConstraints(lblsnametip,gbc);
//			stuinfoPanel.add(lblsnametip);
//
//			gbc.gridx = 4;
//			gbc.gridy = 3;
//			gbl.setConstraints(lblsagetip,gbc);
//			stuinfoPanel.add(lblsagetip);
//
//			gbc.gridx = 3;
//			gbc.gridy = 3;
//			gbl.setConstraints(jfsage,gbc);
//			stuinfoPanel.add(jfsage);
//
//			//员工标号框
//			gbc.gridx = 3;
//			gbc.gridy = 6;
//			gbl.setConstraints(jfcid,gbc);
//			stuinfoPanel.add(jfcid);
//
//			gbc.gridx = 3;
//			gbc.gridy = 4;
//			gbl.setConstraints(boy,gbc);
//			stuinfoPanel.add(boy);
//
//			gbc.gridx = 4;
//			gbc.gridy = 4;
//			gbl.setConstraints(girl,gbc);
//			stuinfoPanel.add(girl);
//
//			//员工工资框
//			gbc.gridx = 3;
//			gbc.gridy = 15;
//			gbl.setConstraints(jfssal,gbc);
//			stuinfoPanel.add(jfssal);
//
//
//			gbc.gridx = 4;
//			gbc.gridy = 15;
//			gbl.setConstraints(jb1,gbc);
//			stuinfoPanel.add(jb1);
//			
//			//确定增加按钮
//			gbc.gridx = 4;
//			gbc.gridy = 7;
//			gbl.setConstraints(jb,gbc);
//			stuinfoPanel.add(jb);
//		
//			
//			
//	         jb1.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					dispose();
//					new ManagerEmp(null);
//					
//				}
//			});
//			
//			
//			jb.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					action = new actionImp();
//					Emp emp  = new Emp();
//					String  snamevalues = sname.getText();
//				    int empno   = Integer.valueOf(jfcid.getText());
//				    double sal = Double.valueOf(jfssal.getText());
//					 int sagevalues =0;
//				   try {
//						 sagevalues = Integer.parseInt(jfsage.getText());
//					} catch (Exception e2) {
//						JOptionPane.showMessageDialog(Addemp.this, "年龄不能为空");
//					}
//				  
//				   String  sex = null;
//				   if(boy.isSelected()){
//					   sex = boy.getText();
//				   }else{
//					   sex = girl.getText();
//				   }
//				  
//					boolean  flag = action.plusemp(empno, snamevalues, sagevalues, sal, sex);
//					if(flag){
//						JOptionPane.showMessageDialog(Addemp.this, " 添加成功 !");	
//						new ManagerEmp(null);
//						dispose();
//					}else{
//						JOptionPane.showMessageDialog(Addemp.this, " 添加失败 !");
//						System.exit(0);
//					}
//				}
//			});
//			action = new actionImp();
//			sname.addFocusListener(new FocusListener() {
//				public void focusGained(FocusEvent e) {
//				}
//				public void focusLost(FocusEvent e) {
//					Emp emp = new Emp();
//					String namevalue = sname.getText();
//					emp = action.queryempbyname(namevalue);
//					if(emp.getEname()!=null){
//						lblsnametip.setText("该学生已经存在,在添加就是重名");
//						lblsnametip.setForeground(Color.RED);
//					}else{
//						lblsnametip.setText(" 该名可使用 或者 您输入的为空");
//						lblsnametip.setForeground(Color.green);
//					}
//				}
//			});
//			
//			this.setContentPane(stuinfoPanel);
//			this.setVisible(true);
//		}	  
//		  
//		  
//		 
//		
//		   public static void main(String[] args) {
//			  Addemp a = new Addemp();
//		}
//}
//
