import java.awt.*;
import java.awt.event.*;

public class TankClient extends Frame {
	int x = 50, y = 50;

	@Override
	public void paint(Graphics g) {// 画图,Container类中的paint，重写paint方法//改paintContainer为paint，版本问题
		Color c = g.getColor();// 保存原来的前景色
		g.setColor(Color.RED);
		g.fillOval(x, y, 30, 30);
		g.setColor(c);// 还原原来的前景色
		y += 10;
	}
	

	public void lauchFrame() {
		this.setLocation(400, 300);
		this.setSize(800, 600);
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
		new Thread(new PaintThread()).start();//启动多线程
	}

	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.lauchFrame();

	}
	private class PaintThread implements Runnable{

		@Override
		public void run() {
			while(true){
				repaint();
				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			
		}
	}
}
