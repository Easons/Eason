package UI;

import java.awt.Dimension;
import java.awt.Toolkit;


public class TestWelComFrame {

	public static void main(String[] args) {
		final WelFrame wel = new WelFrame();
		wel.setVisible(true);
		//窗口放置屏幕中间
		Toolkit kit = Toolkit.getDefaultToolkit();//工具类
		Dimension scn=kit.getScreenSize();//获得屏幕尺寸
		//窗口顶点坐标：屏幕横(纵)坐标/2-窗口横(纵)坐标
		int x = scn.width/2-wel.getWidth()/2;
		int y = scn.height/2-wel.getHeight()/2;
		wel.setLocation(x, y);
		//定义关闭窗口线程(计时)并启动
		new Thread(){
			@Override
			public void run() {
				//当前线程休眠3秒后执行关闭主线程屏幕
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
