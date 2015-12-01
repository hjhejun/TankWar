import java.awt.*;

public class TankClient extends Frame {
	public void lauchFrame() {
		this.setLocation(300, 400);
		this.setSize(500, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.lauchFrame();

	}

}
