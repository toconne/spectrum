package eHacksBJJT;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Bar implements Common {
	private Image image;
	private int Pos;
	private String color;
	private ImageIcon i;
	private BufferedImage[] imageBuffer;
	
	public Bar() {
		bufferLoad();
		initBar();	
	}

	private void initBar() {
		Pos = BAR_POS;
		color = "red";
		loadImage(color);
	}
	
	private void bufferLoad() {
		imageBuffer = new BufferedImage[7];
		try {
			imageBuffer[0] = ImageIO.read(new File("src/eHacksBJJT/bars/blue.png"));
			imageBuffer[1] = ImageIO.read(new File("src/eHacksBJJT/bars/green.png"));
			imageBuffer[2] = ImageIO.read(new File("src/eHacksBJJT/bars/yellow.png"));
			imageBuffer[3] = ImageIO.read(new File("src/eHacksBJJT/bars/orange.png"));
			imageBuffer[4] = ImageIO.read(new File("src/eHacksBJJT/bars/purple.png"));
			imageBuffer[5] = ImageIO.read(new File("src/eHacksBJJT/bars/red.png"));
			imageBuffer[6] = ImageIO.read(new File("src/eHacksBJJT/bars/spectrum.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadImage(String color) {
		i = new ImageIcon("src/eHacksBJJT/bars/red.png");
		switch (color){
		case "blue":
	        i = new ImageIcon(imageBuffer[0]);
	        break;
	    case "green":
	    	i = new ImageIcon(imageBuffer[1]);
	    	break;
        case "yellow":
        	i = new ImageIcon(imageBuffer[2]);
        	break;
        case "orange":
        	i = new ImageIcon(imageBuffer[3]);
        	break;
        case "purple":
        	i = new ImageIcon(imageBuffer[4]);
        	break;
        case "red":
        	i = new ImageIcon(imageBuffer[5]);
        	break;
    }
		image = i.getImage();
	}
	
	public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
       
        //red
        if (key == KeyEvent.VK_Q) {
        	color = "red";
        	loadImage(color);
        }
        //yellow
        if (key == KeyEvent.VK_W) {
        	color = "yellow";
        	loadImage(color);
        }
        //blue
        if (key == KeyEvent.VK_E){
        	color = "blue";
        	loadImage(color);
        }
        if (key == KeyEvent.VK_A){
        	color = "orange";
        	loadImage(color);
        }
        if (key == KeyEvent.VK_D){
        	color = "purple";
        	loadImage(color);
        }
        if (key == KeyEvent.VK_S){
        	color = "green";
        	loadImage(color);
        }
        //Test for Starting Game
    }
	public Image getStartImage() {
		ImageIcon i = new ImageIcon(imageBuffer[6]);
		return i.getImage();
	}
	public String getColor() {
		return color;
	}
	protected Image getImage() {
        return image;
    }
	public ImageIcon getImageIcon() {
		return i;
	}
	public int getPos() {
		return Pos;
	}
}
