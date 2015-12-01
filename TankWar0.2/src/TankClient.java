import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TankClient extends Frame {
	public void lauchFrame() {
		this.setLocation(300, 400);
		this.setSize(500, 400);
		this.setTitle("TankWar");
		this.addWindowListener(new WindowAdapter() { //创建监听器，匿名类（比较短小）

			@Override
			public void windowClosing(WindowEvent e) {  //重写父类即WindowAdapter

				System.exit(0);
			}

		});

		setVisible(true);
		this.setResizable(false);//窗口大小不可调
	}

	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.lauchFrame();

	}

}
