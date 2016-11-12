package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entity.Client;
import entity.Room;
import entity.Vip;

import action.actionImp;

public class YuDingFrame extends JFrame implements ActionListener {
	
	Vip v;
	int vno;
	String vname;
	String putongname;
	String card;
	long tel;
	double ding;
	
	
	private actionImp action;
	
	JPanel main = new JPanel();
	JPanel xuanfang = new JPanel();
	JPanel jpputong = new JPanel();
	
	JScrollPane js ;
	private Vector<Vector<Object>> data;
	private Vector<String> vecHeader;
	TableModel dtm;
	List<Room> list;
	JTable jtroom;
	
	JComboBox jc = new JComboBox();
	//JComboBox jc1 = new JComboBox();
	
	JTextField jfyudingroom = new JTextField(8);
	JTextField jfhuiyuan = new JTextField(12);
	JTextField jfhuiyuanming = new JTextField(12);
	JTextField jfputongname = new JTextField(12);
	JTextField jfputongcard = new JTextField(12);
	JTextField jfputongtel = new JTextField(12);
	JTextField jfdingjin = new JTextField(12);
	

	JButton jbfanhuiputong = new JButton("返回普通客户界面");
	JButton jbshangyiceng = new JButton("返回VIP界面");
	JButton jbqueren = new JButton("确认预定");
	JButton jbhuiyuan = new JButton("会员预定");
	JButton jbputong = new JButton("散客预定");
	JButton jbfanhui = new JButton("返回");
	JButton jbchaxun = new JButton("查询");
	JButton jbyd = new JButton("预定房间");
	JButton jbputongfanhui = new JButton("返回");
	
	JLabel tishitel = new JLabel();
	JLabel tishicard = new JLabel();
	JLabel yonghuname = new JLabel("客户姓名：");
	JLabel yonghucard = new JLabel("客户身份证：");
	JLabel yonghutel = new JLabel("客户电话：");
	JLabel dingjin = new JLabel("请缴纳100元定金：");
	
	JLabel putong = new JLabel("普通客户预定");
	//JLabel huiyuantishi = new JLabel("会员预定区");
	JLabel jtime = new JLabel();
	JLabel jlhuiyuanroom = new JLabel("请输入要预定的房间号:");
	JLabel jlhuiyuanming = new JLabel("会员姓名:");
	JLabel jlhuiyuan = new JLabel("会员编号:");
	
	public YuDingFrame() {
		init();
	}

	 //修改标签大小
	 public void setfont(JLabel j){
		   Font font=new Font("Monospaced",Font.BOLD,18);
		   j.setFont(font);
	   }
	
	private void init() {
		this.setSize(800,700);
		this.setTitle("客房预定");
		this.setDefaultCloseOperation(Managerframe.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		main();
		select();
		putong();
		main.setVisible(true);
		jpputong.setVisible(false);
		xuanfang.setVisible(false);
		this.setVisible(true);
	}

	//普通客户的面板
	private void putong() {
		jpputong.setLayout(null);
		jpputong.setSize(700,600);
		
		setfont(putong);
		setfont(yonghuname);
		setfont(yonghucard);
		setfont(yonghutel);
		setfont(dingjin);
		
		
		yonghuname.setBounds(150,100,250,30);
		jfputongname.setBounds(300,100,200,30);
		
		jfputongcard.setBounds(300,180,200, 30);
		yonghucard.setBounds(150,180,150,30);
		
		jfputongcard.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				String reg = "^\\d{17}([0-9]|x|X{1})$";
				if (!jfputongcard.getText().toString().matches(reg)) {
					tishicard.setText("您的身份证输入有误或输入为空");
					tishicard.setForeground(Color.RED);
				}else {
					tishicard.setText("您的身份证可以使用");
					tishicard.setForeground(Color.GREEN);	
				}
			}
			public void focusGained(FocusEvent e) {
				tishicard.setText(null);			
			}
		});
		setfont(tishicard);
		tishicard.setBounds(520,180,280,30);
		
		jfputongtel.setBounds(300,280,200,30);
		yonghutel.setBounds(150,280,200,30);
		
		
		
		jfputongtel.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				String reg1 = "^((13[0-9])|(15[^4,\\D])|(18[0,1-9]))\\d{8}$";
			    if (!jfputongtel.getText().toString().matches(reg1)) {
			    	tishitel.setText("您的电话输入有误或输入为空");
					tishitel.setForeground(Color.RED);
				}else {
					tishitel.setText("您的电话可以使用");
					tishitel.setForeground(Color.GREEN);
				}
			}
			public void focusGained(FocusEvent e) {
				tishitel.setText(null);
				
			}
		});
		setfont(tishitel);
		tishitel.setBounds(510,280,250,30);
		
		
		jfdingjin.setBounds(300,350,200,30);
		dingjin.setBounds(120,350, 200,30);
		
		putong.setBounds(280,30,200,30);
		
		jbyd.setBounds(180,500,100,40);
		jbputongfanhui.setBounds(450,500,100,40);
		
		jbyd.addActionListener(this);
		jbputongfanhui.addActionListener(this);

		jpputong.add(tishitel);
		jpputong.add(tishicard);
		jpputong.add(jbyd);
		jpputong.add(jbputongfanhui);
		jpputong.add(jfputongcard);
		jpputong.add(jfputongname);
		jpputong.add(jfputongtel);
		jpputong.add(dingjin);
		jpputong.add(yonghuname);
		jpputong.add(yonghucard);
		jpputong.add(yonghutel);
		jpputong.add(jfdingjin);
		jpputong.add(putong);

		this.add(jpputong);
	}
	
	
	private void select() {
		xuanfang.setLayout(null);
		xuanfang.setSize(800,700);
		this.setTitle("房间预定");
		
		 new Timer().schedule(new TimerTask() {
				public void run() {
					Date b = new java.sql.Date(new java.util.Date().getTime());
					Time c = new java.sql.Time(new java.util.Date().getTime());
					jtime.setText("北京时间："+b+" "+c);
					
				}
			},0,1000);
		 Font font=new Font("Monospaced",Font.BOLD,20);
		 jtime.setFont(font);
		 
		jbshangyiceng.setBounds(320,610,130,40);
		jbchaxun.setBounds(540,10,100,30);
		jbqueren.setBounds(530,570,100,40);
		jbfanhuiputong.setBounds(100,610,140,40);
		
		jc.setBounds(400, 10,100,30);
		jc.addItem("全部房间");
		jc.addItem("单人间");
		jc.addItem("双人间");
		jc.addItem("电脑房");
		jc.setEditable(true);
		addata();
		dtm = new DefaultTableModel(data,vecHeader);


		
		jtroom = new JTable(dtm);
		jtroom.setRowHeight(30);
		js = new JScrollPane(jtroom);
		js.setBounds(30,50,750,500);
		

		jtroom.setFont(new Font("Menu.font", Font.PLAIN, 17));
		jtroom.getTableHeader().setFont(new Font("Dialog", 0, 19)); 
		
		jlhuiyuanroom.setFont(new Font("Menu.font", Font.PLAIN, 20));
		
		jfyudingroom.setBounds(250,570,200,30);
		jlhuiyuanroom.setBounds(30,575,230,20);
		jtime.setBounds(10,8,350,40);
		
		jbshangyiceng.addActionListener(this);
		jbchaxun.addActionListener(this);
		jbqueren.addActionListener(this);
		jbfanhuiputong.addActionListener(this);
		
		xuanfang.add(jbfanhuiputong);
		xuanfang.add(jbshangyiceng);
		xuanfang.add(jtime);
		xuanfang.add(jbqueren);
		xuanfang.add(jlhuiyuanroom);
		xuanfang.add(jfyudingroom);
		xuanfang.add(js);
		xuanfang.add(jbchaxun);
		xuanfang.add(jc);
		this.add(xuanfang);
		
	}

	public void main(){
		main.setLayout(null);
		main.setSize(700,600);
		jfhuiyuan.setBounds(300,110,150,30);
		jfhuiyuanming.setBounds(300,250,150,30);
		
		setfont(jlhuiyuan);
		setfont(jlhuiyuanming);
		
		jlhuiyuan.setBounds(200,100,300,50);
		jlhuiyuanming.setBounds(200,240,300,50);
		
		jbhuiyuan.setBounds(250,400,120,40);
		jbputong.setBounds(450,400,120,40);
		jbfanhui.setBounds(100,400, 100,40);
		
		jbfanhui.addActionListener(this);
		jbhuiyuan.addActionListener(this);
		jbputong.addActionListener(this);
		
		main.add(jbfanhui);
		main.add(jfhuiyuanming);
		main.add(jlhuiyuanming);
		main.add(jbputong);
		main.add(jbhuiyuan);
		main.add(jlhuiyuan);
		main.add(jfhuiyuan);
		
		this.add(main);
		
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
			  v.add(list.get(n).getRmbook());
			  v.add(list.get(n).getRmbuff());
			  data.add(v);
			  n++;
		}
		  vecHeader = new Vector<String>();
		  vecHeader.add("房间编号");
		  vecHeader.add("房间类型");
		  vecHeader.add("房间价格");
		  vecHeader.add("会员价格");	
		  vecHeader.add("预定情况");
		  vecHeader.add("入住情况");
		 
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
			  v.add(list.get(n).getRmbook());
			  v.add(list.get(n).getRmbuff());
			  data.add(v);
			  n++;
		}
		  vecHeader = new Vector<String>();
		  vecHeader.add("房间编号");
		  vecHeader.add("房间类型");
		  vecHeader.add("房间价格");
		  vecHeader.add("会员价格");
		  vecHeader.add("预定情况");
		  vecHeader.add("入住情况");
		 
 }

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jbhuiyuan)) {
		   v = new Vip();
		   vno = Integer.valueOf(jfhuiyuan.getText());
		   vname = jfhuiyuanming.getText();
		   action = new actionImp();
		   v = action.querybyid(vno, vname);
		  if (v.getVname()==null){
			JOptionPane.showMessageDialog(null,"您的会员号或名字错误");
		  }else {
			 jfhuiyuan.setText(null);
			 jfhuiyuanming.setText(null);
			 xuanfang.setVisible(true);
			 main.setVisible(false);
		}
		}else if (e.getSource().equals(jbfanhui)) {
			dispose();
			new Empframe();	  
         }else if (e.getSource().equals(jbchaxun)) {
			 String  type = jc.getSelectedItem().toString();
			 if (type.equals("全部房间")) {
				addata();
				dtm = new DefaultTableModel(data,vecHeader);
				jtroom.setModel(dtm);
				jtroom.updateUI();	
				jtroom.setRowHeight(30);
			}else{
				addata(type);
				dtm = new DefaultTableModel(data,vecHeader);
				jtroom.setModel(dtm);
				jtroom.updateUI();	
				jtroom.setRowHeight(30);
			}
			 for (int i = 0; i < data.size(); i++) {
				 for (int j = 0; j < data.get(i).size(); j++) {
						dtm.setValueAt(data.get(i).get(j), i, j);
					}
				}
         }else if (e.getSource().equals(jbshangyiceng)) {
        	 xuanfang.setVisible(false);
			 main.setVisible(true);
			 
		}else if (e.getSource().equals(jbqueren)) {
		   String rmno1 = jfyudingroom.getText();
		   
		   if (rmno1.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入要预定的房间号");
		  }else{
			  
			int rmno = Integer.valueOf(rmno1);
			int n = JOptionPane.showConfirmDialog(null, "确定预定吗？", "提示框",JOptionPane.YES_NO_OPTION);
			if (n==0) {
			    action = new actionImp();
			    Room r = new Room();
			    r = action.queryroomtype(rmno);
			    Date b = new java.sql.Date(new java.util.Date().getTime());
			    Time c = new java.sql.Time(new java.util.Date().getTime());
			    String newtime = ""+b+" "+c;
			    if (vno==0) {
			    	Client client = new Client();
			    	client = action.queryclient(putongname,tel);
			    	if (client.getCnamne()==null) {
						boolean flag = action.putongyuding(rmno,putongname,tel,card,ding);
						if (flag) {
							//更新房间记录
							boolean flag1 = action.updateroom(rmno,newtime);
							//订房间添加历史记录
						boolean flag2 = action.addYuDinghistory(putongname,card,tel,rmno,r.getRmtype(),newtime,"预定房间");
							if (flag1==true&&flag2==true) {
							   JOptionPane.showMessageDialog(null,"预定成功");
							   JOptionPane.showMessageDialog(null, "请于两天内入住，超过时间将自动取消预定");
							   JOptionPane.showMessageDialog(null, "预定时间为:"+newtime);
							    }
						     }
					      }else {
						          JOptionPane.showMessageDialog(null,"该客户已经预定房间，不可重复预定");
					            }
					           jfyudingroom.setText(null);
				}else {		
					Vip v = new Vip();
					v = action.queryvip(vno,vname);
					if (v.getRmno()!=0) {
						JOptionPane.showMessageDialog(null,"该会员已经预定房间或入住房间");
						xuanfang.setVisible(false);
						main.setVisible(true);
					}else{
						boolean flag = action.vipyuding(vno,vname,rmno);
						if (flag) {
							action = new actionImp();
							boolean flag2 = action.addYuDinghistory(v.getVname(),v.getVcard(),v.getTel(),rmno,r.getRmtype(),newtime,"预定房间");
							boolean flag1 = action.updateroom(rmno,newtime);
							if (flag1==true&&flag2==true) {
					
								JOptionPane.showMessageDialog(null,"预定成功");
								JOptionPane.showMessageDialog(null, "请于两天内入住，超过时间将自动取消预定");
								JOptionPane.showMessageDialog(null, "预定时间为:"+newtime);					
							}
						}
						jfyudingroom.setText(null);
					}
				}
			}
			
			
			
		}
		   
		   
           }else if (e.getSource().equals(jbputong)) {
        	   jpputong.setVisible(true);
        	   main.setVisible(false);
		   }else if(e.getSource().equals(jbputongfanhui)){
			   jpputong.setVisible(false); 
			   main.setVisible(true);	    
		  }else if (e.getSource().equals(jbyd)) {
			  putongname = jfputongname.getText();
			  card = jfputongcard.getText();
			  tel = Long.valueOf(jfputongtel.getText());
			  ding= Double.valueOf(jfdingjin.getText());
			  
			  jfputongname.setText(null);
			  jfputongcard.setText(null);
			  jfputongtel.setText(null);
			  jfdingjin.setText(null);
			  tishicard.setText(null);
			  tishitel.setText(null);
			  xuanfang.setVisible(true);
			  jpputong.setVisible(false);
		}else if (e.getSource().equals(jbfanhuiputong)) {
			xuanfang.setVisible(false);
			jpputong.setVisible(true);
		}
		    
		    
		
}
	
	
	
	
	public static void main(String[] args) {
		YuDingFrame y = new YuDingFrame();
	}
}
