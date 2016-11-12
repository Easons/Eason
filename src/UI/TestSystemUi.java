package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Time;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class TestSystemUi {

	
	public TestSystemUi() {
		init();
	}
	
	public void init(){
	  
		   final JFrame frame=new JFrame("��ӭ����Ƶ����ϵͳ");
		   Toolkit kit = Toolkit.getDefaultToolkit();
		   Dimension scn=kit.getScreenSize();
		   int x = scn.width/2-frame.getWidth()/2;
		   int y = scn.height/2-frame.getHeight()/2;
		   frame.setLocation(x-300, y-300);
			
		   GridBagLayout layout = new GridBagLayout();
		   SystemUI pane = new SystemUI();
		   pane.setLayout(layout);
		   pane.setSize(800,450);
		   GridBagConstraints s= new GridBagConstraints();
		   final JLabel time = new JLabel();
			
			 Font font=new Font("Monospaced",Font.BOLD,20);//���������ʽ�ʹ�С
			 time.setForeground(Color.BLACK);//����ǰ��ɫ
			 time.setFont(font);

			 ImageIcon icon = new ImageIcon("��ͷ.png");
			 JButton button=new JButton("Ա����¼");
			 button.setBounds(0, 0, 85, 82);
			 
	         Image temp = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), icon.getImage().SCALE_DEFAULT);  
	         icon = new ImageIcon(temp);
	         button.setIcon(icon);
			 button.setBorderPainted(false);
			 button.setContentAreaFilled(false);
			 

			 JButton button1 = new JButton("����Ա��¼");
			 icon = new ImageIcon(temp);
			 button.setBounds(0, 0, 85, 82);
			 button1.setIcon(icon);
			 button1.setBorderPainted(false);
			 button1.setContentAreaFilled(false);
			
			
			
			 new Timer().schedule(new TimerTask() {
					public void run() {
						Date a = new java.util.Date();
						Date b = new java.sql.Date(a.getTime());
						Time c = new java.sql.Time(a.getTime());
						time.setText("����ʱ�䣺"+b+" "+c);
						
					}
				},0,1000);
			

			s.gridx = 0;
			s.gridy = 2;
			layout.setConstraints(time,s);		
						
			s.gridx = 8;
			s.gridy = 20;
			layout.setConstraints(button,s);
			
			s.gridx = 8;
			s.gridy = 0;
			layout.setConstraints(button1,s);
			
			 
			
			pane.add(button);
			pane.add(time);
			pane.add(button1);
			//Ա��������
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//frame.setVisible(false);
					new EmpLogin();
					frame.dispose();
	               				
				}
			});
			//����Ա��ť������
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//frame.setVisible(false);
					new ManagerLogin();
					frame.dispose();
				}
			});
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			frame.addWindowListener(new WindowAdapter() {
				//�رմ���
				public void windowClosing(WindowEvent e) {
					int var=JOptionPane.showConfirmDialog(frame, "ȷ�Ϲرմ���?");
					if(var==JOptionPane.YES_OPTION){
						System.exit(0);
					}
				}
			});
			frame.setResizable(false);
			frame.setContentPane(pane);
			frame.setSize(700, 500);
			frame.setVisible(true);
	}
}

