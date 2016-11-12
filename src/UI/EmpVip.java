package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * �Ի�Ա������ɾ�Ĳ�
 * @author p
 *
 */

import action.actionImp;
import entity.Vip;
public class EmpVip extends JFrame {
	
	private JPanel main  = new JPanel();
	private JPanel addvip = new JPanel();
	
	private actionImp action;
	
	
	JLabel tishiname = new JLabel("������Ҫ���ӵĻ�Ա������");
	JLabel tishivno = new JLabel("������Ҫ���ӵĻ�Ա�ı�ţ�");
	JLabel tishicard = new JLabel("������Ҫ���ӵĻ�Ա���֤��");
	JLabel tishitel = new JLabel("������Ҫ���ӵĻ�Ա�绰��");
	
	JTextField jfname = new JTextField();
	JTextField jfcard = new JTextField();
	JTextField jftel = new JTextField();
	JTextField jfvno = new JTextField();
	
	private JButton jbqueren = new JButton("ȷ�����");
	private JButton jbquxiao = new JButton("ȡ��");
	
    private JButton jbchaxun  = new JButton("��ѯ");
    private JButton  jbdelete  = new JButton("ɾ��");
    private JButton  jbxiugai  = new JButton("�޸�");
    private JButton  jbtianjia = new JButton("���");
    private JButton jbfanhui = new JButton("����");
    
	
	
	public EmpVip() {
		init();
	}

	//��ʼ������
	private void init() {
		this.setTitle("��Ա�������");
		this.setLayout(null);
		this.setSize(700,500);
		
		//this.setDefaultLookAndFeelDecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		main();
		addvip();
		addvip.setVisible(false);
		main.setVisible(true);
		this.setVisible(true);	
		
	}
	//��ӻ�Ա
	private void addvip() {
		addvip.setLayout(null);
		addvip.setSize(700,500);
		
		tishiname.setBounds(100,50,250,50);
		tishicard.setBounds(100,120,250,50);
		tishitel.setBounds(100,190,250,50);
		tishivno.setBounds(100,260,250,50);
		
		jfname.setBounds(400,50,250,30);
		jfcard.setBounds(400,120,250,30);
		jftel.setBounds(400,190,250,30);
		jfvno.setBounds(400,260,250,30);
		
		jbqueren.setBounds(200,350,100,50);
		jbquxiao.setBounds(350,350,100,50);
		
		
		jbqueren.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				action = new actionImp();
				String card = jfcard.getText();
				Vip v = new Vip();
				v = action.queryvip(card);
				if (v.getId()==0) {
					String vname = jfname.getText();
					long tel = Long.valueOf(jftel.getText());
					int vno = Integer.valueOf(jfvno.getText());
					boolean flag = action.addvip(vname,vno,tel,card);
					if (flag) {
						JOptionPane.showMessageDialog(null, "��ӳɹ�");
						jfcard.setText(null);
						jfname.setText(null);
						jftel.setText(null);
						jfvno.setText(null);
					}
				}else {
					JOptionPane.showMessageDialog(null,"�����֤��vip�Ѿ����ڣ������ظ����");
				}
				
				
				
				
				String vname = jfname.getText();
				
				
				
			}
		});
		jbquxiao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jfcard.setText(null);
				jfname.setText(null);
				jftel.setText(null);
				jfvno.setText(null);
				main.setVisible(true);
				addvip.setVisible(false);
				
			}
		});
		
		
		addvip.add(jbqueren);
		addvip.add(jbquxiao);
		addvip.add(jfcard);
		addvip.add(jfname);
		addvip.add(jftel);
		addvip.add(jfvno);
		addvip.add(tishicard);
		addvip.add(tishiname);
		addvip.add(tishitel);
		addvip.add(tishivno);
		
		
		this.add(addvip);
	}

	public void main(){
		main.setLayout(null);
		main.setSize(700,500);
		
		
		jbchaxun.setBounds(110,200,100,50);
		jbdelete.setBounds(250,200,100,50);
		jbtianjia.setBounds(380,200,100,50);
		jbxiugai.setBounds(510,200,100,50);
		jbfanhui.setBounds(510,300,100,50);
		
		jbxiugai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Xiugaivip();
				dispose();
				
			}
		});
		
		jbfanhui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Empframe();
				dispose();
				
			}
		});
		
		jbdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DeleteVip();
				dispose();
				
			}
		});
		jbchaxun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Chaxunvip();
				dispose();
				
			}
		});
		
		jbtianjia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.setVisible(false);
				addvip.setVisible(true);
				
			}
		});
		
		main.add(jbfanhui);
		main.add(jbchaxun);
		main.add(jbdelete);
		main.add(jbtianjia);
		main.add(jbxiugai);
		
		this.add(main);
		
	}
	
		
	
	public static void main(String[] args) {
		EmpVip e = new EmpVip();
	}
	
	
	
}

