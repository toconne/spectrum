package eHacksBJJT;

import java.awt.EventQueue;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends JFrame implements Common {
	public Main() {
		initUI();
	}

	private void initUI() {
		Sound sounds = new Sound();
		sounds.loadSounds();
		add(new Screen(sounds));

		setResizable(false);

		setTitle(GAME_NAME);
		setLocation(600, 100);
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FRAME_X_SIZE, FRAME_Y_SIZE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			Main frame = new Main();
			frame.setVisible(true);

		});

	}
}