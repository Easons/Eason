package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Client;
import entity.Room;
import entity.Vip;
import entity.YuDingxinxi;

import action.actionImp;
/**
 * Ԥ����ס���������뷿��� (�Զ��ж��Ƿ��ǻ�Ա������ͨ�û�����ӡ)�������Ƿ���ס(�����˶�)
 * ʵʱ��ס�������ֻ�Ա����ͨ�û�(�������)
 * @author p
 *
 */
public class BookRuZhu extends JFrame implements ActionListener{
	
	YuDingxinxi y;
	YuDingxinxi y1;
	
	Date b = new java.sql.Date(new java.util.Date().getTime());
	Time c = new java.sql.Time(new java.util.Date().getTime());
	
	private actionImp action;
	JPanel main = new JPanel();
	JPanel yuding = new JPanel();
	
	
	JTextField jf = new JTextField(10);
	
	JButton jbyuding = new JButton("Ԥ����ס���˶�");
	JButton jbruzhu = new JButton("��ס");
	JButton jbsousuo = new JButton("����");
	JButton jbquerenruzhu = new JButton("ȷ����ס");
	JButton jbtuiding = new JButton("�˶�");
	JButton jbtuihui = new JButton("������һ��");
	JButton jbfanhui = new JButton("����");
	
	JLabel tishiname = new JLabel();
	JLabel tishicard = new JLabel();
	JLabel tishirmno = new JLabel();
	JLabel tishitype = new JLabel();
	JLabel tishitime = new JLabel();
	
	JLabel jlname = new JLabel();
	JLabel jlcard = new JLabel();
	JLabel jlrmno = new JLabel();
	JLabel jltype = new JLabel();
	JLabel jltime = new JLabel();
	JLabel jltishi = new JLabel();
	
	JLabel jlroom = new JLabel("������ͻ������֤�ţ�");
	JLabel jlwelcom = new JLabel("��ӭ���������ס����");
	
	public BookRuZhu() {
		init();
	}

	private void init() {
		   this.setLayout(null);
		   this.setSize(800,600);
		   this.setTitle("��ס����");
		   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   this.setLocationRelativeTo(null);
		   //��������ı䴰��Ĵ�С
		   this.setResizable(false);
		   
		   main_ruzhu();
		   bookruzhu();
		   main.setVisible(true);
		   yuding.setVisible(false);
		   this.setVisible(true);
	}
	
	//���ñ�ǩ������
	 public void setfont(JLabel j){
		   Font font=new Font("Monospaced",Font.BOLD,17);
		   j.setFont(font);
	   }
	 
	 
	
	//������
	 private void main_ruzhu() {
	    main.setLayout(null);
	    main.setSize(800,600);
	    jbtuihui.setBounds(200,400,100,50);
	    jbyuding.setBounds(200,300,150,50);
	    jbruzhu.setBounds(500,300,100,50);

	    Font font=new Font("Monospaced",Font.BOLD,100);//���������ʽ�ʹ�С
		jlwelcom.setForeground(Color.BLACK);//����ǰ��ɫ
		jlwelcom.setFont(font); 
	    
		jlwelcom.setBounds(280,100,300,100);
				
		jbtuihui.addActionListener(this);
	    jbyuding.addActionListener(this);
	    jbruzhu.addActionListener(this);
	    
	    
	    main.add(jbtuihui);
	    main.add(jlwelcom);
	    main.add(jbyuding);
	    main.add(jbruzhu);
	    
	    
	    this.add(main);
	}
	 
	//Ԥ����ס����
	 public void bookruzhu(){
		 yuding.setLayout(null);
		 yuding.setSize(800,500);
		 
		 setfont(jlroom);
		 jlroom.setBounds(100,20,220,30);
		 jf.setBounds(330, 20,200,30);
		 
		 jbsousuo.setBounds(550,20,100,30);
		 jbquerenruzhu.setBounds(600,330,100,40);
		 jbtuiding.setBounds(600,380,100,40);
		 jbfanhui.setBounds(600, 430,100,40);
		 
		 
		 jltishi.setBounds(550, 100,250,40);
		 
		 
		 setfont(jltishi);
		 setfont(tishiname);
		 setfont(tishicard); 
		 setfont(tishirmno);
		 setfont(tishitype); 
		 setfont(tishitime); 
		 setfont(jlroom); 
         setfont(jlwelcom);
         setfont(jlname);
		 setfont(jlcard); 
		 setfont(jlrmno);
		 setfont(jltype); 
		 setfont(jltime); 
		 
		 
		 tishiname.setBounds(100,100,130,30);
		 tishicard.setBounds(100,180,130,30);
		 tishirmno.setBounds(100,260,130,30);
		 tishitype.setBounds(100,340,130,30);
		 tishitime.setBounds(100,420,130,30);
		 
		 
		 jlname.setBounds(300,100,130,30);
		 jlcard.setBounds(300,180,300,30);
		 jlrmno.setBounds(300,260,130,30);
		 jltype.setBounds(300,340,130,30);
		 jltime.setBounds(300,420,300,30);
		 
		 
		 
		 jbfanhui.addActionListener(this);
		 jbquerenruzhu.addActionListener(this);
		 jbtuiding.addActionListener(this);
		 jbsousuo.addActionListener(this);
		 
		 
		 yuding.add(jltishi);
		 yuding.add(jlcard);
		 yuding.add(jlname);
		 yuding.add(jlrmno);
		 yuding.add(jltime);
		 yuding.add(jltype);
		 
		 yuding.add(jbfanhui);
		 yuding.add(jbquerenruzhu);
		 yuding.add(jbtuiding);
		 yuding.add(jbsousuo);
		 yuding.add(tishiname);
		 yuding.add(tishicard);
		 yuding.add(tishirmno);
		 yuding.add(tishitype);
		 yuding.add(tishitime);
		 
		 yuding.add(jlroom);
		 yuding.add(jf);
		
		 this.add(yuding);
	 }
	
	 //���ñ�ǩΪ��
	 public void clearscree(){
		 jf.setText(null);
			jlname.setText(null);
			 jlcard.setText(null);
			 jlrmno.setText(null);
			 jltype.setText(null);
			 jltime.setText(null);
			 tishiname.setText(null);
			  tishicard.setText(null);
			  tishirmno.setText(null);
			  tishitype.setText(null);
			  tishitime.setText(null);
			  jltishi.setText(null);
		 
	 }

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(jbyuding)) {
			yuding.setVisible(true);
			main.setVisible(false);
		}else if (e.getSource().equals(jbsousuo)) {
			if (jf.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"������ͻ������֤��");
			}else {
				actionImp action1 = new actionImp();
				String  card  = jf.getText();
				 y = new YuDingxinxi();
				y = action1.vipruzhuchaxun(card);
				 y1 = new YuDingxinxi();
				y1 = action1.putongruzhuchaxun(card);
				if (y.getRmno()!=0&&y.getTime()!=null) {
					String newtime = ""+b+" "+c;
					
					SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					double allday = 0;
					double nd = 1000*24*60*60;//һ��ĺ�����
					double diff;
					try {
						diff = sd.parse(newtime).getTime() - sd.parse(y.getTime()).getTime();
						double day = diff/nd;//����������
						
						allday = day;
					} catch (ParseException e1) {
						e1.printStackTrace();
					};
				
					if (allday>2) {
						String str = y.getCard().substring(6,14);
						String str1 = y.getCard().replace(str, "********");
						
						 jlname.setText(y.getName());
						 jlcard.setText(str1);
						 jlrmno.setText(String.valueOf(y.getRmno()));
						 jltype.setText(y.getType());
						 jltime.setText(y.getTime());
						 
						 tishiname.setText("�����ǣ�");
						  tishicard.setText("���֤���ǣ�");
						  tishirmno.setText("Ԥ��������ǣ�");
						  tishitype.setText("���������ǣ�");
						  tishitime.setText("Ԥ��ʱ���ǣ�");
						
						
						jltishi.setText("���Ѿ�����Ԥ����ʱ��2��");
						jltishi.setForeground(Color.RED);
						action = new actionImp();
						Vip v = new Vip();
						int rmno = y.getRmno();
						v = action.queryvip(rmno);
						
						boolean flag = action.viptuiding(card);
						boolean flag1 = action.tuidingroom(rmno);
						boolean flag2 = action.addTuiDinghistory(y.getName(),y.getCard(),v.getTel(),rmno,y.getType(),newtime,"�Զ��˶�");
						if (flag==true&&flag1==true&&flag2==true) {
							JOptionPane.showMessageDialog(null, "�Զ�ȡ��Ԥ��");
						}	
						
						clearscree();
						
					}else {
						jltishi.setText("����Ԥ����ʱ��  ��");
						jltishi.setForeground(Color.GREEN);
	
						String str = y.getCard().substring(6,14);
						String str1 = y.getCard().replace(str, "********");
						
						
						 jlname.setText(y.getName());
						 jlcard.setText(str1);
						 jlrmno.setText(String.valueOf(y.getRmno()));
						 jltype.setText(y.getType());
						 jltime.setText(y.getTime());
						 
						 
						 tishiname.setText("�����ǣ�");
						  tishicard.setText("���֤���ǣ�");
						  tishirmno.setText("Ԥ��������ǣ�");
						  tishitype.setText("���������ǣ�");
						  tishitime.setText("Ԥ��ʱ���ǣ�");
						
					}

				}else if(y1.getRmno()!=0&&y1.getTime()!=null) {
                   String newtime = ""+b+" "+c;
					
					SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					double allday = 0;
					double nd = 1000*24*60*60;//һ��ĺ�����
					double diff;
					try {
						diff = sd.parse(newtime).getTime() - sd.parse(y1.getTime()).getTime();
						double day = diff/nd;//����������
						
						allday = day;
					} catch (ParseException e1) {
						e1.printStackTrace();
					};
					
					if (allday<2) {
						jltishi.setText("����Ԥ����ʱ��  ��");
						jltishi.setForeground(Color.GREEN);
						
						String str = y1.getCard().substring(6,14);
						String str1 = y1.getCard().replace(str, "********"); 
						
						
						jlname.setText(y1.getName());
						 jlcard.setText(str1);
						 jlrmno.setText(String.valueOf(y1.getRmno()));
						 jltype.setText(y1.getType());
						 jltime.setText(y1.getTime());
						 
						 
						 tishiname.setText("�����ǣ�");
						  tishicard.setText("���֤���ǣ�");
						  tishirmno.setText("Ԥ��������ǣ�");
						  tishitype.setText("���������ǣ�");
						  tishitime.setText("Ԥ��ʱ���ǣ�");
						
					}else {
						String str = y1.getCard().substring(6,14);
						String str1 = y1.getCard().replace(str, "********");
						
						
						jlname.setText(y1.getName());
						 jlcard.setText(str1);
						 jlrmno.setText(String.valueOf(y1.getRmno()));
						 jltype.setText(y1.getType());
						 jltime.setText(y1.getTime());
						 
						 
						 tishiname.setText("�����ǣ�");
						  tishicard.setText("���֤���ǣ�");
						  tishirmno.setText("Ԥ��������ǣ�");
						  tishitype.setText("���������ǣ�");
						  tishitime.setText("Ԥ��ʱ���ǣ�");
						
						
						jltishi.setText("���Ѿ�����Ԥ����ʱ��2��");
						jltishi.setForeground(Color.RED);
						
						int rmno = y1.getRmno();
						action = new actionImp();
						Client c1 = new Client();
						c1 = action.queryclient(rmno);

						boolean flag2 = action.addTuiDinghistory(y1.getName(),y1.getCard(),c1.getRtel(),rmno,y1.getType(),newtime,"�Զ��˶�");
						
						boolean flag = action.clienttuiding(card);
						boolean flag1 = action.tuidingroom(rmno);
						
						if (flag==true&&flag1==true&&flag2==true) {
							JOptionPane.showMessageDialog(null, "�Զ�ȡ��Ԥ��");
						}
						clearscree();
						
					}
				}else {
					clearscree();
					JOptionPane.showMessageDialog(null, "û�иÿͻ��ķ�����Ϣ��÷��Ѿ���ס");
				}
				 
			}
		}else if (e.getSource().equals(jbfanhui)) {
			clearscree();
			  main.setVisible(true);
			  yuding.setVisible(false);
		}else if (e.getSource().equals(jbquerenruzhu)) {
			
			String newtime = ""+b+" "+c;
			//��Աȷ����ס
			if (y.getRmno()!=0) {
				
				int n = JOptionPane.showConfirmDialog(null, "ȷ����ס��", "��ס��ʾ", JOptionPane.YES_NO_OPTION);
			    if (n==0) {
			    action = new actionImp();
			    int rmno = y.getRmno();
			    Vip v = new Vip();
				v = action.queryvip(rmno);
				String vcard = y.getCard();
				 boolean flag2 = action.addRuZhuhistory(y.getName(),y.getCard(),v.getTel(),rmno,y.getType(),newtime,"��ס");
				 boolean flag = action.vipruzhu(vcard,newtime);
				  boolean flag1 = action.updateruzhuroom(rmno);
				  if (flag1==true&&flag==true&&flag2==true) {
					JOptionPane.showMessageDialog(null,"��ס�ɹ�");
					clearscree();
				}
				}	
		    //��ͨ�û�ȷ����ס
			}else if(y1.getRmno()!=0){
				int n = JOptionPane.showConfirmDialog(null, "ȷ����ס��", "��ס��ʾ", JOptionPane.YES_NO_OPTION);
				if (n==0) {
					String ccard = y1.getCard();
					int rmno = y1.getRmno();
					action = new actionImp();
					Client c1 = new Client();
					c1 = action.queryclient(rmno);
					boolean flag2 = action.addRuZhuhistory(y1.getName(),y1.getCard(),c1.getRtel(),rmno,y1.getType(),newtime,"��ס");
					boolean flag = action.clientruzhu(ccard);
					boolean flag1 = action.updateruzhuroom(rmno);
					if (flag1==true&&flag==true&&flag2==true) {
						JOptionPane.showMessageDialog(null,"��ס�ɹ�");
						clearscree();
					}
					
				}
			}
		}else if (e.getSource().equals(jbtuihui)) {
			 this.dispose();
				new Empframe(); 
		//��Ա�˶�����
		}else if (e.getSource().equals(jbtuiding)) {
//			Date b = new java.sql.Date(new java.util.Date().getTime());
//			Time c = new java.sql.Time(new java.util.Date().getTime());
			String newtime = ""+b+" "+c;
			if (y.getRmno()!=0) {
				int n = JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�˶���", "��ס��ʾ", JOptionPane.YES_NO_OPTION);
				if (n==0) {
					action = new actionImp();
					String card = y.getCard();
					Vip v = new Vip();
					int rmno = y.getRmno();
					v = action.queryvip(rmno);
					
					
					boolean flag = action.viptuiding(card);
					boolean flag1 = action.tuidingroom(rmno);
					boolean flag2 = action.addTuiDinghistory(y.getName(),y.getCard(),v.getTel(),rmno,y.getType(),newtime,"�˶�����");
					if (flag==true&&flag1==true&&flag2==true) {
						JOptionPane.showMessageDialog(null,"�˶��ɹ�");
						clearscree();
					}
				}
			}else if (y1.getRmno()!=0) {
				int n = JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�˶���", "��ס��ʾ", JOptionPane.YES_NO_OPTION);
				if (n==0) {
					action = new actionImp();
					String card = y1.getCard();
					int rmno = y1.getRmno();
					Client c1 = new Client();
					c1 = action.queryclient(rmno);

					boolean flag2 = action.addTuiDinghistory(y1.getName(),y1.getCard(),c1.getRtel(),rmno,y1.getType(),newtime,"�˶�����");
					
					boolean flag = action.clienttuiding(card);
					boolean flag1 = action.tuidingroom(rmno);
					if (flag==true&&flag1==true) {
						JOptionPane.showMessageDialog(null,"�˶��ɹ�");
						clearscree();
					}
				}
			}
		}else if (e.getSource().equals(jbruzhu)) {
			new RuZhu();
			dispose(); 
		}	
	}
	
	
	
	public static void main(String[] args) {
		BookRuZhu b = new BookRuZhu();
	}
}
