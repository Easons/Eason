package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Util.util;
import action.actionImp;

public class DeleteVip extends JFrame implements ActionListener{ 

	   actionImp action;
	

    //����һ�����	
	   JPanel xiugai = new JPanel();
	   
	   //������ǩ
	   JLabel lbl = new JLabel("����������ѡ��");
	   JLabel lbl1 = new JLabel("��Ա������");
	   JLabel lbl2 = new JLabel("��Ա��ţ�");
	 

	   
	   //�����ı���
	   private JTextField jf = new JTextField();
	   private JTextField jp1 = new JTextField();
	   
	   //������ť
	   private JButton jxiu = new JButton("ɾ��");
	   private JButton cancel = new JButton("ȡ��");	   
	   
	   public DeleteVip() {
		   init();
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
//		   this.setDefaultCloseOperation(zeng.EXIT_ON_CLOSE);
	       //�� ������ʾ����
		   this.setLocationRelativeTo(null);
		   //��������ı䴰��Ĵ�С
		   this.setResizable(false);
		   
		   main_xiugai();
        this.setVisible(true);
        //��ʾ���
        xiugai.setVisible(true);
	} 
	   public void setfont(JLabel j){
		   Font font=new Font("Monospaced",Font.BOLD,15);
		   j.setFont(font);
	   }
	   
	   private void main_xiugai() {
		 setfont(lbl1);
		 setfont(lbl2);
		
		 
		 lbl1.setBounds(175,100,150,50);
		 lbl2.setBounds(175,200,150,50);
		
		 
		 
		 jf.setBounds(300,115,300,30);
		 jp1.setBounds(300,215,300,30);
		 
		 
		 cancel.addActionListener(this);
		 jxiu.addActionListener(this);
		
		 jxiu.setBounds(250,400, 100,40);
		 cancel.setBounds(500,400,100,40);
      
		
		 xiugai.add(lbl1);
		 xiugai.add(lbl2);
		 xiugai.add(cancel);
		 xiugai.add(jxiu);
		 xiugai.add(jp1);
		 xiugai.add(jf);
		 
		 xiugai.setSize(800,500);
		 xiugai.setLayout(null);
		 this.add(xiugai);
	}
	  
    public void actionPerformed(ActionEvent e) {
	   if (e.getSource().equals(jxiu)) {
		  action = new actionImp();
		  String name = jf.getText();
		  int vno = Integer.valueOf(jp1.getText());
		  if (vno==0) {
			JOptionPane.showMessageDialog(null, "�޸û�Ա��");
		}
		  boolean flag = action.deletevip(name,vno);
		  if (flag) {
			JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
		} 
	    }else if (e.getSource().equals(cancel)) {
		new EmpVip();
		dispose();
	}
	
}
    public static void main(String[] args) {
		DeleteVip  d = new DeleteVip();
	}
    
    
}
