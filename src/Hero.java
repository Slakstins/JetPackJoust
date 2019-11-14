import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Hero extends Mob {

	private HashMap<String, Boolean> keyMap;
	private double thrust = 0.1;
	private double xMoveAccel = 0.1;
	private double groundedMoveVel = 5;
	private double downWardDashVel = 3;
	private boolean isAttacking = false;
	private ArrayList<Image> walkImagesR = new ArrayList<Image>();
	private ArrayList<Image> walkImagesL = new ArrayList<Image>();
	private ArrayList<Image> idleImages = new ArrayList<Image>();
	private ArrayList<Image> flyImagesR = new ArrayList<Image>();
	private ArrayList<Image> flyImagesL = new ArrayList<Image>();
	private ArrayList<Image> dropImages = new ArrayList<Image>();
	private boolean gotKill;


	public Hero(int xPos, int yPos) {
		super(xPos, yPos);
		this.tick = 0;

		this.setImages();
		this.setImage(this.idleImages.get(0));


	}
	
	public void gotKill() {
		this.gotKill = true;
	}
	
	public boolean getGotKill() {
		return this.gotKill;
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
		this.velUpdate();

		this.updateImages();

		
		this.posUpdate();

		this.shoot();

	}

	/**
	 * increase the hero's upward velocity if up is true
	 */
	@Override
	public void fly() {
		if (this.keyMap.get("up")) {


			this.setYAccel(-this.thrust);
		} else {
			this.setYAccel(this.gravity);

		}

	}
	

	@Override
	public void kill() {
		// TODO Auto-generated method stub
		this.gotKill = false;

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
			this.saveImage(filename, this.idleImages);
		}

		// set walk right images
		for (int i = 0; i <= 1; i++) {
			String filename = "HeroWalkR000" + Integer.toString(i) + ".png";
			this.saveImage(filename, this.walkImagesR);
		}

		// set walk left images
		for (int i = 0; i <= 1; i++) {
			String filename = "HeroWalkL000" + Integer.toString(i) + ".png";
			this.saveImage(filename, this.walkImagesL);
		}
		
		// set flying images
		for (int i = 0; i <= 1; i++) {
			String filename = "HeroFlyR000" + Integer.toString(i) + ".png";
			this.saveImage(filename, this.flyImagesR);
		}
		
		// set drop/attack images
		for (int i = 0; i <= 1; i++) {
			String filename = "HeroDrop000" + Integer.toString(i) + ".png";
			this.saveImage(filename, this.dropImages);
		}
	}
	


	private void updateImages() {
		if (this.keyMap.get("up")) {
			if (this.aniTick >= this.flyImagesR.size())
				this.aniTick = 0;
			this.setImage(this.flyImagesR.get(aniTick));
		} else if (keyMap.get("down")) {
			if (this.aniTick >= this.dropImages.size())
				this.aniTick = 0;
			this.setImage(this.dropImages.get(aniTick));
		} else if (keyMap.get("right")) {
			if (this.aniTick >= this.walkImagesR.size())
				this.aniTick = 0;
			this.setImage(this.walkImagesR.get(aniTick));
		} else if (keyMap.get("left")) {
			if (this.aniTick >= this.walkImagesL.size())
				this.aniTick = 0;
			this.setImage(this.walkImagesL.get(aniTick));
		}  else {
			if (this.aniTick >= this.idleImages.size())
				this.aniTick = 0;
			this.setImage(this.idleImages.get(aniTick));
		}

	}
	public boolean getIsAttacking() {
		return this.isAttacking;
	}

	

	@Override
	public void collidedWithHero() {
		// TODO Auto-generated method stub

	}

	public void setGotKill(boolean b) {
		this.gotKill = false;
		// TODO Auto-generated method stub
		
	}


}
