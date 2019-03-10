package eHacksBJJT;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Screen extends JPanel implements Common {

	private Timer timer;
	private Ball ball;
	private Bar bar;
	// S (start) R (run) P (pause) E (end)
	private String inGame = "S";
	public int score = 0;
	public int endScore = 0;
	public static int lives = 3;
	private Sound sounds;
	private Graphics2D g2d;

	public Screen(Sound sounds) {
		initComponents();
		setBackground(Color.black);
		this.sounds = sounds;
	}

	private void initComponents() {
		addKeyListener(new userInput());
		setFocusable(true);
		gameInit();
		timer = new Timer();
		timer.scheduleAtFixedRate(new ScheduleTask(), DELAY, PERIOD);
	}

	private void gameInit() {
		ball = new Ball();
		bar = new Bar();
	}

	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		if (inGame.equals("S")) {
			drawStart(g2d);
		} else if (inGame.equals("R")) { // if game is in R or RUN state
			drawObjects(g2d);
		} else if (inGame.equals("P")) {
			//draw pause screen
			drawPause(g2d);
		} else if (inGame.equals("E")) {
			//draw game over screen
			drawEnd(g2d);
		} else {
			System.exit(1);
		}
		Toolkit.getDefaultToolkit().sync();
	}

	private void drawObjects(Graphics2D g2d) {
		// ball and bar
		g2d.drawImage(ball.getImage(), ball.getXPos(), ball.getYPos(), BALL_RADIUS, BALL_RADIUS, this); 
		g2d.drawImage(bar.getImage(), 0, bar.getPos(), BAR_X_SIZE, BAR_Y_SIZE, this);
		//heart lives
		g2d.drawImage(ball.getHeartImage(), 0, 0, HEART_SIZE, HEART_SIZE, this);
		Font font = new Font("Sans Serif", Font.BOLD, 24);
		g2d.setFont(font);
		g2d.setColor(Color.black);
		g2d.drawString(Integer.toString(lives), LIVES_XPOS, LIVES_YPOS);
		// score
		g2d.setColor(Color.white);
		g2d.drawString("Score: " + Integer.toString(score), SCORE_XPOS, SCORE_YPOS);
	}

	private void drawStart(Graphics2D g2d) {
		//draws start image
		g2d.drawImage(bar.getStartImage(), 0, 0, FRAME_X_SIZE, FRAME_Y_SIZE - 30, this);
		sounds.getStartMusic().start();
	}

	private void drawPause(Graphics2D g2d) {
		Font font = new Font("Verdana", Font.BOLD, 50);
		g2d.setColor(Color.white);
		g2d.setFont(font);
		g2d.drawString("PAUSED", 35, 300);
	}

	private void drawEnd(Graphics2D g2d) {
		Font font = new Font("Verdana", Font.BOLD, 30);
		g2d.setColor(Color.white);
		g2d.setFont(font);
		g2d.drawString("Game Over", 40, 300);
		g2d.drawString("Score: " + Integer.toString(endScore), 35, 340);
		font = new Font("Verdana", Font.BOLD, 20);
		g2d.setFont(font);
		g2d.drawString("Press s to play again", 35, 550);
	}

	// Key Press and release
	private class userInput extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			// RUN
			//if game is running, key inputs will work during game
			if (inGame.equals("R")) {
				bar.keyPressed(e);
			}
			// START
			// if user hits R and the game is in its start or end state, it will run the game
			if (e.getKeyCode() == KeyEvent.VK_S && inGame.equals("S") || inGame.equals("E")) {
				inGame = "R";
				sounds.getStartMusic().stop();
				sounds.getGameMusic().loop(1000000000);
			}
			// PAUSE
			//includes check for if game is already paused or on the start menu
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				if (inGame.equals("P")) {
					inGame = "R";
				} else if (inGame.equals("S")) {
					inGame = "S";
				} else {
					inGame = "P";
					drawPause(g2d);
					repaint();
				}
			}
		}
	}

	// R U N method R U N method R U N method
	private class ScheduleTask extends TimerTask {
		@Override
		public void run() {
			if (inGame.equals("R")) {
				ball.updatePos();
				if (ball.checkCollision(bar)) {
					score += 1;
					sounds.getPointGet().loop(1);
					int dy = ball.getdy();
					if (score == 2) {
						dy++;
					} // 4
					if (score == 6) {
						dy++;
					} // 8
					if (score == 14) {
						dy++;
					} // 12
					if (score == 26) {
						dy++;
					} // 16
					if (score == 42) {
						dy++;
					} // 20
					if (score == 62) {
						dy++;
					} // 24
					if (score == 86) {
						dy++;
					} // 28
					if (score == 114) {
						dy++;
					}
					ball.setdy(dy);
				} else if (ball.getYPos() >= BAR_POS + 26 && !(ball.getColor().equals(bar.getColor()))
						&& (ball.getAlreadyPassed() == false)) {
					setBackground(Color.red);
					lives -= 1;
					ball.setAlreadyPassed(true);
					sounds.getMissedPoint().loop(1);
					if (lives <= 0) {
						GameOver();
					}
				}
				// sets background back to black after shaming you for missing
				if (ball.getYPos() >= 580)
					setBackground(Color.black);
				repaint();
			}
		}
	}

	public void GameOver() {
		endScore = score;
		score = 0;
		lives = 3;
		gameInit();
		ball.setdy(1);
		setBackground(Color.black);
		inGame = "E";
		// System.exit(1);
	}
}
