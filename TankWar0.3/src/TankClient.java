import java.awt.*;
import java.awt.event.*;


public class TankClient extends Frame {
	@Override
	public void paint(Graphics g) {//��ͼ,Container���е�paint����дpaint����//��paintContainerΪpaint���汾����
		Color c=g.getColor();//����ԭ����ǰ��ɫ
		g.setColor(Color.RED);
		g.fillOval(50, 50, 30, 30);
		g.setColor(c);//��ԭԭ����ǰ��ɫ
	}

	public void lauchFrame() {
		this.setLocation(400, 300);
		this.setSize(800, 600);
		this.setTitle("TankWar");
		this.addWindowListener(new WindowAdapter() { //�����������������ࣨ�Ƚ϶�С��

			@Override
			public void windowClosing(WindowEvent e) {  //��д���༴WindowAdapter

				System.exit(0);
			}

		});

		setVisible(true);
		this.setResizable(false);//���ڴ�С���ɵ�
		this.setBackground(Color.green);
	}

	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.lauchFrame();

	}

}
