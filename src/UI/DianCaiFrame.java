package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import action.actionImp;
import entity.Client;
import entity.Menus;
import entity.Vip;

public class DianCaiFrame extends JFrame implements ActionListener{

	private actionImp action;
    private Empframe mf;
    
	JPanel menus = new JPanel();
	
	
    private TableModel dtm;
	JScrollPane jsp;
	private Vector<Vector<Object>> data;
	private Vector<String> vecHeader;
	private List<Menus> list;
	private JTable jtmenus;
	
	
	private JTextField jfroom = new JTextField("�ڴ�����ͻ��ķ���ţ�");
	private JTextField chaxun = new JTextField("������Ҫ��ѯ�Ĳ�����");
	 
	
	JLabel jlroom = new JLabel("������Ҫ�����Ŀͻ�����ţ�");
	JLabel jldiancai = new JLabel("��˲�ѯ��");
	
	private JButton jbchaxun = new JButton("��ѯ");
	private JButton jbfanhui = new JButton("����");
	private JButton jbqueren = new JButton("ȷ��");
	
	public DianCaiFrame(Empframe mf) {
		this.mf = mf;
		  init();
	}
	private void init() {
		   this.setLayout(null);
		   this.setSize(850,700);
		   this.setTitle("�˵�����");
		   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.setLocationRelativeTo(null);
		   //��������ı䴰��Ĵ�С
		   this.setResizable(false);
		   
           menus();
           this.setVisible(true);
           menus.setVisible(true);
		
	}
	
	
	private void menus(){
		    Font font=new Font("Monospaced",Font.BOLD,18);//���������ʽ�ʹ�С
		    jldiancai.setForeground(Color.BLACK);//����ǰ��ɫ
		    jldiancai.setFont(font);
		    menus.setLayout(null);
		    this.setTitle("�˵�����");

		    jldiancai.setBounds(180,10,100,30);
		    chaxun.setBounds(280,10,180,30);
		    jbchaxun.setBounds(480,9,100,30);
		    jbfanhui.setBounds(600,10,100,30);
		    
		    
		    jlroom.setBounds(30,600,300,30);
		    jlroom.setFont(font);
		    
		    jfroom.setBounds(280,600,220,30);
		    jbqueren.setBounds(530,590,100,40);
		    
		    jbqueren.addActionListener(this);
			jbfanhui.addActionListener(this);
			jbchaxun.addActionListener(this);
			
			
			jfroom.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent arg0) {
//					if (jfroom.getText().equals("")) {
//						jfroom.setText("�ڴ�����ͻ��ķ���ţ�");
//					}
					
				}
				public void focusGained(FocusEvent arg0) {
					if (jfroom.getText().equals("�ڴ�����ͻ��ķ���ţ�")) {
						jfroom.setText(null);
					}		
					
				}
			});
			
			
			chaxun.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
//					if (chaxun.getText().equals("")) {
//						chaxun.setText("������Ҫ��ѯ�Ĳ�����");
//					}
										
				}
				public void focusGained(FocusEvent e) {
					if (chaxun.getText().equals("������Ҫ��ѯ�Ĳ�����")) {
						chaxun.setText(null);
					}		
				}
			});
			
			
			
			jbchaxun.setPreferredSize(new Dimension(90,40));
			jbfanhui.setPreferredSize(new Dimension(90,40));
		
			
		    menus.setSize(850,700);
		    
		    addata();
			dtm = new DefaultTableModel(data,vecHeader);

			
			
			jtmenus = new JTable(dtm);
			jtmenus.setRowHeight(30);
			
			jtmenus.setFont(new Font("Menu.font", Font.PLAIN, 17));
			jtmenus.getTableHeader().setFont(new Font("Dialog", 0, 19));
			
			//��Ӹ�ѡ��
			setcheckbox();
			
			
			
			jsp = new JScrollPane(jtmenus);
			jsp.setBounds(20,50,800,500);

			menus.add(jbqueren);
			menus.add(jfroom);
			menus.add(jlroom);
			menus.add(jbqueren);
			menus.add(jbfanhui);
			menus.add(jldiancai);
			menus.add(chaxun);
			menus.add(jbchaxun);
			menus.add(jsp);
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
		  vecHeader.add("ʳƷ���");
		  vecHeader.add("ʳƷ����");
		  vecHeader.add("ʳƷ�۸�");
		  vecHeader.add("ʳƷ��Ա��");
		  vecHeader.add("ѡ��ķ���");
		  vecHeader.add("��ѡ��");
		  
		 
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
		  vecHeader.add("ʳƷ���");
		  vecHeader.add("ʳƷ����");
		  vecHeader.add("ʳƷ�۸�");
		  vecHeader.add("ʳƷ��Ա��");  
		  vecHeader.add("ѡ��ķ���");
		  vecHeader.add("��ѡ��");
		  
		 
}

	 
	 public void setcheckbox(){
//		 Vector item = new Vector();
//		    item.add("1");
//		    item.add("2");
//		    item.add("3");
//		    item.add("4");
//		    item.add("5");
		 String [] item = {"1","2","3","4","5"};
		 JComboBox JComboBoxItem = new JComboBox(item);
         TableColumn  brandColumn = jtmenus.getColumnModel().getColumn(4);
         brandColumn.setCellEditor(new DefaultCellEditor(JComboBoxItem)); 
			
         jtmenus.getColumnModel().getColumn(5).setCellRenderer(new TableCellRenderer() {

				public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
						int row, int column) {
					JCheckBox ck = new JCheckBox();
					ck.setSelected(isSelected);
					ck.setHorizontalAlignment((int)0.5f);
					return ck;
					
				}
			});
 
	 }
	 
	 

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jbchaxun)) {
			String mname = chaxun.getText();
			if (mname.equals("")||mname.equals("������Ҫ��ѯ�Ĳ���")) {
				addata();
				dtm = new DefaultTableModel(data,vecHeader);
				
				jtmenus.setModel(dtm);
				jtmenus.updateUI();	
				jtmenus.setRowHeight(30);
				 setcheckbox();
				
			}else{
				addata(mname);
				dtm = new DefaultTableModel(data,vecHeader){
					public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
							int row, int column) {
						JCheckBox ck = new JCheckBox();
						ck.setSelected(isSelected);
						ck.setHorizontalAlignment((int)0.5f);
						return ck;
						
					}	
					
				};
				jtmenus.setModel(dtm);
				jtmenus.updateUI();	
				jtmenus.setRowHeight(30);
				
				
				setcheckbox();
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
		}else if (e.getSource().equals(jbqueren)) {
			Vip v = new Vip();
			Client c = new Client();
			int rmno = 0;
		    
			action = new actionImp();
			if (jfroom.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "������Ҫ�����ķ����");
			}else {
			   rmno = Integer.valueOf(jfroom.getText());
			   v = action.queryvip(rmno);
			   c = action.queryclient(rmno);
			   int n1 = -1;
			   //n1 = jtmenus.getRowCount();
			   
			  double  allfee = 0;
			  if (jtmenus.getSelectedRowCount()==0) {
				 JOptionPane.showMessageDialog(null, "��ѡ������ҪʳƷ");
			}else {   
				   if (v.getRmno()!=0&&!v.getVdate().equals("��")) {
					   //һ����Ǯ
					   for(int rowindex : jtmenus.getSelectedRows()){
						    allfee+= (Double) jtmenus.getValueAt(rowindex, 3)* Double.valueOf((String)jtmenus.getValueAt(rowindex, 4));
					   }
					   JOptionPane.showMessageDialog(null, "һ�����"+allfee);
					   
					   
					  action = new actionImp();
					  int n = JOptionPane.showConfirmDialog(null, "ȷ�������", "��ʾ��",JOptionPane.YES_NO_OPTION);
					  if (n==0) {
						//���²ͷ�
					  boolean flag = action.updatevipvfee(v.getRmno(),allfee);
					  if (flag) {
						JOptionPane.showMessageDialog(null, "��ͳɹ�");
					    }
					}
				   }else if (c.getRmno()!=0&&!c.getCdate().equals("��")) {
					   
					   
					   for(int rowindex : jtmenus.getSelectedRows()){
						    allfee+= (Double) jtmenus.getValueAt(rowindex, 2)*Double.valueOf((String)jtmenus.getValueAt(rowindex, 4));
					   }
					   JOptionPane.showMessageDialog(null, "һ�����"+allfee);
					   
					  
					  int n = JOptionPane.showConfirmDialog(null, "ȷ�������", "��ʾ��",JOptionPane.YES_NO_OPTION);
					  if (n==0) {
						//���²ͷ�
					  boolean flag = action.updateclientcfee(c.getRmno(),allfee);
					  if (flag) {
						JOptionPane.showMessageDialog(null, "��ͳɹ�");
					    }
				   } 	  
			   }else {
					     JOptionPane.showMessageDialog(null, "���������д�");
				         }
			}
			  
			   
		  }			  
		}
    }
	public static void main(String[] args) {
		DianCaiFrame d = new DianCaiFrame(null);

		
		
	}
	
	

	
}
