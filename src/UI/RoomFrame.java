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
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entity.Room;

import action.actionImp;

public class RoomFrame extends JFrame implements ActionListener {
	
	int n = 0;
	
	private actionImp action;
    private Managerframe mf;
    
	JPanel room = new JPanel(new BorderLayout());
	JPanel jpnorth =new JPanel();
	
	
    private TableModel dtm;
	JScrollPane jsp;
	private Vector<Vector<Object>> data;
	private Vector<String> vecHeader;
	private List<Room> list;
	private JTable jtroom;
	
	
	private JTextField chaxun = new JTextField("请输入要查询的房间号或房间类型",17);
	 
	JLabel yuangonglbl = new JLabel("房间信息管理");
	private JButton jbadd = new JButton("添加");
	private JButton jbzadd = new JButton("确定增加");
    private JButton jbxiugai  = new JButton("修改");
	private JButton jbdelete = new JButton("删除");
	private JButton jbchaxun = new JButton("查询");
	private JButton jbfanhui = new JButton("返回");
	
	
	
	
	
	public RoomFrame(Managerframe mf) {
		this.mf = mf;
		  init();
	}
	private void init() {
		 Font font=new Font("Monospaced",Font.BOLD,20);//设置字体格式和大小
		   yuangonglbl.setForeground(Color.BLACK);//设置前景色
		   yuangonglbl.setFont(font);
		   this.setLayout(null);
		   this.setSize(800,600);
		   this.setTitle("员工界面");
		   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.setLocationRelativeTo(null);
		   //不允许其改变窗体的大小
		   this.setResizable(false);
		   
         room();
         this.setVisible(true);
         room.setVisible(true);
		
	}
	
	
	private void room(){
		   Font font=new Font("Monospaced",Font.BOLD,20);//设置字体格式和大小
		   yuangonglbl.setForeground(Color.BLACK);//设置前景色
		   yuangonglbl.setFont(font);
		    
		    jpnorth.add(yuangonglbl);
		    jpnorth.add(chaxun);
		    jpnorth.add(jbchaxun);
		    
		    this.setTitle("房间管理");
		    JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER,50,50));
		    
		    p.add(jbfanhui);
		    p.add(jbzadd);
		    p.add(jbadd);
			p.add(jbxiugai);
			p.add(jbdelete);
		     
			chaxun.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
//					if (chaxun) {
//						
//					}
				}
				public void focusGained(FocusEvent arg0) {
					if (n>0) {
						chaxun.setText(null);
					}
					++n;
					
				}
			});
			
			
			

			jbadd.setPreferredSize(new Dimension(90,40));
			jbchaxun.setPreferredSize(new Dimension(90,40));
			jbdelete.setPreferredSize(new Dimension(90,40));
			jbfanhui.setPreferredSize(new Dimension(90,40));
			jbxiugai.setPreferredSize(new Dimension(90,40));
			jbzadd.setPreferredSize(new Dimension(90,40));
			
			
			jbzadd.addActionListener(this);
			jbfanhui.addActionListener(this);
			jbxiugai.addActionListener(this);
			jbadd.addActionListener(this);
			jbdelete.addActionListener(this);
			jbchaxun.addActionListener(this);
			
		    room.setSize(790,600);
		    
		    addata();
			dtm = new DefaultTableModel(data,vecHeader){
				public boolean isCellEditable(int row, int column) {
					if (column==0) {
						return false;
					}
					return true;
				}
				
				
			};

			jtroom = new JTable(dtm);
			jtroom.setRowHeight(30);
			
			//设置表头和表格的字体
			jtroom.setFont(new Font("Menu.font", Font.PLAIN, 17));
			jtroom.getTableHeader().setFont(new Font("Dialog", 0, 19)); 
			jsp = new JScrollPane(jtroom);
			jsp.setBounds(30,50,700,400);
			
			//设置表格中的滚动条自动出现
			jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 

			room.add(jsp);
		    room.add(jpnorth,BorderLayout.NORTH);
		    room.add(p,BorderLayout.SOUTH);
		    this.add(room);   
	   }
	     
	public void addata(String type){
		 data = new Vector<Vector<Object>>();
		 action = new actionImp();
		 list = new ArrayList<Room>();
		 list = action.queryroombytype(type);
		 Vector<Object> v;
		 int n = 0;
		 while (n<list.size()){
			  v = new Vector<Object>();
			  v.add(String.valueOf(list.get(n).getRmno()));
			  v.add(list.get(n).getRmtype());
			  v.add(String.valueOf(list.get(n).getRmprice()));
			  v.add(String.valueOf(list.get(n).getVprice()));
			  data.add(v);
			  n++;
		}
		  vecHeader = new Vector<String>();
		  vecHeader.add("房间编号");
		  vecHeader.add("房间类型");
		  vecHeader.add("房间价格(元/天)");
		  vecHeader.add("会员价格(元/天)");	
		 
}
	 public void addata(){
		 data = new Vector<Vector<Object>>();
		 action = new actionImp();
		 list = new ArrayList<Room>();
		 list = action.queryroombuff();
		 Vector<Object> v;
		 int n = 0;
		 while (n<list.size()){
			  v = new Vector<Object>();
			  v.add(String.valueOf(list.get(n).getRmno()));
			  v.add(list.get(n).getRmtype());
			  v.add(String.valueOf(list.get(n).getRmprice()));
			  v.add(String.valueOf(list.get(n).getVprice()));
			  data.add(v);
			  n++;
		}
		  vecHeader = new Vector<String>();
		  vecHeader.add("房间编号");
		  vecHeader.add("房间类型");
		  vecHeader.add("房间价格(元/天)");
		  vecHeader.add("会员价格(元/天)");	 
}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jbchaxun)) {
			String name = chaxun.getText();
			if (name.equals("")) {
				addata();
				dtm = new DefaultTableModel(data,vecHeader);
				jtroom.setModel(dtm);
				jtroom.updateUI();	
				jtroom.setRowHeight(30);
				//jtroom.setFont(new Font("Menu.font", Font.PLAIN, 20));
			}else{
				addata(name);
				dtm = new DefaultTableModel(data,vecHeader){
					public boolean isCellEditable(int row, int column) {
			             if (column==0) {
							return false;
						}
			             return true;
					}
				};
				jtroom.setModel(dtm);
				jtroom.updateUI();	
				jtroom.setRowHeight(30);
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
		}else if (e.getSource().equals(jbdelete)){
			action = new actionImp();
			int n1 = jtroom.getSelectedRow();
			int rmno = Integer.valueOf((String) dtm.getValueAt(n1,1));
			if (n1>=0) {
				int n = JOptionPane.showConfirmDialog(null, "确定删除该房间吗？", "提示框",JOptionPane.YES_NO_OPTION);
				if (n==0) {
					boolean flag = action.deleteroom(rmno);
					if (flag) {
						JOptionPane.showMessageDialog(null,"删除成功");
						((DefaultTableModel) dtm).removeRow(jtroom.getSelectedRow());	
					}
				}
			}
       }else if (e.getSource().equals(jbxiugai)) {
    	   action = new actionImp();
    	   int n1 = jtroom.getSelectedRow();
    	   int rmno = Integer.valueOf((String) dtm.getValueAt(n1,0));
    	   String type = (String) dtm.getValueAt(n1,1); 
    	   String price1 = (String) dtm.getValueAt(n1,2);
    	   String vprice1 = (String) dtm.getValueAt(n1,3);
    	   
    	   if (type.equals("")||price1.equals("")||vprice1.equals("")) {
 	    	   JOptionPane.showMessageDialog(this, "值不能为空");
 	       }else {
 	    	if (type.equals("单人间")||type.equals("双人间")||type.equals("电脑房")) {
	    		 double price = Double.valueOf(price1);
	 	    	 double vprice = Double.valueOf(vprice1);
	 	    	 if (n1>=0) {
	 	        	  int answer = JOptionPane.showConfirmDialog(null, "确定修改该房间的信息吗？", "提示框",JOptionPane.YES_NO_OPTION);
	 			      if (answer==0) {
	 					boolean flag = action.updateroom(rmno,type,price,vprice);
	 					if (flag) {
	 						JOptionPane.showMessageDialog(null,"更新成功");
	 					}
	 				}           
	 	          }
 	    	}else {
 	    		JOptionPane.showMessageDialog(null, "房间的种类只能是单人间，双人间，电脑房三种");
			}
		}
    	 
           }else if (e.getSource().equals(jbadd)) {
    	      Vector<String> insertVec = new Vector<String>();
			  insertVec.add("房间编号自动增加");
			  ((DefaultTableModel) dtm).insertRow(dtm.getRowCount(), insertVec);
	   }else if(e.getSource().equals(jbzadd)) {
	     action = new actionImp();
 	     int n1 = jtroom.getSelectedRow();
 	     String type = (String) dtm.getValueAt(n1,1); 
 	     String  price1 = (String) dtm.getValueAt(n1,2);
 	     String vprice1 = (String) dtm.getValueAt(n1,3);   
 	     
 	     System.out.println(type);
 	     System.out.println(price1);
 	     if (type==null||price1==null||vprice1==null||type.equals("")||price1.equals("")||vprice1.equals("")) {
 	    	   JOptionPane.showMessageDialog(this, "值不能为空");
 	     }else {
 	    	 if (type.equals("单人间")||type.equals("双人间")||type.equals("电脑房")) {
 	    		 double price = Double.valueOf(price1);
 	 	    	 double vprice = Double.valueOf(vprice1);
 	 	    	 boolean flag = action.addroom(type,price,vprice);
 	 	    	 int answer = JOptionPane.showConfirmDialog(null, "确定增加该房间吗？", "提示框",JOptionPane.YES_NO_OPTION);
 	 	    	 if (answer==0) {
					 if (flag){
 			       JOptionPane.showMessageDialog(null,"增加成功");
 		         }else {
 			         JOptionPane.showMessageDialog(null,"增加失败,系统出现了故障");
 		               }
				}
			}else {
				JOptionPane.showMessageDialog(null, "房间的种类只能是单人间，双人间，电脑房三种");
			}	    	 
			
		}
 	     
 	     
 	     
 	     
	  }
    }
	public static void main(String[] args) {
		RoomFrame r = new RoomFrame(null);
	}
}
