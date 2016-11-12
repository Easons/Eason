package UI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Client;
import entity.Room;
import entity.Vip;

import action.actionImp;
/**
 * 结账
 * 客户姓名
 * 客户身份证
 * 客户电话
 * 客户所在房间号
 * 客户餐费
 * 客户住房的时长
 * 客户房费
 * 客户总的费用
 * 
 * @author p
 *
 */
public class JieZhang extends JFrame implements ActionListener{
	actionImp action;
	int allfee;
	double allday = 0;
	private Room r;
	private Client c;
	private Vip v;
	private Date a;
	private Date b;
	String newtime;
	private Time c1;
	JPanel main = new JPanel();
	
	JLabel xianshitime = new JLabel();
	JLabel jl = new JLabel("请输入要结账的房间号：");
	JLabel tishiname = new JLabel("姓名：");
	JLabel tishicard = new JLabel("身份证：");
	JLabel tishitel = new JLabel("电话：");
	JLabel tishirmno = new JLabel("房间号：");
	JLabel tishiruzhu = new JLabel("入住时间");
	JLabel tishicanfei = new JLabel("餐费：");
	JLabel tishishichang = new JLabel("住房时长：");
	JLabel tishifangfei = new JLabel("房费：");
	JLabel tishizongfei = new JLabel("总的费用：");
	JLabel tishituifang = new JLabel("退房时间");
	JLabel tishiroomprice = new JLabel("房间价格");
	JLabel tishitype = new JLabel("房间类型");
	
	JLabel jltuifangtime = new JLabel();
	JLabel jlname = new JLabel();
	JLabel jlcard = new JLabel();
	JLabel jltel = new JLabel();
	JLabel jlrmno = new JLabel();
	JLabel jlruzhu = new JLabel();
	JLabel jlcanfei = new JLabel();
	JLabel jlshichang = new JLabel();
	JLabel jlfangfei = new JLabel();
	JLabel jlzongfei = new JLabel();
	JLabel jlqian = new JLabel("实际收钱：");
	JLabel jlroomprice = new JLabel();
	JLabel jltype = new JLabel();
	
	JTextField jf = new JTextField(10);
	JTextField jfshouqian = new JTextField(10);
	
	JButton jbtuifang = new JButton("退房");
	JButton jbjiezhang = new JButton("结账");
	JButton jbfanhui = new JButton("返回");
	JButton jbsousuo = new JButton("搜索");
	
	public JieZhang() {
		Init();
	}

	//初始化窗体
	private void Init() {
		this.setTitle("结账界面");
		this.setLayout(null);
		this.setSize(900,700);
		
		//this.setDefaultLookAndFeelDecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		main();
		main.setVisible(true);
		this.setVisible(true);	
	}
	
	//设置标签的字体
	 public void setfont(JLabel j){
		   Font font=new Font("Monospaced",Font.BOLD,17);
		   j.setFont(font);
	   }

	private void main() {
		main.setLayout(null);
		main.setSize(900,700);
		
		
		new Timer().schedule(new TimerTask() {
			public void run() {
				 a = new java.util.Date();
				 b = new java.sql.Date(a.getTime());
				 c1 = new java.sql.Time(a.getTime());
				xianshitime.setText("北京时间："+b+" "+c1);
				
			}
		},0,1000);
		
		setfont(tishituifang);
		setfont(xianshitime);
		setfont(jlruzhu);
		setfont(tishiruzhu);
		setfont(jlqian);
		setfont(jl);
		setfont(tishiname);
		setfont(tishicanfei);
		setfont(tishicard);
		setfont(tishifangfei);
		setfont(tishishichang);
		setfont(tishitel);
		setfont(tishizongfei);
		setfont(tishirmno);
		setfont(tishiroomprice);
		setfont(tishitype);
		
		
		setfont(jltype);
		setfont(jltuifangtime);
		setfont(jlname);
		setfont(jlcanfei);
		setfont(jlcard);
		setfont(jlfangfei);
		setfont(jlshichang);
		setfont(jltel);
		setfont(jlzongfei);
		setfont(jlrmno);
		setfont(jlroomprice);
		
		jl.setBounds(70,50,200,30);
		jf.setBounds(290,50,200, 30);
		
		
		
		
		xianshitime.setBounds(260,10,330,30);
		
		//设置提示的位置
		tishiname.setBounds(80,110,100,30);
		tishicard.setBounds(80,155,100,30);
		tishitel.setBounds(80,200,100,30);
		tishirmno.setBounds(80,245,100,30);
		tishiruzhu.setBounds(80, 290,100,30);
		tishituifang.setBounds(80,335,100,30);
		tishishichang.setBounds(80,380,100,30);
		tishiroomprice.setBounds(80,425,100,30);
		tishicanfei.setBounds(80,470,100,30);
		tishifangfei.setBounds(80,515,100,30);
		tishizongfei.setBounds(80,560,150,30);
		tishitype.setBounds(600,150,100,30);
		
		
		jlname.setBounds(300,110,100,30);
		jlcard.setBounds(300,155,200,30);
		jltel.setBounds(300,200,150,30);
		jlrmno.setBounds(300,245,100,30);
		jlruzhu.setBounds(300,290,200,30);
		jltuifangtime.setBounds(300,335,200,30);
		jlshichang.setBounds(300,380,180,30);
		jlroomprice.setBounds(300,425,150,30);
		jlcanfei.setBounds(300,470,100,30);
		jlfangfei.setBounds(300,515,250,30);
		jlzongfei.setBounds(300,560,150,30);
	    jltype.setBounds(750,150,100,30);
		
		jlqian.setBounds(680,350,140,30);
		jfshouqian.setBounds(660,400,150,30);
		
		jbtuifang.setBounds(680,45,80,40);
		jbsousuo.setBounds(540,45,80,40);
		jbfanhui.setBounds(680,530,80 ,40);
		jbjiezhang.setBounds(680,450,80,40);
		
		jbfanhui.addActionListener(this);
		jbjiezhang.addActionListener(this);
		jbsousuo.addActionListener(this);
		jbtuifang.addActionListener(this);
		
		main.add(tishitype);
		main.add(tishituifang);
		main.add(jltype);
		main.add(jltuifangtime);
		main.add(jbtuifang);
		main.add(jlruzhu);
		main.add(tishiruzhu);
		main.add(jfshouqian);
		main.add(jlqian);
		main.add(jlname);
		main.add(jlcard);
		main.add(jltel);
		main.add(jlcanfei);
		main.add(jlfangfei);
		main.add(jlzongfei);
		main.add(jlrmno);
		main.add(jlshichang);
		main.add(jlroomprice);
		
		main.add(xianshitime);
		main.add(tishiname);
		main.add(tishicard);
		main.add(tishitel);
		main.add(tishicanfei);
		main.add(tishifangfei);
		main.add(tishizongfei);
		main.add(tishirmno);
		main.add(tishishichang);
		main.add(tishiroomprice);
		
		main.add(jbsousuo);
		main.add(jbfanhui);
		main.add(jbjiezhang);
		main.add(jf);
		main.add(jl);
		
		this.add(main);
		
	}
	
	
	//清空标签信息
	public void clearascree(){
		jlname.setText(null);
		jlcard.setText(null);
		jltel.setText(null);
		jlrmno.setText(null);;
		jlruzhu.setText(null);
		jlcanfei.setText(null);
		jlshichang.setText(null);
		jlfangfei.setText(null);
		jlzongfei.setText(null);
		jltuifangtime.setText(null);
		jlroomprice.setText(null);
		jfshouqian.setText(null);
		jf.setText(null);
	}

	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jbsousuo)) {
			action = new actionImp();
			//clearascree();
			int rmno = Integer.valueOf((String)jf.getText());
			//搜房间的价格
		    r = new Room();
			r = action.roomprice(rmno);
			
			v = new Vip();
		    c = new Client();
			c = action.queryclient(rmno);
			action = new actionImp();
			v = action.queryvip(rmno);
			if (c.getRmno()!=0) {
			jlname.setText(c.getCnamne());
			
			
			System.out.println(c.getCcard());
			String str = c.getCcard().substring(7,14);
			String str1 = c.getCcard().replace(str, "******");
			
			jlcard.setText(str1);
			jltel.setText(String.valueOf(c.getRtel()));
			jlrmno.setText(String.valueOf(c.getRmno()));
			jlcanfei.setText(String.valueOf(c.getCfee()));
			jlruzhu.setText(c.getCdate());
			jlroomprice.setText(String.valueOf(r.getRmprice()));
			jltype.setText(r.getRmtype());
				
		 }else if (v.getRmno()!=0&&!v.getVdate().equals("空")) {
			 jlname.setText(v.getVname());
			 
			 String str = v.getVcard().substring(6,14);
			 String str1 = v.getVcard().replace(str, "********");
			 
			 jlcard.setText(str1);
			 jltel.setText(String.valueOf(v.getTel()));
			 jlrmno.setText(String.valueOf(v.getRmno()));
			 jlcanfei.setText(String.valueOf(v.getVfee()));
			 jlruzhu.setText(v.getVdate());
			 jlroomprice.setText(String.valueOf(r.getVprice())+"(会员价)");
			 jltype.setText(r.getRmtype());
		}else {
			JOptionPane.showMessageDialog(null, "没有您搜索的房间信息");
		}
				
	  }else if (e.getSource().equals(jbtuifang)) {
			if (c.getRmno()!=0) {
				
				//设置退房时间可现
				jltuifangtime.setText(b+" "+c1);
				String oldtime = c.getCdate();

			    newtime = ""+b+" "+c1;
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				double nd = 1000*24*60*60;//一天的毫秒数
				double nh = 1000*60*60;//一小时的毫秒数
				double nm = 1000*60;//一分钟的毫秒数
				double ns = 1000;//一秒钟的毫秒数
				allday = 0;
				double diff;
				try {
					diff = sd.parse(newtime).getTime() - sd.parse(oldtime).getTime();
					double day = diff/nd;//计算差多少天
					double hour = diff%nd/nh;//计算差多少小时
					double min = diff%nd%nh/nm;//计算差多少分钟
					double sec = diff%nd%nh%nm/ns;//计算差多少秒//输出结果
					allday = day;
					
	   
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				int day1 = (int)allday;
				double day2 = allday-day1;
				if (day2>0) {
					allday = day1+1;
				}
				
			    allfee = (int) (c.getCfee()+(r.getRmprice()*allday));
				
				//设置时长可现
				jlshichang.setText(String.valueOf(allday+"天"));
				jlfangfei.setText(String.valueOf(r.getRmprice()*allday)+"(不足一天按一天算)");
				jlzongfei.setText(String.valueOf(allfee));
			}else if(v.getRmno()!=0) {
				   
				   System.out.println(v.getVdate());
				
				
				
				    jltuifangtime.setText(b+" "+c1); 
					String oldtime = v.getVdate();
				    newtime = ""+b+" "+c1;
				    allday = 0;
					SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					double nd = 1000*24*60*60;//一天的毫秒数
					double nh = 1000*60*60;//一小时的毫秒数
					double nm = 1000*60;//一分钟的毫秒数
					double ns = 1000;//一秒钟的毫秒数long diff;try {
					double diff;
					try {
						diff = sd.parse(newtime).getTime() - sd.parse(oldtime).getTime();
						double day = diff/nd;//计算差多少天
						double hour = diff%nd/nh;//计算差多少小时
						double min = diff%nd%nh/nm;//计算差多少分钟
						double sec = diff%nd%nh%nm/ns;//计算差多少秒//输出结果
						allday = day;
						
//						BigDecimal bg = new BigDecimal(day);
//						allday = bg.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
					} catch (ParseException e1) {
						e1.printStackTrace();
					};
					int day1 = (int)allday;
					double day2 = allday-day1;
					//设置时长可现
					if (day2>0) {
						allday = day1+1;
					}
					allfee = (int) (v.getVfee()+(r.getVprice()*allday));
					jlshichang.setText(String.valueOf(allday+"天"));
					jlfangfei.setText(String.valueOf(r.getVprice()*allday)+"(不足一天按一天算)");
					allfee = (int)(v.getVfee()+r.getVprice()*allday);
					jlzongfei.setText(String.valueOf(allfee));
			}else {
				JOptionPane.showMessageDialog(null, "该房间还没入住！");
			}
		}else if (e.getSource().equals(jbfanhui)) {
			new Empframe();
			dispose();
		}else if (e.getSource().equals(jbjiezhang)) {
			int money = 0;
			 money = Integer.valueOf(jfshouqian.getText());
			 if (c.getRmno()!=0) {
				if (money==0) {
					JOptionPane.showMessageDialog(null,"请输入客户所付金额");
				}else if (money	>=allfee) {
					action = new actionImp();
					boolean flag = action.addhistory(c.getCnamne(),c.getCcard(),c.getRtel(),c.getRmno(),r.getRmtype(),c.getCdate(),newtime,allfee,"退房");
						
					//更新普通客户所在房间
					boolean flag2 = action.updatetuifangroom(c.getRmno());				
					//删除普通客户的信息
					boolean flag1 = action.deleteclient(c.getCcard(),c.getRmno());
					
					
					JOptionPane.showMessageDialog(null,"找您"+(money-allfee+"元"));
					if (flag==true&&flag1==true&&flag2==true) {
						JOptionPane.showMessageDialog(null, "欢迎下次光临！");	
						clearascree();
					}
					
				}else {
					JOptionPane.showMessageDialog(null,"您输入的金额不够支付");
				}
			}else if (v.getRmno()!=0) {
				
				if (money==0) {
					JOptionPane.showMessageDialog(null,"请输入客户所付金额");
				}else if (money>=allfee) {
					JOptionPane.showMessageDialog(null,"找您"+((money-allfee)+"元"));
					action = new actionImp();
					boolean flag = action.addhistory(v.getVname(),v.getVcard(),v.getTel(),v.getRmno(),r.getRmtype(),v.getVdate(),newtime,allfee,"退房");
					//更新会员信息
					boolean flag1 = action.updatevip(v.getVcard(),v.getRmno());
					//更新普通客户所在房间
					boolean flag2 = action.updatetuifangroom(v.getRmno());
					
					if (flag==true&&flag1==true&&flag2==true) {
						JOptionPane.showMessageDialog(null, "欢迎下次光临！");	
						clearascree();
					}
					
				}else {
					JOptionPane.showMessageDialog(null,"您输入的金额不够支付");
				}
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		JieZhang j = new JieZhang();
//		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		long nd = 1000*24*60*60;//一天的毫秒数
//		long nh = 1000*60*60;//一小时的毫秒数
//		long nm = 1000*60;//一分钟的毫秒数
//		long ns = 1000;//一秒钟的毫秒数long diff;try {
//		//获得两个时间的毫秒时间差异
//		long diff;
//		try {
//			diff = sd.parse("2016-5-28 21:31:18").getTime() - sd.parse("2016-5-26 12:23:31").getTime();
//		   long day = diff/nd;//计算差多少天
//		   long hour = diff%nd/nh;//计算差多少小时
//		   long min = diff%nd%nh/nm;//计算差多少分钟
//		   long sec = diff%nd%nh%nm/ns;//计算差多少秒//输出结果
//		   System.out.println("时间相差："+day+"天"+hour+"小时"+min+"分钟"+sec+"秒。");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
		
		
		
		
	}
	
}
