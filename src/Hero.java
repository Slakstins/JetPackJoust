import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Hero extends Mob {
	
	
	private HashMap<String, Boolean> keyMap;
	private double xMoveVel = 0.05;
	private double thrust = 0.05;
	private double maxThrustSpeed = 1.5;
	private double xMoveAccel = 0.05;

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
	
	/**
	 * 
	 */
	public void keyAcceleration() {
		if (keyMap.get("left")) {
//			this.setXVel(this.getXVel() - this.xMoveVel);
			this.setXAccel(-this.xMoveAccel);
		}
		if (keyMap.get("right")) {
//			this.setXVel(this.getXVel() + this.xMoveVel);
			this.setXAccel(this.xMoveAccel);
		}
		if (!keyMap.get("right") && !keyMap.get("left")) {
			this.setXAccel(0);
		}
			
		
		
		
	}
	
	

	@Override
	public void updateMovement() {
		
		this.keyAcceleration();
		
		
		
		this.fly();
		this.velUpdate();
		this.posUpdate();
		
		
	}
	
	/**
	 * increase the hero's upward velocity if up is true
	 */
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		if (this.keyMap.get("up")) {
			this.setImage("HeroFly.png");
//			this.setYVel(this.getYVel() - this.thrust);
//			this.setPostition(this.getX(), this.getY());
			this.setYAccel(-this.thrust);
		}
		else {
			this.setYAccel(this.gravity);
			
			this.setImage("Hero.png");
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
