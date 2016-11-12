package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import action.actionImp;
import entity.Menus;
import entity.Room;

public class EmpMenus extends JFrame implements ActionListener{
	private actionImp action;
    private Empframe mf;
    
	JPanel menus = new JPanel(new BorderLayout());
	JPanel jpnorth =new JPanel();
	
	
    private TableModel dtm;
	JScrollPane jsp;
	private Vector<Vector<Object>> data;
	private Vector<String> vecHeader;
	private List<Menus> list;
	private JTable jtmenus;
	
	
	private JTextField chaxun = new JTextField("请输入要查询的菜名",17);
	 
	JLabel yuangonglbl = new JLabel("菜单信息管理");
	private JButton jbadd = new JButton("添加");
	private JButton jbzadd = new JButton("确定增加");
    private JButton jbxiugai  = new JButton("修改");
	private JButton jbdelete = new JButton("删除");
	private JButton jbchaxun = new JButton("查询");
	private JButton jbfanhui = new JButton("返回");
	
	
	public EmpMenus(Empframe mf) {
		this.mf = mf;
		  init();
	}
	private void init() {
		   Font font=new Font("Monospaced",Font.BOLD,20);//设置字体格式和大小
		   yuangonglbl.setForeground(Color.BLACK);//设置前景色
		   yuangonglbl.setFont(font);
		   this.setLayout(null);
		   this.setSize(800,600);
		   this.setTitle("菜单界面");
		   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.setLocationRelativeTo(null);
		   //不允许其改变窗体的大小
		   this.setResizable(false);
		   
           menus();
           this.setVisible(true);
           menus.setVisible(true);
		
	}
	
	
	private void menus(){
		    Font font=new Font("Monospaced",Font.BOLD,20);//设置字体格式和大小
		    yuangonglbl.setForeground(Color.BLACK);//设置前景色
		    yuangonglbl.setFont(font);
		    
		    jpnorth.add(yuangonglbl);
		    jpnorth.add(chaxun);
		    jpnorth.add(jbchaxun);
		    
		    this.setTitle("菜单管理");
		    JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER,50,50));
		    p.add(jbzadd);
		    p.add(jbfanhui);
			p.add(jbxiugai);
			p.add(jbadd);
			p.add(jbdelete);
		     
			jbzadd.addActionListener(this);
			jbfanhui.addActionListener(this);
			jbxiugai.addActionListener(this);
			jbadd.addActionListener(this);
			jbdelete.addActionListener(this);
			jbchaxun.addActionListener(this);
			
			jbadd.setPreferredSize(new Dimension(90,40));
			jbchaxun.setPreferredSize(new Dimension(90,40));
			jbdelete.setPreferredSize(new Dimension(90,40));
			jbfanhui.setPreferredSize(new Dimension(90,40));
			jbxiugai.setPreferredSize(new Dimension(90,40));
			jbzadd.setPreferredSize(new Dimension(90,40));
		
			chaxun.addMouseListener(new MouseListener() {
				public void mouseReleased(MouseEvent arg0) {
	
				}
				public void mousePressed(MouseEvent arg0) {
					chaxun.setText(null);
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					
				}

				public void mouseEntered(MouseEvent arg0) {	
				}
				public void mouseClicked(MouseEvent arg0) {
					
				}
			});
			
			
		    menus.setSize(790,600);
		    addata();
		    
		    
		    
			dtm = new DefaultTableModel(data,vecHeader){
				public boolean isCellEditable(int row, int column) {
					if (column==0) {
						return false;
					}
					return true;
				}
			};
			
			jtmenus = new JTable(dtm);
			
			jtmenus.setFont(new Font("Menu.font", Font.PLAIN, 17));
			jtmenus.getTableHeader().setFont(new Font("Dialog", 0, 19));

			jtmenus.setRowHeight(30);
			jsp = new JScrollPane(jtmenus);
			jsp.setBounds(30,50,650,400);

			menus.add(jsp);
			menus.add(jpnorth,BorderLayout.NORTH);
			menus.add(p,BorderLayout.SOUTH);
		    this.add(menus);   
	   }
	     
	public void addata(String mname){
		 data = new Vector<Vector<Object>>();
		 action = new actionImp();
		 list = new ArrayList<Menus>();
		 list = action.querymenus(mname);
		 Vector<Object> v;
		 int n = 0;
		 while (n<list.size()){
			  v = new Vector<Object>();
			  v.add(list.get(n).getMno());
			  v.add(list.get(n).getMname());
			  v.add(list.get(n).getMfee());
			  v.add(list.get(n).getMvfee());  
			  data.add(v);
			  n++;
		}
		  vecHeader = new Vector<String>();
		  vecHeader.add("食品编号");
		  vecHeader.add("食品名称");
		  vecHeader.add("食品价格");
		  vecHeader.add("食品会员价"); 
		 
}
	 public void addata(){
		 data = new Vector<Vector<Object>>();
		 action = new actionImp();
		 list = new ArrayList<Menus>();
		 list = action.querymenus();
		 Vector<Object> v;
		 int n = 0;
		 while (n<list.size()){
			  v = new Vector<Object>();
			  v.add(list.get(n).getMno());
			  v.add(list.get(n).getMname());
			  v.add(list.get(n).getMfee());
			  v.add(list.get(n).getMvfee());  
			  data.add(v);
			  n++;
		}
		  vecHeader = new Vector<String>();
		  vecHeader.add("食品编号");
		  vecHeader.add("食品名称");
		  vecHeader.add("食品价格");
		  vecHeader.add("食品会员价");  
		 
}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jbchaxun)) {
			String mname = chaxun.getText();
			if (mname.equals("")||mname.equals("请输入要查询的菜名")) {
				addata();
				dtm = new DefaultTableModel(data,vecHeader){

					public boolean isCellEditable(int row, int column) {
						if (column==0) {
							return false;
						}
						return true;
					}
				};
				jtmenus.setModel(dtm);
				jtmenus.updateUI();	
				jtmenus.setRowHeight(30);
			}else{
				addata(mname);
				dtm = new DefaultTableModel(data,vecHeader){
					public boolean isCellEditable(int row, int column) {
					    if (column==0) {
							return false;
						}
					    return true;
					}
					
					
				};
				jtmenus.setModel(dtm);
				jtmenus.updateUI();	
				jtmenus.setRowHeight(30);
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
				new Empframe();
			}	 
		}else if (e.getSource().equals(jbdelete)) {
			action = new actionImp();
			int n1 = jtmenus.getSelectedRow();
			String mname = (String) dtm.getValueAt(n1,2);
			if (n1>=0) {
				int n = JOptionPane.showConfirmDialog(null, "确定删除该食品吗？", "提示框",JOptionPane.YES_NO_OPTION);
				if (n==0) {
					boolean flag = action.deletemenus(mname);
					if (flag) {
						JOptionPane.showMessageDialog(null,"删除成功");
						((DefaultTableModel) dtm).removeRow(jtmenus.getSelectedRow());	
					}
				}
			}
       }else if (e.getSource().equals(jbxiugai)) {
    	   action = new actionImp();
    	   int n = jtmenus.getSelectedRow();
    	   int mno =(Integer) dtm.getValueAt(n,0);
    	   String name = dtm.getValueAt(n, 1).toString();
    	   String price1 =  (String) dtm.getValueAt(n, 2);
    	   String vprice1 = (String) dtm.getValueAt(n,3);

    	   System.out.println(name);
    	   System.out.println(price1);
    	   System.out.println(vprice1);
   	     if (name.equals("")||price1.equals("")||vprice1.equals("")) {
			JOptionPane.showMessageDialog(null, "不能为空");
		}else {
		   Menus m = new Menus();
   	       m = action.menusname(name);
   	       
   	       if (m.getMno()!=0) {
			if (m.getMname().equals(name)) {
			   JOptionPane.showMessageDialog(null, "您未修改该食品的原名或名字重复了！");
			   int answer = JOptionPane.showConfirmDialog(null, "确定修改该食品的信息吗？", "提示框",JOptionPane.YES_NO_OPTION);
			   if (answer==0) {
				   double price = Double.valueOf(price1);
				   double vprice = Double.valueOf(vprice1);
				   boolean flag = action.updatemenus(name,price,vprice,mno);
					if (flag) {
						JOptionPane.showMessageDialog(null,"更新成功");
					    }
			}
		}     
		}else {
			   int answer = JOptionPane.showConfirmDialog(null, "确定修改该食品的信息吗？", "提示框",JOptionPane.YES_NO_OPTION);
			   if (answer==0) {
				   double price = Double.valueOf(price1);
				   double vprice = Double.valueOf(vprice1);
				   boolean flag = action.updatemenus(name,price,vprice,mno);
					if (flag) {
						JOptionPane.showMessageDialog(null,"更新成功");
					    }
			}
		}
	    }
   	       
    	  
           }else if (e.getSource().equals(jbadd)) {
    	      Vector<String> insertVec = new Vector<String>();
			  insertVec.add("食品编号自动增长");
			  insertVec.add("新增的食品名称");
			  ((DefaultTableModel) dtm).insertRow(dtm.getRowCount(), insertVec);
	   }else if(e.getSource().equals(jbzadd)) {
	     action = new actionImp();
 	     int n1 = jtmenus.getSelectedRow();
 	     String mname = (String) dtm.getValueAt(n1, 1); 
 	     String  price1 = (String) dtm.getValueAt(n1,2); 
 	     String vprice1 = (String)dtm.getValueAt(n1,3) ;
 	     
 	     Menus m = new Menus();
 	     m = action.menusname(mname);
 	     if (mname.equals("")||mname==null||price1==null||vprice1==null||vprice1.equals("")||price1.equals("")) {
 	    	 JOptionPane.showMessageDialog(null, "不能为空");
		}else {
			   if (mname.equals(m.getMname())) {
				JOptionPane.showMessageDialog(null, "名字有重复");
			}else{
			   int n = JOptionPane.showConfirmDialog(null, "确定增加吗？", "提示框",JOptionPane.YES_NO_OPTION);
				if (n==0) {
					double price = Double.valueOf(price1);
					double vprice = Double.valueOf(vprice1);
					boolean flag = action.addmenus(mname,price,vprice);
	 	            if (flag){
			        JOptionPane.showMessageDialog(null,"增加成功");
		            }else {
			          JOptionPane.showMessageDialog(null,"增加失败,系统出错");
		            }
				}
			}
		}
		}
 	     
    }
	public static void main(String[] args) {
		EmpMenus r = new EmpMenus(null);
//		String reg = "^((单人间)|(双人间))$";
//		String name = "单人间";
//		System.out.println(name.matches(reg));
		
		
		
		
	}
}
