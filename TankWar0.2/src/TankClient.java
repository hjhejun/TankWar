import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TankClient extends Frame {
	public void lauchFrame() {
		this.setLocation(300, 400);
		this.setSize(500, 400);
		this.setTitle("TankWar");
		this.addWindowListener(new WindowAdapter() { //�����������������ࣨ�Ƚ϶�С��

			@Override
			public void windowClosing(WindowEvent e) {  //��д���༴WindowAdapter

				System.exit(0);
			}

		});

		setVisible(true);
		this.setResizable(false);//���ڴ�С���ɵ�
	}

	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.lauchFrame();

	}

}
