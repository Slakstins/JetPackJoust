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
	
	public void setKeyMap(HashMap<String, Boolean> keyMap) {
		this.keyMap = keyMap;
	}
	
	
	public void keyAcceleration() {
		if (keyMap.get("left") && this.getXVel() > -2) {
			super.setXVel(this.getXVel() - 0.05);
		}
		if (keyMap.get("right") && this.getXVel() < 2) {
			super.setXVel(this.getXVel() + 0.05);
		}
	}
	
	

	@Override
	public void updateMovement() {
		
		this.keyAcceleration();
		
		
		this.velUpdate();
		this.posUpdate();
		this.fly();
		
	}
	
	
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		if (this.keyMap.get("up") && this.getYVel() > -1.5) {
			
			this.setYVel(this.getYVel() - 0.07);
//			this.setPostition(this.getX(), this.getY());
		}
		

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
