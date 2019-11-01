import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Mob {
	private Hero hero;
	private double xPos;
	private double yPos;
	private double xVel;
	private double yVel;
	private double xAcceleration;
	private double yAcceleration;
	private Image image;
	public final double gravity = 0.05;
	protected double width;
	protected double height;
	public final int defaultMobHeight = 100;
	public final int defaultMobWidth = 100;
	private double maxXVel = 50;
	private double maxYVel = 50;
	private double friction = 0.01;
	protected final double FRAME_WIDTH = 1000;
	protected final double CELLWIDTHHEIGHT = 100;
	private boolean isGrounded;
	protected int shootCooldown;
	protected boolean shooting;
	
	public Mob(int xPos, int yPos) {
		this.height = defaultMobHeight;
		this.width = defaultMobWidth;
		this.xPos = xPos;
		this.yPos = yPos;
		this.xVel = 0;
		this.yVel = 0;
		this.xAcceleration = 0;
		this.yAcceleration = gravity;
		this.image = null;
		this.isGrounded = false;
		this.hero = null;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)this.getX(), (int)this.getY(), this.defaultMobWidth, this.defaultMobHeight);
	}
	
	
	
	

	public abstract void fly();
	public abstract void kill();
	public abstract void spawn();
	public abstract void shoot();
	public abstract double[] shootDirection();
	
	public void updateMovement() {
		this.velUpdate();
		this.posUpdate();
		
	}
	public void setHero(Hero hero) {
		this.hero = hero;
	}
	
	public Hero getHero() {
		return this.hero;
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
	
	public void setIsGrounded(boolean grounded ) {
		this.isGrounded = grounded;
	}
	public boolean getIsGrounded() {
		return this.isGrounded;
	}
	
	public void setXAccel(double xAccel) {
		this.xAcceleration = xAccel;
	}
	
	public void setYAccel(double yAccel) {
		this.yAcceleration = yAccel;
	}
	
	
	
	public void setPosition(double d, double y) {
		this.xPos = d;
		this.yPos = y;
	}
	
	public void setYVel(double d) {
		this.yVel = d;
		
	}
	public double getYVel() {
		
		return this.yVel;
	}
	public double getXVel() {
		return this.xVel;
	}
	
	public void setXVel(double vel) {
		this.xVel = vel;
	}
	

	
	/**
	 * Call this often to make smooth!
	 * values will have to be reduced if calling more often for smoothness
	 */
	public void posUpdate() {
		if (this.xPos + this.xVel > this.FRAME_WIDTH - this.CELLWIDTHHEIGHT || this.xPos + this.xVel < 0) {
		
			this.setXVel(0);
		} // WHY NO WORK
		if (this.yPos + this.yVel < 0) {
			this.setYVel(0);

			
		}
		
		this.xPos += this.xVel;
		
		this.yPos += this.yVel;
	}
	/**
	 * call often to make smooth
	 */
	public void velUpdate() {
		
		if (this.xVel + this.xAcceleration < this.maxXVel && this.xVel + this.xAcceleration > -this.maxXVel) {
		this.xVel += this.xAcceleration;
		}
		if (this.yVel < this.maxYVel && this.yVel > -this.maxYVel) {
		this.yVel += this.yAcceleration;
		}
		if (this.xVel > 0) {
			this.xVel = this.xVel - this.friction;
		}
		if (this.xVel < 0) {
			this.xVel = this.xVel + this.friction;
		}
		// getting rid of friction for some reaseon fixes the issue of going faster to the left
	}
	public double getXAcceleration() {
		return this.xAcceleration;
	}
	public double getYAcceleration() {
		return this.yAcceleration;
	}
	
	public void setXAcceleration(double accelerationX) {
		this.xAcceleration = accelerationX;
	}
	
	public void setYAcceleration(double accelerationY) {
		this.yAcceleration = accelerationY;
	}
	
	public double getX() {
		return this.xPos;
	}
	public double getY() {
		return this.yPos;
	}
	
	
	
	public void setImage(Image newImage) {
		this.image = newImage;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public boolean getShooting() {
		return this.shooting;
	}

	
	
	
	

}
