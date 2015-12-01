import java.awt.*;
import java.awt.event.*;

public class TankClient extends Frame {
	int x = 50, y = 50;
	public static final int GAME_WIDTH=800;//���峣����������һ���д�������ع���
	public static final int GAME_HEIGHT=600;
	Image offScreenImage = null;//��ͼ�񻺳�

	@Override
	public void paint(Graphics g) {// ��ͼ,Container���е�paint����дpaint����//��paintContainerΪpaint���汾����
		Color c = g.getColor();// ����ԭ����ǰ��ɫ
		g.setColor(Color.RED);
		g.fillOval(x, y, 30, 30);
		g.setColor(c);// ��ԭԭ����ǰ��ɫ
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
		this.addWindowListener(new WindowAdapter() { // �����������������ࣨ�Ƚ϶�С��

			@Override
			public void windowClosing(WindowEvent e) { // ��д���༴WindowAdapter

				System.exit(0);
			}

		});

		setVisible(true);
		this.setResizable(false);// ���ڴ�С���ɵ�
		this.setBackground(Color.green);
		new Thread(new PaintThread()).start();// �������߳�
	}

	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.lauchFrame();

	}

	private class PaintThread implements Runnable {//ʹ���ڲ��ֻ࣬Ϊ��װ������ⲿ���ɷ��ʡ�

		@Override
		public void run() {
			while (true) {
				repaint();// repaint�����ȵ���update����Ȼ�����paint����
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}

		}
	}
}
