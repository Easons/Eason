package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import action.actionImp;

import entity.Emp;
import entity.Room;

public class ManagerEmp extends JFrame implements ActionListener {
	private actionImp action;

	int n = 0;
	
	JPanel emp = new JPanel(new BorderLayout());
	JPanel jpnorth =new JPanel();
	private Managerframe mf;
	
	private TableModel dtm;
	JScrollPane jsp;
	private Vector<Vector<Object>> data;
	private Vector<String> vecHeader;
	private List<Emp> list;
	private JTable jtemp;
	
	
	private JTextField chaxun = new JTextField("请输入要查询的名字或员工编号",18);
	 
	JLabel yuangonglbl = new JLabel("员工信息管理");
	
	
	private JButton jbquerenadd = new JButton("确认增加");
	private JButton jbadd = new JButton("添加");
    private JButton jbxiugai  = new JButton("修改");
	private JButton jbdelete = new JButton("删除");
	private JButton jbchaxun = new JButton("查询");
	private JButton jbfanhui = new JButton("返回");
	
	
	public ManagerEmp(Managerframe mf) {
		this.mf = mf;
		   init();
	}
	private void init() {
		 Font font=new Font("Monospaced",Font.BOLD,20);//设置字体格式和大小
		   yuangonglbl.setForeground(Color.BLACK);//设置前景色
		   yuangonglbl.setFont(font);
		   this.setLayout(null);
		   this.setSize(800,600);
		   this.setTitle("员工管理界面");
		   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.setLocationRelativeTo(null);
		   //不允许其改变窗体的大小
		   this.setResizable(false);
		   
           emp();
           this.setVisible(true);
           emp.setVisible(true);
		
	}

	private void emp(){
		   Font font=new Font("Monospaced",Font.BOLD,20);//设置字体格式和大小
		   yuangonglbl.setForeground(Color.BLACK);//设置前景色
		   yuangonglbl.setFont(font);
		    
		    jpnorth.add(yuangonglbl);
		    jpnorth.add(chaxun);
		    jpnorth.add(jbchaxun);
		    
		    
		    JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER,50,50));
		    

		    p.add(jbfanhui);
		    p.add(jbquerenadd);
		    p.add(jbadd);		    
			p.add(jbxiugai);
			p.add(jbdelete);
		     
			
			jbadd.setPreferredSize(new Dimension(90,50));
			jbchaxun.setPreferredSize(new Dimension(90,40));
			jbdelete.setPreferredSize(new Dimension(90,50));
			jbfanhui.setPreferredSize(new Dimension(90,50));
			jbxiugai.setPreferredSize(new Dimension(90,50));
			jbquerenadd.setPreferredSize(new Dimension(90,50));
			
			
			jbquerenadd.addActionListener(this);
			jbfanhui.addActionListener(this);
			jbxiugai.addActionListener(this);
			jbadd.addActionListener(this);
			jbdelete.addActionListener(this);
			jbchaxun.addActionListener(this);
			
		    emp.setSize(790,600);
		  
		    addata();
			dtm = new DefaultTableModel(data,vecHeader){
				public boolean isCellEditable(int row, int column) {
					if (column==0) {
						return false;
					}
					return true;
				}
			};
			jtemp = new JTable(dtm);
			jtemp.setRowHeight(30);
			
			jtemp.setFont(new Font("Menu.font", Font.PLAIN, 17));
			jtemp.getTableHeader().setFont(new Font("Dialog", 0, 19));
			
			chaxun.addFocusListener(new FocusListener() {
				
				public void focusLost(FocusEvent arg0) {
					if (chaxun.getText().equals("")) {
						chaxun.setText("请输入要查询的员工姓名或员工号");
					}
				}

				public void focusGained(FocusEvent arg0) {
						chaxun.setText(null);
					
					
				}
			});
			
			jsp = new JScrollPane(jtemp);
			jsp.setBounds(30,50,650,400);
		   
			emp.add(jsp);
		    emp.add(jpnorth,BorderLayout.NORTH);
		    emp.add(p,BorderLayout.SOUTH);
		    this.add(emp);   
	   }
	
	public void addata(String name){
		 data = new Vector<Vector<Object>>();
		 action = new actionImp();
		 list = new ArrayList<Emp>();
		 list = action.queryallemp(name);
		 Vector<Object> v;
		 int n = 0;
		 while (n<list.size()){
			  v = new Vector<Object>();
			  v.add(String.valueOf(list.get(n).getEmpno()));
			  v.add(String.valueOf(list.get(n).getEname()));
			  v.add(list.get(n).getEsex());
			  v.add(String.valueOf(list.get(n).getAge()));
			  v.add(String.valueOf(list.get(n).getSal()));
			  data.add(v);
			  n++;
		}
		 vecHeader = new Vector<String>();
		  vecHeader.add("编号");
			vecHeader.add("姓名");
			vecHeader.add("性别");
			vecHeader.add("年龄");
			vecHeader.add("工资");	 
		 
}
	//通过员工编号查询员工
	 public void addata(int empno){
		 data = new Vector<Vector<Object>>();
		 action = new actionImp();
		 list = new ArrayList<Emp>();
		 list = action.queryempempno(empno);
		 Vector<Object> v;
		 int n = 0;
		 while (n<list.size()){
			  v = new Vector<Object>();
			  v.add(String.valueOf(list.get(n).getEmpno()));
			  v.add(String.valueOf(list.get(n).getEname()));
			  v.add(list.get(n).getEsex());
			  v.add(String.valueOf(list.get(n).getAge()));
			  v.add(String.valueOf(list.get(n).getSal()));
			  data.add(v);
			  n++;
		}
		  vecHeader = new Vector<String>();
			vecHeader.add("编号");
			vecHeader.add("姓名");
			vecHeader.add("性别");
			vecHeader.add("年龄");
			vecHeader.add("工资");	 
		 
}
	
	
	
	//查询所有的员工
	 public void addata(){
		 data = new Vector<Vector<Object>>();
		 action = new actionImp();
		 list = new ArrayList<Emp>();
		 list = action.queryallemp();;
		 Vector<Object> v;
		 int n = 0;
		 while (n<list.size()){
			  v = new Vector<Object>();
			  v.add(String.valueOf(list.get(n).getEmpno()));
			  v.add(String.valueOf(list.get(n).getEname()));
			  v.add(list.get(n).getEsex());
			  v.add(String.valueOf(list.get(n).getAge()));
			  v.add(String.valueOf(list.get(n).getSal()));
			  data.add(v);
			  n++;
		}
		  vecHeader = new Vector<String>();
			vecHeader.add("编号");
			vecHeader.add("姓名");
			vecHeader.add("性别");
			vecHeader.add("年龄");
			vecHeader.add("工资");	 
		 
}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jbchaxun)) {
			String ename = chaxun.getText();
			String reg = "^[0-9]{3}$"; 
			if (ename.equals("请输入要查询的员工姓名或员工号")) {
				addata();
				dtm = new DefaultTableModel(data,vecHeader){
					public boolean isCellEditable(int row, int column) {
						if (column==0) {
							return false;
						}
						return true;
					}
				};
				jtemp.setModel(dtm);
				jtemp.updateUI();	
				jtemp.setRowHeight(30);
			}else if (ename.matches(reg)) {
				int empno = Integer.valueOf(ename);
				addata(empno);
				dtm = new DefaultTableModel(data,vecHeader){
					public boolean isCellEditable(int row, int column) {
						if (column==0) {
							return false;
						}
						return true;
					}
				};
				jtemp.setModel(dtm);
				jtemp.updateUI();	
				jtemp.setRowHeight(30);
			}else{
				addata(ename);
				dtm = new DefaultTableModel(data,vecHeader){
					public boolean isCellEditable(int row, int column) {
						if (column==0) {
							return false;
						}
						return true;
					}
				};
				jtemp.setModel(dtm);
				jtemp.updateUI();	
				jtemp.setRowHeight(30);
			}
			 for (int i = 0; i < data.size(); i++) {
				 for (int j = 0; j < data.get(i).size(); j++) {
						dtm.setValueAt(data.get(i).get(j), i, j);
					}
				}
		}else if (e.getSource().equals(jbfanhui)) {
			 this.dispose();
			 if (mf!=null) {
				mf.setVisible(true);
			}else {
				new Managerframe();
			}
	 
		}else if (e.getSource().equals(jbdelete)) {
			action = new actionImp();
			int n1 = jtemp.getSelectedRow();
			int empno = Integer.valueOf((String) dtm.getValueAt(n1,0));
			String name = (String) dtm.getValueAt(n1,1);
			if (n1>=0) {
				int n = JOptionPane.showConfirmDialog(null, "确定删除该员工吗？", "提示框",JOptionPane.YES_NO_OPTION);
				if (n==0) {
					boolean flag = action.deleteemp(empno, name);
					if (flag){
						JOptionPane.showMessageDialog(null,"删除成功");
						((DefaultTableModel) dtm).removeRow(jtemp.getSelectedRow());	
					}
				}
			}
       }else if (e.getSource().equals(jbxiugai)) {
    	   action = new actionImp();
    	   int n1 = jtemp.getSelectedRow();
    	  int empno  = Integer.valueOf((String) dtm.getValueAt(n1,0));
    	  String name = (String) dtm.getValueAt(n1,1);
    	  String sex = (String)dtm.getValueAt(n1,2);
	      int age = Integer.valueOf((String)dtm.getValueAt(n1,3));
    	  double sal = Double.valueOf((String) dtm.getValueAt(n1,4));
    	  
    	   Emp emp = new Emp();
    	  
	    	//emp = action.queryempbyempno(empno);
    	   emp = action.queryemp(name);
    	    System.out.println(emp.getAge());
	    	 if (emp.getAge()!=0) {
				if (n1>=0) {
	    		 int answer = JOptionPane.showConfirmDialog(null, "您未修改该员工的姓名或姓名有重复！确定修改该员工的信息吗？", "提示框",JOptionPane.YES_NO_OPTION);
	    		 if (answer==0) {	 
	    			 boolean flag = action.updateemp(empno,name,age,sal,sex);
	    			 if (flag) {
	    				 JOptionPane.showMessageDialog(null,"更新成功");
	    			 }
	    		 }           
	    	 }
			}else {
				if (n1>=0) {
		    		 int answer = JOptionPane.showConfirmDialog(null, "确定修改该员工的信息吗？", "提示框",JOptionPane.YES_NO_OPTION);
		    		 if (answer==0) {	 
		    			 boolean flag = action.updateemp(empno,name,age,sal,sex);
		    			 if (flag) {
		    				 JOptionPane.showMessageDialog(null,"更新成功");
		    			 }
		    		 }           
		    	 }
			} 	 
       }else if (e.getSource().equals(jbadd)) {
    	   Vector<String> insertVec = new Vector<String>();
//			  insertVec.add(dtm.getRowCount()+1+"");
			  insertVec.add("自动增加的编号");
			  ((DefaultTableModel) dtm).insertRow(dtm.getRowCount(), insertVec);
	   }else if (e.getSource().equals(jbquerenadd)) {
		     action = new actionImp();
	 	     int n1 = jtemp.getSelectedRow();
	 	     //int empno = Integer.valueOf((String) dtm.getValueAt(n1,1));
	 	     String ename1 = (String) dtm.getValueAt(n1,1); 
	 	     String sex1 =  (String)dtm.getValueAt(n1,2);
	 	     String age1 = (String)dtm.getValueAt(n1,3);   
	 	     String sal1 = (String)dtm.getValueAt(n1,4);

			 
			 if (ename1==null||sex1==null||age1==null||sal1==null||ename1.equals("")||sex1.equals("")||age1.equals("")||sal1.equals("")){
				 JOptionPane.showMessageDialog(null, "不能有空值");
			 }else{
				 int age = Integer.valueOf(age1);
				 double sal = Integer.valueOf(sal1);
				 
				 
				Emp emp1 = new Emp();
				emp1 = action.queryemp(ename1);
				if(emp1.getEname()!=null){
					int n = JOptionPane.showConfirmDialog(null,"该姓名已存在，再添加就是重名","提示框",JOptionPane.YES_NO_OPTION);
					if (n==0) {
						action = new actionImp();
						boolean flag = action.plusemp(ename1,age,sal, sex1);
					if (flag) {
						JOptionPane.showMessageDialog(null,"增加成功");
					}else {
						JOptionPane.showMessageDialog(null,"增加失败");
					}	
					}
				 }else {
					 int n = JOptionPane.showConfirmDialog(null,"确认添加？","提示框",JOptionPane.YES_NO_OPTION);
					 if (n==0) {
					    action = new actionImp();
						boolean flag = action.plusemp(ename1,age,sal, sex1);
					if (flag) {
						JOptionPane.showMessageDialog(null,"增加成功");
					}else {
						JOptionPane.showMessageDialog(null,"增加失败");
					}	
			}      
					
			}
		}	  	   
	   }	
    }
      public static void main(String[] args) {
         ManagerEmp m = new ManagerEmp(null);
     }
}
