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
 * ����
 * �ͻ�����
 * �ͻ����֤
 * �ͻ��绰
 * �ͻ����ڷ����
 * �ͻ��ͷ�
 * �ͻ�ס����ʱ��
 * �ͻ�����
 * �ͻ��ܵķ���
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
	JLabel jl = new JLabel("������Ҫ���˵ķ���ţ�");
	JLabel tishiname = new JLabel("������");
	JLabel tishicard = new JLabel("���֤��");
	JLabel tishitel = new JLabel("�绰��");
	JLabel tishirmno = new JLabel("����ţ�");
	JLabel tishiruzhu = new JLabel("��סʱ��");
	JLabel tishicanfei = new JLabel("�ͷѣ�");
	JLabel tishishichang = new JLabel("ס��ʱ����");
	JLabel tishifangfei = new JLabel("���ѣ�");
	JLabel tishizongfei = new JLabel("�ܵķ��ã�");
	JLabel tishituifang = new JLabel("�˷�ʱ��");
	JLabel tishiroomprice = new JLabel("����۸�");
	JLabel tishitype = new JLabel("��������");
	
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
	JLabel jlqian = new JLabel("ʵ����Ǯ��");
	JLabel jlroomprice = new JLabel();
	JLabel jltype = new JLabel();
	
	JTextField jf = new JTextField(10);
	JTextField jfshouqian = new JTextField(10);
	
	JButton jbtuifang = new JButton("�˷�");
	JButton jbjiezhang = new JButton("����");
	JButton jbfanhui = new JButton("����");
	JButton jbsousuo = new JButton("����");
	
	public JieZhang() {
		Init();
	}

	//��ʼ������
	private void Init() {
		this.setTitle("���˽���");
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
	
	//���ñ�ǩ������
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
				xianshitime.setText("����ʱ�䣺"+b+" "+c1);
				
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
		
		//������ʾ��λ��
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
	
	
	//��ձ�ǩ��Ϣ
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
			//�ѷ���ļ۸�
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
				
		 }else if (v.getRmno()!=0&&!v.getVdate().equals("��")) {
			 jlname.setText(v.getVname());
			 
			 String str = v.getVcard().substring(6,14);
			 String str1 = v.getVcard().replace(str, "********");
			 
			 jlcard.setText(str1);
			 jltel.setText(String.valueOf(v.getTel()));
			 jlrmno.setText(String.valueOf(v.getRmno()));
			 jlcanfei.setText(String.valueOf(v.getVfee()));
			 jlruzhu.setText(v.getVdate());
			 jlroomprice.setText(String.valueOf(r.getVprice())+"(��Ա��)");
			 jltype.setText(r.getRmtype());
		}else {
			JOptionPane.showMessageDialog(null, "û���������ķ�����Ϣ");
		}
				
	  }else if (e.getSource().equals(jbtuifang)) {
			if (c.getRmno()!=0) {
				
				//�����˷�ʱ�����
				jltuifangtime.setText(b+" "+c1);
				String oldtime = c.getCdate();

			    newtime = ""+b+" "+c1;
				SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				double nd = 1000*24*60*60;//һ��ĺ�����
				double nh = 1000*60*60;//һСʱ�ĺ�����
				double nm = 1000*60;//һ���ӵĺ�����
				double ns = 1000;//һ���ӵĺ�����
				allday = 0;
				double diff;
				try {
					diff = sd.parse(newtime).getTime() - sd.parse(oldtime).getTime();
					double day = diff/nd;//����������
					double hour = diff%nd/nh;//��������Сʱ
					double min = diff%nd%nh/nm;//�������ٷ���
					double sec = diff%nd%nh%nm/ns;//����������//������
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
				
				//����ʱ������
				jlshichang.setText(String.valueOf(allday+"��"));
				jlfangfei.setText(String.valueOf(r.getRmprice()*allday)+"(����һ�찴һ����)");
				jlzongfei.setText(String.valueOf(allfee));
			}else if(v.getRmno()!=0) {
				   
				   System.out.println(v.getVdate());
				
				
				
				    jltuifangtime.setText(b+" "+c1); 
					String oldtime = v.getVdate();
				    newtime = ""+b+" "+c1;
				    allday = 0;
					SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					double nd = 1000*24*60*60;//һ��ĺ�����
					double nh = 1000*60*60;//һСʱ�ĺ�����
					double nm = 1000*60;//һ���ӵĺ�����
					double ns = 1000;//һ���ӵĺ�����long diff;try {
					double diff;
					try {
						diff = sd.parse(newtime).getTime() - sd.parse(oldtime).getTime();
						double day = diff/nd;//����������
						double hour = diff%nd/nh;//��������Сʱ
						double min = diff%nd%nh/nm;//�������ٷ���
						double sec = diff%nd%nh%nm/ns;//����������//������
						allday = day;
						
//						BigDecimal bg = new BigDecimal(day);
//						allday = bg.setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
					} catch (ParseException e1) {
						e1.printStackTrace();
					};
					int day1 = (int)allday;
					double day2 = allday-day1;
					//����ʱ������
					if (day2>0) {
						allday = day1+1;
					}
					allfee = (int) (v.getVfee()+(r.getVprice()*allday));
					jlshichang.setText(String.valueOf(allday+"��"));
					jlfangfei.setText(String.valueOf(r.getVprice()*allday)+"(����һ�찴һ����)");
					allfee = (int)(v.getVfee()+r.getVprice()*allday);
					jlzongfei.setText(String.valueOf(allfee));
			}else {
				JOptionPane.showMessageDialog(null, "�÷��仹û��ס��");
			}
		}else if (e.getSource().equals(jbfanhui)) {
			new Empframe();
			dispose();
		}else if (e.getSource().equals(jbjiezhang)) {
			int money = 0;
			 money = Integer.valueOf(jfshouqian.getText());
			 if (c.getRmno()!=0) {
				if (money==0) {
					JOptionPane.showMessageDialog(null,"������ͻ��������");
				}else if (money	>=allfee) {
					action = new actionImp();
					boolean flag = action.addhistory(c.getCnamne(),c.getCcard(),c.getRtel(),c.getRmno(),r.getRmtype(),c.getCdate(),newtime,allfee,"�˷�");
						
					//������ͨ�ͻ����ڷ���
					boolean flag2 = action.updatetuifangroom(c.getRmno());				
					//ɾ����ͨ�ͻ�����Ϣ
					boolean flag1 = action.deleteclient(c.getCcard(),c.getRmno());
					
					
					JOptionPane.showMessageDialog(null,"����"+(money-allfee+"Ԫ"));
					if (flag==true&&flag1==true&&flag2==true) {
						JOptionPane.showMessageDialog(null, "��ӭ�´ι��٣�");	
						clearascree();
					}
					
				}else {
					JOptionPane.showMessageDialog(null,"������Ľ���֧��");
				}
			}else if (v.getRmno()!=0) {
				
				if (money==0) {
					JOptionPane.showMessageDialog(null,"������ͻ��������");
				}else if (money>=allfee) {
					JOptionPane.showMessageDialog(null,"����"+((money-allfee)+"Ԫ"));
					action = new actionImp();
					boolean flag = action.addhistory(v.getVname(),v.getVcard(),v.getTel(),v.getRmno(),r.getRmtype(),v.getVdate(),newtime,allfee,"�˷�");
					//���»�Ա��Ϣ
					boolean flag1 = action.updatevip(v.getVcard(),v.getRmno());
					//������ͨ�ͻ����ڷ���
					boolean flag2 = action.updatetuifangroom(v.getRmno());
					
					if (flag==true&&flag1==true&&flag2==true) {
						JOptionPane.showMessageDialog(null, "��ӭ�´ι��٣�");	
						clearascree();
					}
					
				}else {
					JOptionPane.showMessageDialog(null,"������Ľ���֧��");
				}
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		JieZhang j = new JieZhang();
//		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		long nd = 1000*24*60*60;//һ��ĺ�����
//		long nh = 1000*60*60;//һСʱ�ĺ�����
//		long nm = 1000*60;//һ���ӵĺ�����
//		long ns = 1000;//һ���ӵĺ�����long diff;try {
//		//�������ʱ��ĺ���ʱ�����
//		long diff;
//		try {
//			diff = sd.parse("2016-5-28 21:31:18").getTime() - sd.parse("2016-5-26 12:23:31").getTime();
//		   long day = diff/nd;//����������
//		   long hour = diff%nd/nh;//��������Сʱ
//		   long min = diff%nd%nh/nm;//�������ٷ���
//		   long sec = diff%nd%nh%nm/ns;//����������//������
//		   System.out.println("ʱ����"+day+"��"+hour+"Сʱ"+min+"����"+sec+"�롣");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
		
		
		
		
	}
	
}
