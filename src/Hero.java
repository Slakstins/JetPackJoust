import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
	private boolean isAttacking = false;
	private ArrayList<String> walkImagesR = new ArrayList<String>();
	private ArrayList<String> walkImagesL = new ArrayList<String>();
	private ArrayList<String> idleImages = new ArrayList<String>();
	
	public Hero(int xPos, int yPos) {
		super(xPos, yPos);
		this.tick = 0;

		
		this.setImages();
		this.setImage(this.idleImages.get(0));

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
			this.isAttacking = true;
		} else {
			this.isAttacking = false;
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

		this.updateImages();

		this.velUpdate();
		this.posUpdate();

		this.shoot();

		this.tick++;
		this.updateAniTick();
	}

	/**
	 * increase the hero's upward velocity if up is true
	 */
	@Override
	public void fly() {
		if (this.keyMap.get("up")) {
			this.setImage("HeroFly.png");
//			this.setYVel(this.getYVel() - this.thrust);
//			this.setPostition(this.getX(), this.getY());
			this.setYAccel(-this.thrust);
		} else {
			this.setYAccel(this.gravity);

			//this.setImage("HeroIdle.png");
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
		 * if(this.keyMap.get("space") && this.shootCooldown <= 0) { this.shootCooldown
		 * = 100; this.shooting = true; } else if (this.shootCooldown > 0) {
		 * this.shootCooldown--; this.shooting = false; }
		 */
	}

	@Override
	public double[] shootDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	private void setImages() {
		// set idle images
		for (int i = 0; i <= 1; i++) {
			String filename = "HeroIdle000" + Integer.toString(i) + ".png";
			this.idleImages.add(filename);
		}
		
		//set walk right images
		for (int i = 0; i <= 3; i++) {
			String filename = "HeroWalkR000" + Integer.toString(i) + ".png";
			this.walkImagesR.add(filename);
		}
		
		// set walk left images
		for (int i = 0; i <= 3; i++) {
			String filename = "HeroWalkL000" + Integer.toString(i) + ".png";
			this.walkImagesL.add(filename);
		}
	}

	private void updateImages() {
		if (keyMap.get("right")) {
			if (this.aniTick >= this.walkImagesR.size())
				this.aniTick = 0;
			this.setImage(this.walkImagesR.get(aniTick));
		} else if (keyMap.get("left")) {
			if (this.aniTick >= this.walkImagesL.size())
				this.aniTick = 0;
			this.setImage(this.walkImagesL.get(aniTick));
		} else {
			if (this.aniTick >= this.idleImages.size())
				this.aniTick = 0;
			this.setImage(this.idleImages.get(aniTick));
		}
		

	}
	public boolean getIsAttacking() {
		return this.isAttacking;
	}

	private void updateAniTick() {
		if (tick % 15 == 0) {
			aniTick++;
		}
	}

	@Override
	public void collidedWithHero() {
		// TODO Auto-generated method stub
		
	}


}
