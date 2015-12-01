import java.awt.*;
import java.awt.event.*;

public class TankClient extends Frame {
	int x = 50, y = 50;
	public static final int GAME_WIDTH=800;//定义常量，常量名一般大写（代码重构）
	public static final int GAME_HEIGHT=600;
	Image offScreenImage = null;//加图像缓冲

	@Override
	public void paint(Graphics g) {// 画图,Container类中的paint，重写paint方法//改paintContainer为paint，版本问题
		Color c = g.getColor();// 保存原来的前景色
		g.setColor(Color.RED);
		g.fillOval(x, y, 30, 30);
		g.setColor(c);// 还原原来的前景色
		y += 5;
	}

	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.GREEN);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	public void lauchFrame() {
		this.setLocation(400, 300);
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setTitle("TankWar");
		this.addWindowListener(new WindowAdapter() { // 创建监听器，匿名类（比较短小）

			@Override
			public void windowClosing(WindowEvent e) { // 重写父类即WindowAdapter

				System.exit(0);
			}

		});

		setVisible(true);
		this.setResizable(false);// 窗口大小不可调
		this.setBackground(Color.green);
		new Thread(new PaintThread()).start();// 启动多线程
	}

	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.lauchFrame();

	}

	private class PaintThread implements Runnable {//使用内部类，只为包装类服务，外部不可访问。

		@Override
		public void run() {
			while (true) {
				repaint();// repaint方法先调用update方法然后调用paint方法
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}

		}
	}
}
