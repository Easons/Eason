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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import action.actionImp;
import entity.History;
import entity.Menus;

public class JiLuFrame extends JFrame  implements ActionListener{
	private actionImp action;
    private Empframe mf;
    
	JPanel main = new JPanel(new BorderLayout());
	
	
    private TableModel dtm;
	JScrollPane jsp;
	private Vector<Vector<Object>> data;
	private Vector<String> vecHeader;
	private List<History> list;
	private JTable jtroom;
	
	
	private JTextField chaxun = new JTextField("请输入要查询的房间号或房间类型",17);
	 
	JLabel jlchaxun = new JLabel("房间记录查询：");

	private JButton jbchaxun = new JButton("查询");
	private JButton jbfanhui = new JButton("返回");
	
	
	public JiLuFrame(Empframe mf) {
		this.mf = mf;
		  init();
	}
	private void init() {
		   this.setLayout(null);
		   this.setSize(800,600);
		   this.setTitle("房间记录表");
		   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.setLocationRelativeTo(null);
		   //不允许其改变窗体的大小
		   this.setResizable(false);
		   
           main();
           this.setVisible(true);
           main.setVisible(true);
		
	}
	
	
	private void main(){
		    Font font=new Font("Monospaced",Font.BOLD,20);//设置字体格式和大小
		    jlchaxun.setForeground(Color.BLACK);//设置前景色
		    jlchaxun.setFont(font);
		    this.setTitle("房间记录查询");
		    main.setLayout(null);
		    main.setSize(800,600);
		    
		    jlchaxun.setBounds(100,20,150,30);
		    chaxun.setBounds(250,20,250,30);
		    
		    
		    jbchaxun.setBounds(530,10,100,40);
		    jbfanhui.setBounds(650,10,100,40);
		    
		    
		    
			jbfanhui.addActionListener(this);
			jbchaxun.addActionListener(this);
			
		    
		    
		    addata();
			dtm = new DefaultTableModel(data,vecHeader);

			jtroom = new JTable(dtm);
			jtroom.setRowHeight(30);
				
			
			jsp = new JScrollPane(jtroom);
			jsp.setBounds(10,60,780,480);
            setwidth();
			
			
            chaxun.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
				}
				public void focusGained(FocusEvent e) {
					chaxun.setText(null);
					
				}
			});
            
			jtroom.setFont(new Font("Menu.font", Font.PLAIN, 17));
			jtroom.getTableHeader().setFont(new Font("Dialog", 0, 19));
			jtroom.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        	jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
			

			main.add(jlchaxun);
			main.add(chaxun);
			main.add(jsp);
			main.add(jbchaxun);
			main.add(jbfanhui);
		    this.add(main);   
	   }
	//固定表格的宽度
	public void  setwidth(){
		jtroom.getColumnModel().getColumn(0).setPreferredWidth(50);
		jtroom.getColumnModel().getColumn(1).setPreferredWidth(70);
		jtroom.getColumnModel().getColumn(2).setPreferredWidth(180);
		jtroom.getColumnModel().getColumn(3).setPreferredWidth(140);
		jtroom.getColumnModel().getColumn(4).setPreferredWidth(120);
		jtroom.getColumnModel().getColumn(5).setPreferredWidth(100);
		jtroom.getColumnModel().getColumn(6).setPreferredWidth(200);
		jtroom.getColumnModel().getColumn(7).setPreferredWidth(200);
		jtroom.getColumnModel().getColumn(8).setPreferredWidth(200);
		jtroom.getColumnModel().getColumn(9).setPreferredWidth(180);
		jtroom.getColumnModel().getColumn(10).setPreferredWidth(130);
		jtroom.getColumnModel().getColumn(11).setPreferredWidth(100);
		
	}
	
	
	
	//通过类型来查询
		public void addata(String type){
			 data = new Vector<Vector<Object>>();
			 action = new actionImp();
			 list = new ArrayList<History>();
			 list = action.queryjilubytype(type);
			 Vector<Object> v;
			 for (int i = 0; i < list.size(); i++) {
				v = new Vector<Object>();
				  v.add(list.get(i).getId());
				  v.add(list.get(i).getHname());
				  v.add(list.get(i).getHcard());
				  v.add(list.get(i).getHtel());
				  v.add(list.get(i).getHrmno());
				  v.add(list.get(i).getHtype());
				  v.add(list.get(i).getHydate());
				  v.add(list.get(i).getHyedate());
				  v.add(list.get(i).getHdate());
				  v.add(list.get(i).getHedate());
				  v.add(list.get(i).getHallfee());
				  v.add(list.get(i).getHshijian());
				  data.add(v);
			}
			 
			  vecHeader = new Vector<String>();
			  vecHeader.add("行号");
			  vecHeader.add("姓名");
			  vecHeader.add("身份证号");
			  vecHeader.add("电话");
			  vecHeader.add("入住的房间号");
			  vecHeader.add("房间类型");
			  vecHeader.add("预定房间时间");
			  vecHeader.add("退订房间的时间");
			  vecHeader.add("入住时间");
			  vecHeader.add("退房时间");
			  vecHeader.add("总的消费(元)");
			  vecHeader.add("事件");
			 
	}
	
	
	
	
	//通过房间号查询
	public void addata(int rmno){
		 data = new Vector<Vector<Object>>();
		 action = new actionImp();
		 list = new ArrayList<History>();
		 list = action.queryjilu(rmno);
		 Vector<Object> v;
		 for (int i = 0; i < list.size(); i++) {
			v = new Vector<Object>();
			  v.add(list.get(i).getId());
			  v.add(list.get(i).getHname());
			  v.add(list.get(i).getHcard());
			  v.add(list.get(i).getHtel());
			  v.add(list.get(i).getHrmno());
			  v.add(list.get(i).getHtype());
			  v.add(list.get(i).getHydate());
			  v.add(list.get(i).getHyedate());
			  v.add(list.get(i).getHdate());
			  v.add(list.get(i).getHedate());
			  v.add(list.get(i).getHallfee());
			  v.add(list.get(i).getHshijian());
			  data.add(v);
		}
		 
		  vecHeader = new Vector<String>();
		  vecHeader.add("行号");
		  vecHeader.add("姓名");
		  vecHeader.add("身份证号");
		  vecHeader.add("电话");
		  vecHeader.add("入住的房间号");
		  vecHeader.add("房间类型");
		  vecHeader.add("预定房间时间");
		  vecHeader.add("退订房间的时间");
		  vecHeader.add("入住时间");
		  vecHeader.add("退房时间");
		  vecHeader.add("总的消费(元)");
		  vecHeader.add("事件");
		 
}
	//查询所有的记录
	 public void addata(){
		 data = new Vector<Vector<Object>>();
		 action = new actionImp();
		 list = new ArrayList<History>();
		 list = action.queryalljilu();
		 Vector<Object> v;
		 for (int i = 0; i < list.size(); i++) {
				v = new Vector<Object>();
				  v.add(list.get(i).getId());
				  v.add(list.get(i).getHname());
				  v.add(list.get(i).getHcard());
				  v.add(list.get(i).getHtel());
				  v.add(list.get(i).getHrmno());
				  v.add(list.get(i).getHtype());
				  v.add(list.get(i).getHydate());
				  v.add(list.get(i).getHyedate());
				  v.add(list.get(i).getHdate());
				  v.add(list.get(i).getHedate());
				  v.add(list.get(i).getHallfee());
				  v.add(list.get(i).getHshijian());
				  data.add(v);
			}
		  vecHeader = new Vector<String>();
		  vecHeader.add("行号");
		  vecHeader.add("姓名");
		  vecHeader.add("身份证号");
		  vecHeader.add("电话");
		  vecHeader.add("入住的房间号");
		  vecHeader.add("房间类型");
		  vecHeader.add("预定房间时间");
		  vecHeader.add("退订房间的时间");
		  vecHeader.add("入住时间");
		  vecHeader.add("退房时间");
		  vecHeader.add("总的消费");
		  vecHeader.add("事件"); 
		 
}


	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jbchaxun)) {
			String reg = "^[1-3]{1}[0-9]{1}[0-9]{1}$";
//			String reg1 = "^[单人间]|[双人间]|[电脑房]$";
		    String rmno1 = chaxun.getText();
			if (rmno1.matches(reg)) {
				int rmno = Integer.valueOf(rmno1);
				addata(rmno);
				dtm = new DefaultTableModel(data,vecHeader);
				jtroom.setModel(dtm);
				jtroom.updateUI();	
				jtroom.setRowHeight(30);
				setwidth();
			}else if(rmno1.equals("单人间")||rmno1.equals("双人间")||rmno1.equals("电脑房")){
				addata(rmno1);
				dtm = new DefaultTableModel(data,vecHeader);
				jtroom.setModel(dtm);
				jtroom.updateUI();	
				jtroom.setRowHeight(30);
				setwidth();
			}else {
				addata();
				dtm = new DefaultTableModel(data,vecHeader);
				jtroom.setModel(dtm);
				jtroom.updateUI();	
				jtroom.setRowHeight(30);
				setwidth();
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
		}
    }
	public static void main(String[] args) {
		JiLuFrame j = new JiLuFrame(null);
	}
}
