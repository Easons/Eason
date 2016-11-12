package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import action.actionImp;
import entity.Vip;

public class Chaxunvip extends JFrame implements ActionListener{
	 JPanel main = new JPanel();
	  
	 private actionImp action;
	   //������ǩ
	   JLabel lbl = new JLabel("����������ѡ��");
	   JLabel lbl1 = new JLabel("��Ա���֤�ţ� ");
	   JLabel lbl2 = new JLabel("��Ա������");
	   JLabel lbl3 = new JLabel("��Ա��ţ�");
	   JLabel lbl4 = new JLabel("��Ա�绰���룺");

	   //�����ı���
	   private JTextField jf = new JTextField();
	   private JTextField jp1 = new JTextField();
	   private JTextField jp2 = new JTextField();
	   private JTextField jp3 = new JTextField();
	   
	   //������ť
	   private JButton jxiu = new JButton("��ѯ");
	   private JButton cancel = new JButton("ȡ��");	   
	   
	   public Chaxunvip() {
		   init();
	   }

	   //���������С
	   public void setfont(JLabel j){
		   Font font=new Font("Monospaced",Font.BOLD,15);
		   j.setFont(font);
	   }
	   
	   //��ʼ������
	   private void init() {
		   Font font=new Font("Monospaced",Font.BOLD,20);//���������ʽ�ʹ�С
		   lbl.setForeground(Color.BLACK);//����ǰ��ɫ
		   lbl.setFont(font);
		   //���ô���Ϊ�ղ���
		   this.setLayout(null);
		   this.setSize(800,600);
		   this.setTitle("����Ա����");

		//����x֮��رմ���
		   this.setDefaultCloseOperation(Chaxunvip.EXIT_ON_CLOSE);
		   //��������ʾ����
		   this.setLocationRelativeTo(null);
		   //��������ı䴰��Ĵ�С
		   this.setResizable(false);
		   
		   main_xiugai();
         this.setVisible(true);
         //��ʾ���
         main.setVisible(true);
	}
	   
	   private void main_xiugai() {
		 setfont(lbl1);
		 setfont(lbl2);
		 setfont(lbl3);
		 setfont(lbl4);
		 lbl1.setBounds(150,13,150,50);
		 lbl2.setBounds(150,100,150,50);
		 lbl3.setBounds(150,200,150,50);
		 lbl4.setBounds(150,300,150,50);
		 
		 
		 jf.setBounds(300,25,250,30);
		 jp1.setBounds(300,100,250,30);
		 jp2.setBounds(300,200,250,30);
		 jp3.setBounds(300, 300, 250, 30);
		 
		 
		 
		 jxiu.setBounds(600,25, 100,40);
		 cancel.setBounds(500,400,100,40);
		 jxiu.addActionListener(this);
		 cancel.addActionListener(this);
       
		 main.add(jp3);
		 main.add(lbl1);
		 main.add(lbl2);
		 main.add(lbl3);
		 main.add(lbl4);
		 main.add(cancel);
		 main.add(jxiu);
		 main.add(jp2);
		 main.add(jp1);
		 main.add(jf);
		 
		 main.setSize(800,500);
		 main.setLayout(null);
		 this.add(main);
	}


	public void actionPerformed(ActionEvent e) {
	    if (e.getSource().equals(jxiu)) {
			action = new actionImp();
			String card = jf.getText();
			Vip v = new Vip();
			v = action.queryvip(card);
			jp1.setText(String.valueOf(v.getVname()));
			jp2.setText(String.valueOf(v.getVno()));
			jp3.setText(String.valueOf(v.getTel()));		
		}if (e.getSource().equals(cancel)) {
			new EmpVip();
			dispose();
		}
		
	}
	
	
	public static void main(String[] args) {
		Chaxunvip c = new Chaxunvip();
	}
}
