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
	private double groundedMoveVel = 5;
	private int downWardDashVel = 3;
	

	public Hero(int xPos, int yPos) {
		super(xPos, yPos);
		
		setImage("Hero.png");

		// TODO Auto-generated constructor stub
	}



	public void setKeyMap(HashMap<String, Boolean> keyMap) {
		this.keyMap = keyMap;
	}

	/**
	 * 
	 */
	public void keyAcceleration() {
		if (this.getIsGrounded()) {
			this.setXVel(0);
			if (keyMap.get("left")) {
				this.setXVel(-groundedMoveVel);
			}
			if (keyMap.get("right")) {
				this.setXVel(groundedMoveVel);
			}
		} else {
			if (keyMap.get("right")) {
				this.setXAccel(this.xMoveAccel);
			}
			if (keyMap.get("left")) {
				this.setXAccel(-this.xMoveAccel);
			}

		}
		if (!keyMap.get("right") && !keyMap.get("left")) {
			this.setXAccel(0);
		}

		if (keyMap.get("down")) {
			this.downWardDash();
		}

	}

	public void downWardDash() {
		this.setPosition(this.getX(), this.getY() + this.downWardDashVel);
		this.setYVel(3);
	}

	@Override
	public void updateMovement() {

		this.keyAcceleration();

		this.fly();

		this.velUpdate();
		this.posUpdate();

		this.shoot();
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
		} else {
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
		// giving hero shoot functionality for testing purposes
		/*
		if(this.keyMap.get("space") && this.shootCooldown <= 0) {
			this.shootCooldown = 100;
			this.shooting = true;
		} else if (this.shootCooldown > 0) {
			this.shootCooldown--;
			this.shooting = false;
		}
		*/
	}



	@Override
	public double[] shootDirection() {
		// TODO Auto-generated method stub
		return null;
	}

}
