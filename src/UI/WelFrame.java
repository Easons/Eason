package UI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.LineBorder;


public class WelFrame extends JWindow{

	public WelFrame(){
		init();//��ʼ���Զ��崰��
	}	
	//��ʼ������ 
	private void init() {//�������ԣ�������
		setSize(400, 400);
		JPanel pane = new JPanel(new BorderLayout());
		ImageIcon icon = new ImageIcon(WelFrame.class.getResource("酒店.jpg"));
		JLabel lab = new JLabel(icon);//���ͼƬ��ǩ
		pane.add(BorderLayout.CENTER,lab);//��ӵ�ͼƬcenter
		pane.setBorder(new LineBorder(Color.BLACK));//�������߿�
		setContentPane(pane);//������ӵ�pane
		pack();
	}
}
