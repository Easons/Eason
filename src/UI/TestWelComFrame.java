package UI;

import java.awt.Dimension;
import java.awt.Toolkit;


public class TestWelComFrame {

	public static void main(String[] args) {
		final WelFrame wel = new WelFrame();
		wel.setVisible(true);
		//���ڷ�����Ļ�м�
		Toolkit kit = Toolkit.getDefaultToolkit();//������
		Dimension scn=kit.getScreenSize();//�����Ļ�ߴ�
		//���ڶ������꣺��Ļ��(��)����/2-���ں�(��)����
		int x = scn.width/2-wel.getWidth()/2;
		int y = scn.height/2-wel.getHeight()/2;
		wel.setLocation(x, y);
		//����رմ����߳�(��ʱ)������
		new Thread(){
			@Override
			public void run() {
				//��ǰ�߳�����3���ִ�йر����߳���Ļ
				try {
					Thread.sleep(3000);
					wel.dispose();
					new TestSystemUi();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
