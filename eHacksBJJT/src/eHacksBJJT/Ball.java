package eHacksBJJT;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Ball implements Common {

	private Image image;
	private String color;
	private int yPos = 0;
	private int xPos;
	private int dy = 1;
	private boolean alreadyPassed;

	private BufferedImage[] imageBuffer;

	public Ball() {
		bufferLoad();
		initBall();
	}

	public void bufferLoad() {
		imageBuffer = new BufferedImage[7];
		try {
			imageBuffer[0] = ImageIO.read(new File("src/eHacksBJJT/balls/blue.png"));
			imageBuffer[1] = ImageIO.read(new File("src/eHacksBJJT/balls/green.png"));
			imageBuffer[2] = ImageIO.read(new File("src/eHacksBJJT/balls/yellow.png"));
			imageBuffer[3] = ImageIO.read(new File("src/eHacksBJJT/balls/orange.png"));
			imageBuffer[4] = ImageIO.read(new File("src/eHacksBJJT/balls/purple.png"));
			imageBuffer[5] = ImageIO.read(new File("src/eHacksBJJT/balls/red.png"));
			imageBuffer[6] = ImageIO.read(new File("src/eHacksBJJT/balls/heart.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initBall() {
		alreadyPassed = false;
		yPos = 0;
		xPos = (int) (Math.random() * 201 + 50);
		loadImage();

	}

	private void loadImage() {
		ImageIcon i = new ImageIcon(imageBuffer[0]);
		switch ((int) (Math.random() * 6)) {

		case 0:
			i = new ImageIcon(imageBuffer[0]);
			color = "blue";
			break;
		case 1:
			i = new ImageIcon(imageBuffer[1]);
			color = "green";
			break;
		case 2:
			i = new ImageIcon(imageBuffer[2]);
			color = "yellow";
			break;
		case 3:
			i = new ImageIcon(imageBuffer[3]);
			color = "orange";
			break;
		case 4:
			i = new ImageIcon(imageBuffer[4]);
			color = "purple";
			break;
		case 5:
			i = new ImageIcon(imageBuffer[5]);
			color = "red";
			break;
		}
		image = i.getImage();
	}

	public Image getHeartImage() {
		ImageIcon i = new ImageIcon(imageBuffer[6]);
		return i.getImage();
	}

	public Image getImage() {
		return image;
	}

	public int getXPos() {
		return xPos;
	}

	public void setYPos(int Pos) {
		this.yPos = Pos;
	}

	public int getYPos() {
		return yPos;
	}

	public String getColor() {
		return color;
	}
	
	public void setdy(int dy) {
		this.dy = dy;
	}
	
	public int getdy() {
		return dy;
	}
	
	public boolean getAlreadyPassed() {
		return alreadyPassed;
	}
	
	public void setAlreadyPassed(Boolean bool) {
		alreadyPassed = bool;
	}

	public void updatePos() {
		if (yPos < FRAME_Y_SIZE) {
			yPos += dy;
		} else {
			initBall();
		}

	}

	// new checkCollision method, takes in the board object to get its color
	public boolean checkCollision(Bar b) {
		if(alreadyPassed == false) {
			if (this.yPos >= BAR_POS + 25 && this.color.equals(b.getColor())) {
				alreadyPassed = true;
				return true;
			}
		}
		return false;
	}
}
