import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Hero extends Mob {
	
	
	private HashMap<String, Boolean> keyMap;

	public Hero(int xPos, int yPos) {
		super(xPos, yPos);
		setImage("Hero.png"); 
		
		
		
		
		// TODO Auto-generated constructor stub
	}

	public void setImage(String filename) {
		Image image = null;
		try {
			image = ImageIO.read(new File(filename));
		} catch (IOException e) {
			System.out.println("Image not found of hero!!");
		}
		this.setImage(image);
		
		
	}
	
	public void giveKeyMap(HashMap<String, Boolean> keyMap) {
		this.keyMap = keyMap;
	}
	
	
	public void keyAcceleration() {
		if (keyMap.get("left")) {
			super.setXAcceleration(-10);
		}
		if (keyMap.get("right")) {
			super.setYAcceleration(10);
		}
	}
	
	
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		

	}

	@Override
	public void kill() {
		// TODO Auto-generated method stub

	}

	@Override
	public void spawn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub

	}

}
